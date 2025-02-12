package org.example.idus_exam.member;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberService implements UserDetailsService {


    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public void save(MemberDto.SignupRequest memberDto) {
        memberRepository.save(memberDto.toEntity(passwordEncoder));
    }

    public void logout() {


    }

    public void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);


    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findByEmail(username);

        if (result.isPresent()) {
            // 7번 로직
            Member member = result.get();
            return member;
        }

        return null;
    }

    public MemberDto.UserResponse find(Long memberidx) {
        Optional<Member> result = memberRepository.findById(memberidx);

        if (result.isPresent()) {
            // 7번 로직
            Member member = result.get();
            return MemberDto.UserResponse.from(member);
        }
        return null;

    }
}
//
//    public MemberDto.UserResponse find(Long idx) {
//        Member member = memberRepository.findById(idx).orElseThrow();
//
//
//        return null;
//    }

