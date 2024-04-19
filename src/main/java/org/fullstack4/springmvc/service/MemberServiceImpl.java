package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.domain.MemberVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.fullstack4.springmvc.mapper.MemberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberServiceIf{
    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;
    @Override
    public int join(MemberDTO memberDTO) {
        log.info("========================");
        log.info("MemberServiceImpl join(memberDTO)" + memberDTO);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        int result = memberMapper.join(memberVO);

        log.info("MemberServiceImpl memberVO" + memberVO);
        log.info("MemberServiceImpl result" + result);
        log.info("========================");

        return result;
    }

    @Override
    public MemberDTO view(String user_id) {
        MemberVO memberVO = memberMapper.view(user_id);
        MemberDTO memberDTO = modelMapper.map(memberVO,MemberDTO.class);
        return memberDTO;
    }

    @Override
    public int modify(MemberDTO memberDTO) {
        log.info("========================");
        log.info("MemberServiceImpl modify(MemberDTO)" + memberDTO);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        int result = memberMapper.modify(memberVO);
        log.info("MemberServiceImpl result" + result);
        log.info("MemberServiceImpl modify" + memberVO);
        log.info("========================");

        return result;
    }

    @Override
    public int delete(String user_id) {
        return memberMapper.delete(user_id);
    }

}
