package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;

import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.google.gson.Gson;

public class GetStrategy implements PostStrategyInterfaceHandler {

	private InterfaceDTO o;
	private PrintWriter printWriter;
	private Gson gson;

	public GetStrategy(InterfaceDTO o, PrintWriter printWriter,Gson gson) {
		this.o = o;
		this.printWriter = printWriter;
		this.gson = gson;
	}

	@Override
	public void execute() {
		//TODO
		//CRUDController data = new CRUDController();
		try {
			//Transportable tomado =  data.ReadByID(o.getId(), o);
			//this.printWriter.print(this.gson.toJson(new Inspeccion("asd2341","Rivadavia","400", new Tema())));
		} catch (Exception e) {
			printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
		}

	}  

}