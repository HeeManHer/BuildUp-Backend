package com.warmmingup.buildup.backlog.dao;

import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BacklogMapper {

    List<BacklogDTO> findAllBacklogs();

    int addBacklogs(BacklogDTO newBacklog);

    int findBacklogsByNo(BacklogDTO newBacklog);

    void updateBacklogs(BacklogDTO updateBacklog);


    void deleteBacklog(int removeBacklog);


    List<BacklogDTO> searchbacklog(Map<String, Object> searchbacklog);
}