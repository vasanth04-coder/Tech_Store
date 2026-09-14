package com.vasanth.Tech_Store.Exception;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse
{
    private int Status;
    private String message;
    private List<ErrorDetails> errors;
}
