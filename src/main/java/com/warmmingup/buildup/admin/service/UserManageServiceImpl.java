package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.UserManageMapper;
import com.warmmingup.buildup.admin.dto.NewUserDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("userManageService")
public class UserManageServiceImpl implements UserManagerService {

    private final UserManageMapper userManageMapper;

    public UserManageServiceImpl(UserManageMapper userManageMapper) {
        this.userManageMapper = userManageMapper;
    }

    @Override
    public int findUserTotalCount(Map<String, Object> userManage) {
        return userManageMapper.selectUserTotalCount(userManage);
    }

    @Override
    public List<UserDTO> findAllUsers(Map<String, Object> userCnt) {

        return userManageMapper.selectAllUsers(userCnt);
    }

    @Override
    public List<UserDTO> findUserInfo(int userNo) {

        return userManageMapper.selectUserByNo(userNo);
    }

    @Override
    @Transactional
    public void insertUser(NewUserDTO newUser) {

        userManageMapper.insertNewUser(newUser);

        if (newUser.isAuthority()) {
            userManageMapper.insertNewCreatedProject(newUser.getNo());
        }
    }

    @Override
    @Transactional
    public void deleteUser(int userNo) {

        userManageMapper.deleteUser(userNo);
        userManageMapper.deleteAuthority(userNo);
    }

    @Override
    @Transactional
    public void updateUser(Map<String, Object> modifyUser) {

        userManageMapper.updateUser(modifyUser);

        userManageMapper.deleteAuthority((int) modifyUser.get("oldNo"));

        if ("PM".equals(modifyUser.get("authority"))) {
            userManageMapper.insertNewCreatedProject((int) modifyUser.get("no"));
        }
    }
}
