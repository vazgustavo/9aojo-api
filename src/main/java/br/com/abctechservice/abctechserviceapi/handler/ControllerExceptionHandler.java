package br.com.abctechservice.abctechserviceapi.handler;

import br.com.abctechservice.abctechserviceapi.handler.exception.MaxAssistsException;
import br.com.abctechservice.abctechserviceapi.handler.exception.MinimumAssistRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimumAssistRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRiqueried(MinimumAssistRequiredException exception) {
        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxAssistsException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistRiqueried(MaxAssistsException exception) {
        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorMessageResponse> getErrorMessageResponseResponseEntity(String message, String description, HttpStatus statusCode) {
        ErrorMessageResponse error = new ErrorMessageResponse();
        error.setMesssage(message);
        error.setDescription(description);
        error.setTimeStamp(new Date());
        error.setStatusCode(statusCode.value());

        return new ResponseEntity<ErrorMessageResponse>(error, statusCode);
    }
}