package com.excel.model;

import java.io.Serializable;

public class BIN implements Serializable{

	private static final long serialVersionUID = 342575873343567626L;
	
	private String rowa ; 
	private String rowb ; 
	private String rowc ; 
	private String rowd ;
	public String getRowa() {
		return rowa;
	}
	public void setRowa(String rowa) {
		this.rowa = rowa;
	}
	public String getRowb() {
		return rowb;
	}
	public void setRowb(String rowb) {
		this.rowb = rowb;
	}
	public String getRowc() {
		return rowc;
	}
	public void setRowc(String rowc) {
		this.rowc = rowc;
	}
	public String getRowd() {
		return rowd;
	}
	public void setRowd(String rowd) {
		this.rowd = rowd;
	}
	@Override
	public String toString() {
		return "BIN [rowa=" + rowa + ", rowb=" + rowb + ", rowc=" + rowc + ", rowd=" + rowd + "]";
	} 
}
