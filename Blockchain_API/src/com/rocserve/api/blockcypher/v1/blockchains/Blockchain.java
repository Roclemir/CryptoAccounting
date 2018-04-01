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
	 * @param version
	 * @throws IllegalArgumentException
	 */
	public Blockchain(EBlockchains chainType, EAvailableVersions version) throws IllegalArgumentException {
		super(chainType, version);
		// TODO Auto-generated constructor stub
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTXInfo(String hashOfTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUnconfirmedTXInfo() {
		// TODO Auto-generated method stub
		return null;
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
	public String getGeneralInformation() {
		// TODO Auto-generated method stub
		return null;
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
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	@Override
	public double getBalance(String address, String apiToken, boolean omitWalletAddresses)
			throws IOException {
		// Prepare the URL.
		String getBalanceURIExtension = "/addrs/" + address + "/balance";

		// Add the token if it is available
		if (apiToken != null)
			getBalanceURIExtension += "?token=" + apiToken;

		if (omitWalletAddresses)
			if (apiToken != null)
				getBalanceURIExtension += "&omitWalletAddresses=true";
			else
				getBalanceURIExtension += "?omitWalletAddresses=true";
		else if (apiToken != null)
			getBalanceURIExtension += "&omitWalletAddresses=false";
		else
			getBalanceURIExtension += "?omitWalletAddresses=false";

		String url = BASE_URI + getBalanceURIExtension;
		String response = null;

		try {
			response = HTMLRequests.HTMLGet(url);
		} catch (InvalidURIException iex) {
			String message = "HTML GET request failed due to incorrect URI used, unable to retrieve balance."
					+ "\nCheck the URI against the avialable URI's on Blockcypher's servers.\n"
					+ "URI used: " + url.toString() + "\n";
			throw new IOException(message, iex);
		} catch (MalformedURLException mex) {
			String message = "HTML Get request failed due to malformed URL (such as missing HTTP:// at the start), unable to retrieve balance.\n"
					+ "URL used: " + url.toString();
			throw new IOException(message, mex);
		} 

		JSONParser jParser = new JSONParser();
		JSONObject jResponse = null;
		try {
			jResponse = (JSONObject) jParser.parse(response);
		} catch (ParseException e) {
			throw new IOException("Failed to parse JSON object", e);
		}

		System.out.println(jResponse.toJSONString());
		
		return Double.parseDouble(jResponse.get("balance").toString()) / 100000000;
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

}
