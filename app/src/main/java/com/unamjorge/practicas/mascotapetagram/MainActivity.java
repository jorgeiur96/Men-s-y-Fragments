package com.unamjorge.practicas.mascotapetagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.unamjorge.practicas.mascotapetagram.Adaptador.PerfilFragment;
import com.unamjorge.practicas.mascotapetagram.Adaptador.RecyclerViewFragment;
import com.unamjorge.practicas.mascotapetagram.Adaptadores.PageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout =(TabLayout)findViewById(R.id.tabLaoyout);
        viewPager =(ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(MainActivity.this,Contactos.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent i = new Intent(this,About.class);
                startActivity(i);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());


        return fragments;
    }


    public void irDetalle(View v){
        Intent intent= new Intent(this,FavoritasMascota.class);
        startActivity(intent);

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        //Agregar icono a las Tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.hueso2);
        tabLayout.getTabAt(1).setIcon(R.drawable.hueso);

        //Agregar un texto en las tabs
        //tabLayout.getTabAt(2).setText(R.string.email);


    }

}
