package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;

import java.util.List;
import java.util.Map;

public interface IssueService {

    int registIssue(IssueDTO newIssue);

//    List<IssueDTO> findAllIssues();

    void updateIssues(IssueDTO updateIssue);

    void removeIssues(int removeIssue);

    List<ISSUEBDTO> getBacklogByNo(int projectNo);

    List<IssueDTO> searchIssues(Map<String, Object> searchissue);

    List<IssueDTO> findAllIssues(Map<String, Object> selectCriteria);

    int selectIssueTotal(Map<String, Object> issueConnect);
}
