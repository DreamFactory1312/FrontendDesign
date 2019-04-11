package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;

public class WatchlistActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar toolbar;
    RecyclerView watchlistRecyclerView;
    WatchlistAdapter adapter;
    List<Watchlist> watchlists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar_watchlist);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(WatchlistActivity.this, R.color.colorPrimary));

        watchlistRecyclerView = findViewById(R.id.watchlistRecycler);
        watchlistRecyclerView.setHasFixedSize(false);
        watchlistRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        watchlists.clear();
        watchlists.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        watchlists.add(new Watchlist(R.drawable.icon_facebook, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        adapter = new WatchlistAdapter(watchlists, this);
        watchlistRecyclerView.setAdapter(adapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_watchlist);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_watchlist);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_watchlist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(item.getItemId()) {
            case R.id.item_menu_search2:
                Intent intent=new Intent(this,WatchlistSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.item_menu_edit:
                // another startActivity, this is for item with id "menu_item2"
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_balance) {
            Intent intent = new Intent(this, BalanceActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_watchlist) {

        } else if (id == R.id.nav_contact_us) {
            Intent intent1 = new Intent(this, ContactUsActivity.class);
            startActivity(intent1);
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_watchlist);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
