package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dao.IssueMapper;
import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    private final IssueMapper issueMapper;


    @Autowired
    public IssueServiceImpl(IssueMapper issueMapper) { this.issueMapper = issueMapper; }

    @Override
    public int registIssue(IssueDTO newIssue) {
    int result = issueMapper.addIssues(newIssue);
    int issueNo = 0;
    if(result > 0){
        issueNo = issueMapper.findIssuesByNo(newIssue);
    }
        return issueNo;
    }

    @Override
    public List<IssueDTO> findAllIssues() {

        return issueMapper.findAllIssues();
    }

    @Override
    public void updateIssues(IssueDTO updateIssue) {
        
         issueMapper.updateIssues(updateIssue);
    }

    @Override
    public void removeIssues(int removeIssue) {

        issueMapper.deleteIssues(removeIssue);
    }

    @Override
    public List<ISSUEBDTO> getBacklogByNo() {

        return issueMapper.selectbackloglist();
    }

    @Override
    public List<IssueDTO> searchIssues(Map<String, Object> searchissue) {

        return issueMapper.searchIssue(searchissue);
    }



}
