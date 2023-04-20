package com.warmmingup.buildup.login.service;


import com.warmmingup.buildup.exception.LoginFailedException;
import com.warmmingup.buildup.jwt.TokenProvider;
import com.warmmingup.buildup.login.dao.MemberMapper;
import com.warmmingup.buildup.login.dto.MemberDTO;
import com.warmmingup.buildup.login.dto.TokenDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Autowired
    public AuthService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional

    // 토큰 dto , member dto 바꾸기, return값 member, tokenDTO
    public TokenDTO login(MemberDTO memberDTO) {
        log.info("[AuthService] Login Start ===================================");
        log.info("[AuthService] {}", memberDTO);

        // 1. 아이디 조회
        MemberDTO member = memberMapper.findByMemberId(memberDTO.getEmployeeNo())
                .orElseThrow(()-> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));
//                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));

//        System.out.println(passwordEncoder.encode("0401"));

        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(memberDTO.getEmployeePassword(), member.getEmployeePassword())) {
            log.info("[AuthService] Password Match Fail!!!!!!!!!!!!");
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호입니다");
        }



        // 3. 토큰 발급
        TokenDTO tokenDTO = tokenProvider.generateTokenDto(member);
        log.info("[AuthService] tokenDto {}", tokenDTO);

        log.info("[AuthService] Login End ===================================");
        System.out.println(tokenDTO);

        return tokenDTO;
    }

}

