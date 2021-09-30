package com.android.kawalcorona.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.kawalcorona.R;
import com.android.kawalcorona.api.response.DataProvinsiResponse;

import java.util.List;

public class DataProvinsiAdapter extends RecyclerView.Adapter<DataProvinsiAdapter.ViewHolder>{

    private List<DataProvinsiResponse> list;

    public DataProvinsiAdapter(List<DataProvinsiResponse> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View VIEW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summary, parent, false);
        return new ViewHolder(VIEW);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textProvinsi.setText(list.get(position).getAttributes().getProvinsi());
        holder.textPositif.setText(String.valueOf(list.get(position).getAttributes().getKasusPosi()));
        holder.textSembuh.setText(String.valueOf(list.get(position).getAttributes().getKasusSemb()));
        holder.textMeninggal.setText(String.valueOf(list.get(position).getAttributes().getKasusMeni()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textProvinsi, textPositif, textSembuh, textMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textProvinsi = itemView.findViewById(R.id.textProvinsi);
            textPositif = itemView.findViewById(R.id.textPositif);
            textSembuh = itemView.findViewById(R.id.textSembuh);
            textMeninggal = itemView.findViewById(R.id.textMeninggal);
        }
    }
}
