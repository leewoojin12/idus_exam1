package org.example.idus_exam.member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {



    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
    public void save(MemberDto.signupRequest memberDto ) {
        memberRepository.save(memberDto.toEntity(passwordEncoder ));
    }

    public void logout() {


    }

    public void find(Long idx) {
        memberRepository.findById(idx);
    }
}
