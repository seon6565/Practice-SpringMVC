package org.fullstack4.springmvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.domain.BbsReplyVO;
import org.fullstack4.springmvc.domain.BbsVO;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.fullstack4.springmvc.mapper.BbsMapper;
import org.fullstack4.springmvc.mapper.BbsReplyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BbsReplyServiceImpl implements BbsReplyServiceIf{
    private final BbsReplyMapper bbsReplyXMLMapper;
    private final ModelMapper modelMapper;
    @Override
    public int reply_regist(BbsReplyDTO bbsReplyDTO) {
        log.info("========================");
        log.info("BbsReplyServiceImpl regist(bbsDTO)" + bbsReplyDTO);

        BbsReplyVO bbsReplyVO = modelMapper.map(bbsReplyDTO, BbsReplyVO.class);
        int result = bbsReplyXMLMapper.reply_regist(bbsReplyVO);
        int reply_result = bbsReplyXMLMapper.update_reply_cnt(bbsReplyDTO.getBbs_idx());
        log.info("BbsReplyServiceImpl bbsReplyVO" + bbsReplyVO);
        log.info("BbsReplyServiceImpl result" + result);
        log.info("========================");



        return result;
    }

    @Override
    public List<BbsReplyDTO> reply_list() {
        //List<BbsReplyDTO> BbsReplyDTOList = bbsReplyXMLMapper.reply_list().stream().map(vo->modelMapper.map(vo,BbsReplyDTO.class)).collect(Collectors.toList());
        return null;
    }

    @Override
    public int update_reply_cnt(int bbs_idx) {

        int result = bbsReplyXMLMapper.update_reply_cnt(bbs_idx);
        return result;
    }


}
