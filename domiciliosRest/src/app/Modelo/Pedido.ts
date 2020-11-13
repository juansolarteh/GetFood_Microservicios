import { Item } from './Item'

export class Pedido{
    private idRestaurante:number
    private nombreRestaurante:string
    private idCliente:number=99901
    private telefonoCliente:number
    private direccionPedido:string
    private valorPedido:number = 0
    private items:Item[]

    constructor(idRest:number, nombreRestaurante:string){
        this.idRestaurante = idRest
        this.nombreRestaurante = nombreRestaurante
        this.items = new Array;
    };

    private getPositionItem(idPlato:number):number{
        for (let index = 0; index < this.items.length; index++) {
            if(this.items[index].getIdPlato() == idPlato) return index
        }
        return -1
    }

    addItem(item:Item){
        var position = this.getPositionItem(item.getIdPlato())
        if(position < 0){
            this.items.push(item)
            this.valorPedido += item.getPrecioItem()
        }else{
            var numberAux = this.items[position].getPrecioItem() - item.getPrecioItem()
            this.items[position].setCantidadPlato(item.getCantidadPlato())
            this.valorPedido -= numberAux    
        }
    }

    getNumberItems():number{
        return this.items.length;
    }
}