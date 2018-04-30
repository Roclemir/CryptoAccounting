package com.rocserve.api.blockcypher.v1;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 *          This interface provides a standardised method for performing
 *          standard functions to do with metadata on the Blockcypher servers in
 *          relation to the blockchains.
 */
public interface MetadataAPI {

	/**
	 * Gets the available public metadata (according to the blockcypher servers) of
	 * the specified address or named wallet. This is actually a wrapper class for
	 * {@link MetadataAPI#getAddressMeta(String, String, boolean)} but provides
	 * FALSE as the last argument.
	 * 
	 * @param address
	 *            A single address or a named wallet for which to retrieve the
	 *            metedata information. For more information on named wallets, @see
	 *            com.rocserve.api.blockcypher.v1.WalletAPI .
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return The JSON formatted string containing the requested data.
	 */
	public abstract String getAddressMeta(String address, String apiToken);

	/**
	 * Gets the available public (and optionally private) metadata (according to the
	 * blockcypher servers) of the specified address or named wallet.
	 * 
	 * @param address
	 *            A single address or a named wallet for which to retrieve the
	 *            metedata information. For more information on named wallets, @see
	 *            com.rocserve.api.blockcypher.v1.WalletAPI .
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param getPrivateData
	 *            If true, returns both the publicly and privately available
	 *            metadata. This metadata is the metadata kept on the Blockcypher's
	 *            servers. The privately available metadata is only available if to
	 *            the owner of that metadata as identified by the passed apiToken.
	 * @return The JSON formatted string containing the requested data.
	 */
	public abstract String getAddressMeta(String address, String apiToken, boolean getPrivateData);

	/**
	 * This method retrieves the available public metadata on Blockcypher's servers
	 * (https://www.blockcypher.com) in relation to a specified transaction. Wrapper
	 * method for {@link MetadataAPI#getTXMeta(String, String, boolean)} providing
	 * FALSE as the last argument.
	 * 
	 * @param hash
	 *            The hash of the transaction which information is to be requested.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return A JSON formatted string containing the requested metadata.
	 */
	public abstract String getTXMeta(String hash, String apiToken);

	/**
	 * This method retrieves the available metadata on Blockcypher's servers
	 * (https://www.blockcypher.com) in relation to a specified transaction,
	 * optionally including private metadata.
	 * 
	 * @param hash
	 *            The hash of the transaction which information is to be requested.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param getPrivateData
	 *            If true, also returns the privately available metadata information
	 *            (note: only possible if a apiToken is provided).
	 * @return A JSON formatted string containing the requested metadata.
	 */
	public abstract String getTXMeta(String hash, String apiToken, boolean getPrivateData);

	/**
	 * Returns the available metadata (on Blockcypher's servers, see
	 * www.blockcypher.com) in regards to a block specified by it's hash. Wrapper
	 * for {@link MetadataAPI#getBlockMeta(String, String, boolean)} and provides
	 * FALSE as the last argument.
	 * 
	 * @param blockHash
	 *            The hash of the block to request metadata on.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return Returns a JSON formatted string with the requested metadata.
	 */
	public abstract String getBlockMeta(String blockHash, String apiToken);

	/**
	 * Returns the available metadata (on Blockcypher's servers, see
	 * www.blockcypher.com) in regards to a block specified by it's hash.
	 * 
	 * @param blockHash
	 *            The hash of the block to request metadata on.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param getPrivateData
	 *            If true, returns both the publicly and privately available
	 *            metadata. This metadata is the metadata kept on the Blockcypher's
	 *            servers. The privately available metadata is only available if to
	 *            the owner of that metadata as identified by the passed apiToken.
	 * @return Returns a JSON formatted string with the requested metadata.
	 */
	public abstract String getBlockMeta(String blockHash, String apiToken, boolean getPrivateData);

	/**
	 * Sets metadata pertaining to a particular address or named wallet. The data
	 * will be marked private so that it can only be retrieved by requests
	 * containing the same apiToken. Wrapper method for
	 * {@link MetadataAPI#setAddressMeta(String, String, String, boolean)} providing
	 * TRUE as the isPrivate parameter.
	 * 
	 * @param address
	 *            The address or name of the Named wallet for which the data is to
	 *            be stored as metadata.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The data to be stored as the metadata against the specified
	 *            address or named wallet.
	 * @return True if successful.
	 */
	public abstract boolean setAddressMeta(String address, String apiToken, String jsonFormattedData);

	/**
	 * Sets metadata pertaining to a particular address or named wallet. The data
	 * can be marked private so that it can only be retrieved by requests containing
	 * the same apiToken. IMPORTANT: Once set, public metadata is immutable, think
	 * twice before setting public metadata
	 * 
	 * @param address
	 *            The address or name of the Named wallet for which the data is to
	 *            be stored as metadata.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The data to be stored as the metadata against the specified
	 *            address or named wallet.
	 * @param isPrivate
	 *            If true, then the set metadata can only be retrieved in the future
	 *            if the request for the metadata contains the same apiToken as the
	 *            setting request. IMPORTANT: All publicly set metadata is permanent
	 *            and cannot be removed. DO NOT SEND PRIVATE KEYS TO PUBLIC
	 *            METADATA.
	 * @return True if successful.
	 */
	public abstract boolean setAddressMeta(String address, String apiToken, String jsonFormattedData,
			boolean isPrivate);

	/**
	 * Sets metadata (on Blockcypher's servers) pertaining to a specified
	 * transaction. The data will be marked as private so it can only be retrieved
	 * by requests containing the setter's apiToken. Wrapper method for
	 * {@link MetadataAPI#setTXMeta(String, String, String, boolean)} providing TRUE
	 * as the isPrivate parameter.
	 * 
	 * @param txHash
	 *            The hash of the transaction to store the metadata on.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The data (in JSON format) to store as metadata.
	 * @return True if successful.
	 */
	public abstract boolean setTXMeta(String txHash, String apiToken, String jsonFormattedData);

	/**
	 * Sets metadata (on Blockcypher's servers) pertaining to a specified
	 * transaction. The data can be marked as private so it can only be retrieved by
	 * requests containing the setter's apiToken. IMPORTANT: Once set, public
	 * metadata is immutable, think twice before setting public metadata
	 * 
	 * @param txhash
	 *            The hash of the transaction to store the metadata on.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The data (in JSON format) to store as metadata.
	 * @param isPrivate
	 *            If true, then the set metadata can only be retrieved in the future
	 *            if the request for the metadata contains the same apiToken as the
	 *            setting request. IMPORTANT: All publicly set metadata is permanent
	 *            and cannot be removed. DO NOT SEND PRIVATE KEYS TO PUBLIC
	 *            METADATA.
	 * @return True if successful.
	 */
	public abstract boolean setTXMeta(String txhash, String apiToken, String jsonFormattedData, boolean isPrivate);

	/**
	 * Store metadata (on Blockcypher's servers: see www.blockcypher.com) about a
	 * specified block. The data will be marked as private so that only requests
	 * with the same apiToken can retrieve the data. Wrapper method for
	 * {@link MetadataAPI#setBlockMeta(String, String, String, boolean)} providing
	 * TRUE as the isPrivate parameter.
	 * 
	 * @param blockHash
	 *            The has of the block to store the metadata against.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The (JSON formatted) data to be stored in metadata.
	 * @return True if successful.
	 */
	public abstract boolean setBlockMeta(String blockHash, String apiToken, String jsonFormattedData);

	/**
	 * Store metadata (on Blockcypher's servers: see www.blockcypher.com) about a
	 * specified block. The data can be marked as private so that only requests with
	 * the same apiToken can retrieve the data. IMPORTANT: Once set, public metadata
	 * is immutable, think twice before setting public metadata
	 * 
	 * @param blockHash
	 *            The has of the block to store the metadata against.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @param jsonFormattedData
	 *            The (JSON formatted) data to be stored in metadata.
	 * @param isPrivate
	 *            If true, then the set metadata can only be retrieved in the future
	 *            if the request for the metadata contains the same apiToken as the
	 *            setting request. IMPORTANT: All publicly set metadata is permanent
	 *            and cannot be removed. DO NOT SEND PRIVATE KEYS TO PUBLIC
	 *            METADATA.
	 * @return True if successful.
	 */
	public abstract boolean setBlockMeta(String blockHash, String apiToken, String jsonFormattedData,
			boolean isPrivate);

	/**
	 * Deletes all private metadata from a specified address. Only works on private
	 * metadata as public metadata is immutable.
	 * 
	 * @param address
	 *            The address from which to delete the metadata.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return True if successful.
	 */
	public abstract boolean deleteAddressMeta(String address, String apiToken);

	/**
	 * Deletes all private metadata associated with a specified transaction. Only
	 * works on private data as public metadata is immutable.
	 * 
	 * @param txHash
	 *            The hash of the transaction from which to delete the metadata.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return True if successful.
	 */
	public abstract boolean deleteTXMeta(String txHash, String apiToken);

	/**
	 * Deletes all private metadata associated with a specified block. Only works on
	 * private metadata as public metadata is immutable.
	 * 
	 * @param blockHash
	 *            The hash of the block from which to delete the private metadata.
	 * @param apiToken
	 *            This is an API apiToken that has been previously retrieved for
	 *            free by signing up to Blockcypher's registration here:
	 *            https://accounts.blockcypher.com/apiTokens
	 * @return True if successful.
	 */
	public abstract boolean deleteBlockMeta(String blockHash, String apiToken);
}
