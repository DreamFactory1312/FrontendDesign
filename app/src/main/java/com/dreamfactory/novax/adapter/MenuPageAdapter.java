package com.dreamfactory.novax.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dreamfactory.novax.fragment.MenuHomeFragment;
import com.dreamfactory.novax.fragment.MenuOrderFragment;
import com.dreamfactory.novax.fragment.MenuPortfoiloFragment;
import com.dreamfactory.novax.fragment.MenuSocialFragment;

public class MenuPageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public MenuPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MenuHomeFragment();
            case 1:
                return new MenuOrderFragment();
            case 2:
                return new MenuPortfoiloFragment();
            case 3:
                return new MenuSocialFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
