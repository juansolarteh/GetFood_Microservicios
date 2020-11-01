import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRestComponent } from './listar.component';

describe('ListarComponent', () => {
  let component: ListarRestComponent;
  let fixture: ComponentFixture<ListarRestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarRestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarRestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
