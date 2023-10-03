package com.edu.controller;

public class CustomResponse<T> {
    private int statusCode;
    private T data;
	public CustomResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomResponse(int statusCode, T data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

    // Constructors, getters, and setters
}

