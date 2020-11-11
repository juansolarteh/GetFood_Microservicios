import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurante } from 'src/app/Modelo/Restaurante';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  restaurante:Restaurante = new Restaurante

  constructor(private service:ServiceService, private router:Router) { 
  }

  ngOnInit(): void {
  
  }
  

  login(form:NgForm){
    console.log(form.value);
    localStorage.setItem("restnit",form.value.idrest);
    this.router.navigate(['listar']);
  }
  Atras(){
    this.router.navigate(['listarRest'])
  }
}
