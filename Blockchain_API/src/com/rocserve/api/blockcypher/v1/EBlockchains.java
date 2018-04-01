package com.rocserve.api.blockcypher.v1;

/**
 * 
 * @author Ryan Couper
 * @version 0.1
 * 
 * This Enumeration lists all the blockchains that are currently developed or
 * are under development for this library. 
 * NOTE: Some are still under development.
 *
 */
public enum EBlockchains {
	/* The BITCOIN_TEST and BLOCKCYPHER_TEST EBlockchains are available for testing. All the workings on the blockchains is done by Blockcypher 
	 * servers (including all the PoW and whatever other algorithms that are usually performed on these chains). For more information, read 
	 * Blockcypher's information at www.blockcypher.com.
	 */
	
	DASH, BITCOIN, BITCOIN_TEST, DOGECOIN, LITECOIN, BLOCKCYPHER_TEST
}
