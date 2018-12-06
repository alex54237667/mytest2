package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
    @Query("select u from User u left join u.roles r where r.roleName like ?1")
    List<User> findAllByRoleName(String roleName);

}
