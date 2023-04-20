package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.AdminLoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminLoginMapper {
    AdminLoginDTO selectAdmin (String adminId);

    void insertAdminInfo (AdminLoginDTO admin);
}
