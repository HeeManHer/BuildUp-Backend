package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.ProjectManageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectManageMapper {
    List<ProjectManageDTO> selectProject(Map<String, Object> projectManage);

    int selectProjectTotalCount(Map<String, Object> projectManage);
}
