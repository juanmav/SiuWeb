package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;

public class DefaultStrategy implements PostStrategyInterfaceHandler {
	private PrintWriter printWriter;

	public DefaultStrategy(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	@Override
	public void execute() {
		printWriter.print(new PostResult(PostResult.Result.NOSTRATEGY).getToGson());
	}
}
