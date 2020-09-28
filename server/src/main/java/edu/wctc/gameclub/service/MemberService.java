package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Member;

public interface MemberService {
    Member getMember(String email);
}
