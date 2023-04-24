package com.duvarax.navigationactivity.ui.cargar;

import static com.duvarax.navigationactivity.NavigationActivity.notas;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.duvarax.navigationactivity.R;
import com.duvarax.navigationactivity.databinding.FragmentCargarBinding;
import com.duvarax.navigationactivity.ui.listar.ListarViewModel;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel mv;
    private ListarViewModel fm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(CargarViewModel.class);
        mv.getNuevaNota().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String nota) {
                notas.add(nota);
                binding.etNota.setText("");

            }
        });

        binding.btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.setNuevaNota(binding.etNota.getText()+"");
            }
        });

        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}