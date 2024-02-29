package mx.edu.utch.test.Controller

import mx.edu.utch.test.Model.ProductsList
import mx.edu.utch.test.View.ICreateView

interface IController {
    fun OnCreateProduct(model:ProductsList?, view:ICreateView, name:String, price:String)
    fun OnDeleteProduct(model:ProductsList?, view:ICreateView, ID:String)
}