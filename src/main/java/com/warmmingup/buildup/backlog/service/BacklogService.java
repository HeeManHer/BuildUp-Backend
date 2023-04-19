package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dto.BacklogDTO;

import java.util.List;
import java.util.Map;

public interface BacklogService {

    void updateBacklogs(int projectNo, BacklogDTO updateBacklog);

    int registBacklog(int projectNo, BacklogDTO newBacklog);


    void deleteBacklog(int backlogNo);


    int selectBacklogTotal(Map<String, Object> backlogConnect);

    List<BacklogDTO> selectBacklogListWithPaging(Map<String, Object> selectCriteria);
}