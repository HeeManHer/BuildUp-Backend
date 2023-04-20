package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dto.AuthorityDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import com.warmmingup.buildup.project.dto.projectEmployeeDTO;

import java.util.List;
import java.util.Map;

public interface ProjectService {


    Object findAllProjects(Map<String, Integer> projectCnt);

    int registProject(BringProjectDTO newProject);

//    void modifyProjectTitle(ProjectDTO updateTitle);

    List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt);

    Object selectProjectTitle(int projectNo);

    void modifyProjectManagerTitle(ProjectDTO modifyTitle);

    void removeProject(int projectNo);

    void inviteTeamMember(BringProjectDTO inviteMember);

    void removeTeamMember(Map<String, Object> removeMember);

    void modifyMemberAuthority(Map<String, Object> map);
    List<AuthorityDTO> findAuthority();
//    List<projectEmployeeDTO> searchMembers(Map<String, Object> searchMembers);
}
