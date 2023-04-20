package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.AdminLoginMapper;
import com.warmmingup.buildup.admin.dto.AdminLoginDTO;
import com.warmmingup.buildup.exception.LoginFailedException;
import com.warmmingup.buildup.jwt.TokenProvider;
import com.warmmingup.buildup.login.dto.TokenDTO;
import com.warmmingup.buildup.login.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminLoginService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final AdminLoginMapper adminLoginMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;


    public AdminLoginService (AdminLoginMapper adminLoginMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.adminLoginMapper = adminLoginMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    public TokenDTO login (AdminLoginDTO adminInfo) {

        log.info("[AuthService] Login Start ===================================");
        log.info("[AuthService] {}", adminInfo);

        // 1. 아이디 조회
        AdminLoginDTO admin = adminLoginMapper.selectAdmin(adminInfo.getAdminId());
        System.out.println(admin);
        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(adminInfo.getAdminPwd(), admin.getAdminPwd())) {
            log.info("[AuthService] Password Match Fail!!!!!!!!!!!!");
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호입니다");
        }
        System.out.println(2);

        // 3. 토큰 발급
        TokenDTO tokenDTO = tokenProvider.generateTokenDto(admin);
        log.info("[AuthService] tokenDto {}", tokenDTO);

        log.info("[AuthService] Login End ===================================");
        System.out.println(tokenDTO);

        return tokenDTO;
    }

    @Transactional
    public void registAdmin (AdminLoginDTO adminInfo) {

        adminInfo.setAdminPwd(passwordEncoder.encode(adminInfo.getAdminPwd()));

        adminLoginMapper.insertAdminInfo(adminInfo);

    }
}
