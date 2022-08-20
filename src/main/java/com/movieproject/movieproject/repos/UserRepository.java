package com.movieproject.movieproject.repos;

import com.movieproject.movieproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


   // User findByUserName(String user_name);
}
