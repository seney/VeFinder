package com.hsns.vefinder.views.fragments;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.adapters.VeFragmentPagerAdapter;
import com.hsns.vefinder.databinding.FragmentMyFriendsBinding;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class MyFriendsFragment extends Fragment {
    private static final String TAG = MyFriendsFragment.class.getName();
    private static MyFriendsFragment fragment;
    private FragmentMyFriendsBinding mBinding;
    private Activity mActivity;
    private TabLayout mTab;
    private AppBarLayout mAppBar;
    private VeFragmentPagerAdapter mPagerAdapter;

    public MyFriendsFragment() {
    }

    public static MyFriendsFragment getFragment() {
        if (fragment == null)
            fragment = new MyFriendsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_friends, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Initializations
        mTab = new TabLayout(mActivity);
        mAppBar = (AppBarLayout) mActivity.findViewById(R.id.main_appbar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpTabs();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAppBar.removeView(mTab);
    }

    private void setUpTabs() {
        //Add Tab to appbar
        mTab.setSelectedTabIndicatorColor(Color.WHITE);
        mTab.setSelectedTabIndicatorHeight((int) getActivity().getResources().getDimension(R.dimen.tabIndicatorHeight));
        mTab.setTabTextColors(ActivityCompat.getColor(getContext(), R.color.tab_normal), ActivityCompat.getColor(getContext(), R.color.tab_selected));
        mAppBar.addView(mTab);

        //add set tab with viewpager
        mPagerAdapter = new VeFragmentPagerAdapter(getChildFragmentManager());
        mPagerAdapter.addPage(FriendMgtFragment.getFragment(), "Friends");
        mPagerAdapter.addPage(FriendRequestFragment.getFragment(), "Request");
        mBinding.myFriendViewPager.setAdapter(mPagerAdapter);
        mTab.setupWithViewPager(mBinding.myFriendViewPager);
    }
}
