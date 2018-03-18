import { Component, OnInit } from '@angular/core';

import {UsuariosService} from '../usuarios.service';
import { Usuario } from '../usuarios';

@Component({
  selector: 'app-usuario-listado',
  templateUrl: './usuario-listado.component.html',
  styleUrls: ['./usuario-listado.component.css']
})
export class UsuarioListadoComponent implements OnInit {

  public listaUsuarios : Usuario[];
  constructor(private usuarioService : UsuariosService) { }

  userLogged: boolean = false;

  ngOnInit() {
      var isUserLogged = localStorage.getItem("userLogged");
      if (isUserLogged === 'si') {
        this.userLogged = true;
        this.usuarioService.getUsuarios().subscribe(usuario => this.listaUsuarios = usuario);
      } else {
        this.userLogged = false;
      }    
  }

}
