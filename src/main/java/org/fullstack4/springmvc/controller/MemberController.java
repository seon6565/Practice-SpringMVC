package org.fullstack4.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/view")
    public void view(@RequestParam(name="user_id", defaultValue = "") String user_id, Model model){
        log.info("============================");
        log.info("MemberController view");
        log.info("user_id : " +user_id);
    }
    @GetMapping("/join")
    public void joinGET(){
        log.info("============================");
        log.info("MemberController joinGET");
        log.info("============================");
    }
    @PostMapping("/join")
    public String joinPOST(MemberDTO memberDTO, Model model, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("MemberController joinPOST");
        log.info("MemberDTO : " +memberDTO);
        log.info("============================");
//        redirectAttributes.addAttribute("key1","v1");
//        redirectAttributes.addFlashAttribute("key2","v2");
        return "redirect:/login/login";

    }
    @GetMapping("/modify")
    public void modifyGET(){
        log.info("============================");
        log.info("MemberController modifyGET");
        log.info("============================");
    }
    @PostMapping("/modify")
    public void modifyPOST(){
        log.info("============================");
        log.info("MemberController modifyPOST");
        log.info("============================");
    }
    @PostMapping("/leave")
    public void deletePOST(){
        log.info("============================");
        log.info("MemberController deletePOST");
        log.info("============================");
    }
}
