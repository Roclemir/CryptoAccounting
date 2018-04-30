package com.rocserve.api.blockcypher.v1;

import com.rocserve.api.blockcypher.exceptions.*;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 *          The AddressAPI interface allows interaction with Blockcypher's
 *          Address API, allowing the user to retrieve various information
 *          pertaining to an address.
 */
public interface AddressAPI {
	/**
	 * Returns the balance of the specified wallet or address. This is a wrapper
	 * method for {@link AddressAPI#getBalance(String, String, boolean)}, setting
	 * the final parameter to false for a verbose output.
	 * 
	 * @param address
	 *            The same as in @see AddressAPI#getBalance(EBlockchains, String,
	 *            String, boolean)
	 * @param apiToken
	 *            The same as in @see AddressAPI#getBalance(EBlockchains, String,
	 *            String, boolean)
	 * @return The same as in @see AddressAPI#getBalance(EBlockchains, String,
	 *         String, boolean)
	 * @throws IOException
	 *             Thrown when there is an issue with the URI, such as a malformed
	 *             URI or if the URI is not found.
	 */
	public abstract double getBalance(String address, String apiToken) throws IOException;

	/**
	 * Returns the balance of the specified wallet on the specified chain with an
	 * option to omit wallet information for expedience in response.
	 * 
	 * @param address
	 *            This can either be a single address or the NAME of the previously
	 *            setup wallet. For more information on named wallets, @see
	 *            com.rocserve.api.WalletAPI .
	 * @param apiToken
	 *            This is an API token that has been previously retrieved for free
	 *            by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/tokens
	 * @param omitWalletAddresses
	 *            If true, information about all the wallet addresses relevant to
	 *            this request will be omitted in the returned JSON formatted
	 *            string. This can save time/bandwidth when using a large number of
	 *            addresses associated with named wallets and HD wallets
	 * @return Returns the balance of the wallet in JSON formatted string.
	 * @throws IOException
	 *             Thrown when there is an issue with the URI, such as a malformed
	 *             URI or if the URI is not found.
	 */
	public abstract double getBalance(String address, String apiToken, boolean omitWalletAddresses) throws IOException;

	/**
	 * Gets general information about an address or named wallet. This function
	 * provides more information than the getBalance functions but less information
	 * than the getFullAddressInformation function.
	 * 
	 * @param address
	 *            This can either be a single address or the NAME of the previously
	 *            setup wallet. For more information on named wallets, @see
	 *            com.rocserve.api.WalletAPI .
	 * @param apiToken
	 *            This is an API token that has been previously retrieved for free
	 *            by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/tokens
	 * @return Returns a JSON formatted string containing information about the
	 *         given address or named wallet.
	 */
	public abstract String getAddressInformation(String address, String apiToken);
	// Note: there are many possible alternatives to this method, the commented out
	// overloaded getAddressInformation below.

	/**
	 * Provides extensive information pertaining to a specific address or named
	 * wallet.
	 * 
	 * @param address
	 *            This can either be a single address or the NAME of the previously
	 *            setup wallet. For more information on named wallets, @see
	 *            com.rocserve.api.WalletAPI .
	 * @param apiToken
	 *            This is an API token that has been previously retrieved for free
	 *            by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/tokens
	 * @return Returns a JSON formatted string containing information about the
	 *         given address or named wallet.
	 */
	public abstract String getFullAddressInformation(String address, String apiToken);
	// Note: there are many possible alternatives to this method, the commented out
	// overloaded getFullddressInformation below.

	// The below methods are earmarked for future development. See
	// the relevant sections of
	// https://www.blockcypher.com/dev/dash/
	// for more information.
	// public abstract String generateAddress();
	// public abstract generateMultisigAddress(String jsonAddressKeychain);
	// public abstract String getAddressInformation(EBlockchains chainName, String
	// address, String apiToken, boolean unspentOnly, boolean includeScript, boolean
	// includeConfidence, int before, int after, int limit, int confirmations, int
	// confidence, boolean omitWalletAddresses);
	// public abstract String getFullAddressInformation(EBlockchains chainName,
	// String address, String apiToken, int before, int after, int limit, int
	// txlimit, int confirmations, int confidence, boolean includeHex, boolean
	// includeConfidence, boolean omitWalletAddresses);
}
