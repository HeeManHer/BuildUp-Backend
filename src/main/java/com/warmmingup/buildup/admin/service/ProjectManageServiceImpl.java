package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.ProjectManageMapper;
import com.warmmingup.buildup.admin.dto.ProjectManageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ProjectManageService")
public class ProjectManageServiceImpl implements ProjectManageService {
    private final ProjectManageMapper projectManageMapper;

    public ProjectManageServiceImpl (ProjectManageMapper projectManageMapper) {
        this.projectManageMapper = projectManageMapper;
    }

    @Override
    public List<ProjectManageDTO> findProjectManage (Map<String, String> projectManage) {

        return projectManageMapper.selectProject(projectManage);
    }
}
