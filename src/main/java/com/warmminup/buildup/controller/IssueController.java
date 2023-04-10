package com.warmminup.buildup.controller;

import com.warmminup.buildup.model.dto.IssueDTO;
import com.warmminup.buildup.model.service.IssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {this.issueService = issueService;}


        @GetMapping("/issues")
        public ResponseEntity<IssueDTO> getIssues(@RequestParam(name="offset",defaultValue="1") int offset) {

            int limit = 10;

            int startIssue = offset +1;
            int endIssue = startIssue + limit;


            Map<String, Integer> IssueConnect = new HashMap<>();
            IssueConnect.put("start", startIssue);
            IssueConnect.put("end", endIssue);
            IssueDTO issue = issueService.findAllIssues().get(0);
            return ResponseEntity.ok().body(issue);
        }


}
