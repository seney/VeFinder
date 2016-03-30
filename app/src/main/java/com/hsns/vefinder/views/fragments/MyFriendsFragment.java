package com.hsns.vefinder.views.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsns.vefinder.R;
import com.hsns.vefinder.adapters.VeFragmentPagerAdapter;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class MyFriendsFragment extends Fragment {
    private static MyFriendsFragment fragment;
    private Activity mActivity;
    private TabLayout mTab;
    private ViewPager mViewPager;
    private AppBarLayout mAppBar;
    private VeFragmentPagerAdapter mPagerAdapter;
    private View mViewRoot;

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
        mViewRoot = inflater.inflate(R.layout.fragment_my_friends, container, false);
        return mViewRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTab = new TabLayout(mActivity);
        mTab.setSelectedTabIndicatorColor(Color.WHITE);
        mTab.setSelectedTabIndicatorHeight((int) getActivity().getResources().getDimension(R.dimen.tabIndicatorHeight));
        mTab.setTabTextColors(ActivityCompat.getColor(getContext(), R.color.tab_normal), ActivityCompat.getColor(getContext(), R.color.tab_selected));
        mAppBar = (AppBarLayout) mActivity.findViewById(R.id.main_appbar);
        mAppBar.addView(mTab);
        mViewPager = (ViewPager) mViewRoot.findViewById(R.id.myFriendViewPager);

        setUpTabs();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAppBar.removeView(mTab);
    }

    private void setUpTabs() {
        mPagerAdapter = new VeFragmentPagerAdapter(getChildFragmentManager());
        mPagerAdapter.addPage(FriendMgtFragment.getFragment(), "Friends");
        mPagerAdapter.addPage(FriendRequestFragment.getFragment(), "Request");
        mViewPager.setAdapter(mPagerAdapter);
        mTab.setupWithViewPager(mViewPager);
    }
}
