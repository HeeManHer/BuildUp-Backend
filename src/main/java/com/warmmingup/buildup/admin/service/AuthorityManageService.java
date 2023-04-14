package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.AuthTypeDTO;
import com.warmmingup.buildup.admin.dto.AuthorityDTO;

import java.util.List;

public interface AuthorityManageService {
    List<AuthorityDTO> findAuthority ();

    int selectAuthNo ();

    void registAuthority (AuthorityDTO role);

    void updateAuthority (List<AuthorityDTO> role);

    void deleteAuthority (int roleNo);

    List<AuthorityDTO> findAuthRole ();

    List<AuthTypeDTO> findAuthType ();
}
