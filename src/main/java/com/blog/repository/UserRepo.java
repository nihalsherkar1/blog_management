package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entities.Users;
import com.blog.payload.UserDto;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
