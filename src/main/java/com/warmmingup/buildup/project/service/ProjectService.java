package com.warmmingup.buildup.project.service;

import com.warmmingup.buildup.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAllProjects();
}
