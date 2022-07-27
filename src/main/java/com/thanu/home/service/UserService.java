package com.thanu.home.service;

import com.thanu.home.dto.UserDTO;

public interface UserService {

    UserDTO registerUser (UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    UserDTO getUserInfo(String userId);
    void deleteUser (String userId);


}
