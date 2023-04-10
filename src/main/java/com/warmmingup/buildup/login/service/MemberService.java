package com.warmmingup.buildup.login.service;

import com.warmmingup.buildup.login.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> findAllMembers();
}
