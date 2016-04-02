package com.hsns.vefinder.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.hsns.vefinder.R;
import com.hsns.vefinder.data.models.UserProfile;
import com.hsns.vefinder.views.fragments.AboutFragment;
import com.hsns.vefinder.views.fragments.HomeFragment;
import com.hsns.vefinder.views.fragments.MyFriendsFragment;
import com.hsns.vefinder.views.fragments.SettingFragment;

public class MainActivity extends VeBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView mNavigationView;

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isLogin()) {
            LoginActivity.launch(this);
            finish();
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        replaceFragment(HomeFragment.getFragment());
        loadUserProfile();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportActionBar().setTitle(R.string.app_name);
            replaceFragment(new HomeFragment());
        } else if (id == R.id.nav_my_friends) {
            getSupportActionBar().setTitle(R.string.my_friends);
            replaceFragment(MyFriendsFragment.getFragment());
        } else if (id == R.id.nav_about) {
            getSupportActionBar().setTitle(R.string.about);
            replaceFragment(AboutFragment.getFragment());
        } else if (id == R.id.nav_setting) {
            getSupportActionBar().setTitle(R.string.setting);
            replaceFragment(SettingFragment.getFragment());
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    private void loadUserProfile() {
        SimpleDraweeView imvProfile = (SimpleDraweeView) mNavigationView.getHeaderView(0).findViewById(R.id.imvProfile);
        Uri imageUri = Uri.parse(UserProfile.getAvatar());
        ImageRequest mImageRequest = ImageRequestBuilder.newBuilderWithSource(imageUri).setResizeOptions(new ResizeOptions(100, 100)).setImageType(ImageRequest.ImageType.SMALL).build();
        PipelineDraweeController mController = (PipelineDraweeController) Fresco.newDraweeControllerBuilder().setImageRequest(mImageRequest).build();
        imvProfile.setController(mController);
        imvProfile.getHierarchy().setPlaceholderImage(R.drawable.ic_default_profile);
//        imvProfile.getHierarchy().setFailureImage(AppCompatActivity.getDrawable(R.drawable.ic_default_profile));

        TextView txvName = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.txvDisplayName);
        txvName.setText(UserProfile.getDisplayName());
    }
}
