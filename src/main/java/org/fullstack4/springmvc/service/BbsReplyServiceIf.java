package org.fullstack4.springmvc.service;

import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;

import java.util.List;

public interface BbsReplyServiceIf {
    int reply_regist(BbsReplyDTO BbsReplyDTO);
    List<BbsReplyDTO> reply_list(int bbs_idx);


}
