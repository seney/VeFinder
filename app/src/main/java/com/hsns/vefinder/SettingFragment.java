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
public class SettingFragment extends Fragment {
    private static SettingFragment settingFragment;

    public SettingFragment() {
    }

    public static SettingFragment getSettingFragment() {
        if (settingFragment == null)
            settingFragment = new SettingFragment();
        return settingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}
