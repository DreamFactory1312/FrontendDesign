package com.dreamfactory.novax.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dreamfactory.novax.R;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuOrderFragment extends Fragment {

    private MaterialSpinner spinnerMenuOrder;
    private LineChartView lineChartViewMenuOrder;

    private String[] xAxisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};
    private int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};


    public MenuOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_order, container, false);

        spinnerMenuOrder = view.findViewById(R.id.spinner_menu_order);
        lineChartViewMenuOrder = view.findViewById(R.id.lineChartViewMenuOrder);

        implementationSpinnerMenuOrder();
        implementationLineChartViewMenuOrder();


        return view;
    }

    private void implementationLineChartViewMenuOrder() {

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


        lineChartViewMenuOrder.setLineChartData(data);

        Viewport viewport = new Viewport(lineChartViewMenuOrder.getMaximumViewport());
        viewport.top = 10;  //set max value of Y axies
        lineChartViewMenuOrder.setMaximumViewport(viewport);
        lineChartViewMenuOrder.setCurrentViewport(viewport);

        lineChartViewMenuOrder.setOnValueTouchListener(new LineChartOnValueSelectListener() {

            @Override
            public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
                Toast.makeText(getActivity(), "Touched: " + value.getY(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onValueDeselected() {

            }
        });
    }


    private void implementationSpinnerMenuOrder() {
        spinnerMenuOrder.setItems("1 Year", "2 Year", "3 Year", "4 Year", "5 Year", "6 Year", "7 Year", "8 Year", "9 Year", "10 Year");
        spinnerMenuOrder.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                implementationLineChartViewMenuOrder();  //for change the line chart value

                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public int getArr() {
        return new Random().nextInt(10) + 1;
    }

}
