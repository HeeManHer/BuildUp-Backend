package com.warmmingup.buildup.project.dao;

import com.warmmingup.buildup.project.dto.AuthorityDTO;
import com.warmmingup.buildup.project.dto.BringProjectDTO;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import com.warmmingup.buildup.project.dto.projectEmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper {

    List<ProjectDTO> selectAllProjects(int projectCnt);

    int findProjectsByNo(BringProjectDTO newProject);

    int insertProject(BringProjectDTO newProject);

    void insertProjectEmployee(projectEmployeeDTO newProject);

    List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt);

    Object selectProjectTitle(int projectNo);

    void modifyProjectManagerTitle(ProjectDTO modifyTitle);

    void removeProject(int projectNo);

    void inviteTeamMember(BringProjectDTO projectNo);

    void removeTeamMember(Map<String, Object> removeMember);

    void modifyMemberAuthority(Map<String, Object> memberAuthorityMap);

    List<AuthorityDTO> findAuthority();
}

