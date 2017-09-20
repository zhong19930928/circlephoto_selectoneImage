package com.example.zhb;

import android.graphics.Color;
import android.os.Bundle;

import com.example.zhb.fragment.BaseActivity;
import com.example.zhb.fragment.BlankFragment;
import com.example.zhb.fragment.BlankFragment1;
import com.example.zhb.fragment.BlankFragment2;
import com.example.zhb.myapplication.R;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.bottom_tab_bar)
    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        setBottomtabBar();

    }

    private void setBottomtabBar() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(90,90)
                .setFontSize(12)
                .setTabPadding(10,3,10)
                .setChangeColor(Color.YELLOW,Color.BLACK)
                .addTabItem("模块1",R.drawable.ic_error_black_24dp, BlankFragment.class)
                .addTabItem("模块2",R.drawable.ic_cloud_black_24dp, BlankFragment1.class)
                .addTabItem("模块3",R.drawable.ic_person_black_24dp, BlankFragment2.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
