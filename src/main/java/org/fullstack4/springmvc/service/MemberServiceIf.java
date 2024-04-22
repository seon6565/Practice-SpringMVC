package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;

import java.util.List;

public interface MemberServiceIf {
    int join(MemberDTO memberDTO);
    MemberDTO view(String user_id);
    int modify(MemberDTO memberDTO);
    int delete(String user_id);

    int idCheck(String user_id);
}
