package br.com.desafio.totalshake.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){
        if(e.getClass().equals(NullPointerException.class)){
            return new ResponseEntity("Pedido não encontrado", HttpStatus.NOT_FOUND);
        } else if (e.getClass().equals(IllegalArgumentException.class)) {
            return new ResponseEntity("Você precisar adicionar itens ao pedido", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity("Error encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}
