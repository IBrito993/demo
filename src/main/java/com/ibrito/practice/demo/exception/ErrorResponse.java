package com.ibrito.practice.demo.exception;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter()
@Setter()
@Generated
public class ErrorResponse {
	@Generated
	private String message;
	@Generated
	private List<String> details;

	public ErrorResponse(String message, List<String> details) {
		this.message = message;
		this.details = details;
	}
}