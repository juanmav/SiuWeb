package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;

public class UpdateStrategy implements PostStrategyInterfaceHandler {

  private Jsonizable o;
  private PrintWriter printWriter;

  public UpdateStrategy(Jsonizable o, PrintWriter printWriter) {
    this.o = o;
    this.printWriter = printWriter;
  }

  @Override
  public void execute() {
    //CRUDController data = new CRUDController();
    try {
      //data.Update(this.o);
      printWriter.print(new PostResult(PostResult.Result.OK).getToGson());
    } catch (Exception e) {
      printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
    }
  }  
  
}