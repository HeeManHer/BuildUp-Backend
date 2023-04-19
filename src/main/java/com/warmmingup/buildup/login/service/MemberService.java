package com.warmmingup.buildup.login.service;

import com.warmmingup.buildup.login.dao.MemberMapper;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public MemberDTO selectMyEmployeeInfo(@PathVariable String  employeeNo) {
        log.info("[MemberService] getMyInfo Start ==============================");

        MemberDTO member = memberMapper.selectByMemberId( employeeNo);
        log.info("[MemberService] {}",   member);
        log.info("[MemberService] getMyInfo End ==============================");

        return member;
    }
}

