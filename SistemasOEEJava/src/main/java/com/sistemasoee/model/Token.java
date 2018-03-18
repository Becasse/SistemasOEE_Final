package com.sistemasoee.model;

public class Token {
	
	public String texto;
	
	public boolean operacionCorrecta;
	
	public Token() {
		texto = "";
		operacionCorrecta = false;
	}


	public Token(String pTexto, boolean pOperacionCorrecta) {
		texto = pTexto;
		operacionCorrecta = pOperacionCorrecta;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public boolean isOperacionCorrecta() {
		return operacionCorrecta;
	}


	public void setOperacionCorrecta(boolean operacionCorrecta) {
		this.operacionCorrecta = operacionCorrecta;
	}
}
