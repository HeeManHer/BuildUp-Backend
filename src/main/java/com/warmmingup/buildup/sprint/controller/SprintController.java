package com.warmmingup.buildup.sprint.controller;

import com.warmmingup.buildup.common.ResponseDTO;
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

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping("/sprints")
    public ResponseEntity<ResponseDTO> getSprint(@RequestParam(name="offset",defaultValue="0") String offset) {

        int limit = 10;

        int startSprint = Integer.parseInt(offset) + 1;
        int endSprint = startSprint + limit;


        Map<String, Integer> sprintCnt = new HashMap<>();
        sprintCnt.put("start", startSprint);
        sprintCnt.put("end", endSprint);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", sprintService.findAllSprints(sprintCnt)));

    }

    @PostMapping("/sprints")
    public ResponseEntity<ResponseDTO> insertSprint(@RequestBody SprintDTO sprintNew) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 등록 성공", sprintService.insertSprint(sprintNew)));
    }

    @PutMapping("/sprints")
    public ResponseEntity<ResponseDTO> updateSprint(@RequestBody SprintDTO sprintUpd) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 전체 수정 성공", sprintService.updateSprint(sprintUpd)));
    }

    @PatchMapping("/sprints")
    public ResponseEntity<ResponseDTO> patchSprint(@RequestBody SprintDTO sprintPth) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 수정 성공", sprintService.patchSprint(sprintPth)));
    }

    @DeleteMapping ("/sprints")
    public ResponseEntity<ResponseDTO> deleteSprint(@RequestBody SprintDTO sprintDel) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스프린트 삭제 성공", sprintService.deleteSprint(sprintDel)));
    }

}

