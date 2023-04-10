package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.admin.dto.UserDTO;
import com.warmmingup.buildup.admin.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(@RequestParam(name = "offset", defaultValue = "0") String offset) {

        int limit = 10;

        int startUser = Integer.parseInt(offset) + 1;
        int endUser = startUser + limit;

        Map<String, Integer> userCnt = new HashMap<>();
        userCnt.put("start", startUser);
        userCnt.put("end", endUser);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", adminService.findAllUsers(userCnt)));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> insertUser(@ModelAttribute UserDTO newUser) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원 등록 성공", adminService.insertUser(newUser)));
    }

}
