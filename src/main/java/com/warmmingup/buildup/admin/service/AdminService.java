package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.UserDTO;

import java.util.Map;

public interface AdminService {
    Object findAllUsers(Map<String, Integer> userCnt);

    Object insertUser(UserDTO newUser);
}
