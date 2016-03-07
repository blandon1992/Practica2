package com.joseblandon.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Punto2 extends AppCompatActivity {
int operacion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);

        final EditText eOperando1 = (EditText) findViewById(R.id.eOperando1);
        final EditText eOperando2 = (EditText) findViewById(R.id.eOperando2);
        final TextView eResultado = (TextView) findViewById(R.id.eResultado);
        final Button bCalcular = (Button) findViewById(R.id.bCalcular);
        RadioGroup rgOperacion = (RadioGroup) findViewById(R.id.eOperacion);

        bCalcular.setEnabled(false);
        rgOperacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bCalcular.setEnabled(true);
                switch(checkedId) {
                    case R.id.rbSuma:
                        operacion = 1;
                        break;
                    case R.id.rbResta:
                        operacion = 2;
                        break;
                    case R.id.rbMultiplicacion:
                        operacion = 3;
                        break;
                    case R.id.rbDivision:
                        operacion = 4;
                        break;
                }
            }
        });

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double operando1 = 0, operando2 = 0, resultado = 0;
                String op1 = "", op2 = "";
                op1 = eOperando1.getText().toString();
                op2 = eOperando2.getText().toString();
                if ((op1.equals("")) || (op2.equals(""))) {
                    eResultado.setText("Por favor ingresar todos los datos");
                }
                else {
                    operando1 = Double.parseDouble(eOperando1.getText().toString());
                    operando2 = Double.parseDouble(eOperando2.getText().toString());


                    switch (operacion) {
                        case 1:
                            resultado = operando1 + operando2;
                            break;
                        case 2:
                            resultado = operando1 - operando2;
                            break;
                        case 3:
                            resultado = operando1 * operando2;
                            break;
                        case 4:
                            resultado = operando1 / operando2;
                    }
                    if ((operando2 == 0) && (operacion == 4)) {
                        eResultado.setText("ERROR: DIVISION POR CERO");
                    } else
                        eResultado.setText("RESULTADO:  " + resultado);
                }

            }
        });
    }
}
