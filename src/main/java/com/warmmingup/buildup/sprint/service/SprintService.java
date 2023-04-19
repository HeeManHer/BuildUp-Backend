package com.warmmingup.buildup.sprint.service;



import com.warmmingup.buildup.sprint.dto.SprintDTO;

import java.util.List;
import java.util.Map;

public interface SprintService {

    List<SprintDTO> findAllSprints(Map<String, Object> sprintCnt);

   Object insertSprint(SprintDTO sprintNew);

   Object updateSprint(SprintDTO sprintUpd);

   Object patchSprint(SprintDTO sprintPth);

    Object deleteSprint(SprintDTO sprintDel);

    int findSprintTotalCount(Map<String, Object> sprintMap);
}
