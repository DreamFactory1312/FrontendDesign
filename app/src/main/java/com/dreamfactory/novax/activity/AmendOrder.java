package com.dreamfactory.novax.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;

import java.util.Calendar;
import java.util.Random;

public class AmendOrder extends AppCompatActivity {

    private Toolbar toolBarAmendOrder;

    private TextView txtFirstValueAmendOrder, txtSecondValueAmendOrder, txtRealTimeUpdate, txtAvailableForSellValue, txtAmountValue;

    private ProgressBar progressBarLimitPrice, progressBarQuantityAmendOrder;

    private Button btnNextAmendOrder;

    private int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend_order);

        toolBarAmendOrder = findViewById(R.id.toolBarAmendOrder);
        toolBarAmendOrder.setTitle(R.string.US_NVIDIA);
        setSupportActionBar(toolBarAmendOrder);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        txtFirstValueAmendOrder = findViewById(R.id.txtFirstValueAmendOrder);
        txtSecondValueAmendOrder = findViewById(R.id.txtSecondValueAmendOrder);
        txtRealTimeUpdate = findViewById(R.id.txtRealTimeUpdate);
        txtAvailableForSellValue = findViewById(R.id.txtAvailableForSellValue);
        txtAmountValue = findViewById(R.id.txtAmountValue);

        progressBarLimitPrice = findViewById(R.id.progressBarLimitPrice);
        progressBarQuantityAmendOrder = findViewById(R.id.progressBarQuantityAmendOrder);

        btnNextAmendOrder = findViewById(R.id.btnNextAmendOrder);

        implementationprogressBarLimitPrice();
        implementationprogressBarQuantityAmendOrder();

        btnNextAmendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                implementationprogressBarLimitPrice();
                implementationprogressBarQuantityAmendOrder();

                getNextValue();
            }
        });
    }

    private void getNextValue() {
        txtFirstValueAmendOrder.setText("0." + getProgressData());
        txtSecondValueAmendOrder.setText("-0." + getProgressData());
        txtRealTimeUpdate.setText("Real Time, Last Updated " + getUpdatedRealTime());
        txtAvailableForSellValue.setText(getProgressData() + "." + getProgressData());
        txtAmountValue.setText("0." + getProgressData());
    }

    private String getUpdatedRealTime() {
        return java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    private void implementationprogressBarQuantityAmendOrder() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarQuantityAmendOrder.setProgress(progress);
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

    private void implementationprogressBarLimitPrice() {
        if (progress > 0) {
            progress = 0;
        }

        new Thread(new Runnable() {
            public void run() {
                while (progress < getProgressData()) {
                    progress += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarLimitPrice.setProgress(progress);
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
