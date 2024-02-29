package mx.edu.utch.test.View

import java.util.Dictionary

interface ICreateView {
    fun OnCreateSuccess(msg:String,prod_info:Map<String,String>)
    fun OnCreateError(msg:String)
    fun OnDeleteSuccess(msg:String)
    fun OnDeleteError(msg:String)
}