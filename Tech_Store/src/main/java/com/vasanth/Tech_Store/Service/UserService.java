package com.vasanth.Tech_Store.Service;

import com.vasanth.Tech_Store.DTO.LoginRequest;
import com.vasanth.Tech_Store.DTO.RegisterRequest;
import com.vasanth.Tech_Store.Model.Role;
import com.vasanth.Tech_Store.Model.Users;
import com.vasanth.Tech_Store.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserRepo userRepo;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtService jwtService;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager,JwtService jwtService)
    {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest registerRequest)
    {
      Users users = new Users();
      users.setName(registerRequest.getName());
      users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
      users.setEmail(registerRequest.getEmail());
      users.setRole(Role.USER);
      userRepo.save(users);
      return "Registered Successfully..";
    }

    public String login(LoginRequest loginRequest)
    {
       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
               loginRequest.getEmail(),
               loginRequest.getPassword())
               );

        return jwtService.generateToken(authentication);
    }
}
