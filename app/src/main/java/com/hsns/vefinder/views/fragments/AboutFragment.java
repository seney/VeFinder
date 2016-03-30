package com.hsns.vefinder.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class AboutFragment extends Fragment {
    private static AboutFragment fragment;

    public AboutFragment() {
    }

    public static AboutFragment getFragment() {
        if (fragment == null)
            fragment = new AboutFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }
}
