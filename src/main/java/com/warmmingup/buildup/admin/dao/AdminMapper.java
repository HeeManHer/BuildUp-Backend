package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    List<UserDTO> selectAllUsers(Map<String, Integer> userCnt);

    int insertUser(UserDTO newUser);
}
