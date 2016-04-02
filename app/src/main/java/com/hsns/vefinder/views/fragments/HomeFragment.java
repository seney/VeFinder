package com.hsns.vefinder.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class HomeFragment extends FullMap {
    private static HomeFragment fragment;

    public HomeFragment() {
    }

    public static HomeFragment getFragment() {
        if (fragment == null)
            fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
