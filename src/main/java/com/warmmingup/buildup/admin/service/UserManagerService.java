package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserManagerService {
    List<UserDTO> findAllUsers (Map<String, String> userCnt);

    void insertUser (NewUserDTO newUser);

    void deleteUser (int userNo);

    void updateUser (List<Integer> userNo);
}
