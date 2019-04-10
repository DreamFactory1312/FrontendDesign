package com.dreamfactory.novax.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamfactory.novax.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuSocialFragment extends Fragment {


    public MenuSocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_social, container, false);
    }

}
