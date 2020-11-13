import { Item } from './Item'

export class Pedido{
    private idRestaurante:number
    private nombreRestaurante:string
    private idCliente:number=99901
    private telefonoCliente:number
    private direccionPedido:string
    private valorPedido:number
    private items:Item[]

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
        }else{
            this.items[position].setCantidadPlato(item.getCantidadPlato())
        }
    }
}