package com.example.administrator.nuoctinhkhiet.Activities;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.administrator.nuoctinhkhiet.Fragments.InformationFragment;
import com.example.administrator.nuoctinhkhiet.Fragments.OrderHistoryFragment;
import com.example.administrator.nuoctinhkhiet.Fragments.OrderNewFragment;
import com.example.administrator.nuoctinhkhiet.Fragments.ProductFragment;
import com.example.administrator.nuoctinhkhiet.Fragments.SettingFragment;
import com.example.administrator.nuoctinhkhiet.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView navigation;
    TextView segNew, segHisttory;
    TableLayout segment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialView();

//        Drawable backArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
//        backArrow.setColorFilter(getResources().getColor(R.color.backgroundItem), PorterDuff.Mode.SRC_ATOP);
//        getSupportActionBar().setHomeAsUpIndicator(backArrow);







        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // nếu sử dụng popbackstack thì lưu thao tác cũ của fragment
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);

                //This method is called when the up button is pressed. Just the pop back stack.
                Log.e("back","pressed");
                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStack("tag",1);

                } else {
                    onBackPressed();
                }
//                onBackPressed();
            }
        });
        segNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segNew.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                segNew.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                segHisttory.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                segHisttory.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark));

                OrderNewFragment orderNewFragment = new OrderNewFragment();
                android.app.FragmentManager manager= getFragmentManager();
                manager.beginTransaction().replace(R.id.contenLayout,orderNewFragment,orderNewFragment.getTag()).commit();
            }
        });
        segHisttory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                segHisttory.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                segHisttory.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                segNew.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.white));
                segNew.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimaryDark));
                OrderHistoryFragment orderHistoryFragment = new OrderHistoryFragment();
                android.app.FragmentManager manager= getFragmentManager();
                manager.beginTransaction().replace(R.id.contenLayout,orderHistoryFragment,orderHistoryFragment.getTag()).commit();
            }
        });
    }
    void InitialView()
    {
        segment= (TableLayout)findViewById(R.id.segment);
        segNew= (TextView)findViewById(R.id.segNew);
        segHisttory= (TextView)findViewById(R.id.segHistory);
        toolbar= (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // vào ứng dụng là mở fragment home
        navigation.setSelectedItemId(R.id.navigation_home);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.app.FragmentManager manager= getFragmentManager();
            segment.setVisibility(View.INVISIBLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Sản phẩm");

                    ProductFragment mainFragment = new ProductFragment();
                    manager.beginTransaction().replace(R.id.contenLayout,mainFragment,mainFragment.getTag()).commit();
                    return true;
                case R.id.navigation_order:
                    setTitle(null);
                    segment.setVisibility(View.VISIBLE);
                    segNew.callOnClick();
                    return true;
                case R.id.navigation_information:
                    setTitle("Thông tin");
                    InformationFragment informationFragment = new InformationFragment();
                    manager.beginTransaction().replace(R.id.contenLayout,informationFragment,informationFragment.getTag()).commit();
                    return true;
                case R.id.navigation_setting:
                    setTitle("Cài đặt");
                    SettingFragment settingFragment = new SettingFragment();
                    manager.beginTransaction().replace(R.id.contenLayout,settingFragment,settingFragment.getTag()).commit();
                    return true;
            }
            return false;
        }

    };

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Log.e("focus",getCurrentFocus().toString());
//        return super.onKeyDown(keyCode, event);
//    }


    //Click vao backbutton khi sử dụng actionbar
//    @Override
//    public boolean onSupportNavigateUp() {
//        // hide backbutton
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//
//        //This method is called when the up button is pressed. Just the pop back stack.
//        Log.e("back","pressed");
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            getFragmentManager().popBackStack("tag",1);
//
//        } else {
//            super.onBackPressed();
//        }
//        return true;
//    }
}
