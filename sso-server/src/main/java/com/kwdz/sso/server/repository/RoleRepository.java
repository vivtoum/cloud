package com.kwdz.sso.server.repository;

import com.kwdz.sso.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by SuperS on 2017/9/25.
 *
 * @author SuperS
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
