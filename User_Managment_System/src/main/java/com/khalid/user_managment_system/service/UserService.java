package com.khalid.user_managment_system.service;

import com.khalid.user_managment_system.model.User;
import com.khalid.user_managment_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.findUserById(id);
        if(oldUser == null) {
            return false;
        }

        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.findUserById(id);
        if(user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public User checkUsernameAndPassword(String username, String password) {
        return userRepository.checkUsernameAndPassword(username, password);
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public List<User> getUserByRole(String role) {
        return userRepository.findUsersByRole(role);
    }

    public List<User> getUserByAge(Integer age) {
        return userRepository.findUsersByAge(age);
    }
}
