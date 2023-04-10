package com.warmmingup.buildup.login.controller;

import com.warmmingup.buildup.login.service.MemberService;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/login")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("member")
    public ModelAndView findMemberList(ModelAndView mv) {

        List<MemberDTO> memberList = memberService.findAllMembers();

        mv.addObject("memberList", memberList);
        mv.setViewName("login/member");

        return mv;
    }

}
