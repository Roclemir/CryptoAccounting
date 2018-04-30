package com.rocserve.api.blockcypher.v1;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 *          This wallet API is for combining multiple wallet addresses together,
 *          either with Hierarchical Deterministic Wallet addresses or with a
 *          bunch of addresses combined so that they act like a single address.
 *          The best way to think about it is, if a user has five different
 *          Bitcoin addresses that all hold 0.01 btc each, then they could
 *          create a named wallet that contains all five addresses in it, so
 *          when they call the {@link AddressAPI#getBalance(String, String)}
 *          method, they just need to pass in the name of the wallet as the
 *          "address" parameter and they will get the combined balance of all
 *          the addresses.
 */
public interface WalletAPI {
	/**
	 * Creates a NAMED WALLET, which is a container that holds multiple addresses
	 * that can be treated as a single address for calls to other methods (such as
	 * those methods in the AddressAPI interface). This can be beneficial for
	 * getting combined balances or combined information about multiple different
	 * blockchain addresses all at once or in one call. This call requires an
	 * apiToken
	 * 
	 * @param name
	 *            The proposed name for the new wallet. Note: the name must be
	 *            unique to the apiToken. The namespace is shared between standard
	 *            wallets (the wallets creaTed by this function) and Hierarchical
	 *            Deterministic (or HD) wallets (such as those created by the
	 *            createHDWallet() method. IE: in a single apiToken, there can not
	 *            be a standard wallet named "alice" and a HD wallet named "alice".
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param addresses
	 *            An array of addresses to be included in the wallet. More addresses
	 *            can be added later with the
	 *            {@link WalletAPI#addAddressesToWallet(String, String, String[], boolean)}
	 *            method, or removed with the
	 *            {@link WalletAPI#removeAddressesFromWallet(String, String, String[])} method.
	 *  
	 * @return If successful, A JSON formatted string containing information about
	 *         the newly created wallet. If unsuccessful, a string containing
	 *         information to potentially ascertain as to why the call failed.
	 */
	public abstract String createWallet(String name, String apiToken, String[] addresses);

	/**
	 * Creates a named Hierarchical Deterministic (or HD) wallet, with all
	 * sub-addresses pertaining to a given extendedPublicKey (or xPubKey).
	 * 
	 * @param name
	 *            The name for the HD wallet. Note: just like the standard wallet
	 *            {@link WalletAPI#createWallet(String, String, String[])}, the HD
	 *            wallet name must be unique within the HD Wallet namespace AND the
	 *            normal wallet namespace under a given apiToken. For example, an
	 *            apiToken can not have a normal wallet named "alice" and a HD
	 *            wallet named "alice" because the name must be unique and the HD
	 *            wallets and standard wallets share a namespace.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param extendedPublicKey
	 *            The extended public key (or xPubKey) that will be used to
	 *            determine the derived keys for the HD wallet. More information on
	 *            the encoding of xPubKeys can be found here:
	 *            https://github.com/bitcoin/bips/blob/master/bip-0032.mediawiki#serialization-format
	 * @return A JSON formatted string containging all the information in the
	 *         wallet.
	 */
	public abstract String createHDWallet(String name, String apiToken, String extendedPublicKey);

	/**
	 * Creates a named Hierarchical Deterministic (or HD) wallet, with all
	 * sub-addresses pertaining to a given extendedPublicKey (or xPubKey),
	 * optionally including subchainIndexes to initialise with subchains.
	 * 
	 * @param name
	 *            The name for the HD wallet. Note: just like the standard wallet
	 *            {@link WalletAPI#createWallet(String, String, String[])}, the HD
	 *            wallet name must be unique within the HD Wallet namespace AND the
	 *            normal wallet namespace under a given apiToken. For example, an
	 *            apiToken can not have a normal wallet named "alice" and a HD
	 *            wallet named "alice" because the name must be unique and the HD
	 *            wallets and standard wallets share a namespace.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param extendedPublicKey
	 *            The extended public key (or xPubKey) that will be used to
	 *            determine the derived keys for the HD wallet. More information on
	 *            the encoding of xPubKeys can be found here:
	 *            https://github.com/bitcoin/bips/blob/master/bip-0032.mediawiki#serialization-format
	 * @param subchains
	 *            An array of subchain indexes to initialise one or more subchains
	 *            of addresses within the HD wallet.
	 * @return A JSON formatted string containging all the information in the
	 *         wallet.
	 */
	public abstract String createHDWallet(String name, String apiToken, String extendedPublicKey, String[] subchains);

	/**
	 * Returns a list of active wallets under a given apiToken.
	 * 
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return The JSON formatted string containing the active wallets under a given
	 *         apiToken.
	 */
	public abstract String getActiveWallets(String apiToken);

	/**
	 * Gets general information pertaining to a specified named wallet.
	 * 
	 * @param name
	 *            The name of the wallet to get the information about.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param isHDWallet
	 *            True if the named walled is a HD wallet, false for a standard
	 *            wallet.
	 * @return A JSON formatted string containing the information about the wallet.
	 */
	public abstract String getWalletInformation(String name, String apiToken, boolean isHDWallet);

	/**
	 * Adds an address or addresses to a named wallet.
	 * 
	 * @param name
	 *            The name of the wallet of which to add an address.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param addresses
	 *            An array of addresses to add to a wallet. In the case of a single
	 *            address, then create an array of length == 1 and add add the
	 *            address to the array and pass it in.
	 * @param omitWalletAddresses
	 *            If true, the response will omit information pertaining to each
	 *            address within the wallet. This is can significantly reduce
	 *            response time when there are a large number of addresses within
	 *            the wallet.
	 * @return A JSON formatted string containing information about the newly
	 *         modified wallet.
	 */
	public abstract String addAddressesToWallet(String name, String apiToken, String[] addresses,
			boolean omitWalletAddresses);

	/**
	 * Returns a JSON formatted string that contains the addresses in the named
	 * wallet.
	 * 
	 * @param name
	 *            The name of the wallet for which to get the strings.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return A JSON formatted string containing the addresses. In the case of the
	 *         standard wallet, this will return "addresses" as the key, and an
	 *         array of addresses as the value. An example for the response for a
	 *         standard wallet is:
	 * 
	 *         <pre>
	 * {@code
	 *         {"addresses": [
	 *         		"X3cj1QtfW61kQHoqXm3khVRYPJrgQiRM6j",
	 *         		"XJcX75oraJEmzXXHpDjRctw3BX6qDmFM8e" 
	 *         		]
	 *         }
	 *         }</pre>
	 */
	public abstract String getWalletAddresses(String name, String apiToken);

	/**
	 * Returns a Hierarchical Deterministic chain of addresses for the named wallet.
	 * 
	 * @param name
	 *            The name of the wallet for which the addresses are requested.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return In the case of Hierarchical Deterministic wallets, this will return
	 *         "chains" as the first key, then an array of chain_addresses as the
	 *         value, with the value also being the key to a second level array that
	 *         contains all the subchain addresses with "address" as the key and the
	 *         address as the value (this level also has a sibling key-value pair
	 *         which is "path" for the key, and the actual path for the value). See
	 *         {@link WalletAPI#getHDWalletAddresses(String, boolean, String, boolean)}
	 *         for an example of the response.
	 */
	public abstract String getHDWalletAddresses(String name, String apiToken);

	/**
	 * Returns a Hierarchical Deterministic chain of addresses for the named wallet.
	 * 
	 * @param name
	 *            The name of the wallet for which the addresses are requested.
	 * @param usedAddressesOnly
	 *            If TRUE, returns only used addresses. Returns only unused
	 *            addresses if FALSE.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return In the case of Hierarchical Deterministic wallets, this will return
	 *         "chains" as the first key, then an array of chain_addresses as the
	 *         value, with the value also being the key to a second level array that
	 *         contains all the subchain addresses with "address" as the key and the
	 *         address as the value (this level also has a sibling key-value pair
	 *         which is "path" for the key, and the actual path for the value). See
	 *         {@link WalletAPI#getHDWalletAddresses(String, boolean, String, boolean)}
	 *         for an example of the response.
	 */
	public abstract String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken);

	/**
	 * Returns a Hierarchical Deterministic chain of addresses for the named wallet.
	 * 
	 * @param name
	 *            The name of the wallet for which the addresses are requested.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * 
	 * @param zeroBalanceAddresses
	 *            If TRUE, the response will only contain addresses with a zero
	 *            balance. If false, the response will only contain addresses with a
	 *            non-zero balance.
	 * @return In the case of Hierarchical Deterministic wallets, this will return
	 *         "chains" as the first key, then an array of chain_addresses as the
	 *         value, with the value also being the key to a second level array that
	 *         contains all the subchain addresses with "address" as the key and the
	 *         address as the value (this level also has a sibling key-value pair
	 *         which is "path" for the key, and the actual path for the value). see
	 *         {@link WalletAPI#getHDWalletAddresses(String, boolean, String, boolean)}
	 *         for an example.
	 */
	public abstract String getHDWalletAddresses(String name, String apiToken, boolean zeroBalanceAddresses);

	/**
	 * Returns a Hierarchical Deterministic chain of addresses for the named wallet.
	 * 
	 * @param name
	 *            The name of the wallet for which the addresses are requested.
	 * @param usedAddressesOnly
	 *            If TRUE, returns only used addresses. Returns only unused
	 *            addresses if FALSE.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * 
	 * @param zeroBalanceAddresses
	 *            If TRUE, the response will only contain addresses with a zero
	 *            balance. If false, the response will only contain addresses with a
	 *            non-zero balance.
	 * @return In the case of Hierarchical Deterministic wallets, this will return
	 *         "chains" as the first key, then an array of chain_addresses as the
	 *         value, with the value also being the key to a second level array that
	 *         contains all the subchain addresses with "address" as the key and the
	 *         address as the value (this level also has a sibling key-value pair
	 *         which is "path" for the key, and the actual path for the value).
	 * 
	 *         <pre>
	 * {@code
	 * 		{"chains": [ 
	 *         		{"chain_addresses": [ 
	 *         			{ "address": "XFHz8bpEE5qUZ9XhfjzAbCCwo5bT1HMNAc", 
	 *         			  "path": "m/0" 
	 *         			}, 
	 *         			{ "address": "XJ8QDN1u7iDMbJktbqXPSrAqruNjkmRFmT", 
	 *         			  "path": "m/1" 
	 *         			}, 
	 *         			{ "address": "XMWNKnYfE2LVdvAzFUioF3F3JXFpRfDCQb", 
	 *         			  "path": "m/2" 
	 *         			}
	 *         		] } 
	 *         ]}
	 *         }
	 *         </pre>
	 */
	public abstract String getHDWalletAddresses(String name, boolean usedAddressesOnly, String apiToken,
			boolean zeroBalanceAddresses);

	/**
	 * Removes an address from a named wallet. Note: You cannot remove addresses
	 * from HD wallets.
	 * 
	 * @param name
	 *            The name of the wallet from which to remove the address.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param addresses
	 *            The addresses (in a String array) to be removed. For a single
	 *            address, add the address to an array of length == 1.
	 * @return True if successful.
	 */
	public abstract boolean removeAddressesFromWallet(String name, String apiToken, String[] addresses);

	// public abstract String generateAddressInWallet(String name, String apiToken);
	// Earmarked for future development
	// public abstract String deriveAddressInHDWallet(String name, String apiToken);
	// Earmarked for future development
	/**
	 * Deletes a named wallet.
	 * 
	 * @param name
	 *            The name of the wallet to delete.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return True if successful.
	 */
	public abstract boolean deleteWallet(String name, String apiToken);
}
