package com.joseblandon.punto4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Punto4 extends AppCompatActivity {
    int okrg=0,okspinner=0,ano,mes,dia;
    String sexo="",ciudad="",user="",contra="",rcontra="",mail="",hb1="",hb2="",hb3="",hb4="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        final EditText usuario= (EditText) findViewById(R.id.etUsuario);
        final EditText pass= (EditText) findViewById(R.id.etContrasena);
        final EditText retry= (EditText) findViewById(R.id.etRepetir);
        final EditText correo= (EditText) findViewById(R.id.etCorreo);
        final DatePicker fecha = (DatePicker) findViewById(R.id.dp01);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final RadioGroup rgSexo = (RadioGroup) findViewById(R.id.rdSexo);
        final Button bAceptar = (Button) findViewById(R.id.bAceptar);
        final TextView mostrar1 = (TextView) findViewById(R.id.tvMostrar1);
        final TextView mostrar2 = (TextView) findViewById(R.id.tvMostrar2);
        final TextView mostrar3 = (TextView) findViewById(R.id.tvMostrar3);
        final TextView mostrar4 = (TextView) findViewById(R.id.tvMostrar4);
        final TextView mostrar5 = (TextView) findViewById(R.id.tvMostrar5);
        final TextView mostrar6 = (TextView) findViewById(R.id.tvMostrar6);
        final TextView mostrar7 = (TextView) findViewById(R.id.tvMostrar7);
        final TextView mostrar8 = (TextView) findViewById(R.id.tvMostrar8);
        final CheckBox cbtv = (CheckBox) findViewById(R.id.cbtv);
        final CheckBox cbcomer = (CheckBox) findViewById(R.id.cbComer);
        final CheckBox cbestudiar = (CheckBox) findViewById(R.id.cbEstudiar);
        final CheckBox cbotro = (CheckBox) findViewById(R.id.cbOtro);
        //Obtener valores del radio group
        rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                okrg=1;
                switch(checkedId){
                    case R.id.rbFem:
                        sexo="Femenino";
                        break;

                    case R.id.rbMasc:
                        sexo="Masculino";
                }


            }

        });

            //Creacion del Spinner
            String[] valores = {"","Arauca", "Armenia", "Barranquilla", "Bogota", "Bucaramanga", "Cali", "Cartagena", "Cúcuta", "Florencia", "Ibagué", "Inírida", "Leticia", "Manizales", "Medellin", "Monteria", "Mitú", "Mocoa", "Neiva", "Pasto", "Pereira", "Popayán", "Puerto Carreño", "Quibdo", "Riohacha", "San Andrés", "San José del Guaviare", "Santa Marta", "Sincelejo", "Tunja", "Valledupar", "Villavicencio", "Yopal"};
            spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

                                              {

                                                  @Override
                                                  public void onItemSelected(AdapterView<?> adapterView, View view, int position,
                                                                             long id) {
                                                      ciudad = (String) adapterView.getItemAtPosition(position);
                                                      okspinner = 1;
                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {
                                                      // vacio

                                                  }
                                              }

            );

        //Hobbies

        cbtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean cb = ((CheckBox) v ).isChecked();
                if(cb){
                    hb1="Tv";
                }
                else hb1="";
            }
        });

        cbcomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean cb = ((CheckBox) v ).isChecked();
                if(cb){
                    hb2="Comer";
                }
                else hb2="";
            }
        });

        cbestudiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean cb = ((CheckBox) v ).isChecked();
                if(cb){
                    hb3="Estudiar";
                }
                else hb3="";
            }
        });

        cbotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                boolean cb = ((CheckBox) v ).isChecked();
                if(cb){
                    hb4="Otro";
                }
                else hb4="";
            }
        });

            bAceptar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    ano=fecha.getYear();
                    mes=fecha.getMonth()+1;
                    dia=fecha.getDayOfMonth();
                    user=String.valueOf(usuario.getText());
                    contra=String.valueOf(pass.getText());
                    rcontra=String.valueOf(retry.getText());
                    mail=String.valueOf(correo.getText());

                    if((okspinner == 0) || (okrg == 0) || (user.equals("")) || (contra.equals(""))|| (rcontra.equals("")) || (mail.equals("")) || (ciudad.equals("")) || ((hb1 == "")&&(hb2 == "")&&(hb3 == "")&&(hb4 == ""))){
                        mostrar1.setText("Por favor completar todos los campo");
                    }
                    else{
                        if(!contra.equals(rcontra)){
                            mostrar1.setText("Las contraseñas son diferentes");
                        }
                        else{
                            mostrar1.setText("Usuario:"+user);
                            mostrar2.setText("Contraseña: " +contra);
                            mostrar3.setText("Repertir: "+rcontra);
                            mostrar4.setText("Correo: "+mail);
                            mostrar5.setText("Sexo: " +sexo);
                            mostrar6.setText("Fecha de nacimiento: " +dia+"/"+mes+"/"+ano);
                            mostrar7.setText("Ciudad de origen: " +ciudad);
                            mostrar8.setText("Hobbies: " +hb1+" "+hb2+" "+hb3+" "+hb4);
                        }
                    }
                }
            });

        }
    }
