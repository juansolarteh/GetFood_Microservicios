import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Restaurante } from 'src/app/Modelo/Restaurante';
import { ListarComponent } from 'src/app/Plato/listar/listar.component';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listarRest',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarRestComponent implements OnInit{
  restaurantes:Restaurante[];
  constructor(private service:ServiceService, private router:Router) { }
  menu:boolean = false;

  ngOnInit(){
    this.service.getRestaurantes()
    .subscribe(data=>{
      this.restaurantes=data;
    })
  }

  listarMenu(restaurante:number){
    localStorage.setItem("restnit",restaurante.toString());
    this.router.navigate(["listar"]);
  }
}