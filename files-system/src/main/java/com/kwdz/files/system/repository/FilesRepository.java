package com.kwdz.files.system.repository;

import com.kwdz.files.system.domain.FilesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * FilesEntity 存储库.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年3月28日
 */
public interface FilesRepository extends MongoRepository<FilesEntity, String> {
}
