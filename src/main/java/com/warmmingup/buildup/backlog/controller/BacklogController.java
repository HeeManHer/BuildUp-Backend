package com.warmmingup.buildup.backlog.controller;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import com.warmmingup.buildup.backlog.service.BacklogService;
import com.warmmingup.buildup.common.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class BacklogController {

    private final BacklogService backlogService;

    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }

    @GetMapping("/backlogs")
    public ResponseEntity<ResponseDTO> getBacklog(@RequestParam(name = "offset", defaultValue = "0") int offSet) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json", Charset.forName("UTF-8")));
        int limit = 5;
        int startBacklog = offSet + 1;
        int endBacklog = startBacklog + limit;

        Map<String, Integer> BacklogConnect = new HashMap<>();
        BacklogConnect.put("start", startBacklog);
        BacklogConnect.put("end", endBacklog);
        List<BacklogDTO> backlogs = backlogService.findAllBacklogs();
        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", backlogService.findAllBacklogs()));

    }

    @GetMapping("/backlogs/search")
    public ResponseEntity<ResponseDTO> getBacklogs(@RequestParam(name = "search") String searchValue,
                                                 @RequestParam(name = "offset", defaultValue = "0") int offset) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        int limit = 5;
        int startBacklog = offset;
        int endBacklog = startBacklog + limit;

        Map<String, Object> searchbacklog = new HashMap<>();
        searchbacklog.put("start",startBacklog);
        searchbacklog.put("search",'%' + searchValue + '%');
        searchbacklog.put("end",endBacklog);
        List<BacklogDTO> backlogs = backlogService.searchBacklogs(searchbacklog);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(backlogs);

        return new ResponseEntity<>(responseDTO, headers, HttpStatus.OK);
    }








    @PostMapping("/backlogs")
    public ResponseEntity<?> registBacklog(@RequestBody BacklogDTO newBacklog) {
        System.out.println(newBacklog);
        int backlogNo = backlogService.registBacklog(newBacklog);

        return ResponseEntity
                .created(URI.create("/backlogs/" + backlogNo)).build();


    }

    @PutMapping("/backlogs")
    public ResponseEntity<ResponseDTO> updateBacklog(@RequestBody BacklogDTO updateBacklog) {
        System.out.println(updateBacklog);
        backlogService.updateBacklogs(updateBacklog);
        return ResponseEntity.created(URI.create("/api/v1/backlgs/" + updateBacklog.getBacklogNo())).build();

    }

    @DeleteMapping("/backlogs/{backlogNo}")
    public ResponseEntity<ResponseDTO> deleteBacklog(@PathVariable int backlogNo) {
        backlogService.deleteBacklog(backlogNo);
        return ResponseEntity.noContent().build();
    }



}
