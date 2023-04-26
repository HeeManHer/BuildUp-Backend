package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dto.AuthorityDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface ProjectService {


    List<ProjectDTO> findAllProjects(int projectCnt);

    int registProject(BringProjectDTO newProject);

    List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt);

    List<AuthorityDTO> findAuthority();

    Object findProjectTitle(int projectNo);

    void modifyProjectManagerTitle(ProjectDTO modifyTitle);

    void inviteProjectMember(BringProjectDTO inviteMember);

    void modifyMemberAuthority(Map<String, Object> map);

    void removeProject(int projectNo);

    void removeProjectMember(Map<String, Object> removeMember);

}
