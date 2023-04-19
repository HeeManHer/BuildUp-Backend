package com.warmmingup.buildup.issue.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import com.warmmingup.buildup.issue.service.IssueService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.warmmingup.buildup.common.paging.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/projects/{projectNo}")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {this.issueService = issueService;}


    @GetMapping("/issues")
    public ResponseEntity<ResponseDTO> getIssues(@RequestParam(name="offset",defaultValue="1") int offset ,
                                                 @PathVariable (name="projectNo") int projectNo,
                                                 @RequestParam(name = "search", defaultValue = "") String searchValue) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", Charset.forName("UTF-8")));
        int totalCount = issueService.selectIssueTotal(projectNo);
        int limit = 10;
        int buttonAmount = 5;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(offset, totalCount, limit,buttonAmount);

        Map<String, Object> IssueConnect = new HashMap<>();
        IssueConnect.put("projectNo",projectNo);
        IssueConnect.put("PageInfo", selectCriteria);

        System.out.println(IssueConnect.get("projectNo"));
        if (!"".equals( searchValue)) {
            IssueConnect.put("search",'%' + searchValue + '%');
        }

            ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(issueService.findAllIssues(IssueConnect));




        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK,"조회 성공",responseDtoWithPaging));
    }

    @PostMapping("/issues")
    public ResponseEntity<?> registIssue(@RequestBody IssueDTO newIssue) {
        System.out.println(newIssue);
       int issueNo= issueService.registIssue(newIssue);

        return ResponseEntity
                .created(URI.create("/issues/" + issueNo)).build();

    }

    @PutMapping("/issues")
    public ResponseEntity<ResponseDTO> updateProductReview(@RequestBody IssueDTO updateIssue) {
        issueService.updateIssues(updateIssue);
        return ResponseEntity.created(URI.create("/api/v1/issues/"+updateIssue.getIssueNo())).build();
    }


    @DeleteMapping("/issues/{issueNo}")
    public ResponseEntity<ResponseDTO> removeIssue(@PathVariable int issueNo) {
        issueService.removeIssues(issueNo);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/issues/backloglist")
    public ResponseEntity<ResponseDTO> getbacklog(@PathVariable int projectNo) {
        System.out.println(projectNo);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK,"조회 성공",issueService.getBacklogByNo(projectNo)));
    }
//    @GetMapping("/issues/search")
//    public ResponseEntity<ResponseDTO> getIssues(@RequestParam(name = "search") String searchValue,
//                                                 @RequestParam(name = "offset", defaultValue = "0") int offset) {
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//        int limit = 10;
//        int startIssue = offset;
//        int endIssue = startIssue + limit;
//
//        Map<String, Object> searchissue = new HashMap<>();
//        searchissue.put("start",startIssue);
//        searchissue.put("search",'%' + searchValue + '%');
//        searchissue.put("end",endIssue);
//        List<IssueDTO> issues = issueService.searchIssues(searchissue);
//
//        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setData(issues);
//
//        return new ResponseEntity<>(responseDTO, headers, HttpStatus.OK);
//    }
}
