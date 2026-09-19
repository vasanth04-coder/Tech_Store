package com.vasanth.Tech_Store.Security;

import com.vasanth.Tech_Store.Model.Users;
import com.vasanth.Tech_Store.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public UserDetails loadUserByUsername(String name)throws UsernameNotFoundException
    {
         Users user  =  userRepo.findByEmail(name);

         if(user == null)
         {
             throw new UsernameNotFoundException("user Not found");
         }

         return new org.springframework.security.core.userdetails.User(
                 user.getEmail(),
                 user.getPassword(),
                 Collections.emptyList()
         );
    }




}
