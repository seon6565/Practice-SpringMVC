package org.fullstack4.springmvc.domain;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsVO {
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private int read_cnt;
    private LocalDate display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private String interest;
}
