package com.ll.gramgram.boundedContext.member.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/test")
    @ResponseBody
    public String showTest() {
        return "Hello test";
    }


    @GetMapping("/join")
    public String showJoin() {
        return "usr/member/join";
    }

    @PostMapping("/join")
    public String join(@Validated JoinForm joinForm) {
        return "redirect:/";
    }

    @AllArgsConstructor
    @Getter
    public static class JoinForm {
        @NotBlank
        @Size(min = 4, max = 30)
        private final String username;

        @NotBlank
        @Size(min = 4, max = 30)
        private final String password;
    }
}
