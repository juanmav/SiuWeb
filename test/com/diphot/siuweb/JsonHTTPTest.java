package com.diphot.siuweb;

import org.apache.http.HttpResponse;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter;
import com.diphot.siuweb.shared.dtos.AreaDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.diphot.siuweb.shared.dtos.TipoRelevamientoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;

public class JsonHTTPTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://127.0.0.1:8888/mobileendpointService";
		AreaDTO areaDTO = new AreaDTO(1L, "Area1");
		TipoRelevamientoDTO tipoDTO = new TipoRelevamientoDTO(1L, "tipo1", areaDTO);
		TemaDTO temaDTO = new TemaDTO(1L, "tema1", tipoDTO);
		InterfaceDTO objeto = new InspeccionDTO(1L, "Quintino Bocatuva", 457, temaDTO, 
				22.22, 30.00, new Date().toString());//*/

		Gson gson;
		GsonBuilder builder = new GsonBuilder();
		JsonAdapter adapter = new JsonAdapter(JsonAdapter.ACTION.PUT);
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

		System.out.println("Obteniendo Lista Objetos: ");
		Type type = new TypeToken<ArrayList<InspeccionDTO>>(){}.getType();
		ArrayList<InspeccionDTO> registros = gson.fromJson(stringResponse,type);

		for (InspeccionDTO r : registros){
			System.out.println(r.toString());
		};//*/
	}
}
