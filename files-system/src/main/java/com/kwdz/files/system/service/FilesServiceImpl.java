package com.kwdz.files.system.service;

import com.kwdz.files.system.domain.Files;
import com.kwdz.files.system.domain.FilesEntity;
import com.kwdz.files.system.repository.FilesDao;
import com.kwdz.files.system.repository.FilesRepository;
import com.kwdz.files.system.util.FastCopy;
import com.kwdz.files.system.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * FilesEntity 服务.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年7月30日
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
        redisUtil.del(FILES_LIST_CACHE);
        redisUtil.set(FILES_LIST_CACHE, listFilesByPage(0, 20));
        return files;
    }

    @Override
    public void removeFile(String id) {
        filesRepository.delete(id);
        filesDao.delete(id);
        redisUtil.del(FILES_LIST_CACHE);
        redisUtil.set(FILES_LIST_CACHE, listFilesByPage(0, 20));
    }

    @Override
    public Optional<FilesEntity> getFileById(String id) {
        return Optional.of(filesRepository.findOne(id));
    }

    @Override
    public List<Files> listFilesByPage(int pageIndex, int pageSize) {
        if (redisUtil.hasKey(FILES_LIST_CACHE)) {
            return FastCopy.copyList((List<Files>) redisUtil.get(FILES_LIST_CACHE), Files.class);
        } else {
            Page<Files> page = null;
            List<Files> list = null;

            Sort sort = new Sort(Direction.DESC, "uploadDate");
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);

            page = filesDao.findAll(pageable);
            list = page.getContent();
            redisUtil.set(FILES_LIST_CACHE, list.stream().collect(Collectors.toList()));
            return list;
        }

    }
}
