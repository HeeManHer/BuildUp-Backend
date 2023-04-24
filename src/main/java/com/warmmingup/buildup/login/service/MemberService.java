package com.warmmingup.buildup.login.service;

import com.warmmingup.buildup.exception.LoginFailedException;
import com.warmmingup.buildup.login.dao.MemberMapper;
import com.warmmingup.buildup.login.dto.EmployeeDTO;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberMapper memberMapper;


    public MemberService (PasswordEncoder passwordEncoder, MemberMapper memberMapper) {
        this.passwordEncoder = passwordEncoder;
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public MemberDTO selectMyEmployeeInfo (@PathVariable String employeeNo) {
        log.info("[MemberService] getMyInfo Start ==============================");

        MemberDTO member = memberMapper.selectByMemberId(employeeNo);
        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End ==============================");

        return member;
    }


    public String modifyEmployeePassword (EmployeeDTO modifyPassword) {

        MemberDTO member = memberMapper.findByMemberId(modifyPassword.getEmployeeNo()).orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));
        //                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));

        //        System.out.println(passwordEncoder.encode("0401"));

        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(modifyPassword.getEmployeePassword(), member.getEmployeePassword())) {
            log.info("[AuthService] Password Match Fail!!!!!!!!!!!!");

            return "현재 비밀번호가 틀립니다!!";
        }
        modifyPassword.setNewPassword(passwordEncoder.encode(modifyPassword.getNewPassword()));

        System.out.println(modifyPassword.getNewPassword());
        memberMapper.modifyEmployeePassword(modifyPassword);

        return "비밀번호 변경 성공 !!";
    }

    public String resetEmployeePassword (EmployeeDTO modifyPassword) {

        modifyPassword.setNewPassword(passwordEncoder.encode(modifyPassword.getNewPassword()));

        System.out.println(modifyPassword.getNewPassword());
        memberMapper.modifyEmployeePassword(modifyPassword);

        return "비밀번호 변경 성공 !!";
    }


    public String findEmployee (MemberDTO member) {

        int result = memberMapper.selectMember(member);

        return result > 0 ? "정보가 일치합니다" : "일치하는 정보가 없습니다.";
    }
}

