package edu.wctc.gameclub.repo;

import edu.wctc.gameclub.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
    Member findByEmail(String email);
}
