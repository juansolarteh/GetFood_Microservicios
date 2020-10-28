import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Plato } from '../Modelo/Plato';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  Plato:Plato;
  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/DomiciliosRestaurantes/platos';

  getPlatos(){
    return this.http.get<Plato>(this.Url);
  }

  createPlato(plato:Plato){
    return this.http.post<Plato>(this.Url,plato);
  }
}
