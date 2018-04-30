package com.rocserve.api.blockcypher.v1;

import java.io.IOException;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 *          The TransactionAPI sets a standard set of functions for messing
 *          around with transactions within a blockchain.
 */
public interface TransactionAPI {
	/**
	 * getTXInfo, short for "Get Transaction Information", returns a JSON formated
	 * string of information related to a transaction that is specified by the
	 * passed-in hash.
	 * 
	 * @param hashOfTransaction
	 *            The hash of the transaction of which the information is to be
	 *            obtained.
	 * @return A JSON formated string holding information about the specified
	 *         transaction.
	 * @throws IOException
	 *             Thrown when there is an issue with the URI, such as a malformed
	 *             URI or if the URI is not found. An error message is produced and
	 *             propagated the thrown exception.
	 */
	public abstract String getTXInfo(String hashOfTransaction) throws IOException;

	/**
	 * This method returns information regarding unconfirmed transactions on the
	 * blockchain that are not yet part of any block.
	 * 
	 * @return The JSON formated information about the unconfirmed transactions.
	 * @throws IOException
	 *             Thrown when there is an issue with the URI, such as a malformed
	 *             URI or if the URI is not found. An error message is produced and
	 *             propagated the thrown exception.
	 */
	public abstract String getUnconfirmedTXInfo() throws IOException;

	// public abstract String createTX(String jsonTXrequest, boolean
	// includeToSignTx); Earmarked for future development (See
	// https://www.blockcypher.com/dev/dash/#creating-transactions)
	// public abstract String pushRawEncodedTX(String TXHex); Earmarked for future
	// development (See
	// https://www.blockcypher.com/dev/dash/#push-raw-transaction-endpoint)
	// public abstract String decodeRawTX(String TXHex); Earmarked for future
	// development (See
	// https://www.blockcypher.com/dev/dash/#decode-raw-transaction-endpoint)
	// public abstract String encodeDataForBlockchainEmbedding(String NullData);
	// Earmarked for future development (See
	// https://www.blockcypher.com/dev/dash/#data-endpoint)
	// public abstract String getTXPropagationInfo(String token); Earmarked for
	// future development (See
	// https://www.blockcypher.com/dev/dash/#transaction-propagation-endpoint)

}
