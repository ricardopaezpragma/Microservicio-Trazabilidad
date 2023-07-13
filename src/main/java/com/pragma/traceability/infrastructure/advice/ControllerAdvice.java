package com.pragma.traceability.infrastructure.advice;

import com.pragma.traceability.infrastructure.exception.TraceabilityException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = TraceabilityException.class)
    public ResponseEntity<ProblemDetail> traceabilityException(TraceabilityException error) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                error.getMessage());
        problemDetail.setTitle("Not found exception");
        return ResponseEntity.status(404).body(problemDetail);
    }
}
