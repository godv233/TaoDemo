package com.example.taobaounion.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import com.example.taobaounion.R;

/**
 * 使用RadioGroup实现导航栏
 * @Author godv
 * Date on 2020/5/5  14:38
 */
public class TestNavigationActivity  extends Activity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_test);
        radioGroup = findViewById(R.id.test_nav);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkedId就是radioButton的id。也是通过switch来绑定fragment.
            }
        });
    }
}
