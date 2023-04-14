package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorityManageMapper {

    List<AuthorityDTO> selectAuthority ();

    void insertNewRole (AuthorityDTO roleName);

    int selectAuthNo ();

    void insertAuthority (Map<String, Object> roleInfo);

    void updateRole (AuthorityDTO role);

    void updateAuthority (Map<String, Object> roleInfo);

    void deleteRole (int role);

    void deleteAuthority (int roleNo);

    int selectRoleName (AuthorityDTO role);

    List<AuthorityDTO> selectAllAuthRoles ();

    List<AuthTypeDTO> selectAllAuthTypes ();
}
