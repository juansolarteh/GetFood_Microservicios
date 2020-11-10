export class Plato{
    id:number;
    idRest:number;
    name:String;
    price:number;
    description:String;

    compareTo(plato:Plato){
        if (plato.name == this.name && plato.price == this.price && plato.description == this.description)
            return true;
        return false;
    }
}