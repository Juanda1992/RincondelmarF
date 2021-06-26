package com.example.rincondelmar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListaAdaptador  extends RecyclerView.Adapter<ListaAdaptador.viewHolder> {

    ArrayList<Isla> listadeDatos;

    public ListaAdaptador(ArrayList<Isla> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public ListaAdaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItamLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);
        return new viewHolder(vistaDelItamLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdaptador.viewHolder holder, int position) {
    holder.actualizarDatos(listadeDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView nombreIsla;
        ImageView fotoIsla;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombreIsla=itemView.findViewById(R.id.nameisla);
            fotoIsla=itemView.findViewById(R.id.photoIsla);
        }

        public void actualizarDatos(final Isla isla) {
            nombreIsla.setText(isla.getNombreIsla());
            //fotoIsla.setImageResource(isla.getFotoIsla());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("datosIsla",isla);
                    itemView.getContext().startActivity(intent);

                    Picasso.with(itemView.getContext())
                            .load(isla.getFotoIsla())
                            .into(fotoIsla);
                }
            });
        }
    }
}
