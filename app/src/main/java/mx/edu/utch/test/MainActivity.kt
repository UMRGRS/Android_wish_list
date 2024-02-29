package mx.edu.utch.test


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import mx.edu.utch.test.Controller.CreateController
import mx.edu.utch.test.Model.Product
import mx.edu.utch.test.Model.ProductsList
import mx.edu.utch.test.View.ICreateView
import java.util.Dictionary


class MainActivity : AppCompatActivity(),ICreateView,OnClickListener {
    var linear:LinearLayout?=null

    private var prod_name: AppCompatEditText? = null
    private var prod_price:AppCompatEditText? = null

    private var scroll:LinearLayout? = null

    private var save_prod:Button? = null
    private var cancel:Button? = null

    private var model:ProductsList? = null
    private var controller:CreateController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear = findViewById(R.id.products_box)

        model = ProductsList(mutableListOf<Product>())

        prod_name = findViewById(R.id.prod_name)
        prod_price = findViewById(R.id.prod_price)

        save_prod = findViewById(R.id.saveButton)
        cancel = findViewById(R.id.cancelButton)

        scroll = findViewById(R.id.products_box)

        controller = CreateController()

        save_prod!!.setOnClickListener(this)
        cancel!!.setOnClickListener(this)
    }

    override fun OnCreateSuccess(msg: String, prod_info: Map<String, String>) {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.prod_template, null)
        val name:TextView = view.findViewById(R.id.name)
        val price:TextView = view.findViewById(R.id.price)
        val delButton:Button = view.findViewById(R.id.delete_button)
        delButton.setOnClickListener(this)
        delButton.tag = prod_info["id"]
        view.tag = prod_info["id"]
        name.text = prod_info["name"]
        price.text = prod_info["price"]

        linear!!.addView(view)

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun OnCreateError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun OnDeleteSuccess(msg: String,) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun OnDeleteError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        if(v!=null){
            if(R.id.saveButton == v.id){
                controller!!.OnCreateProduct(model,this,prod_name!!.text.toString(),prod_price!!.text.toString())
            }
            else if(R.id.cancelButton == v.id){
                prod_name!!.text!!.clear()
                prod_price!!.text!!.clear()
            }
            else{
                for (i in 0 until linear!!.childCount) {
                    val child = linear!!.getChildAt(i)
                    if (child.tag == v.tag) {
                        controller!!.OnDeleteProduct(model,this,v.tag.toString())
                        linear!!.removeView(child)
                        break
                    }
                }

            }
        }
    }
}