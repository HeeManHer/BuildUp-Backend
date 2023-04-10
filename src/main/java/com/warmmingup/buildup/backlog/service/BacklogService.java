package com.warmmingup.buildup.backlog.service;

import com.warmmingup.buildup.backlog.dto.BacklogDTO;

import java.util.List;

public interface BacklogService {

    List<BacklogDTO> findAllBacklogs();
}
