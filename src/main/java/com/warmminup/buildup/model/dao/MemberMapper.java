package com.warmminup.buildup.model.dao;

import com.warmminup.buildup.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    
    List<MemberDTO> findAllMembers();
}
