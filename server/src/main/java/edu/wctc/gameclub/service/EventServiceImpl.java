package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.exception.ResourceNotFoundException;
import edu.wctc.gameclub.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    public void delete(int eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList<>();
        eventRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Event getEvent(int id) throws ResourceNotFoundException {
        return eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Event", "id", id));
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }
}
