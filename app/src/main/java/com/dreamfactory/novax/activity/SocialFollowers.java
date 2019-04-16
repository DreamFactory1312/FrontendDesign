package com.dreamfactory.novax.activity;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.SocialFollowersAdapter;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.model.Watchlist;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class SocialFollowers extends AppCompatActivity {

    private Toolbar toolBarSoicalFollowers;

    private MaterialSpinner spinnerYearSocialFollowers;
    private LineChartView lineSocialFollowers;
    private LinearLayout llCurrentTradesTab, llTradesReviewTab;
    private TextView txtCurrentTradesTab, txtTraderReviewsTab;
    private RecyclerView recyclerViewSocialFollowers;
    List<Watchlist> socialFollowersList = new ArrayList<>();
    private SocialFollowersAdapter socialFollowersAdapter;

    private String[] xAxisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    private int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_followes);

        toolBarSoicalFollowers = findViewById(R.id.toolBarSoicalFollowers);
        recyclerViewSocialFollowers = findViewById(R.id.recyclerViewSocialFollowers);
        toolBarSoicalFollowers.setTitle("Social Followers");
        setSupportActionBar(toolBarSoicalFollowers);

        lineSocialFollowers = findViewById(R.id.lineSocialFollowers);
        spinnerYearSocialFollowers = findViewById(R.id.spinnerYearSocialFollowers);
        llCurrentTradesTab = findViewById(R.id.llCurrentTradesTab);
        llTradesReviewTab = findViewById(R.id.llTradesReviewTab);
        txtCurrentTradesTab = findViewById(R.id.txtCurrentTradesTab);
        txtTraderReviewsTab = findViewById(R.id.txtTraderReviewsTab);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        implementationSpinnerYearSocialFollowers();
        implementationLineSocialFollowers();
        implementationllCurrentTradesTab();
        implementationllTradesReviewTab();
        implementationRecycler();

        firstCall();
    }

    private void implementationRecycler() {
        recyclerViewSocialFollowers.setHasFixedSize(false);
        recyclerViewSocialFollowers.setLayoutManager(new LinearLayoutManager(this));

        socialFollowersList.clear();
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));
        socialFollowersList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "3,010", "100", "1200", "200"));

        socialFollowersAdapter = new SocialFollowersAdapter(socialFollowersList, this);
        recyclerViewSocialFollowers.setAdapter(socialFollowersAdapter);

    }

    private void firstCall() {
        llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_sharpe));
        txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

        llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_shape_white));
        txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

    }

    private void implementationllTradesReviewTab() {
        llTradesReviewTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_sharpe));
                txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_shape_white));
                txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            }
        });
    }

    private void implementationllCurrentTradesTab() {
        llCurrentTradesTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCurrentTradesTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.left_convertlayout_rounded_sharpe));
                txtCurrentTradesTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                llTradesReviewTab.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.right_convertlayout_rounded_shape_white));
                txtTraderReviewsTab.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));



            }
        });
    }

    private void implementationLineSocialFollowers() {
        List yAxisValues = new ArrayList();
        List xAisValues = new ArrayList();


        Line line = new Line(yAxisValues).setColor(Color.parseColor("#339684"));

        for (int i = 0; i < xAxisData.length; i++) {
            xAisValues.add(i, new AxisValue(i).setLabel(xAxisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, getArr()));
        }

        List lines = new ArrayList();
        lines.add(line);

        final LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis xAxis = new Axis();
        xAxis.setValues(xAisValues);
        xAxis.setTextSize(12);
        xAxis.setTextColor(Color.parseColor("#000000"));
        data.setAxisXBottom(xAxis);

        Axis yAxis = new Axis();
//        yAxis.setName("Sales in millions");
        yAxis.setTextColor(Color.parseColor("#000000"));
        yAxis.setTextSize(12);
        data.setAxisYLeft(yAxis);


        lineSocialFollowers.setLineChartData(data);

        Viewport viewport = new Viewport(lineSocialFollowers.getMaximumViewport());
        viewport.top = 10;  //set max value of Y axies
        lineSocialFollowers.setMaximumViewport(viewport);
        lineSocialFollowers.setCurrentViewport(viewport);

        lineSocialFollowers.setOnValueTouchListener(new LineChartOnValueSelectListener() {

            @Override
            public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
                Toast.makeText(getApplicationContext(), "Touched: " + value.getY(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }

    private void implementationSpinnerYearSocialFollowers() {
        spinnerYearSocialFollowers.setItems("1 Year", "2 Year", "3 Year", "4 Year", "5 Year", "6 Year", "7 Year", "8 Year", "9 Year", "10 Year");
        spinnerYearSocialFollowers.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                implementationLineSocialFollowers();  //for change the line chart value

                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
