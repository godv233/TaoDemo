package com.example.taobaounion.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.ui.fragment.HomeFragment;
import com.example.taobaounion.ui.fragment.RecommendFragment;
import com.example.taobaounion.ui.fragment.RedPacketFragment;
import com.example.taobaounion.ui.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.main_navigation_bar)
    BottomNavigationView mNavigationView;
    private HomeFragment homeFragment;
    private RecommendFragment recommendFragment;
    private RedPacketFragment redPacketFragment;
    private SearchFragment searchFragment;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
        //默认选择首页
        switchFragment(homeFragment);
    }

    /**
     * 设置事件监听
     */
    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        switchFragment(homeFragment);
                        break;
                    case R.id.recommend:
                        switchFragment(recommendFragment);
                        break;
                    case R.id.red_packet:
                        switchFragment(redPacketFragment);
                        break;
                    case R.id.search:
                        switchFragment(searchFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void switchFragment(BaseFragment targetFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_page_container,targetFragment);
        transaction.commit();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        //初始化fragment
        homeFragment = new HomeFragment();
        recommendFragment = new RecommendFragment();
        redPacketFragment = new RedPacketFragment();
        searchFragment = new SearchFragment();
    }
}
