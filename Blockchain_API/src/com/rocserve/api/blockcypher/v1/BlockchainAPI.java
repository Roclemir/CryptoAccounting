package com.rocserve.api.blockcypher.v1;

import java.io.IOException;
import java.math.BigInteger;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 *          This interface provides a standardised way of accessing general
 *          information about the blockchain.
 */
public interface BlockchainAPI {
	/**
	 * Provides general information about the chosen blockchain
	 * 
	 * @return A JSON formatted string containing general information about the
	 *         requested blockchain.
	 * @throws IOException
	 *             Thrown when the URI is malformed or inaccurate in some way. See
	 *             error message thrown for more details.
	 */
	public abstract String getChainInfo() throws IOException;

	/**
	 * Provides general information about a given block on a given blockchain.
	 * 
	 * @param hashOfBlock
	 *            The hash of the block for which information is requested.
	 * @return The JSON formatted string containing the requested information.
	 */
	public abstract String getBlockInfoAtHash(String hashOfBlock);

	/**
	 * Provides general information about a block at a specific height in a specific
	 * blockchain.
	 * 
	 * @param heightOfBlock
	 *            The height of the block of interest.
	 * @return JSON formatted string containing the requested information.
	 */
	public abstract String getInfoOfBlockAtHeight(BigInteger heightOfBlock);
}
