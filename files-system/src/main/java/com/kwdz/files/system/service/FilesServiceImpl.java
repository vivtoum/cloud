package com.kwdz.files.system.service;

import com.kwdz.commons.page.FastPage;
import com.kwdz.commons.page.PageInfo;
import com.kwdz.commons.util.DateUtils;
import com.kwdz.commons.util.FastCopy;
import com.kwdz.commons.util.NumberUtil;
import com.kwdz.commons.util.RedisUtil;
import com.kwdz.files.system.domain.Files;
import com.kwdz.files.system.domain.FilesEntity;
import com.kwdz.files.system.repository.FilesDao;
import com.kwdz.files.system.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FilesEntity 服务.
 *
 * @author YT.Hu
 * @date 2019-5-15
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private FilesDao filesDao;

    @Autowired
    private RedisUtil redisUtil;

    private final static String FILES_LIST_CACHE = "FILES_LIST_CACHE";

    @Override
    public Files saveFile(FilesEntity filesEntity) {
        FilesEntity filesEntity1 = filesRepository.save(filesEntity);
        Files files = FastCopy.copy(filesEntity1, Files.class);
        filesDao.save(files);
        refreshRedis();
        return files;
    }

    @Override
    public void removeFile(String id) {
        filesRepository.delete(id);
        filesDao.delete(id);
        refreshRedis();
    }

    @Override
    public Optional<FilesEntity> getFileById(String id) {
        return Optional.of(filesRepository.findOne(id));
    }

    @Override
    public PageInfo<Files> listFilesByPage(int pageIndex, int pageSize) {
        if (redisUtil.hHasKey(FILES_LIST_CACHE, String.valueOf(pageIndex))) {
            return FastCopy.copy((PageInfo<Files>) redisUtil.hget(FILES_LIST_CACHE, String.valueOf(pageIndex)), PageInfo.class);
        } else {
            Page<Files> page = null;

            Sort sort = new Sort(Direction.DESC, "uploadDate");
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);

            page = filesDao.findAll(pageable);
            PageInfo<Files> pageInfo = FastPage.getPageInfo(page, Files.class);
            pageInfo.setHtml(makeHtml(pageInfo));
            redisUtil.hset(FILES_LIST_CACHE, String.valueOf(pageIndex), pageInfo, 5 * 60);
            return pageInfo;
        }

    }

    public static String makeHtml(PageInfo<Files> pageInfo) {
        StringBuilder stringBuffer = new StringBuilder();
        pageInfo.getRows().forEach(a -> {
            a.setSize(String.valueOf(NumberUtil.div2(Integer.valueOf(a.getSize()), 1024)));
            stringBuffer.append("<tr>");
            stringBuffer.append("<td>").append(a.getName()).append("</td>");
            stringBuffer.append("<td>").append(a.getId()).append("</td>");
            stringBuffer.append("<td>").append(a.getSize()).append("KB</td>");
            stringBuffer.append("<td>").append(DateUtils.getDate(a.getUploadDate(), DateUtils.yyyyMMddhhmmssStr)).append("</td>");
            stringBuffer.append("<td>").append(a.getMd5()).append("</td>");
            stringBuffer
                    .append("<td>")
                    .append("<i class='fas fa-times-circle' style='cursor: pointer;' onclick=\"javascript:handleDelete('").append(a.getId()).append("');\">").append("</i>")
                    .append("<i class='fas fa-arrow-alt-circle-down' style='cursor: pointer;' onclick=\"javascript:window.open('/files/").append(a.getId()).append("');\">").append("</i>")
                    .append("</td>");
            stringBuffer.append("</tr>");
        });
        return stringBuffer.toString();
    }

    public void refreshRedis() {
        redisUtil.del(FILES_LIST_CACHE);
        redisUtil.hset(FILES_LIST_CACHE, "0", listFilesByPage(0, 20), 5 * 60);
    }
}
