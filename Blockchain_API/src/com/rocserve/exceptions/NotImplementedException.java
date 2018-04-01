/**
 * 
 */
package com.rocserve.exceptions;

/**
 * @author Ryan Couper
 *
 */
public class NotImplementedException extends UnsupportedOperationException {

	private static final long serialVersionUID = 8470878730563907502L;

	public NotImplementedException() {
		super("This method has not yet been developed and cannot be used.");
	}

	public NotImplementedException(Throwable cause) {
		super("This method has not yet been developed however this exception was thrown for a different reason.",
				cause);
	}
	
	public NotImplementedException(String message) {
		super(message);
	}

}
