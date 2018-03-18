package com.sistemasoee.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sistemasoee.dao.UsuarioDAO;
import com.sistemasoee.model.Token;
import com.sistemasoee.model.Usuario;

@Service ("autenticationService")
public class AutenticationService implements IAutenticationService {
	
	// Se trata del mapa en el que guardaremos los usuarios registrados
	private Map<String, Usuario> mapa = new HashMap<>();
	
	// Metodo que invocamos al hacer login.
	public Token autenticarUsuario (String pEmail, String pPassword) {
		Token mensajeError = new Token();
		if (new UsuarioDAO().existeUsuario(pEmail, pPassword, mapa)) {
			mensajeError.setTexto("ok");
			mensajeError.setOperacionCorrecta(true);
		} else {
			mensajeError.setTexto("El usuario/contraseña son incorrectos");
			mensajeError.setOperacionCorrecta(false);
		}
		return mensajeError;
	}
	
	// Metodo que invocamos al dar de alta un nuevo usuario
	public Token createUsuario(String pNombre, String pPass, String pEmail, Integer pEdad) {
		Token mensajeError = new Token();
		// Comprobamos si el usuario existe en nuestro sistemas. No mostraremos mensaje para este caso.
		boolean existeUsuario = new UsuarioDAO().existeUsuario(pEmail, pPass, mapa);
		try {
			if (new UsuarioDAO().validateDatosUsuario(pNombre, pPass, pEmail, pEdad) && !existeUsuario) {
				mensajeError = new UsuarioDAO().insertarUsuarioMapa(pNombre, pPass, pEmail, pEdad, mapa);	
				mensajeError.setOperacionCorrecta(true);
	        } else {
	        	mensajeError.setTexto("Existen datos incorrectos. Por favor revise los datos");
	        	mensajeError.setOperacionCorrecta(false);
	        }
			return mensajeError;
		} catch (Exception e) {
			return mensajeError;
		}
	}
	
	// Mostraremos la lista de usuarios que estan registrados
	public List<Usuario> getUsuarios() {
		return new UsuarioDAO().getUsuarios(mapa);
	}
	
}
