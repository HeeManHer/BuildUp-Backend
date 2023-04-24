package com.warmmingup.buildup.sprint.dao;


import com.warmmingup.buildup.sprint.dto.BoardDTO;
import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dto.SprintIssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SprintMapper {

    List<SprintDTO> selectAllSprints(Map<String, Object> sprintCnt);

    int insertSprint(SprintDTO sprintNew);

    int updateSprint(SprintDTO sprintUpd);

//    int patchSprint(SprintDTO sprintPth);

    int deleteSprint(int sprintDel);

    int selectSprintTotalCount(Map<String, Object> sprintMap);

    List<SprintIssueDTO> selectSprintIssue(int projectNo);

    void insertSprintIssue(SprintIssueDTO sprintIssueDTO);

    BoardDTO selectBoard(int boardCnt);

    int deleteBoard(int boardDel);

    void insertBoard(SprintDTO sprintDTO);
}
