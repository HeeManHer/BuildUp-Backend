package com.warmmingup.buildup.login.controller;


import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.login.dto.MemberDTO;
import com.warmmingup.buildup.login.dto.TokenDTO;
import com.warmmingup.buildup.login.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }



    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO) {

//        System.out.println("memberDTO = " + memberDTO);

//        MemberDTO member = authService.login(memberDTO);

        System.out.println("12312312300000000000");
        TokenDTO accessToken = authService.login(memberDTO);

//        System.out.println("member = " + member);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));
    }

}