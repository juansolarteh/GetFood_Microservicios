import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurante } from 'src/app/Modelo/Restaurante';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listarRest',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarRestComponent implements OnInit {
  restaurantes:Restaurante[];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(){
    this.service.getRestaurantes()
    .subscribe(data=>{
      this.restaurantes=data;
    })
  }

}