package com.manuelcanul.magakalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup contenedorRadios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedorRadios = (RadioGroup)findViewById(R.id.radiosOperaciones);
        contenedorRadios.check(R.id.radioSuma);

        contenedorRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView operador = (TextView)findViewById(R.id.textoOperador);
                //CALCULANDO EL RESULTADO
                switch (contenedorRadios.getCheckedRadioButtonId()){
                    case R.id.radioSuma:
                        operador.setText("+");
                        break;
                    case R.id.radioResta:
                        operador.setText("-");
                        break;
                    case R.id.radioMultiplicacion:
                        operador.setText("*");
                        break;
                    case R.id.radioDivision:
                        operador.setText("/");
                        break;
                }
            }
        });
    }

    public void onClickOperar(View v){
        EditText numeroA, numeroB;
        int a, b, resultado = 0;


        numeroA = (EditText)findViewById(R.id.editNumeroX);
        numeroB= (EditText)findViewById(R.id.editNumeroY);

        a = Integer.parseInt(numeroA.getText().toString());
        b = Integer.parseInt(numeroB.getText().toString());
        /*
        if (TextUtils.isEmpty(a1) || TextUtils.isEmpty(a2)) {
            Toast.makeText(this, "Ha dejado campos vacios",
                    Toast.LENGTH_LONG).show();
        }
        else{*/
            //CALCULANDO EL RESULTADO
            switch (contenedorRadios.getCheckedRadioButtonId()){
                case R.id.radioSuma:
                    resultado= a + b;
                    break;
                case R.id.radioResta:
                    resultado= a - b;
                    break;
                case R.id.radioMultiplicacion:
                    resultado= a * b;
                    break;
                case R.id.radioDivision:
                    resultado= a / b;
                    break;
            }


        ((TextView)findViewById(R.id.textoResultado)).setText(String.valueOf(resultado));
    }
}
