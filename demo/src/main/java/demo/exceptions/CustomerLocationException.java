package demo.exceptions;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No match between customer ID and location")
public class CustomerLocationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerLocationException() {
		super();
	}
	
	public CustomerLocationException(String msg) {
		super(msg);
	}
}