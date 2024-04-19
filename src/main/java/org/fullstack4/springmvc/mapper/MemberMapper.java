package org.fullstack4.springmvc.mapper;

import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.domain.MemberVO;

import java.util.List;

public interface MemberMapper {
    int join(MemberVO memberVO);
    MemberVO view(String user_id);
    int modify(MemberVO memberVO);
    int delete(String user_id);
}
