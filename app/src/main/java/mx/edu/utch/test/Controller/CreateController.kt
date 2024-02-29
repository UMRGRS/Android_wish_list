package mx.edu.utch.test.Controller

import mx.edu.utch.test.Model.ProductsList
import mx.edu.utch.test.View.ICreateView

class CreateController:IController {
    override fun OnCreateProduct(model: ProductsList?, view: ICreateView, name:String, price:String) {
        var state = model!!.AddProduct(name,price)
        var value = state.toString()
        when(state){
            -1->view.OnCreateError("Introduce el nombre del producto")
            -2->view.OnCreateError("Introduce el valor del producto")
            else->view.OnCreateSuccess("Producto agregado con exito", mapOf("name" to name, "price" to price, "id" to value))
        }
    }
    override fun OnDeleteProduct(model: ProductsList?, view:ICreateView, ID: String) {
        var state = model!!.DeleteProduct(ID.toInt())
        when(state){
            0->view.OnDeleteError("Hubo un error")
            -1->view.OnDeleteSuccess("Producto eliminado correctamente")
        }
    }

}