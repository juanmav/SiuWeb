package com.diphot.siuweb.server.pdfservice;

//import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.diphot.siuweb.server.business.Inspeccion;
import com.diphot.siuweb.server.pesistense.daos.InspeccionDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@SuppressWarnings("serial")
public class CreatePdfServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		InspeccionDAO idao = new InspeccionDAO();
		idao.begin();
		Inspeccion inspeccion = idao.findById(55L);
		idao.end();
		// http://maps.googleapis.com/maps/api/staticmap?scale=1&center=40.702147,-74.015794&zoom=14&size=300x150&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&sensor=false
		try {
			XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
			
			Document document = new Document();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			String str = "<html><head></head><body>"+
					"<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
					"<h1>Show your support</h1>" +
					"<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees, " +
					"in personal hardware and software costs to set up test environments, and above all," +
					"the huge amounts of time it takes for one person to design and write the actual content.</p>" +
					"<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?</p>" +
					"<p>Donate using PayPal® to real@rgagnon.com.</p>" +
					"<img id=\"x-auto-175\" src=\""+ "data:image/jpeg;base64," +inspeccion.getEncodedIMG1().getEncodedImageString() +"\"></img>"+
					"<p>Contributions via PayPal are accepted in any amount</p>" +
					"<P><br/><table border='1'><tr><td>Java HowTo</td></tr><tr>" +
					"<td style='background-color:red;'>Javascript HowTo</td></tr>" +
					"<tr><td>Powerbuilder HowTo</td></tr></table></p>" +
					"</body></html>";
			worker.parseXHtml(pdfWriter, document, new StringReader(str));
			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
