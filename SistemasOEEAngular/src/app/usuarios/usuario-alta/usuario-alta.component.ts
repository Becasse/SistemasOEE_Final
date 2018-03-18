import { Component, OnInit } from '@angular/core';

import {UsuariosService} from '../usuarios.service';
import { Usuario,Result } from '../usuarios';

@Component({
  selector: 'app-usuario-alta',
  templateUrl: './usuario-alta.component.html',
  styleUrls: ['./usuario-alta.component.css']
})
export class UsuarioAltaComponent implements OnInit {

  mensajeError:String = "";

  public usuario: Usuario = new Usuario();

  constructor(private usuarioService : UsuariosService) { }

  ngOnInit() {
    this.usuario.edad = 0;
  }

  save() {
      this.usuarioService.createUsuario(this.usuario.nombre, this.usuario.password, this.usuario.email, this.usuario.edad).subscribe(
        loginResult => {
          this.processResult(loginResult);
          this.mensajeError = loginResult;
          }
      );
  }

  processResult (result: Result) {
      if(result.operacionCorrecta) {
        this.limpiarCampos();
      }
  }

  limpiarCampos() {
    this.usuario = new Usuario();
    this.usuario.edad = 0;
  }
}

