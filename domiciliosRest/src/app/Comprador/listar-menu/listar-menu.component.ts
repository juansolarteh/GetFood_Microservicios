import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from '../../Service/service.service';
@Component({
  selector: 'app-listar-menu',
  templateUrl: './listar-menu.component.html',
  styleUrls: ['./listar-menu.component.css']
})
export class ListarMenuComponent implements OnInit {

  platos:Plato[];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.service.getMenuComprador(+restnit).subscribe(data=>{
      this.platos=data;
    })
  }
  
  AgregarPedido(plato:Plato):void{

  } 
}