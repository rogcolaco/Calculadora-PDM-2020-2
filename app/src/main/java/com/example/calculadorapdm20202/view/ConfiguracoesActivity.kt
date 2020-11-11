package com.example.calculadorapdm20202.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorapdm20202.Configuracoes
import com.example.calculadorapdm20202.R
import kotlinx.android.synthetic.main.activity_configuracoes.*

class ConfiguracoesActivity : AppCompatActivity() {

    /*REFERENCIA PARA UM OBJETO CONFIGURAÇÕES*/
    private lateinit var configuracoes: Configuracoes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        supportActionBar?.subtitle = "Tela de configuraçoes"

        /*RECUPERAR PARAMETRO QUE VEIO PELA INTENTE DO MAIN ACTIVITY*/
        configuracoes = intent.getParcelableExtra(MainActivity.EXTRA_CONFIGURACOES) ?: Configuracoes(false)
        tipoCalculadoraRg.check(if (configuracoes.avancada) R.id.avancadoRb else R.id.basicaRb)
    }

    fun onClick (view: View) {
        if(view.id == R.id.salvarBtn){
            /*ENVIAR CONFIGURAÇÃO PARA MAIN ACTIVITY*/
            configuracoes.avancada = avancadoRb.isChecked
            val resultadoIntent: Intent = Intent()
            resultadoIntent.putExtra(MainActivity.EXTRA_CONFIGURACOES,configuracoes)
            setResult(RESULT_OK, resultadoIntent)

        }
    }
}