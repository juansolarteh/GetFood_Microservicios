import { Component, OnInit } from '@angular/core';
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

  ngOnInit(): void {
  }

  plato:Plato = new Plato();
  guardar(plato){
    this.service.createPlato(this.plato)
    .subscribe(data=>{
      //falta dejar de mostrar componente de agregacion y que se actualice el componente lista
      alert("Plato añadido..");
    })
  }
}
