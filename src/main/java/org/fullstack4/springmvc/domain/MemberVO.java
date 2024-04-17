package org.fullstack4.springmvc.domain;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {
    private String user_id;
    private String name;
    private String pwd;
    private String jumin;
    private String addr1;
    private String addr2;
    private String birthday;
    private String job_code;
    private int mileage;
    private String user_state;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private LocalDate leave_date;
    private LocalDate pwd_change_date;
}
