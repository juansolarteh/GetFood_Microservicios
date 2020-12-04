import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../Service/service.service';
import { Pedido } from 'src/app/Modelo/Pedido';
import { Error } from 'src/app/Modelo/Error';

@Component({
  selector: 'app-pedido-activo',
  templateUrl: './pedido-activo.component.html',
  styleUrls: ['./pedido-activo.component.css']
})
export class PedidoActivoComponent implements OnInit {

  pedidos:Pedido[];
  bandera:boolean = false;
  errores:Error[];

  constructor(private service:ServiceService,) { }

  ngOnInit(): void {
    this.service.getSentOrder().subscribe(
      data=>{
        if(data!=null && data!=undefined){
          this.pedidos=data
          this.bandera=true
        }
    },
      response=>{
        if(this.bandera==false){
          this.errores=response.error.errors
        }
      });
  }

  entregarPedido(pedido:Pedido){
    this.service.deliverOrder(pedido)
    .subscribe(data=>{
      this.pedidos=this.pedidos.filter(p=>p!==pedido);
    })
  }

  tipoPago(pedido:Pedido):string{
    if (pedido.state == "SendState") return "Pago Electronico";
    return "Pago Contraentrega";
  }

  hayPedidos(){
    if (this.pedidos == undefined || this.pedidos.length == 0) return false
    return true
  }
}
