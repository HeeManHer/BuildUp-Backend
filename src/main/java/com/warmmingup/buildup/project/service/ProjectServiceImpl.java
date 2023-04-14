package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dao.ProjectMapper;
import com.warmmingup.buildup.project.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> findAllProjects(Map<String, Integer> projectCnt) {

        return projectMapper.findAllProjects(projectCnt);
    }

    @Override
    @Transactional
    public int registProject(ProjectDTO newProject) {

        projectMapper.insertProject(newProject);
        ProjectDTO project = projectMapper.selectEmployeeNo(newProject);

        projectMapper.insertProjectEmployee(project);

        return projectMapper.findProjectsByNo(newProject);
    }

    @Override
    public void modifyProjectTitle(ProjectDTO updateTitle) {

        projectMapper.modifyProjectTitle(updateTitle);
    }

    @Override
    public List<ProjectDTO> findAllProjectMembers(Map<String, Integer> projectMemberCnt) {

        return projectMapper.findAllProjectMembers(projectMemberCnt);
    }

    @Override
    public Object selectProjectTitle(int projectNo) {

        return projectMapper.selectProjectTitle(projectNo);
    }

    @Override
    public void modifyProjectManagerTitle(ProjectDTO modifyTitle) {

        projectMapper.modifyProjectManagerTitle(modifyTitle);
    }


}

