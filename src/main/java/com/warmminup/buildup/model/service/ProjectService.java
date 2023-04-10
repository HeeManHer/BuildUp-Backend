package com.warmminup.buildup.model.service;

import com.warmminup.buildup.model.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAllProjects();
}
