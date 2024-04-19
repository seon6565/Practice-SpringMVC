package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.MemberDTO;
import org.fullstack4.springmvc.service.BbsServiceIf;
import org.fullstack4.springmvc.service.MemberServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceIf memberServiceIf;
    @GetMapping("/view")
    public void view(@RequestParam(name="user_id", defaultValue = "") String user_id, Model model){
        log.info("============================");
        log.info("MemberController view");
        log.info("user_id : " +user_id);
        MemberDTO memberDTO = memberServiceIf.view(user_id);
        log.info("memberDTO : " +memberDTO);
        log.info("============================");
        model.addAttribute("memberDTO",memberDTO);
    }
    @GetMapping("/join")
    public void joinGET(){
        log.info("============================");
        log.info("MemberController joinGET");
        log.info("============================");
    }
    @PostMapping("/join")
    public String joinPOST(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("MemberController joinPOST");
        log.info("MemberDTO : " +memberDTO);
        log.info("============================");

        if(bindingResult.hasErrors()){
            log.info("bindingResult Errors : " +memberDTO);
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("memberDTO",memberDTO);
            return "redirect:/member/join";
        }


        int result = memberServiceIf.join(memberDTO);
        if(result > 0 ){
            return "redirect:/bbs/list";
        }
        else{
            return "/member/join";
        }

    }
    @GetMapping("/modify")
    public void modifyGET(@RequestParam(name="user_id", defaultValue = "") String user_id, Model model){
        log.info("============================");
        log.info("MemberController modifyGET");
        log.info("============================");
        MemberDTO memberDTO = memberServiceIf.view(user_id);
        model.addAttribute("memberDTO",memberDTO);
    }
    @PostMapping("/modify")
    public String modifyPOST(MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("MemberController modifyPOST");
        log.info("============================");

        if(bindingResult.hasErrors()){
            log.info("bindingResult Errors : " +memberDTO);
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("memberDTO",memberDTO);
            redirectAttributes.addAttribute("user_id",memberDTO.getUser_id());
            return "redirect:/member/modify";
        }
        int result = memberServiceIf.modify(memberDTO);
        if(result > 0 ){
            return "redirect:/member/view?user_id="+memberDTO.getUser_id();
        }
        else{
            return "/member/modify";
        }
    }
    @PostMapping("/delete")
    public String deletePOST(String user_id){
        log.info("============================");
        log.info("MemberController deletePOST");
        log.info("============================");
        int result = memberServiceIf.delete(user_id);
        if(result > 0 ){
            return "redirect:/bbs/list";
        }
        else{
            return "/member/view?user_id="+user_id;
        }
    }
}
