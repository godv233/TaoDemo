package com.example.taobaounion.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例的manager
 *
 * @Author godv
 * Date on 2020/5/5  17:21
 */
public class RetrofitManager {
    private static final RetrofitManager instance = new RetrofitManager();
    private final Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        return instance;
    }

    private RetrofitManager() {
        //创建retrofit
        mRetrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
