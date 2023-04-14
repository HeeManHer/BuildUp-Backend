package com.warmmingup.buildup.admin.service;

import com.warmmingup.buildup.admin.dao.DashboardMapper;
import com.warmmingup.buildup.admin.dto.DashProjectDTO;
import com.warmmingup.buildup.admin.dto.DashboardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dashboardServiceImpl")
public class DashboardServiceImpl implements DashboardService {

    private final DashboardMapper dashboardMapper;

    public DashboardServiceImpl (DashboardMapper dashboardMapper) {
        this.dashboardMapper = dashboardMapper;
    }

    @Override
    public List<DashboardDTO> findDashIssue () {

        return dashboardMapper.selectDashIssue();
    }

    @Override
    public List<DashboardDTO> findDashBacklog () {

        return dashboardMapper.selectDashBacklog();
    }

    @Override
    public List<DashboardDTO> findDashSprint () {

        return dashboardMapper.selectDashSprint();
    }

    @Override
    public List<DashProjectDTO> findDashProject () {

        return dashboardMapper.selectDashProject();
    }

    @Override
    public List<DashboardDTO> findChartAuth () {

        return dashboardMapper.selectChartAuth();
    }

}
