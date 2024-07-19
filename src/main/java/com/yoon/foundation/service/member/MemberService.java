package com.yoon.foundation.service.member;


import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.dto.member.*;
import com.yoon.foundation.repository.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CommonResponse<String> findMemberSatiety(SatietyRequestDTO satietyRequestDTO) throws NoSuchFieldException {
        Member member = memberRepository.findMember(satietyRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new NoSuchFieldException("존재하지 않는 유저입니다.");
        }
        else{
            return CommonResponse.success("포만도 업데이트 성공");
        }
    }

    @Transactional
    public CommonResponse<Object> findMember(LoginRequestDTO loginRequestDTO){
        Member member = memberRepository.findMember(loginRequestDTO.getName(),loginRequestDTO.getEmail());
        if(Objects.isNull(member)){
            Member newMember = memberRepository.save(new Member(loginRequestDTO.getName(),loginRequestDTO.getEmail()));
            return CommonResponse.success(newMember);
        }else{
            return CommonResponse.success(member);
        }

    }

    @Transactional
    public CommonResponse<String> feedback (FeedbackRequestDTO feedbackRequestDTO){
        Member member = memberRepository.findMember(feedbackRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new EntityNotFoundException("존재하지 않는 유저입니다.");
        }else{
            if(Objects.nonNull( feedbackRequestDTO.getFeedback())){
                if(feedbackRequestDTO.getFeedback()) {
                    member.setServingSize(member.getServingSize() + 0.1);
                }else{
                    member.setServingSize(member.getServingSize()-0.1);
                }
            }
        }
        return CommonResponse.success("피드백이 정상적으로 반영되었습니다.");
    }

    @Transactional
    public CommonResponse<String> finish(FinishRequestDTO finishRequestDTO){
        Member member = memberRepository.findMember(finishRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new EntityNotFoundException("존재하지 않는 유저입니다.");
        }else{
            Double carbonPledge = Objects.nonNull(member.getCarbonPledge()) ?member.getCarbonPledge():0;
            member.setCarbonPledge( carbonPledge + finishRequestDTO.getCarbonPledge());
        }
        return CommonResponse.success("유저 탄소 배출 감소량 업데이트 성공");
    }

    @Transactional
    public CommonResponse<Double> survey(SurveyRequestDTO surveyRequestDTO){
        Member member = memberRepository.findMember(surveyRequestDTO.getMemberId());
        if(Objects.isNull(member)){
            throw new EntityNotFoundException("존재하지 않는 유저입니다.");
        }else{
            member.setServingSize(calculateServingSize(surveyRequestDTO.getScore()));
        }
        return CommonResponse.success(member.getServingSize());
    }

    private Double calculateServingSize(List<Integer> scores){
        double averageScore=0;
        for(Integer score:scores){
            if(score==5){
                averageScore+=1.6;
            }if(score==4){
                averageScore+=1.2;
            }if(score==3){
                averageScore+=1.0;
            }if(score==2){
                averageScore+=0.8;
            }if(score==1){
                averageScore+=0.6;
            }
        }
        averageScore = averageScore / 5;
        return Math.floor(averageScore * 10) / 10.0;    }
}