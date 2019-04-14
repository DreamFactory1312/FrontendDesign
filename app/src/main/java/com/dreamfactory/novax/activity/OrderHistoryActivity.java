package com.dreamfactory.novax.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dreamfactory.novax.R;

public class OrderHistoryActivity extends AppCompatActivity {
    private Toolbar toolBarAmendOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        toolBarAmendOrder = findViewById(R.id.toolbar_order_history);
        toolBarAmendOrder.setTitle("Orders");
        setSupportActionBar(toolBarAmendOrder);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
