package com.yoon.netstlevel.dto.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeedbackRequestDTO {
    Long memberId;
    Boolean feedback;
}
