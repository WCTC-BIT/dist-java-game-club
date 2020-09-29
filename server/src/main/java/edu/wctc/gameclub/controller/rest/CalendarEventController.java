package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.dto.CalendarEvent;
import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.service.EventService;
import edu.wctc.gameclub.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/events")
public class CalendarEventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelMapper modelMapper;

    private CalendarEvent convertToDto(Event event) {
        CalendarEvent calEvent = modelMapper.map(event, CalendarEvent.class);
        return calEvent;
    }

    private Event convertToEntity(CalendarEvent calEvent) throws Exception {
        Event event = modelMapper.map(calEvent, Event.class);
        Member host = memberService.getMember(calEvent.getHostId());
        event.setHost(host);
        return event;
    }

    @GetMapping("/")
    public List<CalendarEvent> getAllEvents() {
        return eventService.getAllEvents().stream()
                .map(this::convertToDto).collect(Collectors.toList());
    }
}
