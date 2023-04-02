package com.ll.gramgram.base.rq;


import com.ll.gramgram.boundedContext.member.entity.Member;
import com.ll.gramgram.boundedContext.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Rq {

    private final MemberService memberService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final HttpSession session;
    private final User user;
    private Member member = null;

    public Rq(MemberService memberService, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.memberService = memberService;
        this.request = request;
        this.response = response;
        this.session = session;

        // 현재 로그인한 회원 인증 정보
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof User) {
            this.user = (User) authentication.getPrincipal();
        } else {
            this.user = null;
        }

    }

    public boolean isLogin() {
        return user != null;
    }

    public boolean isLogout() {
        return user == null;
    }

    public Member getMember() {
        if (isLogout()) {
            return null;
        }

        member = memberService.findByUsername(user.getUsername()).orElseThrow();

        return member;
    }





}
