package com.warmmingup.buildup.sprint.service;



import com.warmmingup.buildup.sprint.dto.SprintDTO;

import java.util.List;
import java.util.Map;

public interface SprintService {

    Object findAllSprints(Map<String, Integer> sprintCnt);

   Object insertSprint(SprintDTO sprintNew);

   Object updateSprint(SprintDTO sprintUpd);

   Object patchSprint(SprintDTO sprintPth);

    Object deleteSprint(SprintDTO sprintDel);
}
