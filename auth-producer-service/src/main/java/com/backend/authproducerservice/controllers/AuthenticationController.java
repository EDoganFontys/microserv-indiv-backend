package com.backend.authproducerservice.controllers;

import com.backend.authproducerservice.RabbitMqSender;
import com.backend.authproducerservice.domainmodels.RegisterUser;
import com.backend.authproducerservice.payload.request.LoginRequest;
import com.backend.authproducerservice.payload.response.JwtResponse;
import com.backend.authproducerservice.payload.response.MessageResponse;
import com.backend.authproducerservice.security.JwtUtils;
import com.backend.authproducerservice.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    private RabbitMqSender rabbitMqSender;

    @Autowired
    public AuthenticationController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    //todo authentication logic to encrypt user details

    @PostMapping(value = "login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
    @PostMapping(value = "register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterUser user) {
        return rabbitMqSender.sendRegister(user);
    }

    @GetMapping(value = "user/info")
    public String profileInfo(){
        return "session not implemented  yet";
    }
}
