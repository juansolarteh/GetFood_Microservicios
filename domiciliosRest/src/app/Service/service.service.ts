import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Plato } from '../Modelo/Plato';
import { Restaurante } from '../Modelo/Restaurante';

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

  getRestaurantes(){
    return this.http.get<Restaurante[]>(this.UrlRestaurante);
  }
}
