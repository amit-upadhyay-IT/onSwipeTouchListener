package com.amitupadhyay.advertisingportal;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imageView;
    private RecyclerView recyclerView;
    private ArrayList<CategoriesDetails> arrayList;

    public void initImageView()
    {
        imageView = (ImageView) findViewById(R.id.imageSwitcher);

        imageView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            @Override
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "TOP", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeRight() {
                imageView.setImageResource(0);
                imageView.setImageResource(R.drawable.app_main_image);
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeLeft() {
                imageView.setImageResource(R.drawable.serviceapps);
                Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "Bottom", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initRecyclerView()
    {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);

        CategoriesDetails obj1 = new CategoriesDetails("Media", R.drawable.media);
        CategoriesDetails obj2 = new CategoriesDetails("Real Estate", R.drawable.real_estate);
        CategoriesDetails obj3 = new CategoriesDetails("Hotels", R.drawable.hotels);
        CategoriesDetails obj4 = new CategoriesDetails("Education", R.drawable.educational);
        CategoriesDetails obj5 = new CategoriesDetails("Hospitality", R.drawable.hospitality);
        CategoriesDetails obj6 = new CategoriesDetails("Example", R.drawable.serviceapps);

        arrayList = new ArrayList<>();

        arrayList.add(obj1);
        arrayList.add(obj2);
        arrayList.add(obj3);
        arrayList.add(obj4);
        arrayList.add(obj5);
        arrayList.add(obj6);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        MyCustomAdapter adapter = new MyCustomAdapter(this, arrayList, R.layout.recycler_row);

        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initImageView();
        initRecyclerView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.homeDrawer) {
            // Home
            Toast.makeText(this, "Welcome to Home", Toast.LENGTH_LONG).show();

        } else if (id == R.id.accountDrawer) {

            Toast.makeText(this, "Welcome to Account", Toast.LENGTH_LONG).show();

        } else if (id == R.id.settingsDrawer) {

            Toast.makeText(this, "Welcome to Settings", Toast.LENGTH_LONG).show();

        } else if (id == R.id.toolsDrawer) {

            Toast.makeText(this, "Welcome to Tools", Toast.LENGTH_LONG).show();

        } else if (id == R.id.realEstateDrawer) {

            Toast.makeText(this, "Welcome to Real Estate", Toast.LENGTH_LONG).show();

        } else if (id == R.id.educationDrawer) {

            Toast.makeText(this, "Welcome to Educational Institutes", Toast.LENGTH_LONG).show();

        } else if (id == R.id.hospitalityDrawer) {

            Toast.makeText(this, "Welcome to Hospitality Services", Toast.LENGTH_LONG).show();

        } else if (id == R.id.medicalStoresDrawer) {

            Toast.makeText(this, "Welcome to Medical Services", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
