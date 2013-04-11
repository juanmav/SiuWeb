package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;
import com.diphot.siuweb.server.pesistense.DAOFactory;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;

public class PutStrategy implements PostStrategyInterfaceHandler {
	private InterfaceDTO o;
	private PrintWriter printWriter;

	public PutStrategy(InterfaceDTO o, PrintWriter printWriter) {
		this.o = o;
		this.printWriter = printWriter;
	}

	@Override
	public void execute() {
		DAOInterface<?, InterfaceDTO> dao = DAOFactory.getDAOImpl(o);
		try {
			dao.creatFromDTO(o);
			printWriter.print(new PostResult(PostResult.Result.OK).getToGson());
		} catch (Exception e) {
			printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
			e.printStackTrace();
		}
	}
}
