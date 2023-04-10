package com.warmmingup.buildup.login.dao;

import com.warmmingup.buildup.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    
    List<MemberDTO> findAllMembers();
}
