package com.richard.board.repository;

import com.richard.board.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db 연동하는 코드
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("richard", "test1", "1234"));
        users.add(new UserDTO("aaa", "test2", "1234"));
        users.add(new UserDTO("bbb", "test3", "1234"));
    }

    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers() {
        return users;
    }
    public UserDTO getUserByUserId(String userId){
        return users.stream()
                .filter(userDTO ->  userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(null);
    }

    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(null)
                .setUserPw(user.getUserPw());
    }

    public void dleleteUser(String userId) {
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }

}
