import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../Service/service.service';
import { Router } from '@angular/router';
import { Pedido } from '../../Modelo/Pedido';
import { Error } from 'src/app/Modelo/Error';
@Component({
  selector: 'app-listar-pedidos',
  templateUrl: './listar-pedidos.component.html',
  styleUrls: ['./listar-pedidos.component.css']
})
export class ListarPedidosComponent implements OnInit {

  constructor(private service:ServiceService, private router:Router) { }
  restNit:number;
  misPedidos:Pedido[];
  errores:Error[];
  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.restNit= +restnit;
    this.service.getPedidos(this.restNit).subscribe(
      data=>{
        this.misPedidos=data;
    },
      response=>{
        alert("Hay errores")
        this.errores=response.error.errors
      });
  }
  Atras(){
    this.router.navigate(['listar'])
  }

}
