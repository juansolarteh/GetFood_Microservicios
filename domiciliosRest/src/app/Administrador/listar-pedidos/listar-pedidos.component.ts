import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../Service/service.service';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/Modelo/Pedido';
import { Error } from 'src/app/Modelo/Error';
import { Item } from 'src/app/Modelo/Item'
@Component({
  selector: 'app-listar-pedidos',
  templateUrl: './listar-pedidos.component.html',
  styleUrls: ['./listar-pedidos.component.css']
})
export class ListarPedidosComponent implements OnInit {

  
  restNit:number;
  pedidos:Pedido[];
  errores:Error[];
  bandera:boolean = false;
  constructor(private service:ServiceService, private router:Router) { }
  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.restNit= +restnit;
    this.service.getPedidos(this.restNit).subscribe(
      data=>{
        if(data!=null && data!=undefined){
          this.pedidos=data
          this.bandera=true
        }
    },
      response=>{
        if(this.bandera==false){
          alert("No hay pedidos")
          this.errores=response.error.errors
        }
      });
  }
  Atras(){
    this.router.navigate(['listar'])
  }

}
