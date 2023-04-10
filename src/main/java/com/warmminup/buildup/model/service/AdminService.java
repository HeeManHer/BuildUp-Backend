package com.warmminup.buildup.model.service;


import com.warmminup.buildup.model.dto.UserDTO;

import java.util.Map;

public interface AdminService {
    Object findAllUsers(Map<String, Integer> userCnt);

    Object insertUser(UserDTO newUser);
}
