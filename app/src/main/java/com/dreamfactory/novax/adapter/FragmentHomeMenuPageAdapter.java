package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.HomeMenu;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.view.LineChartView;

public class FragmentHomeMenuPageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeMenu> homeMenuList = new ArrayList<>();
    private Context context;

    public FragmentHomeMenuPageAdapter(List<HomeMenu> homeMenuList, Context context) {
        this.homeMenuList = homeMenuList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_menu_list_row, viewGroup, false);
        return new FragmentHomeMenuListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HomeMenu homeMenu = homeMenuList.get(i);
        ((FragmentHomeMenuListViewHolder) viewHolder).txtFirstText.setText(homeMenu.getFirstText());
        ((FragmentHomeMenuListViewHolder) viewHolder).txtSecondText.setText(homeMenu.getSecondText());
        ((FragmentHomeMenuListViewHolder) viewHolder).imgMenuImage.setImageResource(homeMenu.getImgMenuImage());
        //((FragmentHomeMenuListViewHolder) viewHolder).lineChartViewMenuHomeList.setLineChartData();

    }

    @Override
    public int getItemCount() {
        return homeMenuList == null ? 0 : homeMenuList.size();
    }

    public class FragmentHomeMenuListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuImage;
        TextView txtFirstText, txtSecondText;
        LineChartView lineChartViewMenuHomeList;

        public FragmentHomeMenuListViewHolder(View view) {
            super(view);

            imgMenuImage = view.findViewById(R.id.imgMenuImage);
            txtFirstText = view.findViewById(R.id.txtFirstText);
            txtSecondText = view.findViewById(R.id.txtSecondText);
            lineChartViewMenuHomeList = view.findViewById(R.id.lineChartViewMenuHomeList);
        }

    }
}
