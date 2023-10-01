package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.exception.ResourceNotFoundException;
import edu.wctc.gameclub.repo.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMember(String email) throws ResourceNotFoundException {
        return memberRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Member", "email", email));
    }

    // New for v2
    public Member getMember(int memberId) throws ResourceNotFoundException {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new ResourceNotFoundException("Member", "id", memberId));
    }

    public List<Member> getAllMembers() {
        List<Member> list = new ArrayList<>();
        memberRepository.findAll().forEach(list::add);
        return list;
    }


}
