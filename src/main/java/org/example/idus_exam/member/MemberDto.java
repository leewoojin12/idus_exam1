package org.example.idus_exam.member;

import jakarta.validation.constraints.*;
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
        @Pattern(regexp = "^[ㄱ-ㅎ가-힣A-Z]+$", message = "이름은 한글 또는 영어 대문자만 입력 가능합니다.")        @Size(max=20 )
        @NotNull
        @Size(max=20 )
        private String name;

        @NotNull(message = "닉네임을 필수로 입력하세요")
        @Size(max=30)
        private String nickname;

        @NotNull(message = "비밀번호는 필수로 입력하세요")
        @Size(min=10,  message = "비밀번호는 10글자 이상으로 입력해주세요.")
        private String password;

        @NotNull(message = "전화번호는 필수로 입력하세요")
        @Size(max=20 )

        private int number;

        @Email(message = "올바른 이메일 양식을 입력해주세요.") @NotBlank(message = "이메일은 필수로 입력해야합니다.")
        @NotNull(message = "이메일 필수로 입력하세요")
        @Size(max=100)
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
