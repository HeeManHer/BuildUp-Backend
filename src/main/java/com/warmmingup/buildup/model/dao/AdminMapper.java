package com.warmmingup.buildup.model.dao;

import com.warmmingup.buildup.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    List<UserDTO> selectAllUsers(Map<String, Integer> userCnt);

    int insertUser(UserDTO newUser);
}
