package com.khalid.user_managment_system.repository;

import com.khalid.user_managment_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findUserById(Integer id);

    User findUserByEmail(String email);

    @Query("select u from User u where u.username=?1 and u.password=?2")
    User checkUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.role=?1")
    List<User> findUsersByRole(String role);

    @Query("select u from User u where u.age>=?1")
    List<User> findUsersByAge(Integer age);
    }

