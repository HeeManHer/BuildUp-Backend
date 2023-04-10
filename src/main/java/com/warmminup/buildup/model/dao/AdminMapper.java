package com.warmminup.buildup.model.dao;


import com.warmminup.buildup.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    List<UserDTO> selectAllUsers(Map<String, Integer> userCnt);

    int insertUser(UserDTO newUser);
}
