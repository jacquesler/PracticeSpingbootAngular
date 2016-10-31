package eCom.validation;

public class IllegalBasketOperation extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IllegalBasketOperation(String message){
		super(message);
	}

}
