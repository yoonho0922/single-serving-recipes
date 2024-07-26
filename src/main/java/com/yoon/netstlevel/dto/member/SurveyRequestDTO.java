package com.yoon.netstlevel.dto.member;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SurveyRequestDTO {
    private Long memberId;
    private List<Integer> score;
}