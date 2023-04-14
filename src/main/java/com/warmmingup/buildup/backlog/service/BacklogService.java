package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dto.BacklogDTO;

import java.util.List;
import java.util.Map;

public interface BacklogService {

    void updateBacklogs(BacklogDTO updateBacklog);

    int registBacklog(BacklogDTO newBacklog);


    List<BacklogDTO> findAllBacklogs();


    void deleteBacklog(int backlogNo);


    List<BacklogDTO> searchBacklogs(Map<String, Object> searchbacklog);
}



