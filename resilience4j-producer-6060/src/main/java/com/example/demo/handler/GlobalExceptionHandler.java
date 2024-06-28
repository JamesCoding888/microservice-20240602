package com.example.demo.handler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.example.demo.model.ErrorMessage;

@ControllerAdvice // Handling Global Transactions (處理全局事務)
public class GlobalExceptionHandler {
	// Handling Specific Global Exceptions
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException ex, WebRequest request){
		// Customize ErrorMessage Response
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		 return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	
}
