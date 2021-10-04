package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Registration;
import edu.wctc.gameclub.repo.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public void cancel(int registrationId) {
        registrationRepo.deleteById(registrationId);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> list = new ArrayList<>();
        registrationRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public boolean isRegistered(Registration registration) {
        return registrationRepo.existsByMemberAndEvent(registration.getMember(), registration.getEvent());
    }

    @Override
    public void register(Registration registration) {
        registrationRepo.save(registration);
    }
}
