package com.a1922is_tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public SharedPreferences configurar;
    public TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prueba=(TextView) findViewById(R.id.prueba);
        consumoApi apis = new consumoApi();
        String temp=apis.accederApi("POST","name","results");
        prueba.setText(temp);
        //consultarPreferencias();
    }

    public void consultarPreferencias() {
        configurar = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        String idFalco;
        idFalco = configurar.getString("idFalco", "");
        if (idFalco.length() == 0) {
            SharedPreferences.Editor editar = configurar.edit();
            editar.putString("idFalco", "Id wapo");
            editar.commit();
            Toast.makeText(MainActivity.this, "Id Falquito agregado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, idFalco + " UWU", Toast.LENGTH_SHORT).show();
            prueba.setText(idFalco);
        }
    }
}