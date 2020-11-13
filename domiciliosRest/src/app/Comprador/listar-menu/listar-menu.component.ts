import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from '../../Service/service.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'
import { Pedido } from 'src/app/Modelo/Pedido';

@Component({
  selector: 'app-listar-menu',
  templateUrl: './listar-menu.component.html',
  styleUrls: ['./listar-menu.component.css']
})
export class ListarMenuComponent implements OnInit {

  //Carrito de compra
  platoAux:Plato;
  cantidad:number = 1;
  pedido:Pedido;

  //Listado platos
  platos:Plato[];
  
  constructor(private service:ServiceService, private router:Router, private modal:NgbModal) { }

  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.service.getMenu(+restnit).subscribe(data=>{
      this.platos=data;
    })
  }

  openModalAgregarPlato(contenido, plato:Plato){
    this.platoAux = plato;
    this.modal.open(contenido,{size:'m', centered:true});
  }

  actualizarPrecio(input){
    if (input.value < 1){
      input.value = 1;
      this.cantidad = 1;
    }else this.cantidad = +input.value;
  }

  aumentarInput(input){
    input.value++;
    this.cantidad++;
  }

  disminuirInput(input){
    if(input.value > 1){
      input.value--;
      this.cantidad--;
    }
  }
  
  AgregarPedido():void{
  } 
}