package com.ex.boot.exception;

public class DbException extends Exception{

	public DbException(){
		super();
	}
	
	public DbException(Exception e) {
		super(e);
	}
	
	public DbException(String message) {
		super(message);
	}
}
