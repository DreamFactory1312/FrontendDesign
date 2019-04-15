package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;

import java.util.Calendar;
import java.util.Random;

public class SellMktOrder extends AppCompatActivity {

    private Toolbar toolBarSellMarketOrder;

    private TextView txtFirstValueSellMKTOrder, txtSecondValueSellMKTOrder, txtRealTimeUpdateSellMKTOrder;
    private LinearLayout llBuySellMKTOrderTab, llSellSellMKTOrderTab;
    private TextView txtBuySellMKTOrderTab, txtSellSellMKTOrderTab;
    private LinearLayout llSellMKTOrder, llSellLOOrder, llSellGTDOrder, GTDLayout, mktLoLayout;
    private TextView txtSellMktOrder, txtSellLOOrder, txtSellGTDOrder;
    private TextView txtAvailableForSellSellMKTValue, txtQuantitySellMKTValue, txtAmountSellMKTValue;
    private View viewSellMKT, viewSellLO, viewSellGTD;
    private ProgressBar progressBarSellMKT;
    private Button btnNextOrderSellMKT;

    private int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_mkt_order);

        toolBarSellMarketOrder = findViewById(R.id.toolBarSellMarketOrder);
        toolBarSellMarketOrder.setTitle("Sell Market Order");
        setSupportActionBar(toolBarSellMarketOrder);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        initializeProperty();
        implementationProperty();
    }

    private void initializeProperty() {
        txtFirstValueSellMKTOrder = findViewById(R.id.txtFirstValueSellMKTOrder);
        txtSecondValueSellMKTOrder = findViewById(R.id.txtSecondValueSellMKTOrder);
        txtRealTimeUpdateSellMKTOrder = findViewById(R.id.txtRealTimeUpdateSellMKTOrder);

        txtAvailableForSellSellMKTValue = findViewById(R.id.txtAvailableForSellSellMKTValue);
        txtQuantitySellMKTValue = findViewById(R.id.txtQuantitySellMKTValue);
        txtAmountSellMKTValue = findViewById(R.id.txtAmountSellMKTValue);

        txtBuySellMKTOrderTab = findViewById(R.id.txtBuySellMKTOrderTab);
        txtSellSellMKTOrderTab = findViewById(R.id.txtSellSellMKTOrderTab);

        txtSellMktOrder = findViewById(R.id.txtSellMktOrder);
        txtSellLOOrder = findViewById(R.id.txtSellLOOrder);
        txtSellGTDOrder = findViewById(R.id.txtSellGTDOrder);

        llBuySellMKTOrderTab = findViewById(R.id.llBuySellMKTOrderTab);
        llSellSellMKTOrderTab = findViewById(R.id.llSellSellMKTOrderTab);

        llSellMKTOrder = findViewById(R.id.llSellMKTOrder);
        llSellLOOrder = findViewById(R.id.llSellLOOrder);
        llSellGTDOrder = findViewById(R.id.llSellGTDOrder);

        viewSellMKT = findViewById(R.id.viewSellMKT);
        viewSellLO = findViewById(R.id.viewSellLO);
        viewSellGTD = findViewById(R.id.viewSellGTD);
        progressBarSellMKT = findViewById(R.id.progressBarSellMKT);

        btnNextOrderSellMKT = findViewById(R.id.btnNextOrderSellMKT);

        GTDLayout = findViewById(R.id.GTDLayout);
        mktLoLayout = findViewById(R.id.mktLoLayout);

        //To Start Sell GTD Order activity
        btnNextOrderSellMKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AmendCancelOrderActivity.class));
            }
        });
    }

    private void implementationProperty() {
        implementationllBuySellMKTOrderTab();
        implementationllSellSellMKTOrderTab();

        implementationllSellMKTOrder();
        implementationllSellLOOrder();
        implementationllSellGTDOrder();

        implementationprogressBarSellMKT();

        llSellSellMKTOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_right_sell_layout));
        txtSellSellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));


        llBuySellMKTOrderTab.setBackgroundColor(Color.TRANSPARENT);
        txtBuySellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));


        viewSellMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        mktLoLayout.setVisibility(View.VISIBLE);
        GTDLayout.setVisibility(View.GONE);
    }

    private void getNextValueForSecondTab() {
        txtAvailableForSellSellMKTValue.setText("0." + getProgressData());
        txtQuantitySellMKTValue.setText("" + getProgressData());
        txtAmountSellMKTValue.setText(getProgressData() + "." + getProgressData());
    }

    private void getNextValueForFirstTab() {
        txtFirstValueSellMKTOrder.setText("0." + getProgressData());
        txtSecondValueSellMKTOrder.setText("-0." + getProgressData());
        txtRealTimeUpdateSellMKTOrder.setText("Real Time, Last Updated " + getUpdatedRealTime());
    }

    private String getUpdatedRealTime() {
        return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    private void implementationprogressBarSellMKT() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarSellMKT.setProgress(progress);
                        }
                    });
                    try {
                        // Sleep for 100 milliseconds to show the progress slowly.
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void implementationllSellGTDOrder() {
        llSellGTDOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressBarSellMKT();

                viewSellMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

                getNextValueForSecondTab();
                GTDLayout.setVisibility(View.VISIBLE);
                mktLoLayout.setVisibility(View.GONE);

            }
        });
    }

    private void implementationllSellLOOrder() {
        llSellLOOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressBarSellMKT();

                viewSellMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                viewSellGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
                GTDLayout.setVisibility(View.GONE);
                mktLoLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void implementationllSellMKTOrder() {
        llSellMKTOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressBarSellMKT();

                viewSellMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                viewSellLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewSellGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
                GTDLayout.setVisibility(View.GONE);
                mktLoLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void implementationllSellSellMKTOrderTab() {
        llSellSellMKTOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llSellSellMKTOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_right_sell_layout));
                txtSellSellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llBuySellMKTOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtBuySellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                getNextValueForFirstTab();
            }
        });
    }

    private void implementationllBuySellMKTOrderTab() {
        llBuySellMKTOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBuySellMKTOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_left_buy_layout));
                txtBuySellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llSellSellMKTOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtSellSellMKTOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                getNextValueForFirstTab();

                Intent intent = new Intent(SellMktOrder.this, BuyMarketOrder.class);
                startActivity(intent);
            }
        });
    }

    private int getProgressData() {
        return new Random().nextInt(100) + 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
