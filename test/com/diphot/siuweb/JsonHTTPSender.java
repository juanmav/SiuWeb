package com.diphot.siuweb;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHTTPSender {
	public static void send(InterfaceDTO objeto, JsonAdapter.ACTION action) throws ClientProtocolException, IOException{
		String url = "http://127.0.0.1:8888/mobileendpointService";
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
		JsonAdapter adapter = new JsonAdapter(action);
		builder.registerTypeAdapter(InterfaceDTO.class,adapter);
		gson = builder.create();
		String TransportableJson = gson.toJson(objeto, InterfaceDTO.class);
		System.out.println("Pedido: ");
		System.out.println(TransportableJson);

		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(URI.create(url));
		StringEntity se = new StringEntity(TransportableJson);
		httpost.setEntity(se);
		/*httpost.setHeader("Accept", "application/json");
		httpost.setHeader("Contenttype", "application/json");*/

		//ResponseHandler responseHandler = new BasicResponseHandler();
		HttpResponse response = httpclient.execute(httpost);

		System.out.println("Respuesta: ");
		String stringResponse = EntityUtils.toString(response.getEntity());
		System.out.println(stringResponse);
	}
}
