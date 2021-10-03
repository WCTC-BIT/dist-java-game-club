package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.exception.ResourceNotFoundException;
import edu.wctc.gameclub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
// Address of IntelliJ's web preview server
//@CrossOrigin(origins="http://localhost:63342")
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        // If client sent an ID, ignore it
        // POST will always create a new event, never update
        event.setId(0);
        eventService.save(event);
        return event;
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event) {
        // PUT will always update a new event, never create
        eventService.save(event);
        return event;
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable String eventId) {
        try {
            eventService.delete(Integer.parseInt(eventId));
            return "Successfully deleted Event ID: " + eventId;
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event Not Found", e);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Event ID", e);
        }
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEvent(@PathVariable String eventId) {
        try {
            return eventService.getEvent(Integer.parseInt(eventId));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event Not Found", e);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Event ID", e);
        }
    }
}
