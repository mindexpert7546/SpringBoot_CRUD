package com.mindexpert.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindexpert.crud.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
