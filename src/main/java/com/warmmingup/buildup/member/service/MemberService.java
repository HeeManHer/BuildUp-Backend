package com.warmmingup.buildup.member.service;

import com.warmmingup.buildup.exception.LoginFailedException;
import com.warmmingup.buildup.login.dao.LoginMapper;
import com.warmmingup.buildup.login.dto.MemberDTO;
import com.warmmingup.buildup.member.dao.MemberMapper;
import com.warmmingup.buildup.member.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberMapper memberMapper;
    private final LoginMapper loginMapper;


    public MemberService(PasswordEncoder passwordEncoder, MemberMapper memberMapper, LoginMapper loginMapper) {
        this.passwordEncoder = passwordEncoder;
        this.memberMapper = memberMapper;
        this.loginMapper = loginMapper;
    }

    @GetMapping
    public MemberDTO selectMyEmployeeInfo(@PathVariable String employeeNo) {
        log.info("[MemberService] getMyInfo Start ==============================");

        MemberDTO member = memberMapper.selectByMemberId(employeeNo);
        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End ==============================");

        return member;
    }

    @Transactional
    public String modifyEmployeePassword(EmployeeDTO modifyPassword) {

        MemberDTO member = loginMapper.findByMemberId(modifyPassword.getEmployeeNo())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));


        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(modifyPassword.getEmployeePassword(), member.getEmployeePassword())) {
            log.info("[AuthService] Password Match Fail!!!!!!!!!!!!");

            return "현재 비밀번호가 틀립니다!!";
        }
        modifyPassword.setNewPassword(passwordEncoder.encode(modifyPassword.getNewPassword()));

        memberMapper.modifyEmployeePassword(modifyPassword);

        return "비밀번호 변경 성공 !!";
    }

    @Transactional
    public String resetEmployeePassword(EmployeeDTO modifyPassword) {

        modifyPassword.setNewPassword(passwordEncoder.encode(modifyPassword.getNewPassword()));

        memberMapper.modifyEmployeePassword(modifyPassword);

        return "비밀번호 변경 성공 !!";
    }


    public String findEmployee(MemberDTO member) {

        int result = memberMapper.selectMember(member);

        return result > 0 ? "정보가 일치합니다" : "일치하는 정보가 없습니다.";
    }
}

