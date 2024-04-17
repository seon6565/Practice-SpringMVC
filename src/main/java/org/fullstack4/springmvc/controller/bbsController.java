package org.fullstack4.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;

@Log4j2
@Controller
@RequestMapping("/bbs")
public class bbsController {

    @GetMapping("/list")
    public void list(){
        log.info("============================");
        log.info("bbsController list");
        log.info("============================");
    }
    @GetMapping("/view")
    public void view(@RequestParam(name="idx", defaultValue = "0") int idx, @RequestParam(name="user_id", defaultValue = "") String user_id,
                     @RequestParam(name="title", defaultValue = "0") String title, @RequestParam(name="display_date", defaultValue = "") LocalDate display_date,
                     Model model){
        log.info("============================");
        log.info("bbsController view");
        log.info("idx : " +idx);
        log.info("name : " +user_id);
        log.info("age : " +title);
        log.info("display_date : " +display_date);
        log.info("============================");
        model.addAttribute("idx",idx);
        model.addAttribute("user_id",user_id);
        model.addAttribute("title",title);
        model.addAttribute("display_date",display_date);
    }
    @GetMapping("/regist")
    public void registGET(){
        log.info("============================");
        log.info("bbsController registGET");
        log.info("============================");
    }
    @PostMapping("/regist")
    public String registPOST(BbsDTO bbsDTO, Model model, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("bbsController registPOST");
        log.info("bbsDTO : " +bbsDTO);
        log.info("============================");

        model.addAttribute("key3","v3");
        redirectAttributes.addAttribute("key1","v1");
        redirectAttributes.addFlashAttribute("key2","v2");
        return "redirect:/bbs/list";

    }
    @GetMapping("/modify")
    public void modifyGET(){
        log.info("============================");
        log.info("bbsController modifyGET");
        log.info("============================");
    }
    @PostMapping("/modify")
    public void modifyPOST(){
        log.info("============================");
        log.info("bbsController modifyPOST");
        log.info("============================");
    }
    @PostMapping("/delete")
    public void deletePOST(){
        log.info("============================");
        log.info("bbsController deletePOST");
        log.info("============================");
    }

    @GetMapping("/list2")
    public void list2(String s1, int i2){
        log.info("============================");
        log.info("list2 list2");
        log.info("list2 s1" +s1);
        log.info("list2 i2" +i2);
        log.info("============================");
    }
}
