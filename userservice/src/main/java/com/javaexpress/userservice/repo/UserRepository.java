package com.javaexpress.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
