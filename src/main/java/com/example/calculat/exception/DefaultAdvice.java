package com.example.calculat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

  @ExceptionHandler(value = ArithmeticException.class)
  public ResponseEntity arithmeticException(ArithmeticException e) {
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ExceptionHandler(value = NumberFormatException.class)
  public ResponseEntity numberFormatException(NumberFormatException e) {
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
