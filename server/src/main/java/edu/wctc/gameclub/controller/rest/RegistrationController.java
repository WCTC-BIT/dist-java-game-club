package edu.wctc.gameclub.controller.rest;

import edu.wctc.gameclub.dto.Rsvp;
import edu.wctc.gameclub.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rsvp")
//@CrossOrigin(origins="http://localhost:63342")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public Rsvp register(@RequestBody Rsvp rsvp) {
        return registrationService.register(rsvp);
    }
}
