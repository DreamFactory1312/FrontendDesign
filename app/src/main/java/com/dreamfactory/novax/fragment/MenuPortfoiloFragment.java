package com.dreamfactory.novax.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.adapter.FragmentHomeMenuPageAdapter;
import com.dreamfactory.novax.adapter.PortfoliosAdapter;
import com.dreamfactory.novax.adapter.WatchlistAdapter;
import com.dreamfactory.novax.model.HomeMenu;
import com.dreamfactory.novax.model.Watchlist;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuPortfoiloFragment extends Fragment {

    private RecyclerView recyclerViewMenuHomePorfolios;
    private PortfoliosAdapter homeMenuPorfoliosPageAdapter;
    private List<Watchlist> homeMenuPorfoliosList = new ArrayList<>();

    private LinearLayout llMenuPortfoiloAll, llMenuPortfoiloHKD, llMenuPortfoiloUSD;
    private TextView txtFirstPercentage, txtSecondPercentage;
    private SeekBar seekBarMenuPortfoiloRVS, seekBarMenuPortfoiloDiversification;

    public MenuPortfoiloFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menu_portfoilo, container, false);
        recyclerViewMenuHomePorfolios = view.findViewById(R.id.portfoliosRecycler);
        recyclerViewMenuHomePorfolios.setHasFixedSize(false);
        recyclerViewMenuHomePorfolios.setLayoutManager(new LinearLayoutManager(getContext()));

        llMenuPortfoiloAll = view.findViewById(R.id.llMenuPortfoiloAll);
        llMenuPortfoiloHKD = view.findViewById(R.id.llMenuPortfoiloHKD);
        llMenuPortfoiloUSD = view.findViewById(R.id.llMenuPortfoiloUSD);

        txtFirstPercentage = view.findViewById(R.id.txtFirstPercentage);
        txtSecondPercentage = view.findViewById(R.id.txtSecondPercentage);

        seekBarMenuPortfoiloRVS = view.findViewById(R.id.seekBarMenuPortfoiloRVS);
        seekBarMenuPortfoiloDiversification = view.findViewById(R.id.seekBarMenuPortfoiloDiversification);


        implementationRecyclerViewMenuHome();

        implementationSeekBarMenuPortfoiloRVS();
        implementationSeekBarMenuPortfoiloDiversification();

        implementationllMenuPortfoiloAll();
        implementationllMenuPortfoiloHKD();
        implementationllMenuPortfoiloUSD();

        return view;
    }

    private void implementationllMenuPortfoiloUSD() {
        llMenuPortfoiloUSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMenuPortfoiloUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                llMenuPortfoiloHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                llMenuPortfoiloAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                seekBarMenuPortfoiloRVS.setProgress(40);
                seekBarMenuPortfoiloDiversification.setProgress(70);
                txtFirstPercentage.setText("-13.62%");
                txtSecondPercentage.setText("08");
            }
        });
    }

    private void implementationllMenuPortfoiloHKD() {
        llMenuPortfoiloHKD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMenuPortfoiloHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                llMenuPortfoiloUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                llMenuPortfoiloAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                seekBarMenuPortfoiloRVS.setProgress(80);
                seekBarMenuPortfoiloDiversification.setProgress(30);
                txtFirstPercentage.setText("-18.60%");
                txtSecondPercentage.setText("11");
            }
        });
    }

    private void implementationllMenuPortfoiloAll() {
        llMenuPortfoiloAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llMenuPortfoiloAll.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryLight));
                llMenuPortfoiloHKD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                llMenuPortfoiloUSD.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

                seekBarMenuPortfoiloRVS.setProgress(76);
                seekBarMenuPortfoiloDiversification.setProgress(86);
                txtFirstPercentage.setText("-28.90%");
                txtSecondPercentage.setText("05");
            }
        });
    }

    private void implementationSeekBarMenuPortfoiloDiversification() {
        seekBarMenuPortfoiloDiversification.setMax(100);
    }

    private void implementationSeekBarMenuPortfoiloRVS() {
        seekBarMenuPortfoiloRVS.setMax(100);
    }

    private void implementationRecyclerViewMenuHome() {
        homeMenuPorfoliosList.clear();
        homeMenuPorfoliosList.add(new Watchlist(R.drawable.icon_nvedia, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        homeMenuPorfoliosList.add(new Watchlist(R.drawable.icon_facebook, "US: NVIDIA", "40", "15", "30,372.50", "4,500", "-22.4", "39.73"));
        homeMenuPorfoliosPageAdapter = new PortfoliosAdapter(homeMenuPorfoliosList, getContext());
        recyclerViewMenuHomePorfolios.setAdapter(homeMenuPorfoliosPageAdapter);
    }

}
