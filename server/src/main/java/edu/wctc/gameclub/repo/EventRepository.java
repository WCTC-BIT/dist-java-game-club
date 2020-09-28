package edu.wctc.gameclub.repo;

import edu.wctc.gameclub.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
