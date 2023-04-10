package com.warmminup.buildup.backlog.service;

import com.warmminup.buildup.backlog.dto.BacklogDTO;

import java.util.List;

public interface BacklogService {

    List<BacklogDTO> findAllBacklogs();
}
