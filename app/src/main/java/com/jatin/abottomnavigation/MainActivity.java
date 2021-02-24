package com.jatin.abottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
    }
    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navHome:
                    fragment = new HomeFragment();
                    break;
                case R.id.navContact:
                    fragment = new ContactFragment();
                    break;
                case R.id.navCall:
                    fragment = new CallsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            return true;
        }
    };
}