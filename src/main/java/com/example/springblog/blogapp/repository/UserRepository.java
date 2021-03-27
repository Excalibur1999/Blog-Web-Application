package com.example.springblog.blogapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.springblog.blogapp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

	@Query("select u from User u where u.username=: username")
	Optional<User> findByUserName(@Param("username") String username);
    
}
