package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthorityManageMapper {

    List<AuthorityDTO> selectAllAuthority (SelectCriteria selectCriteria);

    List<AuthorityDTO> selectAuthorityByNo (int authNo);

    List<AuthTypeDTO> selectAllAuthTypes ();

    void insertNewRole (AuthorityDTO roleName);

    void insertAuthority (Map<String, Object> roleInfo);

    int selectAuthNo ();

    void updateRole (AuthorityDTO role);

    void deleteRole (int role);

    void deleteAuthority (int roleNo);

    int selectAuthorityTotalCount ();

    void insertNewType (AuthTypeDTO type);

    void insertNewAuthorityState (AuthTypeDTO type);

    void insertNewAuthority (AuthTypeDTO type);

    void deleteType (int typeNo);

    void deleteAuthorityType (int typeNo);

    void deleteRoleAuthorityType (int typeNo);

    int selectTypeNo (String typeName);
}
