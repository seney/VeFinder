package com.hsns.vefinder.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.databinding.FragmentFriendRequestBinding;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class FriendRequestFragment extends Fragment {
    private static FriendRequestFragment fragment;
    private FragmentFriendRequestBinding mBinding;

    public FriendRequestFragment() {
    }

    public static FriendRequestFragment getFragment() {
        if (fragment == null)
            fragment = new FriendRequestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend_request, container, false);
        ;
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
