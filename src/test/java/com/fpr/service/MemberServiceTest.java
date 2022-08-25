package com.fpr.service;

import com.fpr.domain.Member;
import com.fpr.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    @DisplayName("회원가입 테스트")
    void 회원가입(){
        // given
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("test@naver.com");
        memberDto.setPassword("1234");
        memberDto.setAge(20);
        memberDto.setJob("무직");
        memberDto.setUsername("테스트");
        memberDto.setPhoneNumber("010-4555-2787");

        // when
        memberService.insertMember(memberDto.toEntity());
        Member findMember = memberService.getMember("테스트");

        log.info("" + findMember.getMemberId());
        log.info("" + findMember.getCreatedAt());

        // then
        Assertions.assertThat(memberDto.getEmail()).isEqualTo(findMember.getEmail());
    }
}
