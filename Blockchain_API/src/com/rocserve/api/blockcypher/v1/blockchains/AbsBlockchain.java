/**
 * 
 */
package com.rocserve.api.blockcypher.v1.blockchains;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;

import com.rocserve.api.blockcypher.exceptions.InvalidURIException;
import com.rocserve.api.blockcypher.v1.AddressAPI;
import com.rocserve.api.blockcypher.v1.AssetAPI;
import com.rocserve.api.blockcypher.v1.BlockchainAPI;
import com.rocserve.api.blockcypher.v1.EAvailableVersions;
import com.rocserve.api.blockcypher.v1.MetadataAPI;
import com.rocserve.api.blockcypher.v1.TransactionAPI;
import com.rocserve.api.blockcypher.v1.WalletAPI;
import com.rocserve.api.blockcypher.v1.EBlockchains;

/**
 * @author Ryan Couper
 *
 */
public abstract class AbsBlockchain
		implements AddressAPI, WalletAPI, AssetAPI, BlockchainAPI, MetadataAPI, TransactionAPI {

	public final EBlockchains CHAIN_TYPE;
	public final EAvailableVersions API_VERSION;
	public static final String BLOCKCYPHER_V1_URI = "https://api.blockcypher.com/v1";
	protected final String BASE_URI;

	/**
	 * Sets up the initial blockchain by taking a chain type from
	 * com.rocserve.api.blockcypher.v1.EBlockchains and setting the base URI
	 * depending on the given EBlockchain.
	 * 
	 * @param chainType
	 *            The type of blockchain to be used with that access point. Possible
	 *            options are listed in
	 *            com.rocserve.api.blockcypher.v1.EBlockchains.
	 * @param version
	 *            The version of the API to be called. The version selection depends
	 *            on what is available at Blockcypher's API (www.blockcypher.com)
	 *            and what has been developed here.
	 * @throws IllegalArgumentException
	 *             This is thrown the event that an incorrect blockchain type was
	 *             passed in, or an incorrect version was passed in.
	 */
	public AbsBlockchain(EBlockchains chainType, EAvailableVersions version) throws IllegalArgumentException {
		CHAIN_TYPE = chainType;
		API_VERSION = version;

		String baseURIPrefix;

		// The API_VERSION is in reference to the available Blockcypher API versions.
		// More information can be found on their website www.blockcypher.com.
		switch (API_VERSION) {
		case V1:
			baseURIPrefix = BLOCKCYPHER_V1_URI;
			break;
		// At the time of writing this comment, Blockcypher had only created one version
		// of their API. This switch is setup for version that are created in the
		// future, much the same way Blockcypher has prepared their URIs to account for
		// future versions.
		default:
			throw new IllegalArgumentException(
					"Unable to setup URI, invalid parameters passed to the Abstract Blockchain constructor"
							+ "\nOffending parameter: API_VERSION = " + API_VERSION.toString());
		}

		// These URIs are found here: www.blockcypher.com/dev/dash/#restful-resources
		switch (CHAIN_TYPE) {
		case DASH:
			BASE_URI = baseURIPrefix + "/dash/main";
			break;
		case BITCOIN:
			BASE_URI = baseURIPrefix + "/btc/main";
			break;
		case BITCOIN_TEST:
			BASE_URI = baseURIPrefix + "/btc/test3";
			break;
		case DOGECOIN:
			BASE_URI = baseURIPrefix + "/doge/main";
			break;
		case LITECOIN:
			BASE_URI = baseURIPrefix + "/ltc/main";
			break;
		case BLOCKCYPHER_TEST:
			BASE_URI = baseURIPrefix + "/bcy/test";
			break;
		default:
			throw new IllegalArgumentException(
					"Unable to setup URI, invalid parameters passed to the Abstract Blockchain class."
							+ "\nOffending parameter: CHAIN_TYPE = " + CHAIN_TYPE.toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getTXInfo(String hashOfTransaction);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getUnconfirmedTXInfo();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAddressMeta(String address, String apiToken) {
		return getAddressMeta(address, apiToken, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getAddressMeta(String address, String apiToken, boolean getPrivateData);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTXMeta(String hash, String apiToken) {
		return getTXMeta(hash, apiToken, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getTXMeta(String hash, String apiToken, boolean getPrivateData);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getBlockMeta(String blockHash, String apiToken) {
		return getBlockMeta(blockHash, apiToken, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getBlockMeta(String blockHash, String apiToken, boolean getPrivateData);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setAddressMeta(String address, String apiToken, String jsonFormattedData) {
		return setAddressMeta(address, apiToken, jsonFormattedData, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean setAddressMeta(String address, String apiToken, String jsonFormattedData,
			boolean isPrivate);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setTXMeta(String txHash, String apiToken, String jsonFormattedData) {
		return setTXMeta(txHash, apiToken, jsonFormattedData, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean setTXMeta(String txhash, String apiToken, String jsonFormattedData, boolean isPrivate);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean setBlockMeta(String blockHash, String apiToken, String jsonFormattedData) {
		return setBlockMeta(blockHash, apiToken, jsonFormattedData, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean setBlockMeta(String blockHash, String apiToken, String jsonFormattedData,
			boolean isPrivate);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteAddressMeta(String address, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteTXMeta(String txHash, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteBlockMeta(String blockHash, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getGeneralInformation();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getBlockInfoAtHash(String hashOfBlock);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getInfoOfBlockAtHeight(BigInteger heightOfBlock);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String createWallet(String name, String apiToken, String[] addresses);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String createHDWallet(String name, String apiToken, String extendedPublicKey);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String createHDWallet(String name, String apiToken, String extendedPublicKey, String[] subchains);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getActiveWallets(String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getWalletInformation(String name, String apiToken, boolean isHDWallet);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String addAddressesToWallet(String name, String apiToken, String[] addresses,
			boolean omitWalletAddresses);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getWalletAddresses(String name, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getHDWalletAddresses(String name, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getHDWalletAddresses(String name, String apiToken, boolean zeroBalanceAddresses);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken,
			boolean zeroBalanceAddresses);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean removeAddressesFromWallet(String name, String apiToken, String[] addresses);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteWallet(String name, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getBalance(String address, String apiToken)
			throws MalformedURLException, IOException, InvalidURIException {
		return getBalance(address, apiToken, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract double getBalance(String address, String apiToken, boolean omitWalletAddresses)
			throws MalformedURLException, IOException, InvalidURIException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getAddressInformation(String address, String apiToken);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getFullAddressInformation(String address, String apiToken);

}
