package Validation;

public class SenhaInvalidaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6334647476500164390L;

	public SenhaInvalidaException (String message) {
		super(message);
	}
}
