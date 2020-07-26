package com.rogerioisj.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editPrecoAlcool;
    EditText editPrecoGasolina;

    TextView resultadoCalculo;

    String precoAlcool;
    String precoGasolina;

    Double precoAlcoolConvertido;
    Double precoGasolinaConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaCampos();
    }

    private void converteValores() {
        precoAlcool = editPrecoAlcool.getText().toString();
        precoGasolina = editPrecoGasolina.getText().toString();

        precoAlcoolConvertido = Double.parseDouble(precoAlcool);
        precoGasolinaConvertido = Double.parseDouble(precoGasolina);
    }

    private void inicializaCampos() {
        editPrecoAlcool = findViewById(R.id.preco_alcool);
        editPrecoGasolina = findViewById(R.id.preco_gasolina);

        resultadoCalculo = findViewById(R.id.texto_pos_calculo);
    }

    public void calcula(View view) {
        if(validarCampos(editPrecoAlcool.getText().toString(), editPrecoGasolina.getText().toString())){
            converteValores();
            calculaDivisaoAlcoolGasolina();
        } else {
            resultadoCalculo.setText("Campos nao preenchidos");
        }
        System.out.println("Alcool = " + precoAlcoolConvertido + ", " + precoAlcool);
        System.out.println("Gasolina = " + precoGasolinaConvertido + ", " + precoGasolina);
    }

    public boolean validarCampos(String alcool, String gasolina){

        System.out.println("Alcool em validacao: " + alcool);
        System.out.println("Alcool em validacao: " + gasolina);

        if(alcool == null || alcool.equals("") || gasolina == null || gasolina.equals("")){
            return false;
        } else {
            return true;
        }
    }

    public void calculaDivisaoAlcoolGasolina(){
        if(precoAlcoolConvertido/precoGasolinaConvertido >= 0.7){
            resultadoCalculo.setText("Melhor usar gasolina");
        } else{
            resultadoCalculo.setText("Melhor usar alcool");
        }
    }
}