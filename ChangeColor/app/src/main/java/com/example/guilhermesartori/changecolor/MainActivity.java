package com.example.guilhermesartori.changecolor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListenerTrocaCores {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    instanciar(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    instanciar(new ConfigFragment());
                    return true;
            }
            return false;
        }
    };

    private void instanciar(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.place_fragments, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean tema = false;

        if(getIntent().getExtras() != null){
            tema = getIntent().getExtras().getBoolean("TEMA");
        }
        setTheme(tema ? R.style.AppTheme : R.style.AppThemeDois);
        setContentView(R.layout.activity_main);




        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if(getIntent().getExtras().getBoolean("PREFERENCES")){
            navigation.setSelectedItemId(R.id.navigation_notifications);
        }
    }


    @Override
    public void trocarCores(boolean tema) {
//        Toast.makeText(this, "trocou de cor", Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("TEMA", tema);
        bundle.putBoolean("PREFERENCES", true);
        intent.putExtras(bundle);
        finish();
        startActivity(intent);
    }
}
