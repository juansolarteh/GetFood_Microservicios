import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurante } from 'src/app/Modelo/Restaurante';
import { ServiceService } from '../../Service/service.service';
import { Error } from 'src/app/Modelo/Error'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  restaurante:Restaurante = new Restaurante
  
  bandera:boolean =  false;
  constructor(private service:ServiceService, private router:Router) { 
  }
  errores:Error[];
  ngOnInit(): void {
  
  }
  login(restnit){
      if (restnit == null)
        alert("Por favor, escriba un ID")
      this.service.getRestaurante(restnit).subscribe(
        data=>{
            localStorage.setItem("restnit",restnit);
            this.router.navigate(['listar']);
            this.bandera=true;
        },
        response=>{
          if (this.bandera==false){
            alert(response.error);
            this.errores = response.error.errores
          }
        })
  }
  Atras(){
    this.router.navigate(['listarRest'])
  }

  mensajeError(field:string):string{
    if (this.errores == undefined) return "";
    for(let error of this.errores)
      if(error.field == field)
        return error.message;
    return "";
  }
}
