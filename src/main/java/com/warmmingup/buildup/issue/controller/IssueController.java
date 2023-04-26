package com.warmmingup.buildup.issue.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import com.warmmingup.buildup.issue.service.IssueService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/projects/{projectNo}")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @GetMapping("/issues")
    public ResponseEntity<ResponseDTO> getIssues(@RequestParam(name = "offset", defaultValue = "1") int offset,
                                                 @PathVariable(name = "projectNo") int projectNo,
                                                 @RequestParam(name = "search", defaultValue = "") String searchValue) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> issueMap = new HashMap<>();

        issueMap.put("projectNo", projectNo);

        if (!"".equals(searchValue)) {
            issueMap.put("search", '%' + searchValue + '%');
        }

        int totalCount = issueService.selectIssueTotalCount(issueMap);
        int limit = 5;
        int buttonAmount = 10;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(offset, totalCount, limit, buttonAmount);
        issueMap.put("pageInfo", selectCriteria);


        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(issueService.findAllIssues(issueMap));


        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    @GetMapping("/issues/backloglist")
    public ResponseEntity<ResponseDTO> getbacklog(@PathVariable int projectNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", issueService.getBacklogByNo(projectNo)));
    }

    @PostMapping("/issues")
    public ResponseEntity<?> insertIssue(@RequestBody IssueDTO newIssue) {
        int issueNo = issueService.registIssue(newIssue);

        return ResponseEntity.created(URI.create("/issues/" + issueNo)).build();

    }

    @PutMapping("/issues")
    public ResponseEntity<ResponseDTO> updateProductReview(@RequestBody IssueDTO updateIssue) {

        issueService.updateIssues(updateIssue);
        return ResponseEntity.created(URI.create("/api/v1/issues/" + updateIssue.getIssueNo())).build();
    }


    @DeleteMapping("/issues/{issueNo}")
    public ResponseEntity<ResponseDTO> deleteIssue(@PathVariable int issueNo) {
        issueService.removeIssues(issueNo);

        return ResponseEntity.noContent().build();
    }

}

