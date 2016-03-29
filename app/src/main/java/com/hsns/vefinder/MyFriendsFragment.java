package com.hsns.vefinder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SENEY SEAN on 3/29/16.
 */
public class MyFriendsFragment extends Fragment {
    private static MyFriendsFragment myFriendsFragment;

    public MyFriendsFragment() {
    }

    public static MyFriendsFragment getMyFriendsFragment() {
        if (myFriendsFragment == null)
            myFriendsFragment = new MyFriendsFragment();
        return myFriendsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_friends, container, false);
    }
}
