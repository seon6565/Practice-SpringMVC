package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.fullstack4.springmvc.mapper.LoginMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginServiceIf{
    private final LoginMapper loginXmlMapper;
    private final ModelMapper modelMapper;
    @Override
    public MemberDTO login_info(String user_id, String pwd) {
        MemberVO memberVO = loginXmlMapper.login_info(user_id,pwd);
        if(memberVO!=null && memberVO.getPwd().equals(pwd)) {
            MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
            return memberDTO;
        }
        return null;
    }

    @Override
    public MemberDTO Cookie_login(String user_id) {
        MemberVO memberVO = loginXmlMapper.Cookie_login(user_id);
            MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
            return memberDTO;
    }

}
