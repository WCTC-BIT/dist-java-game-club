package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.dto.Rsvp;
import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.entity.Registration;
import edu.wctc.gameclub.exception.DuplicateRegistrationException;
import edu.wctc.gameclub.exception.ResourceNotFoundException;
import edu.wctc.gameclub.service.EventService;
import edu.wctc.gameclub.service.MemberService;
import edu.wctc.gameclub.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rsvp")
//@CrossOrigin(origins="http://localhost:63342")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Rsvp register(@RequestBody Rsvp rsvp) {
        try {
            return registrationService.register(rsvp);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (DuplicateRegistrationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid RSVP", e);
        }

    }
}
