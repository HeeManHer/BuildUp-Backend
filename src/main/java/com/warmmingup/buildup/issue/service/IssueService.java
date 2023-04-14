package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;

import java.util.List;
import java.util.Map;

public interface IssueService {

    int registIssue(IssueDTO newIssue);

    List<IssueDTO> findAllIssues();

    void updateIssues(IssueDTO updateIssue);

    void removeIssues(int removeIssue);

    List<ISSUEBDTO> getBacklogByNo();

    List<IssueDTO> searchIssues(Map<String, Object> searchissue);
}
