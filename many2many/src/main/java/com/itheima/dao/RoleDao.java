package com.itheima.dao;

import com.itheima.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,Long>,JpaSpecificationExecutor<Role> {
    @Query("select r from Role r left join r.users u where u.userName like ?1")
    List<Role> findAllByUserName(String username);
}
