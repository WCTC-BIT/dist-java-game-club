package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.dto.CalendarEvent;
import edu.wctc.gameclub.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/events")
//@CrossOrigin(origins="http://localhost:63342")
public class CalendarEventController {
    private final EventService eventService;

    public CalendarEventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<CalendarEvent> getAllEvents() {
        return eventService.getAllCalendarEvents();
    }
}
