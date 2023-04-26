package com.warmmingup.buildup.backlog.dao;

import com.warmmingup.buildup.backlog.dto.BacklogAuthorityDTO;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BacklogMapper {

    int selectBacklogTotalCount(Map<String, Object> backlogConnect);

    List<BacklogDTO> selectAllBacklogs(Map<String, Object> backlogConnect);
    
    int insertBacklog(BacklogDTO newBacklog);

    int selectBacklogsNo(BacklogDTO newBacklog);

    void updateBacklogs(BacklogDTO updateBacklog);


    void deleteBacklog(int removeBacklog);


    List<BacklogAuthorityDTO> authority(Map<String, Object> authority);
}