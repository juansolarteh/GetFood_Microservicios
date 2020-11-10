import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Plato } from '../Modelo/Plato';
import { Restaurante } from '../Modelo/Restaurante';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  UrlPlato='http://localhost:8001/plato';
  UrlRestaurante='http://localhost:8006/restaurante';

  getMenu(idRest:number){
    return this.http.get<Plato[]>(this.UrlPlato+"/rest/"+idRest);
  }

  createPlato(plato:Plato){
    return this.http.post<Plato>(this.UrlPlato,plato);
  }

  deletePlato(plato:Plato){
    return this.http.delete<Plato>(this.UrlPlato+"/"+plato.id);
  }

  /**
   * Método empleado para editar un plato desde la vista del administrador.
   * @param plato 
   */
  updatePlato(plato:Plato){
    return this.http.put<Plato>(this.UrlPlato+"/"+plato.id,plato);
  }

  updateEstadoRestaurante(restaurante:Restaurante){
    return this.http.put<Restaurante>(this.UrlRestaurante+"/"+restaurante.restnit,restaurante);
  }

  /**
   *Método que obtiene un id de un plato en especifico. 
   * @param id 
   */
  getPlatoId(id:number){
    return this.http.get<Plato>(this.UrlPlato+"/"+id);
  }

  getRestaurantes(){
    return this.http.get<Restaurante[]>(this.UrlRestaurante);
  }

  getRestaurante(id:number){
    return this.http.get<Restaurante>(this.UrlRestaurante+"/"+id);
  }
}
