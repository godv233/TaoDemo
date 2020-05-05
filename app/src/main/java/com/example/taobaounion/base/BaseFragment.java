package com.example.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 抽取Fragment
 *
 * @Author godv
 * Date on 2020/5/4  16:39
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int viewId = loadRootView();
        //加载页面
        View rootView = inflater.inflate(viewId, container, false);
        //初始化presenter
        initPresenter();
        //加载数据
        loadData();
        return rootView;
    }

    /**
     * 页面销毁时，取消注册。防止内存泄漏
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        release();
    }

    /**
     * 释放资源
     */
    protected void release(){

    }

    /**
     * 初始化presenter
     */
    protected void initPresenter(){

    }

    /**
     * 加载数据
     */
    protected void loadData(){

    }

    protected abstract int loadRootView();

}
