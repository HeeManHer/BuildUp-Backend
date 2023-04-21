package com.warmmingup.buildup.sprint.service;



import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dto.SprintIssueDTO;

import java.util.List;
import java.util.Map;

public interface SprintService {

    int findSprintTotalCount(Map<String, Object> sprintMap);

    List<SprintDTO> findAllSprints(Map<String, Object> sprintCnt);

   Object insertSprint(SprintDTO sprintNew);

   Object updateSprint(SprintDTO sprintUpd);

   Object patchSprint(SprintDTO sprintPth);

    Object deleteSprint(SprintDTO sprintDel);

    List<SprintIssueDTO> findSprintIssue(int projectNo);
}
