package com.warmmingup.buildup.backlog.controller;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import com.warmmingup.buildup.backlog.service.BacklogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BacklogController {

    private final BacklogService backlogService;

    public BacklogController(BacklogService backlogService) {this.backlogService = backlogService;}

    @GetMapping("/backlogs")
    public ResponseEntity<BacklogDTO> getBacklog(@RequestParam(name="offset", defaultValue="1") int offSet){

        int limit = 5;

        int startBacklog = offSet+ 1;
        int endBacklog = startBacklog + limit;

        Map<String, Integer> BacklogConnect = new HashMap<>();
        BacklogConnect.put("start", startBacklog);
        BacklogConnect.put("end", endBacklog);
        BacklogDTO backlog = backlogService.findAllBacklogs().get(0);
        return ResponseEntity.ok().body(backlog);

    }
   }

