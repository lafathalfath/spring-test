package com.mysql.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysql.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
