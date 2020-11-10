import { HttpErrorResponse, HttpRequest, HttpResponse, HttpResponseBase } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { exit } from 'process';
import { Plato } from 'src/app/Modelo/Plato';
import { Error } from 'src/app/Modelo/Error';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit{

  constructor(private router:Router, private service:ServiceService) { }
  
  plato:Plato = new Plato;
  restNit:number;
  errores:Error[];
  bandera:boolean =  false;

//{{error.error.errors[0] | json}}
  ngOnInit(): void {
    let restnit = localStorage.getItem("restnit");
    this.restNit = +restnit;
  }
  
  guardar(){
    this.plato.idRest = this.restNit;
    this.service.createPlato(this.plato)
    .subscribe(data => {
      if(this.plato.compareTo(data)){
        this.plato = data;
        alert("Plato añadido...");
        localStorage.setItem("restnit",this.restNit.toString());
        this.router.navigate(['listar']);
        this.bandera = true; 
      }
    },
    response => {
      if(this.bandera == false){
        this.errores = response.error.errors       
        } 
      })      
  }

  atras(){
    localStorage.setItem("restnit",this.restNit.toString());
    this.router.navigate(['listar']);
  }   
  mensajeError(field:string):string{
    if (this.errores == undefined) return "";
    for(let error of this.errores)
      if(error.field == field)
        return error.message;
    return "";
  }
}
