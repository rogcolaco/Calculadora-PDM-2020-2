package com.example.calculadorapdm20202.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadorapdm20202.Configuracoes;
import com.example.calculadorapdm20202.R;

public class MainActivity extends AppCompatActivity {
    private TextView visorTv;
    private String value = "";
    private Boolean useColon = false;
    private Double result = null;
    private String op = null;

    private final int CALL_PHONE_PERMISSION_REQUEST_CODE = 0;
    private final int CONFIGURACOES_REQUEST_CODE = 1;

    public static final String EXTRA_CONFIGURACOES = "EXTRA_CONFIGURACOES";

    private final String VALOR_VISOR_TV = "VALOR_VISOR_TV";
    private final String OP = "OP";
    private final Boolean USE_COLON = false;
    private final String RESULT = "RESULT";

    private Configuracoes configuracoes = new Configuracoes(false);


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
            result = Double.parseDouble(savedInstanceState.getString(RESULT, null));
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
        outState.putString(RESULT, String.valueOf(result));
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

                /*Intent configuracoesIntent = new Intent(this, ConfiguracoesActivity.class);
                startActivity(configuracoesIntent);*/

                /*DEFININDO UMA ACTION PARTICULAR DO NOSSO APLICATIVO*/
                Intent configuracoesIntent = new Intent("CONFIGURACOES");
                configuracoesIntent.putExtra(EXTRA_CONFIGURACOES, configuracoes);
                startActivityForResult(configuracoesIntent, CONFIGURACOES_REQUEST_CODE);
                return true;

            case R.id.chamarIfspMi:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_PERMISSION_REQUEST_CODE);
                    }
                }
                chamarIfsp();
                return true;

            case R.id.siteIfspMi:
                /*DEFINIR URL*/
                Uri siteIfspUri = Uri.parse("https://ifsp.edu.br");
                Intent siteIfspIntent = new Intent(Intent.ACTION_VIEW, siteIfspUri);
                startActivity(siteIfspIntent);
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
                    result = result + Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("-")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = result - Double.parseDouble(value);

                } else {

                    fillVisor(String.valueOf(result).replace(".", ","));

                }
                op = getString(R.string.menos);
                limpaVisor();
                break;

            case R.id.multiplicaBtn:
                if (!visorTv.getText().toString().equals("") && result == null) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = 0.0;
                    result = result + Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("x")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = result * Double.parseDouble(value);

                } else {

                    fillVisor(String.valueOf(result).replace(".", ","));

                }
                op = getString(R.string.multiplica);
                limpaVisor();
                break;

            case R.id.divisaoBtn:
                if (!visorTv.getText().toString().equals("") && result == null) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = 0.0;
                    result = result + Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Double.parseDouble(value);

                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("/")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    try {
                        result = result / Double.parseDouble(value);
                    } catch (Exception e) {
                        fillVisor("Impossível divisão");
                        break;
                    }

                } else {

                    fillVisor(String.valueOf(result).replace(".", ","));

                }
                op = getString(R.string.divisao);
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

                        case "x":
                            value = visorTv.getText().toString().replace(",", ".");
                            result = result * Double.parseDouble(value);
                            break;

                        case "/":
                            value = visorTv.getText().toString().replace(",", ".");
                            try {
                                result = result / Double.parseDouble(value);
                            } catch (Exception e) {
                                fillVisor("Impossível divisão");
                                break;
                            }
                            break;
                    }


                }
                op = getString(R.string.igual);
                fillVisor(String.valueOf(result).replace(".", ","));
                break;


            case R.id.raizQuadradaBtn:
                if (!visorTv.getText().toString().equals("") && result == null) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = 0.0;
                    result = result + Double.parseDouble(value);
                    result = Math.sqrt(result);
                    fillVisor(String.valueOf(result));
                } else if (!visorTv.getText().toString().equals("") && result != null && op.equals("=")) {

                    value = visorTv.getText().toString().replace(",", ".");
                    result = Math.sqrt(result);
                    fillVisor(String.valueOf(result));
                }
                else {
                    fillVisor("0,0");
                }
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CALL_PHONE_PERMISSION_REQUEST_CODE) {
            for (int resultado : grantResults) {
                if (resultado != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permissão necessária não concedida", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            chamarIfsp();
        }
    }

    private void chamarIfsp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Uri chamarIfspUri = Uri.parse("tel:1137754501");
                Intent chamarIfspIntent = new Intent(Intent.ACTION_CALL, chamarIfspUri);
                startActivity(chamarIfspIntent);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONFIGURACOES_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            configuracoes = data.getParcelableExtra(EXTRA_CONFIGURACOES);
            if (configuracoes != null && configuracoes.getAvancada()) {
                findViewById(R.id.raizQuadradaBtn).setVisibility(View.VISIBLE);
            } else {
                findViewById(R.id.raizQuadradaBtn).setVisibility(View.GONE);
            }
        }
    }
}
