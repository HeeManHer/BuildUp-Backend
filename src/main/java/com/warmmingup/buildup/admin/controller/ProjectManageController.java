package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.service.ProjectManageService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProjectManageController {

    private final ProjectManageService projectManageService;

    public ProjectManageController (ProjectManageService projectManageService) {
        this.projectManageService = projectManageService;
    }

    @GetMapping("/manage-projects")
    public ResponseEntity<ResponseDTO> getProject (@RequestParam(name = "offset", defaultValue = "0") int offset, @RequestParam(name = "search", defaultValue = "") String searchValue) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int limit = 10;
        String start = limit * offset + "";
        String end = limit * (offset + 1) + "";

        Map<String, String> projectManage = new HashMap<>();

        projectManage.put("start", start);
        projectManage.put("end", end);
        if (!"".equals(searchValue)) {
            projectManage.put("search", "%" + searchValue + "%");
        }

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectManageService.findProjectManage(projectManage)));
    }
}
