package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dao.IssueMapper;
import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    private final IssueMapper issueMapper;

    @Autowired
    public IssueServiceImpl(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    @Override
    public int selectIssueTotalCount(Map<String, Object> issueConnect) {
        return issueMapper.selectIssueTotalCount(issueConnect);
    }

    @Override
    public List<IssueDTO> findAllIssues(Map<String, Object> issueConnect) {

        return issueMapper.selectAllIssues(issueConnect);
    }

    @Override
    public List<ISSUEBDTO> getBacklogByNo(int projectNo) {

        return issueMapper.selectBacklogList(projectNo);
    }

    @Override
    @Transactional
    public int registIssue(IssueDTO newIssue) {

        issueMapper.insertIssues(newIssue);

        return issueMapper.selectIssuesNo(newIssue);
    }

    @Override
    public void updateIssues(IssueDTO updateIssue) {

        issueMapper.updateIssues(updateIssue);
    }

    @Override
    public void removeIssues(int removeIssue) {

        issueMapper.deleteIssues(removeIssue);
    }

}
