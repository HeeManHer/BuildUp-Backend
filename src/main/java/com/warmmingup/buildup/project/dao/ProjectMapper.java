package com.warmmingup.buildup.project.dao;

import com.warmmingup.buildup.project.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectDTO> findAllProjects();
}
