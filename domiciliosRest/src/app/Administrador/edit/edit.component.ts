import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { Error } from 'src/app/Modelo/Error';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  plato :Plato=new Plato();
  constructor(private router:Router, private service:ServiceService) { }
  errores:Error[];
  bandera:boolean =  false;

  ngOnInit(){
    this.editPlato();
  }

  editPlato(){
    let id = localStorage.getItem("id");
    this.service.getPlatoId(+id)
    .subscribe(data=>{
      this.plato=data;
    })
  }

  Actualizar(plato:Plato){
    this.service.updatePlato(plato)
    .subscribe(data=>{
      try {
        this.plato=data;
          alert("Plato editado..");
          this.router.navigate(["listar"]);
          this.bandera=true;
      } catch (error) {
        alert("comparetp mal");
      }
    },
    response => {
      if(this.bandera == false){
        this.errores = response.error.errors       
        } 
      })
  }

  atras(){
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
