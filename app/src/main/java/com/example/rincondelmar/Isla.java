package com.example.rincondelmar;

import java.io.Serializable;

public class Isla implements Serializable {

    String nombreIsla,fotoIsla;
    //int fotoIsla;

    public Isla(String nombreIsla, String fotoIsla) {
        this.nombreIsla = nombreIsla;
        this.fotoIsla = fotoIsla;
    }

    public String getNombreIsla() {
        return nombreIsla;
    }

    public void setNombreIsla(String nombreIsla) {
        this.nombreIsla = nombreIsla;
    }

    public String getFotoIsla() {
        return fotoIsla;
    }

    public void setFotoIsla(String fotoIsla) {
        this.fotoIsla = fotoIsla;
    }
}
