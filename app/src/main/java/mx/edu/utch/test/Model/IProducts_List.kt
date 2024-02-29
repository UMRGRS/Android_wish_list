package mx.edu.utch.test.Model

interface IProducts_List {
    fun GetProducts():MutableList<Product>
    fun AddProduct(name:String, price: String):Int
    fun DeleteProduct(ID:Int):Int
}