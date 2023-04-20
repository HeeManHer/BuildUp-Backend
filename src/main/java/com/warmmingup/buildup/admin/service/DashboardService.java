package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.DashboardMapper;
import com.warmmingup.buildup.admin.dto.DashProjectDTO;
import com.warmmingup.buildup.admin.dto.DashboardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final DashboardMapper dashboardMapper;

    public DashboardService (DashboardMapper dashboardMapper) {
        this.dashboardMapper = dashboardMapper;
    }


    public List<DashboardDTO> findDashIssue () {

        return dashboardMapper.selectDashIssue();
    }


    public List<DashboardDTO> findDashBacklog () {

        return dashboardMapper.selectDashBacklog();
    }


    public List<DashboardDTO> findDashSprint () {

        return dashboardMapper.selectDashSprint();
    }


    public List<DashProjectDTO> findDashProject () {

        return dashboardMapper.selectDashProject();
    }


    public List<DashboardDTO> findChartAuth () {

        return dashboardMapper.selectChartAuth();
    }

}
