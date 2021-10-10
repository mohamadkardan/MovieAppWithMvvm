package com.example.simpleappwithmvvm.request;

import com.example.simpleappwithmvvm.Credentials;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Service instance;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }


    @NotNull
    private static OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Credentials.BASE_URL);

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final ApiService apiService = retrofit.create(ApiService.class);

    public static ApiService getApiService() {
        return apiService;
    }

}
