package com.rocserve.network.http;

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

import com.rocserve.exceptions.*;
import com.rocserve.api.blockcypher.exceptions.*;

/**
 * 
 * @author Ryan Couper
 *
 */
public interface HTMLRequests {

	public static String HTMLPut(String requestUrl, String parameters) {
		// TODO
		throw new NotImplementedException("HTMLPut method not yet implemented.");
	}
	
	public static String HTMLPost(String requestUrl, String parameters) throws MalformedURLException, IOException {

		// Setup connection.
		URL url = new URL(requestUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		// Set headers
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		conn.setDoOutput(true);
		DataOutputStream outputStream = new DataOutputStream(conn.getOutputStream());
		outputStream.writeBytes(parameters);
		outputStream.flush();
		outputStream.close();

		// Handle the response
		int responseCode = conn.getResponseCode();
		if (responseCode > 299)
			throw new IOException("Response code indicates error.\nReponse code: " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String responseLine;
		StringBuffer response = new StringBuffer();
		
		while ((responseLine = in.readLine()) != null) {
			response.append(responseLine);
		}
		in.close();
		
		return response.toString();
	}

	public static String HTMLGet(String requestUrl) throws MalformedURLException, IOException, InvalidURIException {
		StringBuilder result = new StringBuilder();
		URL url = null;

		url = new URL(requestUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		BufferedReader BReader = null;
		try {
			BReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (FileNotFoundException ex) {
			throw new InvalidURIException(url);
		}
		String line;
		while ((line = BReader.readLine()) != null) {
			result.append(line);
		}
		BReader.close();
		
		int responseCode = conn.getResponseCode();
		if(responseCode > 299) {
			throw new IOException("Exception raised from remote resource.\n"
					+ "Response code " + responseCode + " was received.");
		}

		return result.toString();
	}

	public static boolean HTMLDelete(String requestUrl, String parameters) throws MalformedURLException, IOException {
		
		// Setup connection
		URL url = new URL(requestUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		
		// Set headers
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept-Language", "en-US,en);q=0.5");
		
		int responseCode = conn.getResponseCode();
		if(responseCode == 204)
			return true;
		
		return false;
	}
}
