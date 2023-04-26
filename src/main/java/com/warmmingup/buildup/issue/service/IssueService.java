package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;

import java.util.List;
import java.util.Map;

public interface IssueService {

    int selectIssueTotalCount(Map<String, Object> issueConnect);

    List<IssueDTO> findAllIssues(Map<String, Object> selectCriteria);

    List<ISSUEBDTO> getBacklogByNo(int projectNo);

    int registIssue(IssueDTO newIssue);

    void updateIssues(IssueDTO updateIssue);

    void removeIssues(int removeIssue);
}
