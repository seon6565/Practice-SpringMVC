package org.fullstack4.springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.service.BbsServiceIf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/bbs")
@RequiredArgsConstructor
public class BbsController {
    private final BbsServiceIf bbsServiceIf;
//    @GetMapping("/list")
//    public void list(Model model){
//        log.info("============================");
//        log.info("bbsController list");
//        List<BbsDTO> bbsDTOList = bbsServiceIf.listAll();
//        model.addAttribute("bbsList",bbsDTOList);
//        log.info("============================");
//    }
    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        log.info("===============================");
        log.info("BbsController >> list() START");
        log.info("pageRequestDTO : "+ pageRequestDTO.toString());

        if (bindingResult.hasErrors()){
            log.info("BbsController >> list Error");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        }

        PageResponseDTO<BbsDTO> responseDTO = bbsServiceIf.bbsListByPage(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);

        log.info("responseDTO : "+ responseDTO.toString());
        log.info("BbsController >> list() END");
        log.info("===============================");
    }
    @GetMapping("/view")
    public void view(@RequestParam(name="idx", defaultValue = "0") int idx, Model model){
        log.info("============================");
        log.info("bbsController view");
        log.info("idx : " +idx);
        BbsDTO bbsDTO = bbsServiceIf.view(idx);
        log.info("bbsDTO : " +bbsDTO);
        log.info("============================");
        model.addAttribute("bbsDTO",bbsDTO);

    }
    @GetMapping("/regist")
    public void registGET(){
        log.info("============================");
        log.info("bbsController registGET");
        log.info("============================");
    }
    @PostMapping("/regist")
    public String registPOST(@Valid BbsDTO bbsDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("bbsController registPOST");
        log.info("bbsDTO : " +bbsDTO);
        log.info("============================");
        if(bindingResult.hasErrors()){
            log.info("bindingResult Errors : " +bbsDTO);
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbsDTO",bbsDTO);
            return "redirect:/bbs/regist";
        }


        int result = bbsServiceIf.regist(bbsDTO);
        if(result > 0 ){
            return "redirect:/bbs/list";
        }
        else{
            return "/bbs/regist";
        }

    }
    @GetMapping("/modify")
    public void modifyGET(@RequestParam(name="idx", defaultValue = "0") int idx, Model model){
        log.info("============================");
        log.info("bbsController modifyGET");
        log.info("============================");
        BbsDTO bbsDTO = bbsServiceIf.view(idx);
        model.addAttribute("bbsDTO",bbsDTO);
    }
    @PostMapping("/modify")
    public String modifyPOST(@Valid BbsDTO bbsDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("============================");
        log.info("bbsController modifyPOST");
        log.info("modifyPOST bbsDTO"+bbsDTO);
        log.info("============================");
        if(bindingResult.hasErrors()){
            log.info("bindingResult Errors : " +bbsDTO);
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("bbsDTO",bbsDTO);
            redirectAttributes.addAttribute("idx",bbsDTO.getIdx());
            return "redirect:/bbs/modify";
        }
        int result = bbsServiceIf.modify(bbsDTO);
        if(result > 0 ){
            return "redirect:/bbs/view?idx="+bbsDTO.getIdx();
        }
        else{
            return "/bbs/modify";
        }

    }
    @PostMapping("/delete")
    public String deletePOST(@RequestParam(name="idx", defaultValue = "0") int idx){
        log.info("============================");
        log.info("bbsController deletePOST");
        log.info("============================");
        int result = bbsServiceIf.delete(idx);
        if(result > 0 ){
            return "redirect:/bbs/list";
        }
        else{
            return "/bbs/view?idx="+idx;
        }
    }



}
