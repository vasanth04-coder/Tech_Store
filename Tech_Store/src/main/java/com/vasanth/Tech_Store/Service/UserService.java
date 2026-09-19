package com.vasanth.Tech_Store.Service;

import com.vasanth.Tech_Store.DTO.LoginRequest;
import com.vasanth.Tech_Store.DTO.RegisterRequest;
import com.vasanth.Tech_Store.Model.Role;
import com.vasanth.Tech_Store.Model.Users;
import com.vasanth.Tech_Store.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    UserRepo userRepo;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder,AuthenticationManager authenticationManager)
    {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String register(RegisterRequest registerRequest)
    {
      Users user = new Users();
      user.setName(registerRequest.getName());
      user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
      user.setEmail(registerRequest.getEmail());
      user.setRole(Role.USER);
      userRepo.save(user);
      return "Registerd Successfully..";
    }

    public String login(LoginRequest loginRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                         loginRequest.getEmail(),
                         loginRequest.getPassword())
                           );
        return "Login Successfully";
    }


}
