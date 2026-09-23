package com.vasanth.Tech_Store.Security;

import com.vasanth.Tech_Store.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter
{
    @Autowired
    JwtService jwtService;
    MyUserDetailsService myUserDetailsService;

    public JwtFilter(JwtService jwtService,MyUserDetailsService myUserDetailsService)
    {
        this.jwtService = jwtService;
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)throws IOException,ServletException
    {
        String head = request.getHeader("Authorization");

        if(head.startsWith("Bearer "))
        {
             String token = head.substring(7);

            try
            {
             String user = jwtService.extractUser(token);

             UserDetails userDetails = myUserDetailsService.loadUserByUsername(user);

             Authentication authentication = new UsernamePasswordAuthenticationToken(
                     userDetails.getUsername(),
                     null,
                     userDetails.getAuthorities()
             );

             SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            catch (Exception e)
            {
               System.out.println("Invalid Jwt");
            }

        }
        filterChain.doFilter(request,response);
    }
}
