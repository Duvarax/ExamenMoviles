package com.duvarax.navigationactivity.ui.listar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duvarax.navigationactivity.R;

import java.util.List;

public class ListarFragmentAdapter extends RecyclerView.Adapter<ListarFragmentAdapter.ViewHolder> {


    private Context contexto;
    private List<String> notas;
    private LayoutInflater inflater;

    public ListarFragmentAdapter(Context contexto, List<String> notas, LayoutInflater inflater) {
        this.contexto = contexto;
        this.notas = notas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ListarFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contexto = parent.getContext();
        View root = inflater.inflate(R.layout.nota_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarFragmentAdapter.ViewHolder holder, int position) {
        holder.nota.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nota;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nota = itemView.findViewById(R.id.tvNota);

        }
    }
}
