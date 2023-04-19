package com.warmmingup.buildup.login.dao;

import com.warmmingup.buildup.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

    MemberDTO findByMemberId(String employeeNo);

    MemberDTO selectByMemberId(String  employeeNo);

    MemberDTO selectByEmail(String email);


}
