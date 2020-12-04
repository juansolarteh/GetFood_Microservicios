import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PedidoActivoComponent } from './pedido-activo.component';

describe('PedidoActivoComponent', () => {
  let component: PedidoActivoComponent;
  let fixture: ComponentFixture<PedidoActivoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PedidoActivoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PedidoActivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
