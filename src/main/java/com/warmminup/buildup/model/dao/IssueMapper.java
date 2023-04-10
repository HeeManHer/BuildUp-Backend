package com.warmminup.buildup.model.dao;

import com.warmminup.buildup.model.dto.IssueDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IssueMapper {

    List<IssueDTO> findAllIssues();

}
