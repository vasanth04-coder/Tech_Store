package com.vasanth.Tech_Store.Controller;
import com.vasanth.Tech_Store.DTO.LoginRequest;
import com.vasanth.Tech_Store.DTO.RegisterRequest;
import com.vasanth.Tech_Store.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")

public class UserController
{
    @Autowired
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest)
    {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<String>login(@Valid @RequestBody LoginRequest loginRequest)
    {
      return new ResponseEntity<>(userService.login(loginRequest),HttpStatus.OK);
    }
}
