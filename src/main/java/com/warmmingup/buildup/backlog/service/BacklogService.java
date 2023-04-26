package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dto.BacklogAuthorityDTO;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;

import java.util.List;
import java.util.Map;

public interface BacklogService {

    int selectBacklogTotalCount(Map<String, Object> backlogConnect);

    List<BacklogDTO> selectAllBacklogs(Map<String, Object> selectCriteria);

    int insertBacklog(int projectNo, BacklogDTO newBacklog);

    void updateBacklogs(int projectNo, BacklogDTO updateBacklog);

    void deleteBacklog(int backlogNo);

    List<BacklogAuthorityDTO> authority(Map<String, Object> authority);
}