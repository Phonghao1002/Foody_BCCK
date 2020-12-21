package com.example.foody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Adapter.ViewFagerAdapter;
import Fragment.NotiFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigationView = findViewById(R.id.bottom_navigation);
        mViewPager = findViewById(R.id.view_pager_main);

        setUpViewPager();
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_bookmark:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_invoice:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_noti:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.nav_profile:
                        mViewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });


    }
    private void setUpViewPager() {
        ViewFagerAdapter viewFagerAdapter = new ViewFagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewFagerAdapter);
    }

}