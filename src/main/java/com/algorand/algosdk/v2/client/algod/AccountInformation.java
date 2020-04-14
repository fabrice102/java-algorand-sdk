package com.algorand.algosdk.v2.client.algod;

import com.algorand.algosdk.v2.client.common.Client;
import com.algorand.algosdk.v2.client.common.Query;
import com.algorand.algosdk.v2.client.common.QueryData;
import com.algorand.algosdk.v2.client.common.Response;
import com.algorand.algosdk.v2.client.model.Account;


/**
 * Given a specific account public key, this call returns the accounts status, 
 * balance and spendable amounts /v2/accounts/{address} 
 */
public class AccountInformation extends Query {
	private String address;

	private boolean addressIsSet;

	public AccountInformation(Client client, String address) {
		super(client, "get");
		this.address = address;
	}

	@Override
	public Response<Account> execute() throws Exception {
		Response<Account> resp = baseExecute();
		resp.setValueType(Account.class);
		return resp;
	}
	public QueryData getRequestString() {
		QueryData qd = new QueryData();
		qd.addPathSegment(String.valueOf("v2"));
		qd.addPathSegment(String.valueOf("accounts"));
		qd.addPathSegment(String.valueOf(address));

		return qd;
	}
}