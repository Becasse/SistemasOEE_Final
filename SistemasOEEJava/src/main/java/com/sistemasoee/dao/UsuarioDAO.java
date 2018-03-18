package com.sistemasoee.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sistemasoee.model.Token;
import com.sistemasoee.model.Usuario;

public class UsuarioDAO {

	// Vamos a validar si todos los campos del alta de usuarios son correctos.
	// Como clave vamos a guardar el email del usuario
	public boolean validateDatosUsuario(String pNombre, String pPass, String pEmail, Integer pEdad) {
		boolean usuarioValido = false;
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = pattern.matcher(pEmail.trim());
        if (mather.find() == true) {
			if (!pNombre.trim().isEmpty() && !pPass.trim().isEmpty() && pEdad > 0) {
				usuarioValido = true;
			}
        } 
        return usuarioValido;
	}
	
	// Metodo en el que comprobaremos si ya existe el usuario en nuestro sistemas
	public boolean existeUsuario(String pEmail, String pPassword, Map<String, Usuario> pMapa) {
		for (Map.Entry<String, Usuario> entry : pMapa.entrySet()) {
			if (pEmail.equalsIgnoreCase(entry.getKey())) {
				if (pPassword.equals(entry.getValue().getPassword())) {
					return true;
				}
			}
		}
		return false;
	}

	// Metodo que se encarga de guardar las altas nuevas de los usuarios
	public Token insertarUsuarioMapa(String pNombre, String pPass, String pEmail, Integer pEdad, Map<String, Usuario> pMapa) {
		Usuario usuario = new Usuario(pNombre, pPass, pEmail, pEdad);
		pMapa.put(pEmail, usuario);
		String mensajeError = "El usuario se ha creado correctamente";
		boolean operacionCorrecta = true;		
		return new Token(mensajeError, operacionCorrecta);
	}
	
	// Metodo en el que cargaremos la lista completa de usuarios
	public List<Usuario> getUsuarios(Map<String, Usuario> pMapa) {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		for (Map.Entry<String, Usuario> entry : pMapa.entrySet()) {
			Usuario usuario = new Usuario();
			usuario.setNombre(entry.getValue().getNombre());
			usuario.setPassword(entry.getValue().getPassword());
			usuario.setEdad(entry.getValue().getEdad());
			usuario.setEmail(entry.getValue().getEmail());
			listaUsuarios.add(usuario);
		}		
		return listaUsuarios;
	}
}
