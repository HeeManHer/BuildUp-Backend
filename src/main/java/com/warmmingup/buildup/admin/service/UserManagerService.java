package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserManagerService {
    int findUserTotalCount(Map<String, Object> userManage);

    List<UserDTO> findAllUsers(Map<String, Object> userCnt);

    List<UserDTO> findUserInfo(int userNo);

    void insertUser(NewUserDTO newUser);

    void deleteUser(int userNo);

    void updateUser(Map<String, Object> userNo);
}
