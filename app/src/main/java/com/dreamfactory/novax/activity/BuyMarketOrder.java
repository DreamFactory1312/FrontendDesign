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
import android.widget.SeekBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;

import java.util.Calendar;
import java.util.Random;

public class BuyMarketOrder extends AppCompatActivity {

    private Toolbar toolBarBuyMarketOrder;

    private TextView txtFirstValueMKTOrder, txtSecondValueMKTOrder, txtRealTimeUpdateMKTOrder,
            txtMaximumBuyValue, txtQuantityBMOValue, txtAmountBMOValue, txtBuyMarketOrderTab,
            txtSellMarketOrderTab, txtMktOrder, txtLOOrder, txtGTDOrder;
    private Button btnNextOrderBMO;
    private LinearLayout llBuyMarketOrderTab, llSellMarketOrderTab, llMKTOrder, llLOOrder, llGTDOrder;

    private SeekBar seekBarLimitPriceBMO, seekBarQuantityAmendOrderBMO;

    private View viewMKT, viewLO, viewGTD;

    private int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_market_order);

        toolBarBuyMarketOrder = findViewById(R.id.toolBarBuyMarketOrder);
        toolBarBuyMarketOrder.setTitle("Buy Market Order");
        setSupportActionBar(toolBarBuyMarketOrder);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        initializeProperty();

        implementationProperty();

        btnNextOrderBMO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyMarketOrder.this, OrderHistoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initializeProperty() {
        txtFirstValueMKTOrder = findViewById(R.id.txtFirstValueMKTOrder);
        txtSecondValueMKTOrder = findViewById(R.id.txtSecondValueMKTOrder);
        txtRealTimeUpdateMKTOrder = findViewById(R.id.txtRealTimeUpdateMKTOrder);
        txtMaximumBuyValue = findViewById(R.id.txtMaximumBuyValue);
        txtQuantityBMOValue = findViewById(R.id.txtQuantityBMOValue);
        txtAmountBMOValue = findViewById(R.id.txtAmountBMOValue);
        txtBuyMarketOrderTab = findViewById(R.id.txtBuyMarketOrderTab);
        txtSellMarketOrderTab = findViewById(R.id.txtSellMarketOrderTab);
        txtMktOrder = findViewById(R.id.txtMktOrder);
        txtLOOrder = findViewById(R.id.txtLOOrder);
        txtGTDOrder = findViewById(R.id.txtGTDOrder);

        btnNextOrderBMO = findViewById(R.id.btnNextOrderBMO);

        llBuyMarketOrderTab = findViewById(R.id.llBuyMarketOrderTab);
        llSellMarketOrderTab = findViewById(R.id.llSellMarketOrderTab);
        llMKTOrder = findViewById(R.id.llMKTOrder);
        llLOOrder = findViewById(R.id.llLOOrder);
        llGTDOrder = findViewById(R.id.llGTDOrder);

        seekBarLimitPriceBMO = findViewById(R.id.seekBarLimitPriceBMO);
        seekBarQuantityAmendOrderBMO = findViewById(R.id.seekBarQuantityAmendOrderBMO);

        viewMKT = findViewById(R.id.viewMKT);
        viewGTD = findViewById(R.id.viewGTD);
        viewLO = findViewById(R.id.viewLO);
    }

    private void getNextValueForSecondTab() {
        txtMaximumBuyValue.setText("0." + getProgressData());
        txtQuantityBMOValue.setText("" + getProgressData());
        txtAmountBMOValue.setText(getProgressData() + "." + getProgressData());
    }

    private void getNextValueForFirstTab() {
        txtFirstValueMKTOrder.setText("0." + getProgressData());
        txtSecondValueMKTOrder.setText("-0." + getProgressData());
        txtRealTimeUpdateMKTOrder.setText("Real Time, Last Updated " + getUpdatedRealTime());
    }

    private String getUpdatedRealTime() {
        return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    private void implementationProperty() {
        implementationllBuyMarketOrderTab();
        implementationllSellMarketOrderTab();
        implementationllMKTOrder();
        implementationllLOOrder();
        implementationllGTDOrder();

        implementationseekBarLimitPriceBMO();
        implementationseekBarQuantityAmendOrderBMO();

        llBuyMarketOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_left_buy_layout));
        txtBuyMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        llSellMarketOrderTab.setBackgroundColor(Color.TRANSPARENT);
        txtSellMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

        viewMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
    }

    private void implementationseekBarQuantityAmendOrderBMO() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            seekBarLimitPriceBMO.setProgress(progress);
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

    private void implementationseekBarLimitPriceBMO() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            seekBarQuantityAmendOrderBMO.setProgress(progress);
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

    private void implementationllGTDOrder() {
        llGTDOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationseekBarLimitPriceBMO();
                implementationseekBarQuantityAmendOrderBMO();

                viewGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                viewMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllLOOrder() {
        llLOOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationseekBarLimitPriceBMO();
                implementationseekBarQuantityAmendOrderBMO();

                viewLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                viewGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllMKTOrder() {
        llMKTOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationseekBarLimitPriceBMO();
                implementationseekBarQuantityAmendOrderBMO();

                viewMKT.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                viewLO.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                viewGTD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));

                getNextValueForSecondTab();
            }
        });
    }

    private void implementationllSellMarketOrderTab() {
        llSellMarketOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBuyMarketOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtBuyMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                llSellMarketOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_right_sell_layout));
                txtSellMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                getNextValueForFirstTab();
                Intent intent = new Intent(BuyMarketOrder.this, SellMktOrder.class);
                startActivity(intent);
            }
        });
    }

    private void implementationllBuyMarketOrderTab() {
        llBuyMarketOrderTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBuyMarketOrderTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rounded_shape_left_buy_layout));
                txtBuyMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llSellMarketOrderTab.setBackgroundColor(Color.TRANSPARENT);
                txtSellMarketOrderTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                getNextValueForFirstTab();
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
