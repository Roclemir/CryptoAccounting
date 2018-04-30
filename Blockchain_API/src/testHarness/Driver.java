package testHarness;

import com.rocserve.api.blockcypher.v1.*;
import com.rocserve.api.blockcypher.v1.blockchains.*;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Blockchain dash = new Blockchain(EBlockchains.DASH, EAvailableVersions.V1);

//		try {
////			System.out.println(dash.getBalance("XoSVKyFk1VaJfhzgkiZKemMCcYYUefHbD5", null)); // Empty wallet
//			System.out.println(dash.getBalance("XwPZGiPy2T99DLEoPLF2AFupyc5R3rtnBp", null)); // Wallet with a balance.
//			System.out.println();
//			System.out.println(dash.getTXInfo("1fc7284983aa201969d59a675448fa643271714cdc1016a23e3053ea42781963"));
//			System.out.println(dash.getUnconfirmedTXInfo());
//			System.out.println();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Blockchain BCTestNet = new Blockchain(EBlockchains.BLOCKCYPHER_TEST, EAvailableVersions.V1);
		Blockchain bitcoin = new Blockchain(EBlockchains.BITCOIN, EAvailableVersions.V1);
		
		try {
			System.out.println(bitcoin.getChainInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
