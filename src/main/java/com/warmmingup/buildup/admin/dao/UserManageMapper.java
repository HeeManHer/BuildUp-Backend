package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserManageMapper {
    List<UserDTO> selectAllUsers (Map<String, String> userCnt);

    void insertNewUser (NewUserDTO newUser);

    void insertNewCreatedProject (int newUser);

    void deleteUser (int userNo);

    void updateUser (int userNo);

    void deleteAuthority (int userNo);
}
