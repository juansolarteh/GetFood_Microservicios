import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
//import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  plato:Plato;
  constructor(){}
  //constructor(private service:ServiceService, private router:Router){ }

  ngOnInit(){
    //this.service.getPlatos()
    ////this.plato=data;
    //})
  }

}
