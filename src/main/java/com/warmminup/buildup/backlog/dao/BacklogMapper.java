package com.warmminup.buildup.backlog.dao;

import com.warmminup.buildup.backlog.dto.BacklogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BacklogMapper {

    List<BacklogDTO> findAllBacklog();
}
