package com.warmmingup.buildup.sprint.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.common.paging.Pagenation;
import com.warmmingup.buildup.common.paging.ResponseDtoWithPaging;
import com.warmmingup.buildup.common.paging.SelectCriteria;
import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.service.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SprintController {
    private final SprintService sprintService;

    public SprintController (SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping("/{projectNo}/sprints")
    public ResponseEntity<ResponseDTO> getSprint (@PathVariable int projectNo, @RequestParam(name = "offset", defaultValue = "1") int offset) {

        Map<String, Object> sprintMap = new HashMap<>();
        sprintMap.put("projectNo", projectNo);

        int limit = 5;
        int buttonAmount = 5;
        int totalCount = sprintService.findSprintTotalCount(sprintMap);

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(offset, totalCount, limit, buttonAmount);
        sprintMap.put("pageInfo", selectCriteria);

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(sprintService.findAllSprints(sprintMap));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    @GetMapping("sprints/{sprintNo}")
    public ResponseEntity<ResponseDTO> selectBoard (@PathVariable int sprintNo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "보드 조회 성공", sprintService.selectBoard(sprintNo)));
    }

    @PostMapping("/sprints")
    public ResponseEntity<ResponseDTO> insertSprint (@RequestBody SprintDTO sprintNew) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 등록 성공", sprintService.insertSprint(sprintNew)));
    }

    @PutMapping("/sprints/{sprintNo}")
    public ResponseEntity<ResponseDTO> updateSprint(@PathVariable int  sprintNo) {
        System.out.println(1);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 수정 성공", sprintService.updateSprint(sprintNo)));
    }

    //    @PatchMapping("/sprints")
    //    public ResponseEntity<ResponseDTO> patchSprint(@RequestBody SprintDTO sprintPth) {
    //
    //        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 수정 성공", sprintService.patchSprint(sprintPth)));
    //    }

    @DeleteMapping("/sprints/{sprintNo}")
    public ResponseEntity<ResponseDTO> deleteSprint (@PathVariable int sprintNo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 삭제 성공", sprintService.deleteSprint(sprintNo)));
    }


}

