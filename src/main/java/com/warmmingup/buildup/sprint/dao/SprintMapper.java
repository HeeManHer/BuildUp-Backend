package com.warmmingup.buildup.sprint.dao;


import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dto.SprintDatailDTO;
import com.warmmingup.buildup.sprint.dto.SprintIssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SprintMapper {

    int selectSprintTotalCount(Map<String, Object> sprintMap);

    List<SprintDTO> selectAllSprints(Map<String, Object> sprintCnt);

    SprintDatailDTO selectSprintByNo(int boardCnt);

    int insertSprint(SprintDTO sprintNew);

    void insertSprintIssue(SprintIssueDTO sprintIssueDTO);

    int updateSprint(int sprintUpd);

    int deleteSprint(int sprintDel);
}
