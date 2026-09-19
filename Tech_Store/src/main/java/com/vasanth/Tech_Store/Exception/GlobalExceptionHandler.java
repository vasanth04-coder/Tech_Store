package com.vasanth.Tech_Store.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(productNotFoundException e)
    {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(categoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFound(categoryNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String>hadleWrongEmails(UsernameNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Email or email");
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String>handlesWrongPasswords(BadCredentialsException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Password or email");
    }


    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidations (MethodArgumentNotValidException e)
    {
         ArrayList<ErrorDetails>errors = new ArrayList<>();
         e.getBindingResult().getFieldErrors().forEach(error->
         {
            ErrorDetails errorDetails = new ErrorDetails(error.getField(),error.getDefaultMessage());
            errors.add(errorDetails);
         });

         ErrorResponse errorResponse = new ErrorResponse(404,"Not Validation",errors);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}

