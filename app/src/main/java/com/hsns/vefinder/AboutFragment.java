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
public class AboutFragment extends Fragment {
    private static AboutFragment aboutFragment;

    public AboutFragment() {
    }

    public static AboutFragment getAboutFragment() {
        if (aboutFragment == null)
            aboutFragment = new AboutFragment();
        return aboutFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }
}
