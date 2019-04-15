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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class BalanceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private LinearLayout depositeLayout, withdrawLayout, convertLayout, withdrawlayoutContent, convetlayoutContent;
    private ScrollView depositelayoutContent;
    TextView txtwithdraw, txtconvert, txtdepsite;
    View deposite_withdraw_view, convet_withdraw_view;
    private Button buttonWithdraw, buttonConvert;
    private MaterialSpinner userAccountSpinner, currencySpinner, userDepositeAccountSpinner, currencyDepositeSpinner;
    private ImageView depositeImage, depositeDetailsImage;
    private Button btnPhotoUpload, buttonUploadBalanceDeposite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_menu);

        findViewId();
        firstCall();
        spinnersItem();
        toolbarInit();
        drawerInit();
        navInit();


        depositeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                depositeLayout.setBackgroundDrawable(ContextCompat.getDrawable(BalanceActivity.this, R.drawable.deposite_rounded_shape_left));
                withdrawLayout.setBackgroundColor(Color.TRANSPARENT);
                convertLayout.setBackgroundColor(Color.TRANSPARENT);

                depositelayoutContent.setVisibility(View.VISIBLE);
                withdrawlayoutContent.setVisibility(View.GONE);
                convetlayoutContent.setVisibility(View.GONE);

                txtdepsite.setTextColor(getResources().getColor(R.color.white));
                txtconvert.setTextColor(getResources().getColor(R.color.black));
                txtwithdraw.setTextColor(getResources().getColor(R.color.black));

            }
        });

        withdrawLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withdrawLayout.setBackgroundColor(ContextCompat.getColor(BalanceActivity.this, R.color.colorPrimary));
                convertLayout.setBackgroundColor(Color.TRANSPARENT);
                depositeLayout.setBackgroundColor(Color.TRANSPARENT);

                withdrawlayoutContent.setVisibility(View.VISIBLE);
                convetlayoutContent.setVisibility(View.GONE);
                depositelayoutContent.setVisibility(View.GONE);

                txtwithdraw.setTextColor(getResources().getColor(R.color.white));
                txtconvert.setTextColor(getResources().getColor(R.color.black));
                txtdepsite.setTextColor(getResources().getColor(R.color.black));
            }
        });

        convertLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLayout.setBackgroundDrawable(ContextCompat.getDrawable(BalanceActivity.this, R.drawable.convertlayout_rounded_shape));
                withdrawLayout.setBackgroundColor(Color.TRANSPARENT);
                depositeLayout.setBackgroundColor(Color.TRANSPARENT);

                withdrawlayoutContent.setVisibility(View.GONE);
                depositelayoutContent.setVisibility(View.GONE);
                convetlayoutContent.setVisibility(View.VISIBLE);

                txtconvert.setTextColor(getResources().getColor(R.color.white));
                txtwithdraw.setTextColor(getResources().getColor(R.color.black));
                txtdepsite.setTextColor(getResources().getColor(R.color.black));

            }
        });



        buttonUploadBalanceDeposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BalanceActivity.this, "Upload", Toast.LENGTH_SHORT).show();
            }
        });

        btnPhotoUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BalanceActivity.this, "Upload Photo", Toast.LENGTH_SHORT).show();
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

        depositeDetailsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BalanceActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        depositeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BalanceActivity.this, DepositeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void navInit() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_balance);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void drawerInit() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_balance);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void toolbarInit() {
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(BalanceActivity.this, R.color.colorPrimary));
    }

    private void spinnersItem() {
        userAccountSpinner.setItems("WONG MAY FUNG ", "WONG MAY FUNG ", "WONG MAY FUNG ");
        userDepositeAccountSpinner.setItems("WONG MAY FUNG ", "WONG MAY FUNG ", "WONG MAY FUNG ");
        currencySpinner.setItems("USD ", "MY ", "TA ");
        currencyDepositeSpinner.setItems("USD ", "MY ", "TA ");
    }

    private void firstCall() {
        depositeLayout.setBackgroundDrawable(ContextCompat.getDrawable(BalanceActivity.this, R.drawable.deposite_rounded_shape_left));
        txtdepsite.setTextColor(getResources().getColor(R.color.white));
    }

    private void findViewId() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_balance);
        depositeLayout = findViewById(R.id.depositeLayout);
        withdrawLayout = findViewById(R.id.withdrawLayout);
        convertLayout = findViewById(R.id.convertLayout);
        withdrawlayoutContent = findViewById(R.id.withdrawlayoutContent);
        convetlayoutContent = findViewById(R.id.convertlayoutContent);
        depositelayoutContent = findViewById(R.id.depositelayoutContent);
        txtwithdraw = findViewById(R.id.txtwithdraw);
        txtconvert = findViewById(R.id.txtconvert);
        deposite_withdraw_view = findViewById(R.id.deposite_withdraw_view);
        convet_withdraw_view = findViewById(R.id.convet_withdraw_view);
        buttonWithdraw = findViewById(R.id.buttonWithdraw);
        buttonConvert = findViewById(R.id.buttonConvert);
        userAccountSpinner = findViewById(R.id.userAccountSpinner);
        currencySpinner = findViewById(R.id.currencySpinner);
        txtdepsite = findViewById(R.id.txtdepsite);
        depositeImage = findViewById(R.id.depositeImage);
        depositeDetailsImage = findViewById(R.id.depositeDetailsImage);
        userDepositeAccountSpinner = findViewById(R.id.userDepositeAccountSpinner);
        currencyDepositeSpinner = findViewById(R.id.currencyDepositeSpinner);
        btnPhotoUpload = findViewById(R.id.btnPhotoUpload);
        buttonUploadBalanceDeposite = findViewById(R.id.buttonUploadBalanceDeposite);
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
