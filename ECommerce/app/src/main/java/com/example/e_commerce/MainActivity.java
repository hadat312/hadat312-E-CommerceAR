package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.e_commerce.ui.catalogs.CatalogsFragment;
import com.example.e_commerce.ui.home.HomeFragment;
import com.example.e_commerce.ui.notifications.NotificationsFragment;
import com.example.e_commerce.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    BottomNavigationView bottomNav = findViewById(R.id.nav_view);
    bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectdFragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selectdFragment = new HomeFragment();
                            break;
                        case R.id.navigation_notification:
                            selectdFragment = new NotificationsFragment();
                            break;
                        case R.id.navigation_catalogs:
                            selectdFragment = new CatalogsFragment();
                            break;
                        case R.id.navigation_profile:
                            selectdFragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectdFragment).commit();
                    return true;
                }
            };
}