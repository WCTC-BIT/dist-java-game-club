package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member getMember(String email) {
        return memberRepository.findByEmail(email);
    }
}
