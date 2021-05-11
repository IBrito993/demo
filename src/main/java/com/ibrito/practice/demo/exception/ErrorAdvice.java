package com.ibrito.practice.demo.exception;



import com.ibrito.practice.demo.utils.Constants;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice()
@Generated
@Slf4j
public class ErrorAdvice {


  @ExceptionHandler(NotFoundException.class)
  public final ResponseEntity<Object> notFoundException(NotFoundException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse error = new ErrorResponse("Resource not found", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    log.error("Resource not found: " + ex.getLocalizedMessage());
    return errorResponse;
  }

  @ExceptionHandler(BadRequestException.class)
  public final ResponseEntity<Object> badRequestException(
      BadRequestException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    log.error("Input data error " + ex.getLocalizedMessage());
    return errorResponse;
  }

  @ExceptionHandler(ConflictException.class)
  public final ResponseEntity<Object> conflictException(ConflictException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse error = new ErrorResponse("Conflict", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
    log.error("Conflict: " + ex.getLocalizedMessage());
    return errorResponse;
  }

  @ExceptionHandler(InternalException.class)
  public final ResponseEntity<Object> internalException(InternalException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse error = new ErrorResponse("Internal error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.INTERNAL_SERVER_ERROR);
    return errorResponse;
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public final ResponseEntity<Object> methodArgumentNotValidException(
      MethodArgumentNotValidException ex,
      WebRequest request) {
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    return errorResponse;
  }

  @ExceptionHandler(value = ConstraintViolationException.class)
  public final ResponseEntity<Object> methodConstraintViolation(ConstraintViolationException ex,
      WebRequest request) {
    List<String> details = new ArrayList<>();
    for (ConstraintViolation<?> error : ex.getConstraintViolations()) {
      details.add(error.getMessage());
    }
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    return errorResponse;
  }

  @ExceptionHandler(value = DataIntegrityViolationException.class)
  public final ResponseEntity<Object> methodIntegrityViolation(DataIntegrityViolationException ex,
      WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(Constants.DATA_CONFLICT);
    ErrorResponse error = new ErrorResponse("Conflict", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
    log.error("Conflict: " + ex.getLocalizedMessage());
    return errorResponse;
  }

  @ExceptionHandler(value = BindException.class)
  public final ResponseEntity<Object> BindExceptionException(BindException ex, WebRequest request) {
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    return errorResponse;
  }

  @ExceptionHandler(value = HttpMessageNotReadableException.class)
  public final ResponseEntity<Object> handleException(HttpMessageNotReadableException ex,
      WebRequest request) {
    List<String> details = new ArrayList<>();
    details
        .add("The method you are querying requires a valid JSON in the body of the Http request");
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    return errorResponse;
  }

  @ExceptionHandler(value = NumberFormatException.class)
  public final ResponseEntity<Object> handleException(NumberFormatException ex,
      WebRequest request) {
    List<String> details = new ArrayList<>();
    details
        .add("The method you are querying requires a number or a list of numbers as a parameter");
    ErrorResponse error = new ErrorResponse("Input data error", details);
    ResponseEntity<Object> errorResponse = new ResponseEntity<Object>(error,
        HttpStatus.BAD_REQUEST);
    return errorResponse;
  }
}
