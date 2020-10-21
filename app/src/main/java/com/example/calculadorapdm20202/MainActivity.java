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
        setContentView(R.layout.activity_main);

        visorTv=findViewById(R.id.visorTv);
    }

    public void fillVisor(String s){
        visorTv.setText(s);
    }

    public void onClick(View view){
        switch ((view.getId())) {
            case R.id.zeroBtn:
                value = value+(getString(R.string.zero));
                fillVisor(value);
                //visorTv.setText(getString(R.string.zero));
                //Log.v(getString(R.string.app_name),getString(R.string.zero));
                break;
            case R.id.umBtn:
                value = value+(getString(R.string.um));
                fillVisor(value);
                //visorTv.setText(getString(R.string.um));
                break;
            case R.id.doisBtn:
                value = value+(getString(R.string.dois));
                fillVisor(value);
                //visorTv.setText(getString(R.string.dois));
                break;
            case R.id.limparBtn:
                value = "";
                fillVisor(value);
                break;
        }

    }
}