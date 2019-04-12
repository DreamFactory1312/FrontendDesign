package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class BalanceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private LinearLayout depositeLayout, withdrawLayout, convertLayout, withdrawlayoutContent, convetlayoutContent;
    TextView txtwithdraw, txtconvert;
    View deposite_withdraw_view, convet_withdraw_view;
    private Button buttonWithdraw, buttonConvert;
    private MaterialSpinner userAccountSpinner, currencySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar_balance);
        depositeLayout = findViewById(R.id.depositeLayout);
        withdrawLayout = findViewById(R.id.withdrawLayout);
        convertLayout = findViewById(R.id.convertLayout);
        withdrawlayoutContent = findViewById(R.id.withdrawlayoutContent);
        convetlayoutContent = findViewById(R.id.convertlayoutContent);
        txtwithdraw = findViewById(R.id.txtwithdraw);
        txtconvert = findViewById(R.id.txtconvert);
        deposite_withdraw_view = findViewById(R.id.deposite_withdraw_view);
        convet_withdraw_view = findViewById(R.id.convet_withdraw_view);
        buttonWithdraw = findViewById(R.id.buttonWithdraw);
        buttonConvert = findViewById(R.id.buttonConvert);
        userAccountSpinner = findViewById(R.id.userAccountSpinner);
        currencySpinner = findViewById(R.id.currencySpinner);

        userAccountSpinner.setItems("WONG MAY FUNG ", "WONG MAY FUNG ", "WONG MAY FUNG ");
        currencySpinner.setItems("USD ", "MY ", "TA ");

        withdrawLayout.setBackgroundColor(ContextCompat.getColor(BalanceActivity.this, R.color.colorPrimaryLight));
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(BalanceActivity.this, R.color.colorPrimary));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_balance);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_balance);
        navigationView.setNavigationItemSelectedListener(this);

        depositeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceActivity.this, DepositeActivity.class);
                startActivity(intent);
            }
        });

        withdrawLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withdrawLayout.setBackgroundColor(ContextCompat.getColor(BalanceActivity.this, R.color.colorPrimaryLight));
                convertLayout.setBackgroundColor(Color.TRANSPARENT);
                withdrawlayoutContent.setVisibility(View.VISIBLE);
                convetlayoutContent.setVisibility(View.GONE);

                txtwithdraw.setTextColor(getResources().getColor(R.color.white));
                txtconvert.setTextColor(getResources().getColor(R.color.black));
            }
        });

        convertLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLayout.setBackgroundDrawable(ContextCompat.getDrawable(BalanceActivity.this, R.drawable.convertlayout_rounded_shape));
                withdrawLayout.setBackgroundColor(Color.TRANSPARENT);
                withdrawlayoutContent.setVisibility(View.GONE);
                convetlayoutContent.setVisibility(View.VISIBLE);

                txtconvert.setTextColor(getResources().getColor(R.color.white));
                txtwithdraw.setTextColor(getResources().getColor(R.color.black));

            }
        });
        buttonWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BalanceActivity.this, "Withdraw", Toast.LENGTH_SHORT).show();
            }
        });
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BalanceActivity.this, "Convert", Toast.LENGTH_SHORT).show();
            }
        });
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
        switch (item.getItemId()) {
            case R.id.item_menu_search:
//                Intent intent=new Intent(this,WatchlistSearchActivity.class);
//                startActivity(intent);
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
            Toast.makeText(this, "Clicked: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_watchlist) {
            Intent intent = new Intent(this, WatchlistActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact_us) {
            Intent intent = new Intent(this, ContactUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            Intent intent1 = new Intent(this, WelcomeActivity.class);
            startActivity(intent1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_balance);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
