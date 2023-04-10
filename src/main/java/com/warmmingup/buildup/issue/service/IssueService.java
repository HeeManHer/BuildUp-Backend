package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dto.IssueDTO;

import java.util.List;

public interface IssueService {

    List<IssueDTO> findAllIssues();

}
