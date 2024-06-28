package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	private final String HANDLER_NAME = "Global Exception Handling";
	private int statusCode;
	private String message;
}
