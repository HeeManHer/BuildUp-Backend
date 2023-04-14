package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.service.DashboardService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/api/v1")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController (DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    @GetMapping("/dash-issue")
    public ResponseEntity<ResponseDTO> findDashIssue () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "대쉬보드 이슈현황 조회 성공", dashboardService.findDashIssue()));
    }

    @GetMapping("/dash-backlog")
    public ResponseEntity<ResponseDTO> findDashBacklog () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "대쉬보드 백로그현황 조회 성공", dashboardService.findDashBacklog()));
    }

    @GetMapping("/dash-sprint")
    public ResponseEntity<ResponseDTO> findDashSprint () {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "대쉬보드 스프린트현황 조회 성공", dashboardService.findDashSprint()));
    }

    @GetMapping("/dash-project")
    public ResponseEntity<ResponseDTO> findDashProject () {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "대시보드 프로젝트 조회 성공", dashboardService.findDashProject()));
    }

    @GetMapping("/dash-auth")
    public ResponseEntity<ResponseDTO> findChartAuth () {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "차트 권한 조회 성공", dashboardService.findChartAuth()));
    }
}
