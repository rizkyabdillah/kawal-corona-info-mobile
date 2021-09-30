package com.android.kawalcorona.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.kawalcorona.api.ApiClient;
import com.android.kawalcorona.api.ApiInterfaceKawalCorona;
import com.android.kawalcorona.api.response.DataIndonesiaResponse;
import com.android.kawalcorona.api.response.DataProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private final ApiInterfaceKawalCorona apiInterfaceKawalCorona;
    private static final String TAG = "REPOSITORY";

    public Repository() {
        this.apiInterfaceKawalCorona = ApiClient.getApiInterfaceKawalCorona();
    }

    public MutableLiveData<DataIndonesiaResponse> getDataIndonesia() {
        MutableLiveData<DataIndonesiaResponse> data = new MutableLiveData<>();
        apiInterfaceKawalCorona.getDataIndonesia().enqueue(new Callback<DataIndonesiaResponse>() {
            @Override
            public void onResponse(Call<DataIndonesiaResponse> call, Response<DataIndonesiaResponse> response) {
                if (response.code() == 200) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataIndonesiaResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                data.postValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<List<DataProvinsiResponse>> getDataProvinsi() {
        MutableLiveData<List<DataProvinsiResponse>> data = new MutableLiveData<>();
        apiInterfaceKawalCorona.getDataProvinsi().enqueue(new Callback<List<DataProvinsiResponse>>() {
            @Override
            public void onResponse(Call<List<DataProvinsiResponse>> call, Response<List<DataProvinsiResponse>> response) {
                if (response.code() == 200) {
                    data.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DataProvinsiResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                data.postValue(null);
            }
        });

        return data;
    }
}
