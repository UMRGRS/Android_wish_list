package mx.edu.utch.test.Model

class ProductsList (private var ProdList:MutableList<Product>):IProducts_List{
    override fun GetProducts(): MutableList<Product> {
        return ProdList
    }

    override fun AddProduct(name: String, price: String): Int {
        var newProd = Product(ProdList.size,name,price)
        when(newProd.isValid()){
            0 -> return -1
            1 -> return -2
            -1 ->{
                ProdList+=newProd
                return newProd.GetID()
            }
        }
        return -3
    }

    override fun DeleteProduct(ID: Int): Int {
        if(ProdList.size-1<=ID){
            ProdList.removeAt(ID)
            return -1
        }
        return 0
    }

}