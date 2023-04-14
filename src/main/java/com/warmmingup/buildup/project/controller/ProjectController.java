package com.warmmingup.buildup.project.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.project.service.ProjectService;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService)  { this.projectService = projectService; }

    @GetMapping("/projects")
    public ResponseEntity<ResponseDTO> getProjects(@RequestParam(name="offset", defaultValue="1") int offset) {

        int limit = 10;

        /* 페이징 처리 코드 */
        int startProject = offset;
        int endProject = startProject + limit;

        Map<String, Integer> projectCnt = new HashMap<>();
        projectCnt.put("start", startProject);
        projectCnt.put("end", endProject);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.findAllProjects(projectCnt)));
    }


    @PostMapping("/projects")
    public ResponseEntity<?> registProject(@RequestBody ProjectDTO newProject) {

        int projectNo = projectService.registProject(newProject);

        return ResponseEntity
                .created(URI.create("/projects/" + projectNo)).build();
    }

    @PutMapping("/projects")
    public ResponseEntity<ResponseDTO> modifyProjectTitle(@RequestBody ProjectDTO updateTitle) {

        projectService.modifyProjectTitle(updateTitle);

        return ResponseEntity
                .created(URI.create("api/v1/projects/" + updateTitle.getProjectNo()))
                .build();
    }

    @GetMapping("/projects/{projectNo}")
    public ResponseEntity<ResponseDTO> getProjectMembers(@PathVariable int projectNo, @RequestParam(name="offset", defaultValue="0") int offset) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int limit = 10;

        int startProjectMember = offset * limit;
        int endProjectMember = (offset + 1) * limit;

        Map<String, Integer> projectMemberCnt = new HashMap<>();
        projectMemberCnt.put("start", startProjectMember);
        projectMemberCnt.put("projectNo", projectNo);
        projectMemberCnt.put("end", endProjectMember);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.findAllProjectMembers(projectMemberCnt)));
    }

    @GetMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> getProjectTitle(@PathVariable int projectNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.selectProjectTitle(projectNo)));
    }



    @PutMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> modifyProjectManagerTitle(@RequestBody ProjectDTO modifyTitle) {

        projectService.modifyProjectManagerTitle(modifyTitle);

        return ResponseEntity
                .created(URI.create("api/v1/projects/" + modifyTitle.getProjectNo() + "/manager"))
                .build();
    }
}
