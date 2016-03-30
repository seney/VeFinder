package com.hsns.vefinder.views.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

/**
 * Created by SENEY SEAN on 3/30/16.
 */
public class VeBaseActivity extends AppCompatActivity {
    protected static final String MyPREFERENCES = "MyPrefs";
    protected static final String IsLogin = "isLogin";
    protected SharedPreferences sharedpreferences;

    protected boolean isLogin() {
        if (sharedpreferences == null)
            initMySharedPreference();
        return (sharedpreferences.getString(IsLogin, "0").equals("1"));
    }

    private void initMySharedPreference() {
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void logOut() {
        if (sharedpreferences == null)
            initMySharedPreference();
        LoginManager.getInstance().logOut();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.remove(IsLogin);
        editor.commit();
        LoginActivity.launch(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!FacebookSdk.isInitialized())
            FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
