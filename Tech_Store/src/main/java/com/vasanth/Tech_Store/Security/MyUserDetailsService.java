package com.vasanth.Tech_Store.Security;

import com.vasanth.Tech_Store.Model.Users;
import com.vasanth.Tech_Store.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Users users = userRepo.findByEmail(username);

        if (users == null)
        {
            throw new UsernameNotFoundException("User Not Found");
        }

        return new User(
                users.getEmail(),
                users.getPassword(),
                Collections.emptyList()
        );

    }
}