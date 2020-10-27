package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private TextView visorTv;
    private String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo de vida completo");
        setContentView(R.layout.activity_main);

        visorTv=findViewById(R.id.visorTv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name), "onStart executado - iniciado ciclo de vida visível");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name), "onResume executado - iniciado ciclo de vida em primeiro plano");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name), "onPause executado - finalizado ciclo de vida em primeiro plano");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getString(R.string.app_name), "onStop executado - Finalizado ciclo de vida visível");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getString(R.string.app_name), "onDestroy executado - Finalizado ciclo de vida completo");
    }

    public void fillVisor(String s){
        visorTv.setText(s);
    }

    public void onClick(View view){
        switch ((view.getId())) {
            case R.id.zeroBtn:
                if (!value.equals("")) {
                    value = value + (getString(R.string.zero));
                    fillVisor(value);
                }
                break;
            case R.id.umBtn:
                value = value+(getString(R.string.um));
                fillVisor(value);
                break;
            case R.id.doisBtn:
                value = value+(getString(R.string.dois));
                fillVisor(value);
                  break;
            case R.id.tresBtn:
                value = value+(getString(R.string.tres));
                fillVisor(value);
                break;
            case R.id.quatroBtn:
                value = value+(getString(R.string.quatro));
                fillVisor(value);
                break;
            case R.id.cincoBtn:
                value = value+(getString(R.string.cinco));
                fillVisor(value);
                break;
            case R.id.seisBtn:
                value = value+(getString(R.string.seis));
                fillVisor(value);
                break;
            case R.id.seteBtn:
                value = value+(getString(R.string.sete));
                fillVisor(value);
                break;
            case R.id.oitoBtn:
                value = value+(getString(R.string.oito));
                fillVisor(value);
                break;
            case R.id.noveBtn:
                value = value+(getString(R.string.nove));
                fillVisor(value);
                break;
            case R.id.limparBtn:
                value = "";
                fillVisor(value);
                break;
        }

    }
}