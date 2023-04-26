package com.warmmingup.buildup.issue.dao;

import com.warmmingup.buildup.issue.dto.ISSUEBDTO;
import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IssueMapper {

    int selectIssueTotalCount(Map<String, Object> issueConnect);

    List<IssueDTO> selectAllIssues(Map<String, Object> issueConnect);

    List<ISSUEBDTO> selectBacklogList(int projectNo);

    int insertIssues(IssueDTO newIssue);

    int selectIssuesNo(IssueDTO newIssue);

    void updateIssues(IssueDTO updateIssue);

    void deleteIssues(int deleteIssue);
}
