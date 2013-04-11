package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;

public class PutStrategy implements PostStrategyInterfaceHandler {
  private Jsonizable o;
  private PrintWriter printWriter;

  public PutStrategy(Jsonizable o, PrintWriter printWriter) {
    this.o = o;
    this.printWriter = printWriter;
  }

  @Override
  public void execute() {
    //CRUDController data = new CRUDController();
    try {
      //data.Create(o);
      printWriter.print(new PostResult(PostResult.Result.OK).getToGson());
    } catch (Exception e) {
      printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
    }
  }
}
