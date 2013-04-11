package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.google.gson.Gson;

public class ListStrategy implements PostStrategyInterfaceHandler {

  private Jsonizable o;
  private PrintWriter printWriter;
  private Gson gson;

  public ListStrategy(Jsonizable o, PrintWriter printWriter, Gson gson) {
    this.o = o;
    this.printWriter = printWriter;
    this.gson = gson;
  }

  @Override
  public void execute() {
    //CRUDController data = new CRUDController();
    ArrayList<Jsonizable> list = new ArrayList<Jsonizable>();
    /*list.add(new Registro("asd2341","Rivadavia","400", new Tema()));
    list.add(new Registro("asd2341","Rivadavia","400", new Tema()));*/
    try {
      this.printWriter.print(this.gson.toJson(list));
    } catch (Exception e) {
      e.printStackTrace();
      printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
    }  
  }
  
}
