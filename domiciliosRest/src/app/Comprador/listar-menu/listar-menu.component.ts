import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from '../../Service/service.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'
import { Pedido } from 'src/app/Modelo/Pedido';
import { Item } from 'src/app/Modelo/Item';
import { Error } from 'src/app/Modelo/Error';

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
  bandera:boolean =  false;
  errores:Error[];

  //Listado platos
  platos:Plato[];
  restnit:number;
  restNombre:string;
  
  constructor(private service:ServiceService, private router:Router, public modal:NgbModal) { }

  ngOnInit(){
    let str = localStorage.getItem("restnit,restname");
    this.restnit = +str.split(",")[0];
    this.restNombre = str.split(",")[1];
    this.service.getMenu(this.restnit).subscribe(data=>{
      this.platos=data;
    })
    document.getElementById("miPedido").setAttribute("disabled","true");
    document.getElementById("circle").setAttribute("disabled","true");
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
  
  agregarItem():void{
    if(this.pedido == undefined || this.pedido == null){
      this.pedido = new Pedido(this.restnit, this.restNombre)
      document.getElementById("miPedido").removeAttribute("disabled");
      document.getElementById("circle").removeAttribute("disabled");
    } 
    var item = new Item(this.platoAux.id, this.platoAux.name, this.cantidad, this.platoAux.price)
    this.pedido.addItem(item)
    this.cantidad = 1;
  } 

  finalizarPedido(){
    this.service.createPedido(this.pedido)
    .subscribe(data => {
      if(data != undefined || data != null){;
        this.bandera = true; 
        this.pedido=null
        document.getElementById("miPedido").setAttribute("disabled","true")
        document.getElementById("circle").setAttribute("disabled","true")
        this.modal.dismissAll()
        alert("Pedido enviado");
      }
    },
    response => {
      if(this.bandera == false){
        this.errores = response.error.errors       
        } 
      })  
  }

  getNumeroItems():number{
    try {
      return this.pedido.getNumberItems()
    } catch (error) {
      return 0
    }
  }

  openModalTelDir(modalDirTel){
    this.modal.dismissAll()
    this.modal.open(modalDirTel,{size:'m', centered:true});
  }

  mensajeError(field:string):string{
    if (this.errores == undefined || this.errores == null) return "";
    for(let error of this.errores)
      if(error.field == field)
        return error.message;
    return "";
  }
}