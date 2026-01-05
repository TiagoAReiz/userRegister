package signin.user.adapters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import signin.user.application.dtos.httpResponse;
import signin.user.core.exceptions.UserAlreadyExistsException;
import signin.user.core.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<httpResponse> handleUserNotFoundException(UserNotFoundException ex){

        httpResponse httpResponse = new httpResponse(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(httpResponse.getStatus()).body(httpResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<httpResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
        httpResponse httpResponse = new httpResponse(HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(httpResponse.getStatus()).body(httpResponse);
    }
}
