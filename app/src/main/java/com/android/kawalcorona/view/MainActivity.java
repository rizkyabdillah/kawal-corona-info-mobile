package com.android.kawalcorona.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.kawalcorona.R;
import com.android.kawalcorona.adapter.DataProvinsiAdapter;
import com.android.kawalcorona.api.response.DataIndonesiaResponse;
import com.android.kawalcorona.api.response.DataProvinsiResponse;
import com.android.kawalcorona.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textMeninggal, textSembuh, textPositif;
    private RecyclerView recyclerView;
    private MainViewModel viewModel;
    private final LifecycleOwner OWNER = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMeninggal = findViewById(R.id.textMeninggal);
        textSembuh = findViewById(R.id.textSembuh);
        textPositif = findViewById(R.id.textPositif);
        recyclerView = findViewById(R.id.recyclerView);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getDataIndonesia().observe(OWNER, new Observer<DataIndonesiaResponse>() {
            @Override
            public void onChanged(DataIndonesiaResponse dataIndonesiaResponse) {
                if(dataIndonesiaResponse != null) {
                    textMeninggal.setText(dataIndonesiaResponse.getMeninggal());
                    textSembuh.setText(dataIndonesiaResponse.getSembuh());
                    textPositif.setText(dataIndonesiaResponse.getPositif());
                }
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getDataProvinsi().observe(OWNER, new Observer<List<DataProvinsiResponse>>() {
            @Override
            public void onChanged(List<DataProvinsiResponse> dataProvinsiResponses) {
                if(dataProvinsiResponses != null) {
                    recyclerView.setAdapter(new DataProvinsiAdapter(dataProvinsiResponses));
                }
            }
        });

    }
}