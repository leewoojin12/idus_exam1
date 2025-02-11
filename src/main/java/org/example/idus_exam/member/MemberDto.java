package org.example.idus_exam.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserResponse {
        private Long idx;
        private String name;
        private String nickname;
        private String password;
        private int number;
        private String email;
        private String sex;


        public static MemberDto.UserResponse from(Member member) {
            return UserResponse.builder()
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .email(member.getEmail())
                    .number(member.getNumber())
                    .build();
        }

    }


}
