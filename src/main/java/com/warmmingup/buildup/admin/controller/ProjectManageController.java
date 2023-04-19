package com.warmmingup.buildup.admin.controller;

import com.warmmingup.buildup.admin.service.ProjectManageService;
import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
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
    public ResponseEntity<ResponseDTO> getProject (@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "search", defaultValue = "") String searchValue) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> projectManage = new HashMap<>();
        if (!"".equals(searchValue)) {
            projectManage.put("search", "%" + searchValue + "%");
        }

        int totalCount = projectManageService.findProjectTotalCount(projectManage);
        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);
        projectManage.put("pageInfo", selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(projectManageService.findProjectManage(projectManage));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }
}
