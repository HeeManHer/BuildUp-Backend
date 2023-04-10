package com.warmminup.buildup.model.dao;

import com.warmminup.buildup.model.dto.ProjectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectDTO> findAllProjects();
}
