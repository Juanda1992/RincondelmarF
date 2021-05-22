package com.example.rincondelmar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView frase;

Isla isla;

ImageView fotoIsla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frase.findViewById(R.id.frasePrueba);
        fotoIsla.findViewById(R.id.logotipo);

        isla = (Isla)getIntent().getSerializableExtra("datosIsla");

        fotoIsla.setImageResource(isla.getFotoIsla());

    }
}