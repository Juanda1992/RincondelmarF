package com.example.rincondelmar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Isla> listadeIslas = new ArrayList<>();
    RecyclerView listadoGrafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listadoGrafico=findViewById(R.id.listado);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();
        ListaAdaptador adaptador = new ListaAdaptador(listadeIslas);
        listadoGrafico.setAdapter(adaptador);
    }

    private void crearLista(){

        listadeIslas.add(new Isla("Mucura",R.drawable.islote));
        listadeIslas.add(new Isla("Islote de Santa Cruz",R.drawable.islote));
        listadeIslas.add(new Isla("Tintipan",R.drawable.tintipan));
    }
}