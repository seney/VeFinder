package com.hsns.vefinder.views.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.data.models.Friend;
import com.hsns.vefinder.data.viewmodels.FriendViewModel;
import com.hsns.vefinder.data.viewmodels.FriendsViewModel;
import com.hsns.vefinder.databinding.FragmentFriendMgtBinding;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class FriendMgtFragment extends Fragment {
    private static FriendMgtFragment fragment;
    private FragmentFriendMgtBinding mBinding;
    private FriendsViewModel items;
    private FriendViewModel item;
    private LinearLayoutManager layoutManager;

    public FriendMgtFragment() {
    }

    public static FriendMgtFragment getFragment() {
        if (fragment == null)
            fragment = new FriendMgtFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend_mgt, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        items = new FriendsViewModel();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBinding.rclFriend.setLayoutManager(layoutManager);
        mBinding.setItems(items);

        loadData();
    }

    private void loadData() {
        Friend friend = new Friend();
        friend.setDisplayName("Seney Sean");
        item = new FriendViewModel();
        item.setModel(friend);

        items.addItem(item);
        items.addItem(item);
        items.addItem(item);
        items.addItem(item);
    }
}
