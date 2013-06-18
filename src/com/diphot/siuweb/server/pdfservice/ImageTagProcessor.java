package com.diphot.siuweb.server.pdfservice;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImageTagProcessor extends AbstractTagProcessor {

	private final CssUtils utils = CssUtils.getInstance();
		
	@Override
	public List<Element> end(final WorkerContext ctx, final Tag tag, final List<Element> currentContent) {
		Map<String, String> attributes = tag.getAttributes();
		String src = attributes.get(HTML.Attribute.SRC);
		com.itextpdf.text.Image img = null;
		List<Element> l = new ArrayList<Element>(1);
		if (null != src && src.length() > 0) {
			// check if the image was already added once
			src = XMLUtil.unescapeXML(src);
			src = src.trim();
			try {
				// TODO Hay que hacer algo para que no re genere imagenes ya existentes
				src = src.replace("data:image/jpeg;base64,", "");
				byte[] a = Base64.decode(src);
				img = Image.getInstance(a);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if (null != img) {
				String width = attributes.get(HTML.Attribute.WIDTH);
				float widthInPoints = utils.parsePxInCmMmPcToPt(width);
				String height = attributes.get(HTML.Attribute.HEIGHT);
				if (width == null || height == null)
					img.setScaleToFitLineWhenOverflow(true);
				else
					img.setScaleToFitLineWhenOverflow(false);
				float heightInPoints = utils.parsePxInCmMmPcToPt(height);
				if (widthInPoints > 0 && heightInPoints > 0) {
					img.scaleAbsolute(widthInPoints, heightInPoints);
				} else if (widthInPoints > 0) {
					heightInPoints = img.getHeight() * widthInPoints / img.getWidth();
					img.scaleAbsolute(widthInPoints, heightInPoints);
				} else if (heightInPoints > 0) {
					widthInPoints = img.getWidth() * heightInPoints / img.getHeight();
					img.scaleAbsolute(widthInPoints, heightInPoints);
				}
				try {
					HtmlPipelineContext htmlPipelineContext = getHtmlPipelineContext(ctx);
					l.add(getCssAppliers().apply(new Chunk((com.itextpdf.text.Image) getCssAppliers().apply(img, tag, htmlPipelineContext), 0, 0, true), tag, htmlPipelineContext));
				} catch (NoCustomContextException e) {
					throw new RuntimeWorkerException(e);
				}
			}
		}
		return l;
	}

	@Override
	public boolean isStackOwner() {
		return false;
	}
}