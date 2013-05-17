package com.diphot.siuweb.server.pdfservice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class CustomWorker {


	public CustomWorker(){

	}

	public void exec(ServletOutputStream output, StringReader StringHTML) throws DocumentException, IOException{

		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,output);
		document.open();
		HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
		htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
		htmlContext.setImageProvider(new CustomImageProvider());

		//htmlContext.setLinkProvider(new LinkProvider());

		CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

		Pipeline<?> pipeline = new CssResolverPipeline(cssResolver,	new HtmlPipeline(htmlContext,new PdfWriterPipeline(document, writer)));

		XMLWorker worker = new XMLWorker(pipeline, true);

		XMLParser p = new XMLParser(worker);

		p.parse(StringHTML);

		document.close();
	}

}
