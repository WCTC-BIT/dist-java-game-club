package edu.wctc.gameclub.service;

import edu.wctc.gameclub.dto.Rsvp;
import edu.wctc.gameclub.entity.Event;
import edu.wctc.gameclub.entity.Member;
import edu.wctc.gameclub.entity.Registration;
import edu.wctc.gameclub.exception.DuplicateRegistrationException;
import edu.wctc.gameclub.repo.RegistrationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepo registrationRepo;
    private final EventService eventService;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    public RegistrationService(RegistrationRepo registrationRepo,
                               EventService eventService,
                               MemberService memberService,
                               ModelMapper modelMapper) {
        this.registrationRepo = registrationRepo;
        this.eventService = eventService;
        this.memberService = memberService;
        this.modelMapper = modelMapper;
    }

    private Rsvp convertToDto(Registration reg) {
        Rsvp rsvp = modelMapper.map(reg, Rsvp.class);
        return rsvp;
    }

    private Registration convertToEntity(Rsvp rsvp) {
        Registration reg = modelMapper.map(rsvp, Registration.class);
        // Can't save a parent object with transient child objects
        Member member = memberService.getMember(rsvp.getMemberEmail());
        Event event = eventService.getEvent(rsvp.getEventId());
        reg.setMember(member);
        reg.setEvent(event);
        return reg;
    }

    public List<Registration> getAllRegistrations() {
        List<Registration> list = new ArrayList<>();
        registrationRepo.findAll().forEach(list::add);
        return list;
    }

    public boolean isRegistered(Registration registration) {
        return registrationRepo.existsByMemberAndEvent(registration.getMember(), registration.getEvent());
    }

    public Rsvp register(Rsvp rsvp) {
        Registration reg = convertToEntity(rsvp);
        if (isRegistered(reg)) {
            throw new DuplicateRegistrationException(reg.getMember().getEmail(), reg.getEvent().getName());
        } else {
            registrationRepo.save(reg);
            rsvp.setRsvpStatus("Registered successfully. See you at " + reg.getEvent().getName() + "!");
            return rsvp;
        }
    }
}
