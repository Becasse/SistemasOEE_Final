package com.sistemasoee.services;

import java.util.List;

import com.sistemasoee.model.Token;
import com.sistemasoee.model.Usuario;

public interface IAutenticationService {

	Token autenticarUsuario (String pNombre, String pPassword);
	List<Usuario> getUsuarios();
	
	Token createUsuario(String pNombre, String pPass, String pEmail, Integer pEdad);
}
