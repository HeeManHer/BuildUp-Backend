package com.warmmingup.buildup.login.service;

import com.warmmingup.buildup.login.dao.MemberMapper;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {this.memberMapper = memberMapper;}

    @Override
    public List<MemberDTO> findAllMembers() {

        return memberMapper.findAllMembers();
    }
}
