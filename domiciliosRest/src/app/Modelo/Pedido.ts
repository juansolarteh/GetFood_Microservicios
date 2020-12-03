import { Item } from './Item'

export class Pedido{
    private id_restaurante:number
    private nombre_restaurante:string
    private id_cliente:number=99901
    telefono_pedido:number
    direccion_pedido:string
    valor_pedido:number = 0
    items:Item[]
    state:string

    constructor(idRest:number, nombreRestaurante:string){
        this.id_restaurante = idRest
        this.nombre_restaurante = nombreRestaurante
        this.items = new Array;
    };

    private getPositionItem(idPlato:number):number{
        for (let index = 0; index < this.items.length; index++) {
            if(this.items[index].getid_producto() == idPlato) return index
        }
        return -1
    }

    setDireccion(direccion:string){
        this.direccion_pedido = direccion
    }

    setTelefono(telefono:number){
        this.telefono_pedido = telefono
    }
    setState(state:string){
        this.state=state
    }

    getValorPedido():number{
        return this.valor_pedido;
    }

    getTelefono():number{
        return this.telefono_pedido;
    }
    getDireccion():string{
        return this.direccion_pedido;
    }
    getItems(): Item[]{
        return this.items;
    }

    addItem(item:Item){
        var position = this.getPositionItem(item.getid_producto())
        if(position < 0){
            this.items.push(item)
            this.valor_pedido += item.getprecio_item()
        }else{
            var numberAux = this.items[position].getprecio_item() - item.getprecio_item()
            this.items[position].setcantidad_producto(item.getcantidad_producto())
            this.items[position].setprecio_item(item.getprecio_producto())
            this.valor_pedido -= numberAux    
        }
    }
    getNumberItems():number{
        return this.items.length;
    }
}