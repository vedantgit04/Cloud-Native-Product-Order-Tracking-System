package com.example.ProductService.Advises;


import com.example.ProductService.DTOs.ArithmaticExceptionDTO;
import com.example.ProductService.DTOs.InvalidProductIdExceptionDTO;
import com.example.ProductService.Exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandderAdvice {

    @ExceptionHandler(ArithmeticException.class)
    // this is very generic you can handle this by return different things
    public ResponseEntity<ArithmaticExceptionDTO> HandlingArithmaticException(){
           ArithmaticExceptionDTO dto = new ArithmaticExceptionDTO();
           dto.setMessage("this is the message from controller advise exceptional handling");
           return new ResponseEntity<>(dto, HttpStatusCode.valueOf(404));
    }
    @ExceptionHandler(InvalidProductIdException.class)
    public   ResponseEntity<InvalidProductIdExceptionDTO> HandlingInvalidProductIdException(){
        InvalidProductIdExceptionDTO dto = new InvalidProductIdExceptionDTO();
        dto.setMessage("Invalid product id");
        return new ResponseEntity<>(dto,HttpStatusCode.valueOf(404));
    }
}
