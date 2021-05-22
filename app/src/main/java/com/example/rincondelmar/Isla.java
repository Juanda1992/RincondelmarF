package com.example.rincondelmar;

import java.io.Serializable;

public class Isla implements Serializable {

    String nombreIsla;
    int fotoIsla;

    public Isla(String nombreIsla, int fotoIsla) {
        this.nombreIsla = nombreIsla;
        this.fotoIsla = fotoIsla;
    }

    public String getNombreIsla() {
        return nombreIsla;
    }

    public void setNombreIsla(String nombreIsla) {
        this.nombreIsla = nombreIsla;
    }

    public int getFotoIsla() {
        return fotoIsla;
    }

    public void setFotoIsla(int fotoIsla) {
        this.fotoIsla = fotoIsla;
    }
}
