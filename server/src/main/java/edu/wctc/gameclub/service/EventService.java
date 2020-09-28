package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.exception.ResourceNotFoundException;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEvent(int id) throws ResourceNotFoundException;

    void save(Event event);

    void delete(int id) throws ResourceNotFoundException;
}
