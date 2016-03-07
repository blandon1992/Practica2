package com.joseblandon.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Punto3 extends AppCompatActivity {
    int operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);

        final TextView var1 = (TextView) findViewById(R.id.eVar1);
        final EditText val_var1 = (EditText) findViewById(R.id.eVal_Var1);
        final TextView var2 = (TextView) findViewById(R.id.eVar2);
        final TextView val_var2 = (TextView) findViewById(R.id.eVal_Var2);
        final TextView eResultado = (TextView) findViewById(R.id.eResultado);
        RadioGroup rgFigura = (RadioGroup) findViewById(R.id.eFigura);
        final Button bCalcular = (Button) findViewById(R.id.bCalcular);

        bCalcular.setEnabled(false);
        rgFigura.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bCalcular.setEnabled(true);
                switch (checkedId) {
                    case R.id.rbCuadrado:
                        val_var2.setEnabled(false);
                        var1.setText("LADO :  ");
                        var2.setText("");
                        val_var2.setText("");
                        operacion = 1;
                        break;
                    case R.id.rbRectangulo:
                        val_var2.setEnabled(true);
                        var1.setText("BASE:  ");
                        var2.setText("ALTURA:  ");
                        operacion = 1;
                        break;
                    case R.id.rbTriangulo:
                        val_var2.setEnabled(true);
                        var1.setText("BASE:  ");
                        var2.setText("ALTURA:  ");
                        operacion = 2;
                        break;
                    case R.id.rbCirculo:
                        val_var2.setEnabled(false);
                        var1.setText("RADIO:  ");
                        var2.setText("");
                        val_var2.setText("");
                        operacion = 3;
                        break;
                }
            }
        });

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double operando1, operando2, resultado = 0;
                String op1="",op2="";

                op1=val_var1.getText().toString();
                op2=val_var2.getText().toString();
                if(((op1.equals(""))||(op2.equals("")))&&((operacion != 1)||(op1.equals(""))) && ((operacion !=3)||(op1.equals("")))){
                    eResultado.setText("Por favor ingresar todos los datos");
                }
                else{
                switch (operacion) {
                    case 1: //area cuadrado y rectangulo
                        operando1 = operando2= Double.parseDouble(val_var1.getText().toString());
                        resultado = operando1*operando1;
                        break;
                    case 2: //triangulo
                        operando1 = Double.parseDouble(val_var1.getText().toString());
                        operando2 = Double.parseDouble(val_var2.getText().toString());
                        resultado = (operando1*operando2)/2;
                        break;
                    case 3://circulo
                        operando1 = Double.parseDouble(val_var1.getText().toString());
                        resultado = operando1*operando1*(3.14);
                        break;
                }
                eResultado.setText("RESULTADO:  " + resultado);
            }

            }
        });
    }
}
