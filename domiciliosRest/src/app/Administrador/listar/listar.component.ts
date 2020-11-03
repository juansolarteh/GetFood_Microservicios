import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from 'src/app/Modelo/Plato';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  platos:Plato[];
  constructor(private service:ServiceService, private router:Router){ }

  restNit:number;

  ngOnInit(){
    let restnit = localStorage.getItem("restnit");
    this.restNit = +restnit;
    this.service.getMenu(this.restNit).subscribe(data=>{
      this.platos=data;
    })
  }

  delete(plato:Plato){
    this.service.deletePlato(plato)
    .subscribe(data=>{
      this.platos=this.platos.filter(p=>p!==plato);
    })
  }

  agregarPlato(){
    localStorage.setItem("restnit",this.restNit.toString());
    this.router.navigate(['add']);
  }
}
