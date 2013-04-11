package com.diphot.siuweb.server.mobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diphot.siuweb.server.mobile.adapters.JsonAdapter;
import com.diphot.siuweb.server.mobile.adapters.JsonAdapter.ACTION;
import com.diphot.siuweb.server.mobile.handlerstrategies.DefaultStrategy;
import com.diphot.siuweb.server.mobile.handlerstrategies.DeleteStrategy;
import com.diphot.siuweb.server.mobile.handlerstrategies.GetStrategy;
import com.diphot.siuweb.server.mobile.handlerstrategies.ListStrategy;
import com.diphot.siuweb.server.mobile.handlerstrategies.PostStrategyInterfaceHandler;
import com.diphot.siuweb.server.mobile.handlerstrategies.PutStrategy;
import com.diphot.siuweb.server.mobile.handlerstrategies.UpdateStrategy;
import com.diphot.siuweb.shared.Jsonizable.Jsonizable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PostHandler {

  private PostStrategyInterfaceHandler strategy;

  public PostHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException{
    resp.setContentType("text/plain");
    Gson gson;
    GsonBuilder builder = new GsonBuilder();
    JsonAdapter adapter = new JsonAdapter();
    builder.registerTypeAdapter(Jsonizable.class,adapter);
    gson = builder.create();
    String inputData = readReader(req.getReader());
    Jsonizable o = gson.fromJson(inputData, Jsonizable.class);
    setStrategy(adapter.getAction(),o,resp.getWriter(),gson);
  }  

  public void execute(){
    strategy.execute();
  }

  private void setStrategy(ACTION action,Jsonizable o, PrintWriter printWriter,Gson gson){

    // {PUT,GET,UPDATE,DELETE,LIST,QUERY,NONE};
    switch (action) {
    case PUT:
      this.strategy = new PutStrategy(o,printWriter);    
      break;
    case GET:
      this.strategy = new GetStrategy(o, printWriter, gson);
      break;
    case DELETE:
      this.strategy = new DeleteStrategy(o, printWriter);
      break;
    case LIST:
      this.strategy = new ListStrategy(o, printWriter, gson);
      break;
    case UPDATE:
      this.strategy = new UpdateStrategy(o, printWriter);
      break;
    case NONE:
      this.strategy = new DefaultStrategy(printWriter);
      break;
    default:
      this.strategy = new DefaultStrategy(printWriter); 
      break;
    }
  }

  private String readReader(BufferedReader reader){
    StringBuffer jb = new StringBuffer();
    String line = null;
    try {
      while ((line = reader.readLine()) != null){
        jb.append(line);
      }
    } catch (Exception e) { 
      //report an error 
    } 
    return jb.toString();
  }
  
}