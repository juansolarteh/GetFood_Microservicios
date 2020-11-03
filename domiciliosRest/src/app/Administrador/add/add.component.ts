import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { exit } from 'process';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }
  plato:Plato = new Plato;

  restNit:number;

  ngOnInit(): void {
    let restnit = localStorage.getItem("restnit");
    this.restNit = +restnit;
  }
  
  guardar(){
    this.plato.idRest = this.restNit;
    this.service.createPlato(this.plato)
    .subscribe(data=>{ 
    })
    alert("Plato añadido..");
    localStorage.setItem("restnit",this.restNit.toString());
    this.router.navigate(['listar']);
  }

  atras(){
    localStorage.setItem("restnit",this.restNit.toString());
    this.router.navigate(['listar']);
  }
}
