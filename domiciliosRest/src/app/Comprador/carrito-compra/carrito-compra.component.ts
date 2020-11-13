import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'

@Component({
  selector: 'app-carrito-compra',
  templateUrl: './carrito-compra.component.html',
  styleUrls: ['./carrito-compra.component.css']
})
export class CarritoCompraComponent implements OnInit {

  constructor(private modal:NgbModal) { }

  ngOnInit(): void {
  }
  openSM(contenido){
    this.modal.open(contenido,{size:'xl', centered:true});
  }

}
