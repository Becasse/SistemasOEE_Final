import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { Usuario,Result } from './usuarios';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UsuariosService {

  private usuariosUrl = 'api/';  // URL to web api
  public usuarioCorrecto : boolean = false;

  constructor(
    private http: HttpClient) { }

  /** Comprobamos si nombre y pass son correctos en login */
  comprobarCredenciales (email: String, pass:String): Observable<any> {
    return this.http.get<Result>(this.usuariosUrl + 'login?email='+ email+'&pass='+pass) .pipe(
      catchError(this.handleError('comprobarCredenciales', []))
    );
  }

  /** GET usuarios from the server */
  getUsuarios (): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.usuariosUrl + 'usuarios');
  }

  //////// Save methods //////////

  /** POST: add a new hero to the server */
 createUsuario (nombre: String,  pass: String, email: String, edad: Number): Observable<any> {
    return this.http.get<String>(this.usuariosUrl + 'alta?name='+ nombre+'&pass='+pass +'&email='+email +'&age='+edad) .pipe(
      catchError(this.handleError('createUsuario', []))
    )
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for usuario consumption
      //this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}