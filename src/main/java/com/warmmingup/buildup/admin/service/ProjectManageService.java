package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.ProjectManageMapper;
import com.warmmingup.buildup.admin.dto.ProjectManageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectManageService {
    private final ProjectManageMapper projectManageMapper;

    public ProjectManageService (ProjectManageMapper projectManageMapper) {
        this.projectManageMapper = projectManageMapper;
    }


    public int findProjectTotalCount (Map<String, Object> projectManage) {

        return projectManageMapper.selectProjectTotalCount(projectManage);
    }


    public List<ProjectManageDTO> findProjectManage (Map<String, Object> projectManage) {

        return projectManageMapper.selectProject(projectManage);
    }
}
