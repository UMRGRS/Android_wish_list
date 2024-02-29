package mx.edu.utch.test.Model

import android.text.TextUtils

class Product (private var ID:Int, private var name:String, private var price:String):IProduct{
    override fun GetID(): Int {
        return ID
    }

    override fun GetName(): String {
        return name
    }

    override fun GetPrice(): String {
        return price
    }

    override fun isValid(): Int {
        if(TextUtils.isEmpty(GetName())) return 0
        if(TextUtils.isEmpty(GetPrice())) return 1

        return -1
    }

}