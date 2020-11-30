import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../Service/service.service';
import { Router } from '@angular/router';
import { Pedido } from 'src/app/Modelo/Pedido';
import { Error } from 'src/app/Modelo/Error';
import { Item } from 'src/app/Modelo/Item'
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'

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
    //Aqui deberia ir toda la logica de publicador de evento para traer los pedidos con nit(this.restNit)
    this.historialPedidos = new Array
    this.historialPedidos.push(new Pedido(12,"aa"))
    this.historialPedidos[0].addItem(new Item(1,"bb",3,434))
    this.historialPedidos[0].setDireccion("cara")
    this.historialPedidos[0].setTelefono(12345)
  }
}
