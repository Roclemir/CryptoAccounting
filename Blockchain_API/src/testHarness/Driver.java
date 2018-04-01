package testHarness;

import com.rocserve.api.blockcypher.v1.*;
import com.rocserve.api.blockcypher.v1.blockchains.*;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Blockchain dash = new Blockchain(EBlockchains.DASH, EAvailableVersions.V1);

		try {
			System.out.println(dash.getBalance("XoSVKyFk1VaJfhzgkiZKemMCcYYUefHbD5", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
