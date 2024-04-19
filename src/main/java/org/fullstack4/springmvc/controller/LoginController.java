package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.LoginServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.net.URLEncoder;

@Log4j2
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginServiceIf loginServiceIf;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void loginGET(HttpServletRequest req, Model model){
        String acc_url = req.getHeader("referer");
        String uri = acc_url;
//        try {
//            uri = URLEncoder.encode(acc_url, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
        model.addAttribute("acc_url", uri);
        log.info("============================");
        log.info("LoginController loginGET");
        log.info("============================");
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginPOST(String user_id, String pwd,
                            @RequestParam(name="acc_url", defaultValue = "/bbs/list", required = false) String acc_url,
                            HttpServletRequest req,
                            Model model,
                            RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("LoginController loginPOST");
        log.info("============================");
        MemberDTO LoginMemberDTO = loginServiceIf.login_info(user_id,pwd);
//        if(bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
//            return "/login/login";
//        }
        String uri = acc_url;
//        try {
//            uri = URLEncoder.encode(acc_url, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
//        }
        if(LoginMemberDTO !=null){
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo",LoginMemberDTO);
            //model.addAttribute("user_id",LoginMemberDTO);
            //redirectAttributes.addFlashAttribute("loginInfo",LoginMemberDTO);
            return "redirect:"+uri;
        }
        redirectAttributes.addFlashAttribute("errors","사용자 정보가 일치하지 않습니다.");
        return "redirect:/login/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if(session!=null) {
            session.invalidate();
        }
        log.info("============================");
        log.info("LoginController logout");
        log.info("============================");

        return "redirect:/bbs/list";
    }
}
