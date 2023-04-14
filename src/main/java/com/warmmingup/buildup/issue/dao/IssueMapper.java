package com.warmmingup.buildup.issue.dao;

import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IssueMapper {

    List<IssueDTO> findAllIssues();

    int addIssues(IssueDTO newIssue);

    int findIssuesByNo(IssueDTO newIssue);

    void updateIssues(IssueDTO updateIssue);

    void deleteIssues(int deleteIssue);

    List<ISSUEBDTO> selectbackloglist();

    List<IssueDTO> searchIssue(Map<String, Object> searchissue);
}
