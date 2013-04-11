package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
 
public class DeleteStrategy implements PostStrategyInterfaceHandler{

  private Jsonizable o;
  private PrintWriter printWriter;

  public DeleteStrategy(Jsonizable o, PrintWriter printWriter) {
    this.o = o;
    this.printWriter = printWriter;

  }

  @Override
  public void execute() {
    //CRUDController data = new CRUDController();
    try {
      //data.DeleteByID(o.getId(), o);
      printWriter.print(new PostResult(PostResult.Result.OK).getToGson());
    } catch (Exception e) {
      printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
    }

  }
  
}