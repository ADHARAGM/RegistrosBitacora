package com.example.registrosbitacora.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.registrosbitacora.R

class DialogAlert(val context: Context,val title:String?, val descrip:String?){//, val positiveButton:()->Unit, val positiveButtonText:String?){
    constructor(builder: Builder): this(
        context=builder.context,
        title=builder.title,
        descrip=builder.description
        //positiveButton=builder.positiveButton,
        //positiveButtonText=builder.positiveButtonText
    )
    init{
        AlertDialog.Builder(context, R.style.alertDialog)
            .setTitle(title)
            .setMessage(descrip)
            .setCancelable(true)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()

    }
    companion object{
         inline fun alertShow(block: Builder.() ->Unit) = Builder().apply(block)
    }

}
class Builder(){
    lateinit var context:Context
    var title:String?=null;
    var description:String?=null
}

fun <T> LiveData<T>.observeOnce(observer: Observer<T>) {
    observeForever( object : Observer<T> {
        override fun onChanged(value: T) {
            observer.onChanged(value)
            removeObserver(this)
        }
    })
}