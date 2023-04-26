package com.warmmingup.buildup.project.controller;

import com.warmmingup.buildup.common.ResponseDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import com.warmmingup.buildup.project.dto.projectEmployeeDTO;
import com.warmmingup.buildup.project.service.ProjectService;
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
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /* 프로젝트 조회 페이지 전체 프로젝트 조회 */
    @GetMapping("/{employeeNo}/projects")
    public ResponseEntity<ResponseDTO> getProjects(@PathVariable int employeeNo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.findAllProjects(employeeNo)));
    }

    /* 프로젝트 생성 시 제목, 담당자, 팀원 초대까지 다 되게 PostMapping */
    @PostMapping("/projects")
    public ResponseEntity<ResponseDTO> insertProject(@RequestBody BringProjectDTO newProject) {

        int projectNo = projectService.registProject(newProject);

        return ResponseEntity.created(URI.create("/api/v1/projects/" + projectNo)).build();
    }


    /* 프로젝트 상세 조회 페이지 */
    @GetMapping("/projects/{projectNo}")
    public ResponseEntity<ResponseDTO> getProjectMembers(@PathVariable int projectNo, @RequestParam(name = "offset", defaultValue = "0") int offset) {

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

    /* 프로젝트 관리 페이지 권한 조회 */
    @GetMapping("/projects/authority")
    public ResponseEntity<ResponseDTO> getAuthority() {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.findAuthority()));
    }

    /* 프로젝트 관리 페이지 프로젝트 명 조회 */
    @GetMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> getProjectTitle(@PathVariable int projectNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return ResponseEntity.ok().headers(headers).body(new ResponseDTO(HttpStatus.OK, "조회 성공", projectService.findProjectTitle(projectNo)));
    }

    /* 프로젝트 관리 페이지 프로젝트 명 수정 */
    @PutMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> updateProjectTitle(@RequestBody ProjectDTO modifyTitle) {

        projectService.modifyProjectManagerTitle(modifyTitle);

        return ResponseEntity
                .created(URI.create("api/v1/projects/" + modifyTitle.getProjectNo() + "/manager"))
                .build();
    }

    /* 프로젝트 관리 페이지에서 팀원 초대 */
    @PostMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> insertMember(@RequestBody BringProjectDTO inviteMember) {

        projectService.inviteProjectMember(inviteMember);

        return ResponseEntity
                .created(URI.create("api/v1/projects/" + inviteMember.getProjectNo() + "/manager"))
                .build();
    }

    /* 프로젝트 관리 페이지에서 팀원 권한 수정 */
    @PutMapping("/projects/{projectNo}/manager/authority")
    public ResponseEntity<ResponseDTO> updateMemberAuthority(@PathVariable int projectNo, @RequestBody projectEmployeeDTO modifyAuthority) {

        Map<String, Object> map = new HashMap<>();
        map.put("projectNo", projectNo);
        map.put("roleNo", modifyAuthority.getRoleNo());
        map.put("employeeNo", modifyAuthority.getEmployeeNo());

        projectService.modifyMemberAuthority(map);

        return ResponseEntity
                .created(URI.create("api/v1/projects/" + projectNo + "/manager/member"))
                .build();
    }

    /* 프로젝트 관리 페이지 프로젝트 삭제 */
    @DeleteMapping("/projects/{projectNo}/manager")
    public ResponseEntity<ResponseDTO> deleteProject(@PathVariable int projectNo) {

        projectService.removeProject(projectNo);

        return ResponseEntity.noContent().build();
    }

    /* 프로젝트 관리 페이지에서 팀원 삭제 */
    @DeleteMapping("/projects/{projectNo}/manager/member")
    public ResponseEntity<ResponseDTO> deleteMember(@PathVariable int projectNo, @RequestBody List<String> employeeNo) {

        Map<String, Object> removeMember = new HashMap<>();
        removeMember.put("projectNo", projectNo);
        removeMember.put("employeeNo", employeeNo);

        projectService.removeProjectMember(removeMember);

        return ResponseEntity.noContent().build();
    }

}

