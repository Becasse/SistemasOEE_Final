import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule }    from '@angular/common/http';


import { AppComponent } from './app.component';

import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UsuarioAltaComponent } from './usuarios/usuario-alta/usuario-alta.component';
import { UsuarioListadoComponent } from './usuarios/usuario-listado/usuario-listado.component';
import  { UsuariosService} from './usuarios/usuarios.service';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'usuarios/listado',      component: UsuarioListadoComponent },
  { path: 'usuarios/alta',      component: UsuarioAltaComponent },
  { path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  //{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UsuarioAltaComponent,
    UsuarioListadoComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
        FormsModule,
        ReactiveFormsModule,
    
    HttpClientModule
  ],
  providers: [UsuariosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
