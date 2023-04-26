package com.warmmingup.buildup.sprint.service;

import com.warmmingup.buildup.sprint.dao.SprintMapper;
import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dto.SprintDatailDTO;
import com.warmmingup.buildup.sprint.dto.SprintIssueDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    private static SprintMapper sprintMapper;

    public SprintServiceImpl(SprintMapper sprintMapper) {
        this.sprintMapper = sprintMapper;
    }

    @Override
    public int findSprintTotalCount(Map<String, Object> sprintMap) {
        return sprintMapper.selectSprintTotalCount(sprintMap);
    }

    @Override
    public List<SprintDTO> findAllSprints(Map<String, Object> sprintCnt) {
        return sprintMapper.selectAllSprints(sprintCnt);
    }

    @Override
    public SprintDatailDTO findSprintByNo(int boardCnt) {

        return sprintMapper.selectSprintByNo(boardCnt);
    }

    @Override
    @Transactional
    public Object insertSprint(SprintDTO sprintNew) {

        sprintMapper.insertSprint(sprintNew);

        for (SprintIssueDTO sprintIssueDTO : sprintNew.getSprintIssue()) {
            sprintMapper.insertSprintIssue(sprintIssueDTO);
        }

        return "등록 성공";
    }

    @Override
    @Transactional
    public Object updateSprint(int sprintNo) {

        sprintMapper.updateSprint(sprintNo);

        return "스프린트 수정 성공";
    }

    @Override
    @Transactional
    public Object deleteSprint(int sprintDel) {

        sprintMapper.deleteSprint(sprintDel);

        return "스프린트 삭제 성공";
    }

}
