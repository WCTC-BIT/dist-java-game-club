package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Registration;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAllRegistrations();

    boolean isRegistered(Registration registration);

    void register(Registration registration);

    void cancel(int registrationId);
}
