/**
 * 
 */
package com.rocserve.api.blockcypher.exceptions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ryan Couper
 *
 */
public class InvalidURIException extends MalformedURLException {

	private static final long serialVersionUID = -369698491442629910L;

	/**
	 * @param uri The java.net.URL that was used in the attempted connection.
	 */
	public InvalidURIException(URL uri) {
		super("Invalid URI used.\nURI passed to method: " + uri.toString());
	}
	
	/**
	 * Use this to add a custom message to the error report.
	 * @param message Any message passed in for enhanced error reporting. 
	 * @param uri The URI in string format that was used in the attempted connection.
	 */
	public InvalidURIException(String message, String uri) {
		super(message + "\nInvalid URI used.\nURI passed to method: " + uri);
	}
	
	/**
	 * Convenience method, converts the URI to string and sends it to {@link InvalidURIException#InvalidURIException(String, String)}
	 * @param message Any message passed in for enhanced error reporting.
	 * @param uri The URI in string format that was used in the attempted connection.
	 */
	public InvalidURIException(String message, URL uri) {
		this(message, uri.toString());
	}

}
