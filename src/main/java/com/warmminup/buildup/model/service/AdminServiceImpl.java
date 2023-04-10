package com.warmminup.buildup.model.service;

import com.warmminup.buildup.model.dao.AdminMapper;
import com.warmminup.buildup.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Object findAllUsers(Map<String, Integer> userCnt) {
        List<UserDTO> userList = adminMapper.selectAllUsers(userCnt);

        return userList;
    }

    @Override
    public Object insertUser(UserDTO newUser) {

        int result = adminMapper.insertUser(newUser);


        return (result > 0) ? "등록 성공" : "등록 실패";
    }
}
