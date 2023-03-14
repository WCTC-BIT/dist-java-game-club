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
@RequestMapping("/api/events")
//@CrossOrigin(origins="http://localhost:63342")
public class CalendarEventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<CalendarEvent> getAllEvents() {
        return eventService.getAllCalendarEvents();
    }
}
