package com.sistemasoee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistemasoee.model.Token;
import com.sistemasoee.model.Usuario;
import com.sistemasoee.services.IAutenticationService;


@RestController
@RequestMapping("/api")
public class UsuariosController {

	@Autowired
	private IAutenticationService autenticationService;
	
    @RequestMapping("/login")
    public Token hacerLogin(@RequestParam(value="email") String email, @RequestParam(value="pass") String pass) {
        return autenticationService.autenticarUsuario(email, pass);
    }
    
    @RequestMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return autenticationService.getUsuarios();
    }
    
    @RequestMapping("/alta")
    public Token createUsuario(@RequestParam(value="name") String name, @RequestParam(value="pass") String pass, @RequestParam(value="email") String email, @RequestParam(value="age") Integer age) {
        return autenticationService.createUsuario(name, pass, email, age);
    }
}