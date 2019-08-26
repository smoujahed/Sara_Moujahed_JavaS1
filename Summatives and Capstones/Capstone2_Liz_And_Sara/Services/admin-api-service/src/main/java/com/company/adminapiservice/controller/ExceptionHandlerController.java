package com.company.adminapiservice.controller;

import com.company.adminapiservice.exception.NotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ExceptionHandlerController {

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> notFoundException(NotFoundException e, WebRequest request){
        VndErrors error= new VndErrors(request.toString(),e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> invalidFormat(InvalidFormatException e, WebRequest request){
        VndErrors error= new VndErrors(request.toString(),e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> outOfRange(NullPointerException e, WebRequest request){
        VndErrors error= new VndErrors(request.toString(),e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<VndErrors> unsupportedApiRoute(HttpRequestMethodNotSupportedException e, WebRequest request){
        String msg = "Invalid Route!";
        VndErrors error= new VndErrors(request.toString(), msg);
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.METHOD_NOT_ALLOWED);
        return responseEntity;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> invalidFormat(NumberFormatException e, WebRequest request){
        String msg =  "A string was found in the route or the request body but was expecting a number ";
        VndErrors error= new VndErrors(request.toString(), msg);
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> taskerValidationError(MethodArgumentNotValidException e, WebRequest request){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();
        for(FieldError error:fieldErrors){
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(),error.getDefaultMessage());
            vndErrorList.add(vndError);
        }
        VndErrors vndErrors = new VndErrors(vndErrorList);
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors,HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors> requestSyntaxIssue(HttpMessageNotReadableException e, WebRequest request){
        String msg =  "Invalid Request Body!";
        VndErrors error= new VndErrors(request.toString(), msg);
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}

