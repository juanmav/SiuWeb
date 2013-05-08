package com.diphot.siuweb;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter;
import com.diphot.siuweb.shared.InterfaceDTO;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonLocalTest {
	public static void main(String[] args) {
		/*AreaDTO areaDTO = new AreaDTO(1L, "Area1");
		TipoRelevamientoDTO tipoDTO = new TipoRelevamientoDTO(1L, "tipo1", areaDTO);
		TemaDTO temaDTO = new TemaDTO(1L, "tema1", tipoDTO);
		Jsonizable command1 = new InspeccionDTO(1L, "Quintino Bocatuva", "457", temaDTO, 22.22, 30.00, new Date());*/
		
		InterfaceDTO command1 = new InspeccionDTO();
		
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
		JsonAdapter adapter = new JsonAdapter(JsonAdapter.ACTION.LIST);
		builder.registerTypeAdapter(InterfaceDTO.class,adapter);
		gson = builder.create();
		/* Del objeto a Json*/
		String JsonizableJson = gson.toJson(command1, InterfaceDTO.class);
		System.out.println(JsonizableJson);
		//System.out.println(adapter.getAction().toString());
		/* De Json al objeto*/
		JsonizableJson = "{\"ACTION\":\"PUT\",\"CLASSNAME\":\"com.diphot.siuweb.shared.dtos.InspeccionDTO\",\"INSTANCE\":{\"id\":1,\"calle\":\"Quintino Bocatuva\",\"altura\":\"457\",\"tema\":{\"nombre\":\"tema1\",\"id\":1,\"tiporelevamientodto\":{\"id\":1,\"nombre\":\"tipo1\",\"areadto\":{\"id\":1,\"nombre\":\"Area1\"}}},\"longitude\":22.22,\"latitude\":30.0,\"fecha\":\"Apr 11, 2013 3:32:14 PM\"}}";
		System.out.println(JsonizableJson);
		InterfaceDTO o = gson.fromJson(JsonizableJson, InterfaceDTO.class);
		System.out.println(adapter.getAction().toString());
		System.out.println(o);//*/
	}
}
