package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.AuthorityManageMapper;
import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("AuthorityManageService")
public class AuthorityManageServiceImpl implements AuthorityManageService {


    private final AuthorityManageMapper authorityManageMapper;

    public AuthorityManageServiceImpl (AuthorityManageMapper authorityManageMapper) {
        this.authorityManageMapper = authorityManageMapper;
    }

    @Override
    public List<AuthorityDTO> findAuthority () {

        return authorityManageMapper.selectAuthority();
    }

    @Override
    public int selectAuthNo () {
        return authorityManageMapper.selectAuthNo();
    }

    @Override
    @Transactional
    public void registAuthority (AuthorityDTO auth) {
        int roleNo = authorityManageMapper.selectRoleName(auth);

        if (roleNo > 0) {
            return;
        } else {
            auth.setRoleNo(selectAuthNo());
            authorityManageMapper.insertNewRole(auth);
        }

        insertAuthority(auth);
    }

    @Override
    @Transactional
    public void updateAuthority (List<AuthorityDTO> auth) {

        for (AuthorityDTO role : auth) {

            authorityManageMapper.updateRole(role);
            authorityManageMapper.deleteAuthority(role.getRoleNo());

            insertAuthority(role);
        }
    }

    @Override
    public void deleteAuthority (int roleNo) {
        authorityManageMapper.deleteRole(roleNo);
        authorityManageMapper.deleteAuthority(roleNo);
    }

    @Override
    public List<AuthorityDTO> findAuthRole () {

        return authorityManageMapper.selectAllAuthRoles();
    }

    @Override
    public List<AuthTypeDTO> findAuthType () {

        return authorityManageMapper.selectAllAuthTypes();
    }

    @Transactional
    public void insertAuthority (AuthorityDTO auth) {

        Map<String, Object> roleInfo = new HashMap<>();
        roleInfo.put("roleNo", auth.getRoleNo());
        roleInfo.put("typeName", auth.getTypeName());
        roleInfo.put("state", auth.getState());

        authorityManageMapper.insertAuthority(roleInfo);

    }
}
