package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.service.BbsReplyServiceIf;
import org.fullstack4.springmvc.service.BbsServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Log4j2
@Controller
@RequestMapping("/bbsreply")
@RequiredArgsConstructor
public class BbsReplyController {
    private final BbsReplyServiceIf bbsReplyServiceIf;
    @PostMapping("/regist")
    public String registPOST(@Valid BbsReplyDTO bbsReplyDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("BbsReplyController registPOST");
        log.info("bbsDTO : " +bbsReplyDTO);
        log.info("============================");
        if(bindingResult.hasErrors()){
            log.info("bindingResult Errors : " +bbsReplyDTO);
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbsDTO",bbsReplyDTO);
            return "redirect:/bbs/view?idx="+bbsReplyDTO.getBbs_idx();
        }
        int result = bbsReplyServiceIf.reply_regist(bbsReplyDTO);
        return "redirect:/bbs/view?idx="+bbsReplyDTO.getBbs_idx();

    }
    @PostMapping("/delete")//수정필요
    public String deletePOST(@RequestParam(name="idx", defaultValue = "0") int idx){
        log.info("============================");
        log.info("bbsController deletePOST");
        log.info("============================");
        //int result = bbsReplyServiceIf.delete(idx);

        return "redirect:/bbs/view?idx="+idx;

    }



}
