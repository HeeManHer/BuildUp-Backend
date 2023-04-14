package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

public interface ProjectService {


    Object findAllProjects(Map<String, Integer> projectCnt);

    int registProject(ProjectDTO newProject);

    void modifyProjectTitle(ProjectDTO updateTitle);

    List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt);

    Object selectProjectTitle(int projectNo);


    void modifyProjectManagerTitle(ProjectDTO modifyTitle);
}
