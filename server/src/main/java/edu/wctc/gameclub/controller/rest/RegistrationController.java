package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.dto.Rsvp;
import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.entity.Registration;
import edu.wctc.gameclub.service.EventService;
import edu.wctc.gameclub.service.MemberService;
import edu.wctc.gameclub.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/rsvp")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private EventService eventService;

    @Autowired
    private ModelMapper modelMapper;

    private Registration convertToEntity(Rsvp rsvp) throws Exception {
//        Registration reg = modelMapper.map(rsvp, Registration.class);
        Registration reg = new Registration();
        // Can't save a parent object with transient child objects
        Member member = memberService.getMember(rsvp.getMemberEmail());
        Event event = eventService.getEvent(rsvp.getEventId());
        reg.setMember(member);
        reg.setEvent(event);
        return reg;
    }


    @PostMapping("/")
    public Rsvp makeReservation(@RequestBody Rsvp rsvp) {
        try {
            Registration reg = convertToEntity(rsvp);
            if (registrationService.isRegistered(reg)) {
                rsvp.setStatus("You are already registered for " + reg.getEvent().getName());
            } else {
                registrationService.register(reg);
                rsvp.setStatus("See you at " + reg.getEvent().getName() + "!");
            }
            return rsvp;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid RSVP", e);
        }
    }
}
