package com.warmminup.buildup.model.service;

import com.warmminup.buildup.model.dao.ProjectMapper;
import com.warmminup.buildup.model.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) { this.projectMapper = projectMapper; }

    @Override
    public List<ProjectDTO> findAllProjects() {

        return projectMapper.findAllProjects();
    }
}
