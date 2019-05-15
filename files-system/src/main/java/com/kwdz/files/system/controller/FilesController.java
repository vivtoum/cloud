package com.kwdz.files.system.controller;

import com.kwdz.commons.page.PageInfo;
import com.kwdz.commons.util.MD5Util;
import com.kwdz.files.system.domain.Files;
import com.kwdz.files.system.domain.FilesEntity;
import com.kwdz.files.system.service.FilesService;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * 文件管理
 * CrossOrigin允许所有域名访问
 *
 * @author YT.Hu
 * @date 2019-5-15
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class FilesController {

    @Autowired
    private FilesService filesService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/")
    public String index(Model model) {
        // 展示最新二十条数据
        model.addAttribute("files", filesService.listFilesByPage(0, 20));
        return "index";
    }

    /**
     * 分页查询文件
     *
     * @param pageIndex 当前页数
     * @param pageSize  每页大小
     * @return 分页包装类
     */
    @PostMapping("files")
    @ResponseBody
    public PageInfo<Files> listFilesByPage(int pageIndex, int pageSize) {
        return filesService.listFilesByPage(pageIndex, pageSize);
    }

    /**
     * 获取文件片信息
     *
     * @param id 文件id
     * @return 1
     */
    @GetMapping("files/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String id) {

        Optional<FilesEntity> file = filesService.getFileById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + new String(file.get().getName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1))
                    .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FilesEntity was not fount");
        }

    }

    /**
     * 在线显示文件
     *
     * @param id 文件id
     * @return 响应体
     */
    @GetMapping("/view/{id}")
    @ResponseBody
    public ResponseEntity<Object> serveFileOnline(@PathVariable String id) {

        Optional<FilesEntity> file = filesService.getFileById(id);

        if (file.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.get().getName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, file.get().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, file.get().getSize() + "").header("Connection", "close")
                    .body(file.get().getContent().getData());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FilesEntity was not fount");
        }

    }

    /**
     * 上传
     *
     * @param file               文件对象
     * @param redirectAttributes 重定向属性
     * @return 1
     */
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            FilesEntity f = new FilesEntity(file.getOriginalFilename(), file.getContentType(), String.valueOf(file.getSize()),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            filesService.saveFile(f);
        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Your " + file.getOriginalFilename() + " is wrong!");
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    /**
     * 上传接口
     *
     * @param file 文件对象
     * @return 1
     */
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        Files returnFilesEntity;
        String serverAddress = "localhost";
        try {
            FilesEntity f = new FilesEntity(file.getOriginalFilename(), file.getContentType(), String.valueOf(file.getSize()),
                    new Binary(file.getBytes()));
            f.setMd5(MD5Util.getMD5(file.getInputStream()));
            returnFilesEntity = filesService.saveFile(f);
            String path = "//" + serverAddress + ":" + serverPort + "/view/" + returnFilesEntity.getId();
            return ResponseEntity.status(HttpStatus.OK).body(path);

        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    /**
     * 删除文件
     *
     * @param id 文件id
     * @return 1
     */
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteFile(@PathVariable String id) {

        try {
            filesService.removeFile(id);
            return ResponseEntity.status(HttpStatus.OK).body("DELETE Success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
