package com.khalid.user_managment_system.controller;

import com.khalid.user_managment_system.model.User;
import com.khalid.user_managment_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ape/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        Boolean isUpdated = userService.updateUser(id, user);
        if(isUpdated) {
            return ResponseEntity.status(200).body("User updated");
        }
        return ResponseEntity.status(400).body("Id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        Boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("User deleted");
        }
        return ResponseEntity.status(400).body("Id not found");
    }
    @GetMapping("/get-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get-role/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getUserByRole(role));
    }

    @GetMapping("/get-age/{age}")
    public ResponseEntity getUserByAge(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.getUserByAge(age));
    }

    @GetMapping("check/{username}/{password}")
    public ResponseEntity checkUsernameAndPassword(String username, String password) {
        return ResponseEntity.status(200).body(userService.checkUsernameAndPassword(username, password));
    }

}
