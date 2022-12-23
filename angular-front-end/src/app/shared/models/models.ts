export class Product {
    product_id: number
    img_url: string
    title: string
    stars: number
    price: number
    category: Category
}


export class Category{
    category_id: number
    description: string
}