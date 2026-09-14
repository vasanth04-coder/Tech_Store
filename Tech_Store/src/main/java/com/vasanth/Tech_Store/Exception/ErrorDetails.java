package com.vasanth.Tech_Store.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails
{
    String field;
    String message;
}
