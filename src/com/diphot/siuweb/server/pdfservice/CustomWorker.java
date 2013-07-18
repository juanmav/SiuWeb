package com.diphot.siuweb.server.pdfservice;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.Pipeline;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.html.HTML.Tag;
public class CustomWorker {


	public CustomWorker(){

	}

	public void exec(ServletOutputStream output, StringReader StringReaderHTML) throws DocumentException, IOException{

		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document,output);
		
		document.open();
		
		HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
		
		TagProcessorFactory tags = Tags.getHtmlTagProcessorFactory();
		/*Generamos un tag propio para el manejo de imagenes*/
		tags.addProcessor(new ImageTagProcessor(),Tag.IMG);
		htmlContext.setTagFactory(tags);
	
		CSSResolver cssResolver = XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
		
		HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext,new PdfWriterPipeline(document, writer));
		
		Pipeline<?> pipeline = new CssResolverPipeline(cssResolver,	htmlPipeline);
		
		XMLWorker worker = new XMLWorker(pipeline, true);
		
		XMLParser p = new XMLParser(worker);

		p.parse(StringReaderHTML);

		document.close();
	}

}
