package com.richard.board.controller;

import com.richard.board.dto.UserDTO;
import com.richard.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user) {
        return userService.insertUser(user);
    }
    @GetMapping("")
    public List<UserDTO> getALlUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable  String userId) {
        return userService.getUserByUserId(userId);
    }
    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody UserDTO user) {
        userService.updateUserPw(userId, user);
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
