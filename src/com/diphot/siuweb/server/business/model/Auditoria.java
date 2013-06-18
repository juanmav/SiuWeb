package com.diphot.siuweb.server.business.model;

import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.ManyToOne;
import com.google.appengine.datanucleus.annotations.Unowned;

public class Auditoria {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String encodedKey;
	@Persistent
	@Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
	private Long id;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	@ManyToOne
	private Inspeccion inspeccion;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG1;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG2;
	@Persistent(defaultFetchGroup = "true")
	@Unowned
	private EncodedImage encodedIMG3;
	@Persistent
	private Boolean resuelto;
	@Persistent
	private String observaciones;
	@Persistent
	private Date fecha;

	

	public Auditoria(){

	}

	public Auditoria(Inspeccion inspeccion, EncodedImage img1, EncodedImage img2, EncodedImage img3, Boolean resuelto, String observaciones){
		this.inspeccion = inspeccion;
		this.inspeccion.addAuditoria(this);
		this.encodedIMG1 = img1;
		this.encodedIMG2 = img2;
		this.encodedIMG3 = img3;
		this.resuelto = resuelto;
		this.observaciones = observaciones;
	}

	public String getEncodedKey() {
		return encodedKey;
	}

	public void setEncodedKey(String encodedKey) {
		this.encodedKey = encodedKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Inspeccion getInspeccion() {
		return inspeccion;
	}
	public void setInspeccion(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}
	public EncodedImage getEncodedIMG1() {
		return encodedIMG1;
	}
	public void setEncodedIMG1(EncodedImage encodedIMG1) {
		this.encodedIMG1 = encodedIMG1;
	}
	public EncodedImage getEncodedIMG2() {
		return encodedIMG2;
	}
	public void setEncodedIMG2(EncodedImage encodedIMG2) {
		this.encodedIMG2 = encodedIMG2;
	}
	public EncodedImage getEncodedIMG3() {
		return encodedIMG3;
	}
	public void setEncodedIMG3(EncodedImage encodedIMG3) {
		this.encodedIMG3 = encodedIMG3;
	}
	public Boolean getResuelto() {
		return resuelto;
	}
	public void setResuelto(Boolean resuelto) {
		this.resuelto = resuelto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
