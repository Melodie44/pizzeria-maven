package fr.pizzeria.exception;

public class StockageException extends Exception{

	String message;
	
	public StockageException(String message) {
		
		this.message = message;
		
	}
	
}
