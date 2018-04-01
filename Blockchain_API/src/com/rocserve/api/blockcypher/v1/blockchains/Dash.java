/**
 * 
 */
package com.rocserve.api.blockcypher.v1.blockchains;

/***********************************************
 *  THIS FILE HAS BEEN ABANDONED IN FAVOUR     *
 *     OF MAKING A MORE GENERIC VERSION        *
 *          (see Blockchain.java)              *
 ***********************************************/

import java.math.BigInteger;

import com.rocserve.api.blockcypher.v1.EBlockchains;
import com.rocserve.api.blockcypher.v1.EAvailableVersions;

/**
 * @author Ryan Couper
 *
 */
public class Dash extends AbsBlockchain {
	
	public static final String DASH_URI_EXTENSION = "/dash/main";

	/**
	 * @param chainType
	 */
	public Dash() throws IllegalArgumentException {
		super(EBlockchains.DASH, EAvailableVersions.V1);
		// TODO Auto-generated constructor stub
	}

////////////////// FUNCTIONS REGARDING METADATA ///////////////////

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

////////////////// END METADATA FUCNTIONS ///////////////////
////////////////// GENERAL INFORMATION METHODS //////////////
	
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
	
////////////////// END GENERAL INFO METHODS ///////////////////
///////////////// METHODS FOR NAMED WALLETS ///////////////////

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
	
///////////////// END WALLET MANIPULATION METHODS ///////////////
//////////////// ADDRESS MANIPULATION METHODS ///////////////////

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getBalance(String address, String apiToken, boolean omitWalletAddresses) {
		double balance = 0.0;
		
		
		
		return balance;
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
	
//////////////// END ADDRESS MANIPULATION METHODS ////////////////
}
