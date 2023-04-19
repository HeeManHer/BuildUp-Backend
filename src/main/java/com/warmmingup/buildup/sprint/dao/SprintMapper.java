package com.warmmingup.buildup.sprint.dao;


import com.warmmingup.buildup.sprint.dto.SprintDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SprintMapper {

    List<SprintDTO> selectAllSprints(Map<String, Object> sprintCnt);

    int insertSprint(SprintDTO sprintNew);

    int updateSprint(SprintDTO sprintUpd);

    int patchSprint(SprintDTO sprintPth);

    int deleteSprint(SprintDTO sprintDel);

    int selectSprintTotalCount(Map<String, Object> sprintMap);
}
