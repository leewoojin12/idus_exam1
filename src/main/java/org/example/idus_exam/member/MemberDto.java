package org.example.idus_exam.member;

import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberDto {

    @Getter
    public static class SignupRequest {
        private String name;
        private String nickname;
        private String password;
        private int number;
        private String email;
        private String sex;
        public Member toEntity(PasswordEncoder passwordEncoder ) {

                return Member.builder()
                        .name(name)
                        .nickname(nickname)
                        .password(passwordEncoder.encode(password))
                        .number(number)
                        .email(email)
                        .sex("man")
                        .role("USER")
                        .build();


        }
    }
}
