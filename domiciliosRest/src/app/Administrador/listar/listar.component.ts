import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { Restaurante } from 'src/app/Modelo/Restaurante';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  platos:Plato[];
  restaurante:Restaurante = new Restaurante;
  constructor(private service:ServiceService, private router:Router){ }

  restNit:number;
  bandera:boolean;
  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.restNit = +restnit;
    this.service.getRestaurante(this.restNit).subscribe(
      data=>{
      this.restaurante=data;
    })
      this.service.getMenu(this.restNit).subscribe(data=>{
        this.platos=data;
      })
  }

  delete(plato:Plato){
    this.service.deletePlato(plato)
    .subscribe(data=>{
      this.platos=this.platos.filter(p=>p!==plato);
    })
  }

  agregarPlato(){
    localStorage.setItem("restnit",this.restNit.toString());
    this.router.navigate(['add']);
  }

  editPlato(plato:Plato):void{
    localStorage.setItem("id",plato.id.toString());
    this.router.navigate(["edit"]);
  }

  cambiarEstadoRest(){
    if(this.restaurante.restabierto){
      this.restaurante.restabierto = false;
    }else{
      this.restaurante.restabierto = true;
    }
    this.service.updateEstadoRestaurante(this.restaurante)
    .subscribe(data=>{
    })
  }
}
