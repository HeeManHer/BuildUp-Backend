package com.warmmingup.buildup.backlog.dao;

import com.warmmingup.buildup.backlog.dto.BacklogAuthorityDTO;
import com.warmmingup.buildup.backlog.dto.BacklogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BacklogMapper {

    int selectBacklogTotal(Map<String, Object> backlogConnect);

    List<BacklogDTO> selectBacklogListWithPaging(Map<String, Object> backlogConnect);


    int addBacklogs(BacklogDTO newBacklog);

    int findBacklogsByNo(BacklogDTO newBacklog);

    void updateBacklogs(BacklogDTO updateBacklog);


    void deleteBacklog(int removeBacklog);




    List <BacklogAuthorityDTO>authority(Map<String, Object> authority);
}