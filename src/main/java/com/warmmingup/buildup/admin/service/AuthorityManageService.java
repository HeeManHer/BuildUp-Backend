package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;
import com.warmmingup.buildup.common.paging.SelectCriteria;

import java.util.List;

public interface AuthorityManageService {
    int findAuthorityTotalCount ();

    List<AuthorityDTO> findAllAuthority (SelectCriteria selectCriteria);

    List<AuthorityDTO> findAuthorityDetail (int authNo);

    List<AuthTypeDTO> findAuthType ();

    int registAuthority (AuthorityDTO role);

    void updateAuthority (AuthorityDTO role);

    void deleteAuthority (int roleNo);

    int addNewAuthType (AuthTypeDTO type);

    void deleteAuthType (String typeNo);
}
