package com.diphot.siuweb;

import java.util.Date;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter;
import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.diphot.siuweb.shared.dtos.InspeccionDTO;
import com.diphot.siuweb.shared.dtos.TemaDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonLocalTest {
	public static void main(String[] args) {
		Jsonizable command1 = new InspeccionDTO(1L, "Quintino Bocatuva", "457", new TemaDTO(), 
												22.22, 30.00, new Date());
		//Transportable command2 = new SysUser(22L,"xx","zxcv");
		Gson gson;
		GsonBuilder builder = new GsonBuilder();
		JsonAdapter adapter = new JsonAdapter(JsonAdapter.ACTION.PUT);
		builder.registerTypeAdapter(Jsonizable.class,adapter);
		gson = builder.create();
		/* Del objeto a Json*/
		String JsonizableJson = gson.toJson(command1, Jsonizable.class);
		System.out.println(JsonizableJson);
		//System.out.println(adapter.getAction().toString());
		/* De Json al objeto*/
		/*JsonizableJson = "{\"ACTION\":\"PUT\",\"CLASSNAME\":\"RegistroCalle\",\"INSTANCE\":{\"id\":\"asd2341\",\"calle\":\"Rivadavia\",\"altura\":\"400\"}}";
		System.out.println(JsonizableJson);
		Jsonizable o = gson.fromJson(JsonizableJson, Jsonizable.class);
		System.out.println(adapter.getAction().toString());
		System.out.println(o);*/
	}
}
