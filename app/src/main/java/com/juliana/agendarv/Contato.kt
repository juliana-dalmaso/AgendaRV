package com.juliana.agendarv

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Contato (open val nome: String,
               open var celular: String,
               open val referencia: String) : Parcelable{

//    open fun exibir(): String {
//        return " $nome - $celular - $referencia \n"
//    }
}