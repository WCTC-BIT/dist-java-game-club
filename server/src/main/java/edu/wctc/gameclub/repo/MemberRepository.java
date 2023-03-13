package edu.wctc.gameclub.repo;

import edu.wctc.gameclub.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Integer> {
    Optional<Member> findByEmail(String email);
}
