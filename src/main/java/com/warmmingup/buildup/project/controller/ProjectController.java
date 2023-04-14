package com.warmmingup.buildup.project.controller;

import com.warmmingup.buildup.project.service.ProjectService;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService)  { this.projectService = projectService; }

    @GetMapping("/projects")
    public ResponseEntity<ProjectDTO> getProjects(@RequestParam(name="offset", defaultValue="1") int offset) {

        int limit = 10;

        int startProject = offset + 1;
        int endProject = startProject + limit;

        Map<String, Integer> ProjectConnect = new HashMap<>();
        ProjectConnect.put("start", startProject);
        ProjectConnect.put("end", endProject);
        ProjectDTO project = projectService.findAllProjects().get(0);

        return ResponseEntity.ok().body(project);

    }

//    @PostMapping("projects")
//    public ResponseEntity<?> registProject(@RequestBody ProjectDTO newProject) {
//
//        int lastProjectNo = projects.get(projects.size)
//    }
}
