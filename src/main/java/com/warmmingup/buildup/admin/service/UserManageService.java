package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.UserManageMapper;
import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserManageService {

    private final UserManageMapper userManageMapper;
    private final PasswordEncoder passwordEncoder;

    public UserManageService(UserManageMapper userManageMapper, PasswordEncoder passwordEncoder) {
        this.userManageMapper = userManageMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public int findUserTotalCount(Map<String, Object> userManage) {
        return userManageMapper.selectUserTotalCount(userManage);
    }


    public List<UserDTO> findAllUsers(Map<String, Object> userCnt) {

        return userManageMapper.selectAllUsers(userCnt);
    }


    public List<UserDTO> findUserInfo(int userNo) {

        return userManageMapper.selectUserByNo(userNo);
    }


    @Transactional
    public void insertUser(NewUserDTO newUser) {

        newUser.setPwd(passwordEncoder.encode(newUser.getPwd()));

        userManageMapper.insertNewUser(newUser);
    }


    @Transactional
    public void deleteUser(int userNo) {

        userManageMapper.deleteUser(userNo);
    }


    @Transactional
    public void updateUser(Map<String, Object> modifyUser) {
        userManageMapper.updateUser(modifyUser);
    }
}
