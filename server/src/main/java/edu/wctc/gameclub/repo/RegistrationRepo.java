package edu.wctc.gameclub.repo;

import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.entity.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<Registration, Integer> {
    boolean existsByMemberAndEvent(Member member, Event event);
}
