export class Item{
    private idPlato:number
    private nombrePlato:string
    private cantidadPlato:number
    private precioPlato:number
    private precioItem:number

    getIdPlato():number{
        return this.idPlato
    }

    setCantidadPlato(cantidad:number){
        this.cantidadPlato=cantidad;
    }

    getCantidadPlato():number{
        return this.cantidadPlato
    }
}