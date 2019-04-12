package com.dreamfactory.novax.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamfactory.novax.R;
import com.dreamfactory.novax.model.SocialRating;

import java.util.ArrayList;
import java.util.List;

public class SocialStarRatingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SocialRating> SocialStarRating=new ArrayList<>();
    Context mcontext;
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;

    public SocialStarRatingAdapter(List<SocialRating> SocialRating, Context mcontext) {
        this.SocialStarRating = SocialRating;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.social_star_rating_single_row, viewGroup, false);
        return new SocialStarRatingViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SocialRating list = SocialStarRating.get(position);
        ((SocialStarRatingViewHolder) viewHolder).startradersName.setText(list.getStartradersName());
        ((SocialStarRatingViewHolder) viewHolder).startradersImage.setImageResource(list.getStartradersImage());


    }

    @Override
    public int getItemCount() {
        return SocialStarRating == null ? 0 : SocialStarRating.size();
    }

    public class SocialStarRatingViewHolder extends RecyclerView.ViewHolder{

         ImageView startradersImage;
         TextView startradersName;

        public SocialStarRatingViewHolder(@NonNull View itemView) {
            super(itemView);

            startradersImage=itemView.findViewById(R.id.startradersImage);
            startradersName=itemView.findViewById(R.id.startradersName);

        }
    }
}
