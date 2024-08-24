package com.cseazeem.course_management.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Define a custom exception and map it to 400 Bad Request
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CourseAlreadyExistsException extends RuntimeException {

    // Constructor that takes a message
    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}
