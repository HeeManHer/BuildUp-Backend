package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dao.IssueMapper;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("issueService")
public class IssueServiceImpl implements IssueService{

    private final IssueMapper issueMapper;

    @Autowired
    public IssueServiceImpl(IssueMapper issueMapper) { this.issueMapper = issueMapper; }

    @Override
    public List<IssueDTO> findAllIssues() {

            return issueMapper.findAllIssues();
    }
}
