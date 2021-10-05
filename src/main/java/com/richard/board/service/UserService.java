package com.richard.board.service;

import com.richard.board.dto.UserDTO;
import com.richard.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDTO getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserPw(String userId, UserDTO user) {
        userRepository.updateUserPw(userId, user);
    }

    public void deleteUser(String userId){
        userRepository.dleleteUser(userId);
    }

}
