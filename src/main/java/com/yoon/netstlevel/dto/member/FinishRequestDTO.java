package com.yoon.netstlevel.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FinishRequestDTO {
    private Long memberId;
    private Double carbonPledge;

}
