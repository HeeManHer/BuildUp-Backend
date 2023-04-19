package com.warmmingup.buildup.sprint.service;

import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dao.SprintMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    private static SprintMapper sprintMapper;

    public SprintServiceImpl(SprintMapper sprintMapper) { this.sprintMapper = sprintMapper; }

    @Override
    public List<SprintDTO> findAllSprints(Map<String, Object> sprintCnt) {

        return sprintMapper.selectAllSprints(sprintCnt);
    }
    @Override
    public Object insertSprint(SprintDTO sprintNew) {

        int result = sprintMapper.insertSprint(sprintNew);


        return (result > 0) ? "등록 성공" : "등록 실패";
    }

    @Override
    public Object updateSprint(SprintDTO sprintUpd) {

        int result = sprintMapper.updateSprint(sprintUpd);

        return (result > 0) ? "전체 수정 성공" : "전체 수정 실패";
    }


    @Override
    public Object patchSprint(SprintDTO sprintPth) {

        int result = sprintMapper.patchSprint(sprintPth);

        return (result > 0) ? "수정 성공" : "수정 실패";
    }

    @Override
    public Object deleteSprint(SprintDTO sprintDel) {

        int result = sprintMapper.deleteSprint(sprintDel);

        return (result > 0) ? "삭제 성공" : "삭제 실패";
    }

    @Override
    public int findSprintTotalCount(Map<String, Object> sprintMap) {
        return sprintMapper.selectSprintTotalCount(sprintMap);
    }


}
