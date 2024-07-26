package com.yoon.netstlevel.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestDTO {
    private  String name;
    private String email;

}
