package com.warmminup.buildup.model.service;

import com.warmminup.buildup.model.dto.IssueDTO;

import java.util.List;

public interface IssueService {

    List<IssueDTO> findAllIssues();

}
