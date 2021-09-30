package com.android.kawalcorona.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.kawalcorona.api.response.DataIndonesiaResponse;
import com.android.kawalcorona.api.response.DataProvinsiResponse;
import com.android.kawalcorona.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final Repository REPOSITORY;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.REPOSITORY = new Repository();
    }

    public MutableLiveData<DataIndonesiaResponse> getDataIndonesia() {
        return this.REPOSITORY.getDataIndonesia();
    }

    public MutableLiveData<List<DataProvinsiResponse>> getDataProvinsi() {
        return this.REPOSITORY.getDataProvinsi();
    }


}
