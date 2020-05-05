package com.example.taobaounion.ui.fragment;


import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.presenter.IHomePresenter;
import com.example.taobaounion.presenter.impl.HomePresenterImpl;
import com.example.taobaounion.view.IHomeCallback;

/**
 * 首页
 *
 * @Author godv
 * Date on 2020/5/4  16:13
 */
public class HomeFragment extends BaseFragment implements IHomeCallback {

    private IHomePresenter homePresenter;

    @Override
    protected int loadRootView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {
        homePresenter = new HomePresenterImpl();
        homePresenter.registerCallback(this);
    }

    /**
     * 释放资源 ,取消注册
     */
    @Override
    protected void release() {
        if (homePresenter != null) {
            homePresenter.unRegisterCallback(this);
        }
    }

    /**
     * 加载数据
     */
    @Override
    protected void loadData() {
        homePresenter.getCategories();
    }

    /**
     * 异步数据返回
     */
    @Override
    public void onCategoriesLoad() {

    }
}
