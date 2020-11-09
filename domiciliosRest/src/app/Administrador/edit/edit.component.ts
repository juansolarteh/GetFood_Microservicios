import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  plato :Plato=new Plato();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(){
    this.editPlato();
  }

  editPlato(){
    let id = localStorage.getItem("id");
    this.service.getPlatoId(+id)
    .subscribe(data=>{
      this.plato=data;
    })
  }

  Actualizar(plato:Plato){
    this.service.updatePlato(plato)
    .subscribe(data=>{
      this.plato=data;
      alert("Plato editado..");
      this.router.navigate(["listar"]);
    })
  }
  atras(){
    this.router.navigate(['listar']);
  }
}
