package com.juliana.agendarv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContatosAdapter(val context: Context, var dataSet: MutableList<Contato>) :
    RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nome = view.findViewById<TextView>(R.id.itemNome)
        val celular = view.findViewById<TextView>(R.id.itemCelular)
        val referencia = view.findViewById<TextView>(R.id.itemReferencia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val instanciaView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(instanciaView)
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        holder.nome.text = dataSet[position].nome
        holder.celular.text = dataSet[position].celular
        holder.referencia.text = dataSet[position].referencia
    }

    override fun getItemCount(): Int = dataSet.size

}