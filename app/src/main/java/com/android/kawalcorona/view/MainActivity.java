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

    private static final String TAG = "MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMeninggal = findViewById(R.id.textMeninggal);
        textSembuh = findViewById(R.id.textSembuh);
        textPositif = findViewById(R.id.textPositif);
        recyclerView = findViewById(R.id.recyclerView);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getDataIndonesia().observe(OWNER, new Observer<List<DataIndonesiaResponse>>() {
            @Override
            public void onChanged(List<DataIndonesiaResponse> dataIndonesiaResponses) {
                if(dataIndonesiaResponses != null) {
                    textMeninggal.setText(dataIndonesiaResponses.get(0).getMeninggal());
                    textSembuh.setText(dataIndonesiaResponses.get(0).getSembuh());
                    textPositif.setText(dataIndonesiaResponses.get(0).getPositif());
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