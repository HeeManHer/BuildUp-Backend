package com.warmmingup.buildup.login.dao;

import com.warmmingup.buildup.login.dto.EmployeeDTO;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface MemberMapper {

    //    MemberDTO findByMemberId(String employeeNo);
    Optional<MemberDTO> findByMemberId (String memberId);

    MemberDTO selectByMemberId (String employeeNo);

    int selectMember (MemberDTO email);

    void modifyEmployeePassword (EmployeeDTO modifyPassword);

    MemberDTO findEmployeePassword(String employeePassword);

    int selectMember(MemberDTO member);
}
