package com.diphot.siuweb.server.pdfservice;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.xerces.impl.dv.util.Base64;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

public class CustomImageProvider extends AbstractImageProvider{

	@Override
	public String getImageRootPath() {
		// TODO Auto-generated method stub
		return "/";
	}

	public Image retrieve(final String src){
		Image result = null;
		try {
			result = Image.getInstance(Base64.decode(src));
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
