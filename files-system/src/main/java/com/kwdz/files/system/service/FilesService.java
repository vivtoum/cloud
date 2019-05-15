/**
 *
 */
package com.kwdz.files.system.service;


import com.kwdz.commons.page.PageInfo;
import com.kwdz.files.system.domain.Files;
import com.kwdz.files.system.domain.FilesEntity;

import java.util.Optional;


/**
 * FilesEntity 服务接口.
 *
 * @since 1.0.0 2017年3月28日
 * @author YT.Hu
 */
public interface FilesService {
    /**
     * 保存文件
     * @param File
     * @return
     */
    Files saveFile(FilesEntity filesEntity);

    /**
     * 删除文件
     * @param File
     * @return
     */
    void removeFile(String id);

    /**
     * 根据id获取文件
     * @param File
     * @return
     */
    Optional<FilesEntity> getFileById(String id);

    /**
     * 分页查询，按上传时间降序
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<Files> listFilesByPage(int pageIndex, int pageSize);
}
