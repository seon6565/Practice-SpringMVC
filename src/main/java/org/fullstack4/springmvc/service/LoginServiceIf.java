package org.fullstack4.springmvc.service;


import org.fullstack4.springmvc.dto.LoginDTO;
import org.fullstack4.springmvc.dto.MemberDTO;

public interface LoginServiceIf {
    MemberDTO login_info(LoginDTO loginDTO);

    MemberDTO Cookie_login(String user_id);
}
