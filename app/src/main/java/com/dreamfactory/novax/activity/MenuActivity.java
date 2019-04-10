package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.MenuPageAdapter;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout menuTabLayout;
    private TabItem menuTabItemHome;
    private TabItem menuTabItemPortfoilo;
    private TabItem menuTabItemOrder;
    private TabItem menuTabItemSocial;
    private ViewPager menuViewPager;
    private MenuPageAdapter menuPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //settup toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //settup toolbar

        //setup tab option
        menuTabLayout = findViewById(R.id.menu_tab_layout);
        menuTabItemHome = findViewById(R.id.tab_item_home);
        menuTabItemPortfoilo = findViewById(R.id.tab_item_portfoilo);
        menuTabItemOrder = findViewById(R.id.tab_item_order);
        menuTabItemSocial = findViewById(R.id.tab_item_social);
        menuViewPager = findViewById(R.id.menu_viewpager);

        menuPageAdapter = new MenuPageAdapter(getSupportFragmentManager(), menuTabLayout.getTabCount());
        menuViewPager.setAdapter(menuPageAdapter);
        //setup tab

        //setting navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //end setting navigation drawer

        //setting tab selected listner so that we can change selected or unselected tab items background
        menuTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                menuViewPager.setCurrentItem(tab.getPosition());

                toolbar.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                menuTabLayout.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                }

                /*if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorAccent));
                    menuTabLayout.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorAccent));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, R.color.colorAccent));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, android.R.color.darker_gray));
                    menuTabLayout.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, android.R.color.darker_gray));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, android.R.color.darker_gray));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                    menuTabLayout.setBackgroundColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, R.color.colorPrimary));
                    }
                }*/

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        menuViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(menuTabLayout));
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
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.item_menu_search) {
            Toast.makeText(getApplicationContext(), "Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_balance) {
            Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_watchlist) {
            Intent intent=new Intent(MenuActivity.this,WatchlistActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact_us) {
            Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
