package org.fullstack4.springmvc.service;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.springmvc.dto.BbsDTO;
import org.fullstack4.springmvc.dto.BbsReplyDTO;
import org.fullstack4.springmvc.dto.PageRequestDTO;
import org.fullstack4.springmvc.dto.PageResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BbsReplyServiceTests {
    @Autowired()
    private BbsReplyServiceIf bbsReplyServiceIf;
    @Test
    public void testRegist(){
        BbsReplyDTO bbsReplyDTO = BbsReplyDTO.builder()
                .user_id("test")
                .title("제목 테스트").bbs_idx(51)
                .build();
        int result = bbsReplyServiceIf.reply_regist(bbsReplyDTO);
    }


}
