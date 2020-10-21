package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView visorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visorTv=findViewById(R.id.visorTv);
    }

    public void onClick(View view){
        switch ((view.getId())) {
            case R.id.zeroBtn:
                visorTv.setText(getString(R.string.zero));
                Log.v(getString(R.string.app_name),getString(R.string.zero));
                break;
            case R.id.umBtn:
                visorTv.setText(getString(R.string.um));
                break;
            case R.id.doisBtn:
                visorTv.setText(getString(R.string.dois));
                break;
            case R.id.limparBtn:
                visorTv.setText(" ");
                break;
        }

    }
}