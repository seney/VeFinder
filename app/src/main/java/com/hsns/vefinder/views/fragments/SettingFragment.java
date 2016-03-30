package com.hsns.vefinder.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.databinding.FragmentSettingBinding;
import com.hsns.vefinder.views.activities.MainActivity;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class SettingFragment extends Fragment {
    private static SettingFragment fragment;
    private FragmentSettingBinding mBinding;

    public SettingFragment() {
    }

    public static SettingFragment getFragment() {
        if (fragment == null)
            fragment = new SettingFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initEvent();
    }

    private void initEvent() {
        mBinding.btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).logOut();
                MainActivity.launch(getActivity());
            }
        });
    }
}
