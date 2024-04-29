package ru.stepup.homework.hw5.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {SException.class})
    protected ResponseEntity<Object> apiError(RuntimeException ex, WebRequest request) {
        ErrorMessageType emt = new ErrorMessageType();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (ex instanceof SException){
            SException sexp = (SException) ex;
            emt.setMessages(List.of(sexp.getMessage()));
            //System.out.println(emt);
            switch (sexp.getHttpMethodType()){
                case "Bad_Request":
                    status = HttpStatus.BAD_REQUEST;
                    emt.setCode(400);
                    break;
                case "Not_Found":
                    status = HttpStatus.NOT_FOUND;
                    emt.setCode(404);
                    break;
            }
        }

        return handleExceptionInternal(ex, emt,
                new HttpHeaders(), status, request);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ErrorMessageType emt = new ErrorMessageType();
//        headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//
//        emt.setMessages(Arrays.stream(ex.getDetailMessageArguments()).filter(o -> !o.toString().equals("")).collect(Collectors.toList()));
//        return this.handleExceptionInternal(ex, emt, headers, HttpStatus.BAD_REQUEST, request);
//    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class ErrorMessageType {
    private List<Object> messages;
    private int code;
}