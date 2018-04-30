/**
 * 
 */
package com.rocserve.api.blockcypher.v1.blockchains;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;

import org.json.simple.*;
import org.json.simple.parser.*;

import com.rocserve.api.blockcypher.exceptions.InvalidURIException;
import com.rocserve.api.blockcypher.v1.EAvailableVersions;
import com.rocserve.api.blockcypher.v1.EBlockchains;
import com.rocserve.network.http.*;

/**
 * @author Ryan Couper
 *
 */
public class Blockchain extends AbsBlockchain {

	/**
	 * @param chainType
	 *            The name of the coin of which to create a blockchain API for.
	 *            Possible options are in {@link EBlockchains}
	 * @param version
	 *            The version of Blockcypher's API to use for this instance of the
	 *            Blockchain API access. Possible options are in
	 *            {@link EAvailableVersions}
	 * @throws IllegalArgumentException
	 *             Thrown when an incorrect value is passed into either of the
	 *             arguments. An incorrect value is a value that is not listed in
	 *             the {@link EBlockchains} and {@link EAvailableVersions}
	 *             enumerations.
	 */
	public Blockchain(EBlockchains chainType, EAvailableVersions version) throws IllegalArgumentException {
		super(chainType, version);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTXInfo(String hashOfTransaction) throws IOException {
		String urlString = BASE_URI + "/txs/" + hashOfTransaction;
		return getHTML(urlString);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUnconfirmedTXInfo() throws IOException {
		String urlString = BASE_URI + "/txs";
		return getHTML(urlString);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAddressMeta(String address, String apiToken, boolean getPrivateData) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTXMeta(String hash, String apiToken, boolean getPrivateData) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBlockMeta(String blockHash, String apiToken, boolean getPrivateData) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setAddressMeta(String address, String apiToken, String jsonFormattedData, boolean isPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setTXMeta(String txhash, String apiToken, String jsonFormattedData, boolean isPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setBlockMeta(String blockHash, String apiToken, String jsonFormattedData, boolean isPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAddressMeta(String address, String apiToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteTXMeta(String txHash, String apiToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteBlockMeta(String blockHash, String apiToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getChainInfo() throws IOException {
		// TODO Auto-generated method stub
		return getHTML(BASE_URI);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBlockInfoAtHash(String hashOfBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInfoOfBlockAtHeight(BigInteger heightOfBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createWallet(String name, String apiToken, String[] addresses) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createHDWallet(String name, String apiToken, String extendedPublicKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String createHDWallet(String name, String apiToken, String extendedPublicKey, String[] subchains) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getActiveWallets(String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getWalletInformation(String name, String apiToken, boolean isHDWallet) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String addAddressesToWallet(String name, String apiToken, String[] addresses, boolean omitWalletAddresses) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getWalletAddresses(String name, String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHDWalletAddresses(String name, String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHDWalletAddresses(String name, String apiToken, boolean zeroBalanceAddresses) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken,
			boolean zeroBalanceAddresses) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAddressesFromWallet(String name, String apiToken, String[] addresses) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteWallet(String name, String apiToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getBalance(String address, String apiToken, boolean omitWalletAddresses) throws IOException {
		// Prepare the URL.
		String getBalanceURIExtension = "/addrs/" + address + "/balance";

		// Add the token if it is available
		if (apiToken != null)
			getBalanceURIExtension += "?token=" + apiToken;

		/*
		 * According to Blockcypher's API (here:
		 * https://www.blockcypher.com/dev/dash/#address-api), omitWalletAddressses is
		 * only valid if used in accordance with a named wallet. It is meaningless when
		 * used on a single address, and to use a named wallet, the request must contain
		 * an API token. Adding the omitWalletAddress to the URI without an API token is
		 * therefore pointless.
		 */
		if (omitWalletAddresses && apiToken != null)
			getBalanceURIExtension += "&omitWalletAddresses=true";

		String url = BASE_URI + getBalanceURIExtension;
		String response = null;

		response = getHTML(url);

		JSONParser jParser = new JSONParser();
		JSONObject jResponse = null;
		try {
			jResponse = (JSONObject) jParser.parse(response);
		} catch (ParseException e) {
			throw new IOException("Failed to parse JSON object", e);
		}

		// System.out.println(jResponse.toJSONString());

		return Double.parseDouble(jResponse.get("balance").toString()) * SMALLEST_UNIT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAddressInformation(String address, String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFullAddressInformation(String address, String apiToken) {
		// TODO Auto-generated method stub
		return null;
	}

	// Helper methods

	/**
	 * This method is a helper method for the above methods, it just calls the
	 * getHTML method from the com.rocserve.network.http.HTMLRequests class.
	 * 
	 * @param url
	 *            The String representation of the URL that is to be called.
	 * 
	 * @return Returns the response in String format from the connection.
	 * 
	 * @throws IOException
	 *             Thrown when URI is malformed or inaccurate such as a missing
	 *             "http://" at the start of the URI or if the URI is misspelled.
	 */
	private String getHTML(String url) throws IOException {
		String response = null;
		try {
			response = HTMLRequests.HTMLGet(url);
		} catch (InvalidURIException iex) {
			String message = "HTML GET request failed due to incorrect URI used, unable to retrieve requested information."
					+ "\nCheck the URI against the avialable URI's on Blockcypher's servers.\n" + "URI used: "
					+ url.toString() + "\n";
			throw new IOException(message, iex);
		} catch (MalformedURLException mex) {
			String message = "HTML Get request failed due to malformed URL "
					+ "(such as missing HTTP:// at the start), unable to retrieve requested information.\n"
					+ "URL used: " + url.toString();
			throw new IOException(message, mex);
		}

		return response;
	}
}
