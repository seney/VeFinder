package com.hsns.vefinder.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.databinding.FragmentHomeBinding;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class HomeFragment extends Fragment {
    private static HomeFragment fragment;
    private FragmentHomeBinding mBinding;

    public HomeFragment() {
    }

    public static HomeFragment getFragment() {
        if (fragment == null)
            fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBinding.txvSMS.setText("Hello me");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
