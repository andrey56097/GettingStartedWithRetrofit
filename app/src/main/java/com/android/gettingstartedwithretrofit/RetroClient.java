package com.android.gettingstartedwithretrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by batsa on 15.02.2017.
 */

public class RetroClient {

    /**
     * URLS
     */

    private static final String ROOT_URL = "https://api.github.com/";

    /**
     * GET Retrofit Instance
     */

    private static Retrofit getRetrofitInstance() {

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(log);

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    /**
     * GET API Service
     */


    public static GitHubService getApiService() {
        return getRetrofitInstance().create(GitHubService.class);
    }
}
