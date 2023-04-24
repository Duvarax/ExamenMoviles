package com.duvarax.navigationactivity.ui.cargar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.duvarax.navigationactivity.R;

public class CargarViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> nuevaNota;
    public CargarViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getNuevaNota(){
        if(nuevaNota == null){
            nuevaNota = new MutableLiveData<>();
        }
        return nuevaNota;
    }

    public void setNuevaNota(String nota){
        if(nota.length() > 0){

            nuevaNota.setValue(nota);
            Toast.makeText(context, "Nota agregada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Nota no puede estar vacio", Toast.LENGTH_LONG).show();
        }
    }
}