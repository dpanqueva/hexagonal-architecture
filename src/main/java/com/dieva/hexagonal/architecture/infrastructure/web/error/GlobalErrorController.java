package com.dieva.hexagonal.architecture.infrastructure.web.error;

import com.dieva.hexagonal.architecture.domain.error.DomainEntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

   @ExceptionHandler(DomainEntityNotFoundException.class)
    ProblemDetail handleEntityNotFoundException(DomainEntityNotFoundException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Entity Not Found");
        problemDetail.setType(URI.create("https://dieva.com/errors/entity-not-found"));
        return problemDetail;
    }
}
