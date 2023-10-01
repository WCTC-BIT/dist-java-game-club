package edu.wctc.gameclub.service;

import edu.wctc.gameclub.dto.CalendarEvent;
import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.exception.ResourceNotFoundException;
import edu.wctc.gameclub.repo.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private final MemberService memberService;
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public EventService(MemberService memberService,
                        EventRepository eventRepository,
                        ModelMapper modelMapper) {
        this.memberService = memberService;
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    public void delete(int eventId) throws ResourceNotFoundException {
        getEvent(eventId);
        eventRepository.deleteById(eventId);
    }

    public List<CalendarEvent> getAllCalendarEvents() {
        List<CalendarEvent> list = new ArrayList<>();
        eventRepository.findAll().forEach(event -> list.add(convertToDto(event)));
        return list;
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList<>();
        eventRepository.findAll().forEach(list::add);
        return list;
    }

    public Event getEvent(int id) throws ResourceNotFoundException {
        return eventRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Event", "id", id));
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    private CalendarEvent convertToDto(Event event) {
        return modelMapper.map(event, CalendarEvent.class);
    }

    private Event convertToEntity(CalendarEvent calEvent) throws Exception {
        Event event = modelMapper.map(calEvent, Event.class);
        Member host = memberService.getMember(calEvent.getHostId());
        event.setHost(host);
        return event;
    }
}
