package edu.wctc.gameclub.service;

import edu.wctc.gameclub.entity.Registration;

public interface RegistrationService {
    boolean isRegistered(Registration registration);

    void register(Registration registration);

    void cancel(int registrationId);
}
