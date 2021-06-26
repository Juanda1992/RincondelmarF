package com.example.rincondelmar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<Isla> listadeIslas = new ArrayList<>();
    RecyclerView listadoGrafico;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listadoGrafico=findViewById(R.id.listado);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();

    }

    //Encargada de cambiar la configuracion del idioma del telefono
    public void cambiarIdioma(String lenguaje){
        Locale idioma = new Locale(lenguaje); //Tipo de datos que recibe el lenguaje a configuarar el telefono
        Locale.setDefault(idioma); //Se establece el lenguaje del telefono

        Configuration configuraciontelefono = getResources().getConfiguration();
        configuraciontelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuraciontelefono,getBaseContext().getResources().getDisplayMetrics());
    }

    //Metodo encargado de pintar el menu de opciones
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;

    }

    //Metodo para controlar la accion de cada menu (lO QUE QUIERO HACER)
    public boolean onOptionsItemSelected(MenuItem item){

        int id= item.getItemId();

        switch (id){
            case(R.id.opcion1):

                Intent intent1= new Intent(Home.this,Acercade.class);
                startActivity(intent1);

                break;

            case(R.id.opcion2):

                cambiarIdioma("en");
                Intent intent2= new Intent(Home.this,Home.class);
                startActivity(intent2);

                break;

            case(R.id.opcion3):

                cambiarIdioma("es");
                Intent intent3= new Intent(Home.this,Home.class);
                startActivity(intent3);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void crearLista(){

        baseDatos.collection("islas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String isla=document.get("isla").toString();
                                String foto=document.get("foto").toString();

                                listadeIslas.add(new Isla (foto,isla));
                            }

                            ListaAdaptador adaptador = new ListaAdaptador(listadeIslas);
                            listadoGrafico.setAdapter(adaptador);

                        }else {

                            Toast.makeText(Home.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        //listadeIslas.add(new Isla("Mucura",R.drawable.islote));
        //listadeIslas.add(new Isla("Islote de Santa Cruz",R.drawable.islote));
        //listadeIslas.add(new Isla("Tintipan",R.drawable.tintipan));
    }
}