package com.warmmingup.buildup.sprint.service;

import com.warmmingup.buildup.sprint.dto.BoardDTO;
import com.warmmingup.buildup.sprint.dto.SprintDTO;
import com.warmmingup.buildup.sprint.dao.SprintMapper;
import com.warmmingup.buildup.sprint.dto.SprintIssueDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    private static SprintMapper sprintMapper;

    public SprintServiceImpl(SprintMapper sprintMapper) { this.sprintMapper = sprintMapper; }

    @Override
    public List<SprintIssueDTO> findSprintIssue(int projectNo) {
        return sprintMapper.selectSprintIssue(projectNo);
    }


    @Override
    public List<SprintDTO> findAllSprints(Map<String, Object> sprintCnt) {
        return sprintMapper.selectAllSprints(sprintCnt);
    }

    @Override
    @Transactional
    public Object insertSprint(SprintDTO sprintNew) {

        int result = sprintMapper.insertSprint(sprintNew);
//        sprintMapper.insertBoard(sprintNew);
        for(SprintIssueDTO sprintIssueDTO: sprintNew.getSprintIssue())
        {sprintMapper.insertSprintIssue(sprintIssueDTO);}

        return (result > 0) ? "등록 성공" : "등록 실패";
    }

    @Override
    @Transactional
    public Object updateSprint(SprintDTO sprintUpd) {

        int result = sprintMapper.updateSprint(sprintUpd);

        return (result > 0) ? "스프린트 수정 성공" : "스프린트 수정 실패";
    }


//    @Override
//    public Object patchSprint(SprintDTO sprintPth) {
//
//        int result = sprintMapper.patchSprint(sprintPth);
//
//        return (result > 0) ? "수정 성공" : "수정 실패";
//    }


    @Override
    @Transactional
    public BoardDTO selectBoard(int boardCnt) {

       return sprintMapper.selectBoard(boardCnt);

    }

    @Override
    @Transactional
    public Object deleteSprint(int sprintDel) {

        int result = sprintMapper.deleteSprint(sprintDel);
         result *= sprintMapper.deleteBoard(sprintDel);

        return (result > 0) ? "스프린트 삭제 성공" : "스프린트 삭제 실패";
    }

    @Override
    public int findSprintTotalCount(Map<String, Object> sprintMap) {
        return sprintMapper.selectSprintTotalCount(sprintMap);
    }

}
