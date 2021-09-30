package com.android.kawalcorona.api;

import com.android.kawalcorona.api.response.DataIndonesiaResponse;
import com.android.kawalcorona.api.response.DataProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaceKawalCorona {

    @GET("indonesia")
    Call<DataIndonesiaResponse> getDataIndonesia();

    @GET("indonesia/provinsi/")
    Call<List<DataProvinsiResponse>> getDataProvinsi();

}
