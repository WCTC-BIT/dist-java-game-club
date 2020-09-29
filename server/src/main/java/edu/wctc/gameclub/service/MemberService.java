package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.exception.ResourceNotFoundException;

public interface MemberService {
    Member getMember(String email);

    Member getMember(int memberId) throws ResourceNotFoundException;
}
