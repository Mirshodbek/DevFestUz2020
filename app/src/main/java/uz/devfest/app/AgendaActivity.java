package uz.devfest.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uz.devfest.app.agenda.fragments.AllFragment;
import uz.devfest.app.agenda.fragments.CloudFragment;
import uz.devfest.app.agenda.fragments.AndroidFragment;
import uz.devfest.app.agenda.fragments.WebFragment;

public class AgendaActivity extends AppCompatActivity {
    private Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_bottom_naviagtion);

        toolbar = findViewById(R.id.agendaToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_back);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new AllFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.allButton:
                            fragment = new AllFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.cloudButton:
                            fragment = new CloudFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.mobileButton:
                            fragment = new AndroidFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.webButton:
                            fragment = new WebFragment();
                            loadFragment(fragment);
                            return true;
                    }
                    return false;
                }
            };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}