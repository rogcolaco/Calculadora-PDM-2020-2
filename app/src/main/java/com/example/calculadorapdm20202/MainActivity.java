package com.example.calculadorapdm20202;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView visorTv;
    private String value = "";
    private Boolean useColon = false;
    //private Double number = 0.0;
    private Double result = null;
    private String op = null;

    private final String VALOR_VISOR_TV = "VALOR_VISOR_TV";
    private final String OP = "OP";
    private final Boolean USE_COLON = false;
    private final Double RESULT = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v(getString(R.string.app_name), "onCreate executado - iniciado ciclo de vida completo");
        setContentView(R.layout.activity_main);

        visorTv = findViewById(R.id.visorTv);

        if (savedInstanceState != null) {
            visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV, ""));
            value = savedInstanceState.getString(VALOR_VISOR_TV, "");
            useColon = savedInstanceState.getBoolean(String.valueOf(USE_COLON), false);
            result = savedInstanceState.getDouble(String.valueOf(RESULT), 0.0);
            op = savedInstanceState.getString(OP, null);
        }

        getSupportActionBar().setSubtitle("Tela Principal");
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(getString(R.string.app_name), "onSaveInstanceState executado - salvando dados de instancia");
        outState.putString(VALOR_VISOR_TV, visorTv.getText().toString());
        outState.putString(OP, op);
        outState.putBoolean(String.valueOf(USE_COLON), useColon);
        outState.putDouble(String.valueOf(RESULT), result);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(getString(R.string.app_name), "onRestoreInstanceState executado - restaurando dados de instancia");
        //visorTv.setText(savedInstanceState.getString(VALOR_VISOR_TV,""));
        //value = savedInstanceState.getString(VALOR_VISOR_TV,"");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.configuracoesMi:
                Intent configuracoesIntent = new Intent(this, ConfiguracoesActivity.class);
                startActivity(configuracoesIntent);
                return true;

            case R.id.sairMi:
                finish();
                return true;

            default:
                return false;
        }
    }

    public void fillVisor(String s) {
        visorTv.setText(s);
    }

    public void limpaVisor() {
        value = "";
        fillVisor(value);
    }

    public void onClick(View view) {
        switch ((view.getId())) {
            case R.id.zeroBtn:
                if (!value.equals("")) {
                    value = value + (getString(R.string.zero));
                    fillVisor(value);
                }
                break;
            case R.id.umBtn:
                value = value + (getString(R.string.um));
                fillVisor(value);
                break;
            case R.id.doisBtn:
                value = value + (getString(R.string.dois));
                fillVisor(value);
                break;
            case R.id.tresBtn:
                value = value + (getString(R.string.tres));
                fillVisor(value);
                break;
            case R.id.quatroBtn:
                value = value + (getString(R.string.quatro));
                fillVisor(value);
                break;
            case R.id.cincoBtn:
                value = value + (getString(R.string.cinco));
                fillVisor(value);
                break;
            case R.id.seisBtn:
                value = value + (getString(R.string.seis));
                fillVisor(value);
                break;
            case R.id.seteBtn:
                value = value + (getString(R.string.sete));
                fillVisor(value);
                break;
            case R.id.oitoBtn:
                value = value + (getString(R.string.oito));
                fillVisor(value);
                break;
            case R.id.noveBtn:
                value = value + (getString(R.string.nove));
                fillVisor(value);
                break;
            case R.id.limparBtn:
                value = "";
                useColon = false;
                result = null;
                op = null;
                fillVisor(value);
                break;

            case R.id.virgulaBtn:
                if (!useColon && value.equals("")) {
                    value = getString(R.string.zero) + getString(R.string.virgula);
                    fillVisor(value);
                    useColon = true;
                } else if (!useColon) {
                    value = value + getString(R.string.virgula);
                    fillVisor(value);
                    useColon = true;
                }
                break;

            case R.id.maisBtn:
                if (!visorTv.getText().toString().equals("") && result == null) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = 0.0;
                    result = result + Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("+")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = result + Double.parseDouble(value);

                } else {

                    fillVisor(String.valueOf(result).replace(".", ","));

                }
                op = getString(R.string.mais);
                limpaVisor();
                break;

            case R.id.menosBtn:
                if (!visorTv.getText().toString().equals("") && result == null) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = 0.0;
                    result = result - Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("+")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = result - Double.parseDouble(value);

                } else {

                    fillVisor(String.valueOf(result).replace(".", ","));

                }
                op = getString(R.string.menos);
                limpaVisor();
                break;

            case R.id.igualBtn:

                if (!visorTv.getText().toString().equals("")) {
                    switch (op) {
                        case "+":
                            value = visorTv.getText().toString().replace(",", ".");
                            result = result + Double.parseDouble(value);
                            break;

                        case "-":
                            value = visorTv.getText().toString().replace(",", ".");
                            result = result - Double.parseDouble(value);
                            break;
                    }


                }
                op = getString(R.string.igual);
                fillVisor(String.valueOf(result).replace(".", ","));
                break;

        }

    }
}