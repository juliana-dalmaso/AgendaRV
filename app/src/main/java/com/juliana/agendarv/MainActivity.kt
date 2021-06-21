package com.juliana.agendarv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var pesquisaDigitada: EditText
    lateinit var lupa: Button
    lateinit var exibir: Button
    lateinit var cadastrar: Button
    lateinit var lista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesquisaDigitada = findViewById(R.id.edtPesquisar)
        lupa = findViewById(R.id.btnPesquisar)
        lista = findViewById(R.id.txtResultado)
        exibir = findViewById(R.id.btnExibir)
        cadastrar = findViewById(R.id.btnCadastrar)

        val contato : Contato? = intent.extras?.get(SecondActivity.CONTATO) as? Contato

        listaContato?.let {
            if (contato != null) {
                listaContato.add(contato)
                listaContato.sortBy {it.nome}
            }
        }

        cadastrar.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

//        lupa.setOnClickListener{
//
//            val pesquisar = pesquisaDigitada.text.toString()
//            //val resultado = listaContato.find{X -> X.nome == pesquisar}
//
//            var resultado = listaContato.filter{it.nome.contains(pesquisar)}
//
//            if (resultado != null) {
//                lista.adapter = ContatosAdapter(this, dataSet = resultado)
//                lista.layoutManager = LinearLayoutManager(this)
//
//            } else {
//                Toast.makeText(this,
//                    getString(R.string.semPesquisa),
//                    Toast.LENGTH_SHORT).show()
//            }
//
//            pesquisaDigitada.setText("")
//
//        }

        exibir.setOnClickListener{

            lista.adapter = ContatosAdapter(this, dataSet = listaContato)
            lista.layoutManager = LinearLayoutManager(this)

        }

    }

    companion object {
        var listaContato = mutableListOf<Contato>()
    }
}