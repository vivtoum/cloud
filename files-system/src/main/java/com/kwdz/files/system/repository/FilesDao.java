package com.kwdz.files.system.repository;

import com.kwdz.files.system.domain.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @version 0.0.1
 * @author: huyt
 * @date: 2019/5/8 20:38
 */
public interface FilesDao extends JpaRepository<Files, String>, JpaSpecificationExecutor<Files> {

}
