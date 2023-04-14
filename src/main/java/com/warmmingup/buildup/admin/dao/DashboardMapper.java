package com.warmmingup.buildup.admin.dao;

import com.warmmingup.buildup.admin.dto.DashProjectDTO;
import com.warmmingup.buildup.admin.dto.DashboardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashboardMapper {
    List<DashboardDTO> selectDashIssue ();

    List<DashboardDTO> selectDashBacklog ();

    List<DashboardDTO> selectDashSprint ();

    List<DashProjectDTO> selectDashProject ();

    List<DashboardDTO> selectChartAuth ();
}