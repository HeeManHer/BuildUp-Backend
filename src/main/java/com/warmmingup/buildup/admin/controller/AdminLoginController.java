package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.dto.AdminLoginDTO;
import com.warmmingup.buildup.admin.service.AdminLoginService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class AdminLoginController {

    private final AdminLoginService adminLoginService;

    public AdminLoginController (AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    @PostMapping("/manage-login")
    public ResponseEntity<ResponseDTO> login (@RequestBody AdminLoginDTO admin) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", adminLoginService.login(admin)));
    }

    @PostMapping("/manage-admin")
    public ResponseEntity<ResponseDTO> registAdmin (@RequestBody AdminLoginDTO admin) {
        adminLoginService.registAdmin(admin);

        return ResponseEntity.ok().build();
    }
}
