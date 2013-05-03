package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class UpdateStrategy implements PostStrategyInterfaceHandler {

	private InterfaceDTO o;
	private PrintWriter printWriter;

	public UpdateStrategy(InterfaceDTO o, PrintWriter printWriter) {
		this.o = o;
		this.printWriter = printWriter;
	}

	@Override
	public void execute() {
		// TODO implementar
		//CRUDController data = new CRUDController();
		try {
			//data.Update(this.o);
			printWriter.print(new PostResult(PostResult.Result.OK).getToGson());
		} catch (Exception e) {
			printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
		}
	}  

}