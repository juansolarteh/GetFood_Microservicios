import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarRestComponent } from './Restaurante/listarRest/listar.component';
import { AddComponent } from './Plato/add/add.component';
import { EditComponent } from './Plato/edit/edit.component';
import { ListarComponent } from './Plato/listar/listar.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path:'listar', component:ListarComponent},
  {path:'add', component:AddComponent},
  {path:'edit', component:EditComponent},
  {path:'listarRest',component:ListarRestComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
