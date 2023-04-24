package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.AuthorityManageMapper;
import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorityManageService {


    private final AuthorityManageMapper authorityManageMapper;

    public AuthorityManageService (AuthorityManageMapper authorityManageMapper) {
        this.authorityManageMapper = authorityManageMapper;
    }


    public int findAuthorityTotalCount () {
        return authorityManageMapper.selectAuthorityTotalCount();
    }


    public List<AuthorityDTO> findAllAuthority (SelectCriteria selectCriteria) {
        return authorityManageMapper.selectAllAuthority(selectCriteria);
    }


    public List<AuthorityDTO> findAuthorityDetail (int authNo) {

        return authorityManageMapper.selectAuthorityByNo(authNo);
    }


    public List<AuthTypeDTO> findAuthType () {

        return authorityManageMapper.selectAllAuthTypes();
    }


    @Transactional
    public int registAuthority (AuthorityDTO auth) {
        authorityManageMapper.insertNewRole(auth);
        auth.setRoleNo(authorityManageMapper.selectAuthNo());

        insertAuthorityType(auth);

        return auth.getRoleNo();
    }

    @Transactional
    public void insertAuthorityType (AuthorityDTO auth) {
        Map<String, Object> authority = new HashMap<>();
        authority.put("roleNo", auth.getRoleNo());

        for (AuthTypeDTO type : auth.getType()) {
            if (type.getState().size() == 0)
                continue;
            authority.put("typeNo", type.getTypeNo());
            for (String state : type.getState()) {
                authority.put("state", state);
                authorityManageMapper.insertAuthority(authority);
            }
        }
    }


    @Transactional
    public void updateAuthority (AuthorityDTO auth) {

        authorityManageMapper.updateRole(auth);
        authorityManageMapper.deleteAuthority(auth.getRoleNo());

        insertAuthorityType(auth);
    }

    @Transactional
    public void deleteAuthority (int roleNo) {
        authorityManageMapper.deleteRole(roleNo);
    }


}
