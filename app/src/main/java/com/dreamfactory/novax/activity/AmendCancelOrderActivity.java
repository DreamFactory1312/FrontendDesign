package com.dreamfactory.novax.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dreamfactory.novax.R;

public class AmendCancelOrderActivity extends AppCompatActivity {

    private Toolbar toolBarBalance;
    private Button btn_amend_order, btn_cancel_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amend_cancel_order);

        btn_amend_order = findViewById(R.id.btn_amend_order);
        btn_cancel_order = findViewById(R.id.btn_cancel_order);

        toolBarBalance = findViewById(R.id.toolBarBalance);
        toolBarBalance.setTitle(R.string.US_NVIDIA);
        setSupportActionBar(toolBarBalance);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btn_cancel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AmendCancelOrderActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_amend_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AmendOrder.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        } else if (item.getItemId() == R.id.item_menu_search) {
            Toast.makeText(this, "Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}
