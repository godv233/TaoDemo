package com.example.taobaounion.model.domain;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Author godv
 * Date on 2020/5/5  17:18
 */
public interface Api {
    @GET("discovery/categories")
    Call<Categories> getCategories();
}
