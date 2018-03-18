
import { Component, OnInit } from '@angular/core';

import {UsuariosService} from '../usuarios/usuarios.service';
import { Usuario,Result } from '../usuarios/usuarios';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

public usuario: Usuario = new Usuario();
 
mensajeError: String = "";

userLogged: boolean = false;

constructor(private usuarioService : UsuariosService, private router: Router) { }

ngOnInit() {
  var isUserLogged = localStorage.getItem("userLogged");
  if (isUserLogged === 'si') {
    this.userLogged = true;
  } else {
    this.userLogged = false;
  }
}

login() {
       this.usuarioService.comprobarCredenciales(this.usuario.email, this.usuario.password).subscribe(loginResult => {
         this.processResult(loginResult);
         this.mensajeError = loginResult;
       });
}

processResult (result: Result) {
  if(result.texto === 'ok') {
    localStorage.setItem('userLogged', "si");
    this.router.navigate(['usuarios/listado']);
  } else {
    localStorage.setItem('userLogged', "no");
    this.limpiar();
  }
}

logout() {
  this.usuario = null;
  localStorage.setItem('userLogged', "no");
  this.router.navigate(['login']);
  window.location.reload();
}


limpiar() {
  this.usuario.nombre = "";
  this.usuario.password = "";
  this.router.navigate(['login']);
}
}


