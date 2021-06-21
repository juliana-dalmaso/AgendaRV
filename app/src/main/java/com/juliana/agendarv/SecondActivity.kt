package com.juliana.agendarv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {

    var nomeDigitado: EditText? = null
    var celularDigitado: EditText? = null
    lateinit var referenciaDigitada: EditText
    lateinit var salvar: Button
    lateinit var rdgSetor: RadioGroup
    lateinit var pessoal: RadioButton
    lateinit var setorSelecionado: Setor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        nomeDigitado = findViewById(R.id.edtNome)
        celularDigitado = findViewById(R.id.edtCelular)
        rdgSetor = findViewById(R.id.rdgSetor)
        pessoal = findViewById(R.id.rdPessoal)
        referenciaDigitada = findViewById(R.id.edtReferencia)
        salvar = findViewById(R.id.btnSalvar)

        salvar.setOnClickListener {

            val nome = nomeDigitado?.text.toString()
            if (nome.isEmpty())  nomeDigitado?.error= getString(R.string.semInformacao)
            val celular = celularDigitado?.text.toString()
            if (celular.isEmpty())  celularDigitado?.error=getString(R.string.semInformacao)

            val intent = Intent(this,MainActivity::class.java)

            if(!(nome.isEmpty() || (celular.isEmpty()))){

                val referencia = referenciaDigitada.text.toString()
                val ctt = Contato(nome.toUpperCase(), celular, referencia)
                intent.putExtra(CONTATO, ctt)
                startActivity(intent)
            }else{
                Toast.makeText(this,
                    getString(R.string.informacaoo),
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {

            val foiChecado = view.isChecked

            when (view.id) {

                R.id.rdPessoal ->
                    if (foiChecado) {
                        setorSelecionado = Setor.PESSOAL
                        referenciaDigitada.setHint(getString(R.string.referencia))
                        referenciaDigitada.setInputType(InputType.TYPE_CLASS_TEXT)
                    }

                R.id.rdTrabalho ->
                    if (foiChecado) {
                        setorSelecionado = Setor.TRABALHO
                        referenciaDigitada.setHint(getString(R.string.email))
                        referenciaDigitada.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
                    }
            }

        }
    }

    companion object {
        val CONTATO = "Contato"
    }
}