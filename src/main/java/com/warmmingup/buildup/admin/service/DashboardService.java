package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dto.DashProjectDTO;
import com.warmmingup.buildup.admin.dto.DashboardDTO;

import java.util.List;

public interface DashboardService {

    List<DashboardDTO> findDashIssue ();

    List<DashboardDTO> findDashBacklog ();

    List<DashboardDTO> findDashSprint ();

    List<DashProjectDTO> findDashProject ();

    List<DashboardDTO> findChartAuth ();
}