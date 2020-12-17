import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../Service/service.service';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/Modelo/Pedido';
import { Error } from 'src/app/Modelo/Error';
import { Item } from 'src/app/Modelo/Item'
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'
import { pseudoRandomBytes } from 'crypto';
import { BrowserStack } from 'protractor/built/driverProviders';

@Component({
  selector: 'app-listar-pedidos',
  templateUrl: './listar-pedidos.component.html',
  styleUrls: ['./listar-pedidos.component.css']
})
export class ListarPedidosComponent implements OnInit {

  
  restNit:number;
  pedidos:Pedido[];
  historialPedidos:Pedido[];
  errores:Error[];
  bandera:boolean = false;
  pedidoAux:Pedido;
  pedidosAux:Pedido[];
  constructor(private service:ServiceService, private router:Router, public modal:NgbModal) { }
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

  openModalHistorial(contenido){
    this.getHistorial()
    this.modal.open(contenido,{size:'xl', centered:true});
  }

  getHistorial(){
    this.service.getHistorialPedidos(this.restNit).subscribe(
      data=>{
        if(data!=null && data!=undefined){
          this.historialPedidos=data
          this.bandera=true
        }
    },
      response=>{
        if(this.bandera==false){
          alert("No ha realizado ningun pedido")
          this.errores=response.error.errors
        }
      });
  }
  Despachar(pedido:Pedido){
    this.service.sendOrder(pedido).subscribe(data=>{
      for (let index = 0; index < this.pedidos.length; index++) {
        if(this.pedidos[index].id == pedido.id){
          this.pedidos[index].state = "SendState"
          index = this.pedidos.length
        }
      }
    })
  }

  isSent(pedido:Pedido){
    if(pedido.state == "SendNotPayState" || pedido.state == "SendState") return true
        return false
  }
}
