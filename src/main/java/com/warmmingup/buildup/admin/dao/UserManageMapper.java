package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserManageMapper {
    int selectUserTotalCount(Map<String, Object> userManage);

    List<UserDTO> selectAllUsers(Map<String, Object> userCnt);

    List<UserDTO> selectUserByNo(int userNo);

    void insertNewUser(NewUserDTO newUser);

    void insertNewCreatedProject(int newUser);

    void deleteUser(int userNo);

    void updateUser(Map<String, Object> userNo);

    void deleteAuthority(int userNo);
}
