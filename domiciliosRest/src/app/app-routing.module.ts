import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarRestComponent } from './Comprador/listarRest/listar.component';
import { AddComponent } from './Administrador/add/add.component';
import { EditComponent } from './Administrador/edit/edit.component';
import { ListarComponent } from './Administrador/listar/listar.component';
import { ListarMenuComponent } from './Comprador/listar-menu/listar-menu.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './Administrador/login/login.component';
import { ListarPedidosComponent } from './Administrador/listar-pedidos/listar-pedidos.component';

const routes: Routes = [
  {path:'listar', component:ListarComponent},
  {path:'add', component:AddComponent},
  {path:'edit', component:EditComponent},
  {path:'listarRest',component:ListarRestComponent},
  {path:'listarMenu', component:ListarMenuComponent},
  {path:'login',component:LoginComponent},
  {path:'listarPedidos',component:ListarPedidosComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
