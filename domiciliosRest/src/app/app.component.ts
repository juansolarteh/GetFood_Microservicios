import { Component} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'domiciliosRest';

  constructor(private router:Router){}

  listarMenuAdministrador(idRest:number){
    localStorage.setItem("restnit",idRest.toString());
    this.router.navigate(['listar']);
  }

  listarRest(){
    this.router.navigate(['listarRest']);
  }
  login(){
    this.router.navigate(['login'])
  }
  listarPedidos(){
    this.router.navigate(['listarPedidos'])
  }
}
