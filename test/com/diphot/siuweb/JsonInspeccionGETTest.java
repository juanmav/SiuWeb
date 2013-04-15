package com.diphot.siuweb;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter.ACTION;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class JsonInspeccionGETTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		InterfaceDTO objeto = new InspeccionDTO();
		JsonHTTPSender.send(objeto, ACTION.LIST);
	}
}
