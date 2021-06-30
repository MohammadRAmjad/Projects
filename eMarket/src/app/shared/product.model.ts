
export class Product{
     id:number;
    public title:string;
    public price:number;
    public category: string;
    public favorite: boolean;
    public imagePath: string;

    constructor(id:number, title:string, price:number,  category: string){
        this.id = id;
        this.title =title;
        this.price = price;
        this.category = category;
        this.favorite = false;
        

    }
}