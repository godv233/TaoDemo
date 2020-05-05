package com.example.taobaounion.presenter.impl;

import android.util.Log;

import com.example.taobaounion.model.domain.Api;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.presenter.IHomePresenter;
import com.example.taobaounion.utils.RetrofitManager;
import com.example.taobaounion.view.IHomeCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @Author godv
 * Date on 2020/5/5  16:15
 */
public class HomePresenterImpl implements IHomePresenter {
    private static final String TAG = "HomePresenterImpl";

    @Override
    public void getCategories() {
        //加载数据
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        Api api = retrofit.create(Api.class);
        Call<Categories> task = api.getCategories();
        task.enqueue(new Callback<Categories>() {
            /**
             * 正确请求返回的结果
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response != null && response.code() == HttpURLConnection.HTTP_OK) {
                    Categories categories = response.body();
                    Log.d(TAG, categories.toString());
                } else {
                    Log.d(TAG, "请求有误");
                }
            }

            //失败
            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Log.d(TAG, "请求失败");
            }
        });


    }

    @Override
    public void registerCallback(IHomeCallback callback) {

    }

    @Override
    public void unRegisterCallback(IHomeCallback callback) {

    }
}
