package com.warmmingup.buildup.login.dao;

import com.warmmingup.buildup.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface LoginMapper {

    Optional<MemberDTO> findByMemberId(String memberId);
}
