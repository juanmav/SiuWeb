package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
 
public class DeleteStrategy implements PostStrategyInterfaceHandler{

  private InterfaceDTO o;
  private PrintWriter printWriter;

  public DeleteStrategy(InterfaceDTO o, PrintWriter printWriter) {
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