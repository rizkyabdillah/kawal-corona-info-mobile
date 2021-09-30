package com.android.kawalcorona.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiInterfaceKawalCorona apiInterfaceKawalCorona;

    public static ApiInterfaceKawalCorona getApiInterfaceKawalCorona() {
        if(apiInterfaceKawalCorona == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BaseURL.KAWAL_CORONA)
                    .build();
            apiInterfaceKawalCorona = retrofit.create(ApiInterfaceKawalCorona.class);
        }
        return apiInterfaceKawalCorona;
    }

}
