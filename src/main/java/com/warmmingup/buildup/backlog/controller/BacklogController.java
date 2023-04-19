package com.warmmingup.buildup.backlog.controller;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import com.warmmingup.buildup.backlog.service.BacklogService;
import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
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


    @GetMapping("/{projectNo}/backlogs")
    public ResponseEntity<ResponseDTO> findAllBacklogs(@RequestParam(name = "offset", defaultValue = "1") int offSet
                                                      ,@PathVariable(name = "projectNo") int projectNo
                                                      ,@RequestParam(name = "search", defaultValue="" )String searchValue) {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                new MediaType("application", "json",Charset.forName("UTF-8")));

        Map<String, Object> BacklogConnect = new HashMap<>();

        BacklogConnect.put("projectNo",projectNo);
        if(! "".equals(searchValue)){
            BacklogConnect.put("searchValue","%"+searchValue+"%");
        }

        int totalCount = backlogService.selectBacklogTotal(BacklogConnect);
        int limit = 5;
        int buttonAmount = 10;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(offSet, totalCount, limit, buttonAmount);
        BacklogConnect.put("pageInfo",selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(backlogService.selectBacklogListWithPaging(BacklogConnect));

        System.out.println(responseDtoWithPaging);

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));

    }



    @PostMapping("/project/{projectNo}/backlogs")
    public ResponseEntity<?> registBacklog(@RequestBody BacklogDTO newBacklog
                                          ,@PathVariable(name = "projectNo") int projectNo) {
        int backlogNo = backlogService.registBacklog(projectNo,newBacklog);


        return ResponseEntity
                .created(URI.create("/backlogs/" + backlogNo)).build();


    }
    
    @PutMapping("/project/{projectNo}/backlogs")
    public ResponseEntity<ResponseDTO> updateBacklog(@RequestBody BacklogDTO updateBacklog
                                                    ,@PathVariable(name = "projectNo") int projectNo) {
        backlogService.updateBacklogs(projectNo,updateBacklog);
        return ResponseEntity.created(URI.create("/api/v1/backlgs/" + updateBacklog.getBacklogNo())).build();

    }

    @DeleteMapping("/backlogs/{backlogNo}")
    public ResponseEntity<ResponseDTO> deleteBacklog(@PathVariable int backlogNo) {
        backlogService.deleteBacklog(backlogNo);
        return ResponseEntity.noContent().build();
    }




}