package com.warmmingup.buildup.login.service;

import com.warmmingup.buildup.exception.UserNotFoundException;
import com.warmmingup.buildup.login.dao.MemberMapper;
import com.warmmingup.buildup.login.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final MemberMapper mapper;

    public CustomUserDetailsService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String employeeNo) throws UsernameNotFoundException {
        log.info("[CustomUserDetailsService] ===================================");
        log.info("[CustomUserDetailsService] loadUserByUsername {}",  employeeNo);

        return mapper.findByMemberId( employeeNo)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException( employeeNo + "> 찾을 수 없습니다."));


    }

    private MemberDTO addAuthorities(MemberDTO memberDTO) {
        memberDTO.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(memberDTO.getEmployeeRole())));

        return memberDTO;
    }
}
