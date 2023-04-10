package com.warmminup.buildup.model.service;

import com.warmminup.buildup.model.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    List<MemberDTO> findAllMembers();
}
