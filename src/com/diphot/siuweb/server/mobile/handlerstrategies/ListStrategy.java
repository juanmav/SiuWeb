package com.diphot.siuweb.server.mobile.handlerstrategies;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.diphot.siuweb.server.pesistense.DAOFactory;
import com.diphot.siuweb.server.pesistense.DAOInterface;
import com.diphot.siuweb.shared.dtos.InterfaceDTO;
import com.google.gson.Gson;

public class ListStrategy implements PostStrategyInterfaceHandler {

  private InterfaceDTO o;
  private PrintWriter printWriter;
  private Gson gson;

  public ListStrategy(InterfaceDTO o, PrintWriter printWriter, Gson gson) {
    this.o = o;
    this.printWriter = printWriter;
    this.gson = gson;
  }

  @Override
  public void execute() {
    DAOInterface<?, ?> dao = DAOFactory.getDAOImpl(o);
    ArrayList<InterfaceDTO> list  = (ArrayList<InterfaceDTO>) dao.getDTOList();
       
    try {
      this.printWriter.print(this.gson.toJson(list));
    } catch (Exception e) {
      e.printStackTrace();
      printWriter.print(new PostResult(PostResult.Result.FALSE).getToGson());
    }  
  }
  
}
