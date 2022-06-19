package com.backend.authproducerservice.services;

import com.backend.authproducerservice.domainmodels.CheckResponses;
import com.backend.authproducerservice.domainmodels.RegisterUser;
import com.backend.authproducerservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepository;

    public CheckResponses checkIfUserExists(RegisterUser registerUser) {
        var user = userRepository.findByUsername(registerUser.getUsername());
        if (user.isEmpty()) {
            return CheckResponses.ACCOUNT_AVAILABLE;
        } else {
            if (user.get().getUsername().equals(registerUser.getUsername())) {
                return CheckResponses.USERNAME_EXISTS;
            }
            if (user.get().getEmail().equals(registerUser.getEmail())) {
                return CheckResponses.EMAIL_EXISTS;
            }
        }
        return null;
    }
}
