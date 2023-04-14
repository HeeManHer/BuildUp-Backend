package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.ProjectManageDTO;

import java.util.List;
import java.util.Map;

public interface ProjectManageService {
    List<ProjectManageDTO> findProjectManage (Map<String, String> projectManage);
}
