package com.example.calculoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    lateinit var pesoInformado : TextView;
    lateinit var alturaInformada : TextView;
    lateinit var resultado : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        pesoInformado = findViewById(R.id.text_peso);
        alturaInformada = findViewById(R.id.text_altura);
        resultado = findViewById(R.id.text_resultado);

        val bundle = intent.extras;
        if(bundle!= null) {
            val peso = bundle.getDouble("peso");
            val altura = bundle.getDouble("altura");

            pesoInformado.text = "Peso informado: $peso";
            alturaInformada.text = "Altura informada: $altura";

            val imc = peso/(altura *altura);
            if(imc < 18.5) {
                resultado.text = "Baixo"
            }
            else if(imc in 18.5..24.9  ) {
                resultado.text = "Normal";
            }
            else if(imc in 25.0..29.9) {
                resultado.text = "Sobrepeso";
            }
            else {
                resultado.text = "Obesidade";
            }
        }
    }
}