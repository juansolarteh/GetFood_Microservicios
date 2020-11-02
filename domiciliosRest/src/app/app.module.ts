import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarRestComponent } from './Comprador/listarRest/listar.component';
import { ListarComponent } from './Administrador/listar/listar.component';
import { AddComponent } from './Administrador/add/add.component';
import { EditComponent } from './Administrador/edit/edit.component';
import { FormsModule } from '@angular/forms';
import { ServiceService } from '../app/Service/service.service';
import { HttpClientModule } from '@angular/common/http';
import { ListarMenuComponent } from './Comprador/listar-menu/listar-menu.component';

@NgModule({
  declarations: [
    AppComponent,
    ListarComponent,
    ListarRestComponent,
    AddComponent,
    EditComponent,
    ListarMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
