package com.warmmingup.buildup.issue.service;

import com.warmmingup.buildup.issue.dao.IssueMapper;
import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("issueService")
public class IssueServiceImpl implements IssueService {

    private final IssueMapper issueMapper;
    private Object projectNo;


    @Autowired
    public IssueServiceImpl(IssueMapper issueMapper) { this.issueMapper = issueMapper; }

    @Override
    public int registIssue(IssueDTO newIssue) {
        System.out.println(1);
    int result = issueMapper.addIssues(newIssue);
        System.out.println(2);

    int issueNo = 0;
        System.out.println(3);
    if(result > 0){
        System.out.println(4);
        issueNo = issueMapper.findIssuesByNo(newIssue);
        System.out.println(5);
    }
        System.out.println(6);
        return issueNo;
    }

//    @Override
//    public List<IssueDTO> findAllIssues() {
//
//        return issueMapper.findAllIssues();
//    }

    @Override
    public void updateIssues(IssueDTO updateIssue) {
        
         issueMapper.updateIssues(updateIssue);
    }

    @Override
    public void removeIssues(int removeIssue) {

        issueMapper.deleteIssues(removeIssue);
    }

    @Override
    public List<ISSUEBDTO> getBacklogByNo(int projectNo) {

        return issueMapper.selectbackloglist(projectNo);
    }

//    @Override
//    public List<ISSUEBDTO> getBacklogByNo() {
//
//        return issueMapper.selectbackloglist();
//    }

    @Override
    public List<IssueDTO> searchIssues(Map<String, Object> searchissue) {

        return issueMapper.searchIssue(searchissue);
    }

    @Override
    public List<IssueDTO> findAllIssues(Map<String, Object> issueConnect) {

        return issueMapper.findAllIssues(issueConnect);
    }

    @Override
    public int selectIssueTotal(Map<String, Object> issueConnect) {
        return issueMapper.selectIssueTotalCount(issueConnect);
    }


//    @Override
//    public int selectIssueTotal(Map<String, Object> projectNo) {
//        return issueMapper.selectIssueTotalCount(projectNo);
//    }


}
