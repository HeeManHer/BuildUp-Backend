package com.warmmingup.buildup.member.dao;

import com.warmmingup.buildup.login.dto.MemberDTO;
import com.warmmingup.buildup.member.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {

    MemberDTO selectByMemberId(String employeeNo);

    void modifyEmployeePassword(EmployeeDTO modifyPassword);

    int selectMember(MemberDTO member);
}
