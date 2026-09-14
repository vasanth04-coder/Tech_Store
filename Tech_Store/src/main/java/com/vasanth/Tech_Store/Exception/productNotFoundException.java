package com.vasanth.Tech_Store.Exception;

public class productNotFoundException extends RuntimeException
{
    public productNotFoundException(String message)
    {
        super(message);
    }
}
