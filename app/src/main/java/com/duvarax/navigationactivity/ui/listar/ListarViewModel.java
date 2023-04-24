package com.duvarax.navigationactivity.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListarViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> nuevaNota;


    public ListarViewModel() {

    }

    public LiveData<ArrayList<String>> getNotas(){
        if(nuevaNota == null){
            nuevaNota = new MutableLiveData<>();
        }
        return nuevaNota;
    }

    public void setNota(ArrayList<String> notas){
        if(notas.size() > 0){
            nuevaNota.setValue(notas);
        }
    }

}