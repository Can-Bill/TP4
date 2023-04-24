package com.example.tp4;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.tp4.databinding.ActivityInfosBinding;

public class TP4Application extends Application {

    private int nombre;
    private int compteur;


    @Override
    public void onCreate(){
        super.onCreate();
        this.compteur = 0;

    }

    public int getNombre() {
        return nombre;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }


}
