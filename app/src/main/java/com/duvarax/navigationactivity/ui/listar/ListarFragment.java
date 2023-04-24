package com.duvarax.navigationactivity.ui.listar;

import static com.duvarax.navigationactivity.NavigationActivity.notas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.duvarax.navigationactivity.databinding.FragmentHomeBinding;
import com.duvarax.navigationactivity.ui.cargar.CargarViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListarFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ListarViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ListarViewModel.class);


        mv.getNotas().observe(getActivity(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> notass) {
                Collections.sort(notass);
                RecyclerView rv = binding.rvLista;
                GridLayoutManager grid = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                rv.setLayoutManager(grid);
                ListarFragmentAdapter adapter = new ListarFragmentAdapter(getActivity(), notass, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
        mv.setNota(notas);



        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}