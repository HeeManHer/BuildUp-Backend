package com.warmmingup.buildup.project.dao;

import com.warmmingup.buildup.project.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper {

    List<ProjectDTO> findAllProjects(Map<String, Integer> projectCnt);
    int findProjectsByNo(ProjectDTO newProject);

    int insertProject(ProjectDTO newProject);

    void insertProjectEmployee(ProjectDTO newProject);

    ProjectDTO selectEmployeeNo(ProjectDTO newProject);

    void modifyProjectTitle(ProjectDTO updateTitle);

    List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt);

    Object selectProjectTitle(int projectNo);

    void modifyProjectManagerTitle(ProjectDTO modifyTitle);
}

