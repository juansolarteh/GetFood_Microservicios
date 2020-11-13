export class Item{
    private idPlato:number
    private nombrePlato:string
    private cantidadPlato:number
    private precioPlato:number
    private precioItem:number

    constructor(idPlato:number, nombrePlato:string, cantidadPlato:number, precioPlato:number){
        this.idPlato = idPlato
        this.nombrePlato = nombrePlato
        this.cantidadPlato = cantidadPlato
        this.precioPlato = precioPlato
        this.precioItem = cantidadPlato * precioPlato
    }

    getIdPlato():number{
        return this.idPlato
    }

    getPrecioItem():number{
        return this.precioItem
    }

    setCantidadPlato(cantidad:number){
        this.cantidadPlato=cantidad;
    }

    getCantidadPlato():number{
        return this.cantidadPlato
    }
}