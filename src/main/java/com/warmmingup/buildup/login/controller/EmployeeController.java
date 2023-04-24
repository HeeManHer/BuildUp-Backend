package com.warmmingup.buildup.login.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.login.dto.EmployeeDTO;
import com.warmmingup.buildup.login.dto.MemberDTO;
import com.warmmingup.buildup.login.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final MemberService memberService;


    public EmployeeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/auth/login/{employeeNo}")
    public ResponseEntity<ResponseDTO> selectMyEmployeeInfo(@PathVariable String employeeNo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectMyEmployeeInfo(employeeNo)));
    }

    @PutMapping("/changepassword/{employeeNo}")
    public ResponseEntity<ResponseDTO> modifyEmployeePassword(@RequestBody EmployeeDTO employeeDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "변경 성공!!", memberService.modifyEmployeePassword(employeeDTO)));
    }

    @PutMapping("/password")
    public ResponseEntity<ResponseDTO> resetEmployeePassword(@RequestBody EmployeeDTO employeeDTO) {

        System.out.println(employeeDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "변경 성공!!", memberService.resetEmployeePassword(employeeDTO)));
    }

    @PostMapping("/member")
    public ResponseEntity<ResponseDTO> selectEmployee(@RequestBody MemberDTO member) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, memberService.findEmployee(member), member.getEmployeeNo()));
    }
}
