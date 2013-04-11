package com.diphot.siuweb.server.mobile;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MobileEndPoint extends HttpServlet {
  
  private static final long serialVersionUID = 4560857144444468055L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().print("Go away mother fucker!");
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)  throws IOException{
    new PostHandler(req,resp).execute();
  }
}