package com.sistemasoee.model;

public class Usuario {

	public String nombre;
	public String password;
	public String email;
	public Integer edad;
	
	/**
	 * Constructores sin parametros
	 */
	public Usuario() {
		this.nombre = "";
		this.password = "";
		this.email = "";
		this.edad = 0;
	}
	
	/**
	 * Constructores con parametros
	 * 
	 */
	public Usuario(String pNombre, String pPassword) {
		this.nombre = pNombre;
		this.password = pPassword;
	}
	
	
	public Usuario(String pNombre, String pPassword, String pEmail, Integer pEdad) {
		this.nombre = pNombre;
		this.password = pPassword;
		this.email = pEmail;
		this.edad = pEdad;
	}
	
	/**
	 * Getter & Setter
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}	
}
