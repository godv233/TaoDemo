package com.example.taobaounion.presenter;

import com.example.taobaounion.view.IHomeCallback;

/**
 * @Author godv
 * Date on 2020/5/5  16:04
 */
public interface IHomePresenter {
    /**
     * 获取商品列表
     */
    void getCategories();

    /**
     * 注册回调方法，取得数据
     * @param callback
     */
    void registerCallback(IHomeCallback callback);

    /**
     * 销毁注册
     * @param callback
     */
    void unRegisterCallback(IHomeCallback callback);
}
