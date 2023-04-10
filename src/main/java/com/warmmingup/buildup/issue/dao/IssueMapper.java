package com.warmmingup.buildup.issue.dao;

import com.warmmingup.buildup.issue.dto.IssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IssueMapper {

    List<IssueDTO> findAllIssues();

}
