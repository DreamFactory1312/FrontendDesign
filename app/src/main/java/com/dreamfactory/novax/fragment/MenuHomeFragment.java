package com.dreamfactory.novax.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.activity.MenuActivity;
import com.dreamfactory.novax.adapter.FragmentHomeMenuPageAdapter;
import com.dreamfactory.novax.model.HomeMenu;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuHomeFragment extends Fragment {

    private MaterialSpinner spinnerMenuHome;
    private LineChartView lineChartViewMenuHome;
    private SeekBar seekBarMenuHome;
    private LinearLayout llReturnVsRiskLayout, llDiversificationLayout, llProfitAndLoss, llCompletedOrder;
    private TextView txtReturnVsRisk, txtDiversification, txtProfitAndLoss, txtCompletedOrder, txtProfitLossCount;

    private RecyclerView recyclerViewMenuHome;
    private FragmentHomeMenuPageAdapter homeMenuPageAdapter;
    private List<HomeMenu> homeMenuList = new ArrayList<>();

    private String[] xAxisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    private int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

    public MenuHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_home, container, false);

        spinnerMenuHome = view.findViewById(R.id.spinner_menu_home);
        lineChartViewMenuHome = view.findViewById(R.id.lineChartViewMenuHome);
        seekBarMenuHome = view.findViewById(R.id.seekBarMenuHome);

        llReturnVsRiskLayout = view.findViewById(R.id.llReturnVsRiskLayout);
        llDiversificationLayout = view.findViewById(R.id.llDiversificationLayout);
        txtReturnVsRisk = view.findViewById(R.id.txtReturnVsRisk);
        txtDiversification = view.findViewById(R.id.txtDiversification);

        llProfitAndLoss = view.findViewById(R.id.llProfitAndLoss);
        llCompletedOrder = view.findViewById(R.id.llCompletedOrder);
        txtCompletedOrder = view.findViewById(R.id.txtCompletedOrder);
        txtProfitAndLoss = view.findViewById(R.id.txtProfitAndLoss);

        txtProfitLossCount = view.findViewById(R.id.txtProfitLossCount);

        recyclerViewMenuHome = view.findViewById(R.id.recyclerViewMenuHome);
        recyclerViewMenuHome.setHasFixedSize(false);
        recyclerViewMenuHome.setLayoutManager(new LinearLayoutManager(getContext()));


        implementationSpinnerMenuHome();
        implementationLineChartViewMenuHome();
        implementationSeekBarMenuHome();

        implementationllReturnVsRiskLayout();
        implementationllDiversificationLayout();

        implementationllProfitAndLossLayout();
        implementationllCompletedOrderLayout();

        implementationRecyclerViewMenuHome();


        return view;
    }

    private void implementationRecyclerViewMenuHome() {
        homeMenuList.clear();
        homeMenuList.add(new HomeMenu(R.drawable.icon_nvedia, "US:NVIDIA", "40+(1.5%)"));
        homeMenuList.add(new HomeMenu(R.drawable.icon_facebook, "US:AMD", "40+(1.5%)"));
        homeMenuPageAdapter = new FragmentHomeMenuPageAdapter(homeMenuList, getContext());
        recyclerViewMenuHome.setAdapter(homeMenuPageAdapter);
    }

    private void implementationllCompletedOrderLayout() {
        llCompletedOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llProfitAndLoss.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                txtProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                llCompletedOrder.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                txtCompletedOrder.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });
    }

    private void implementationllProfitAndLossLayout() {
        llProfitAndLoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCompletedOrder.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                txtCompletedOrder.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));

                llProfitAndLoss.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                txtProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
            }
        });
    }

    private void implementationllDiversificationLayout() {
        llDiversificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDiversification.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                llDiversificationLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));

                txtReturnVsRisk.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                llReturnVsRiskLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                seekBarMenuHome.setProgress(80);
            }
        });
    }

    private void implementationllReturnVsRiskLayout() {
        llReturnVsRiskLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDiversification.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                llDiversificationLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                txtReturnVsRisk.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
                llReturnVsRiskLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));

                seekBarMenuHome.setProgress(40);
            }
        });
    }

    private void implementationSeekBarMenuHome() {
        seekBarMenuHome.setMax(100);
    }

    private void implementationLineChartViewMenuHome() {

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


        lineChartViewMenuHome.setLineChartData(data);

        Viewport viewport = new Viewport(lineChartViewMenuHome.getMaximumViewport());
        viewport.top = 10;  //set max value of Y axies
        lineChartViewMenuHome.setMaximumViewport(viewport);
        lineChartViewMenuHome.setCurrentViewport(viewport);

        lineChartViewMenuHome.setOnValueTouchListener(new LineChartOnValueSelectListener() {

            @Override
            public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
                Toast.makeText(getActivity(), "Touched: " + value.getY(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }

    private void implementationSpinnerMenuHome() {
        spinnerMenuHome.setItems("2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020");
        spinnerMenuHome.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();

//                lineChartViewMenuHome.clearAnimation();
//                lineChartViewMenuHome.clearFocus();
                implementationLineChartViewMenuHome();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }
}
