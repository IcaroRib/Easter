package bsi.pp_2016_1.easter.GUI;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import bsi.pp_2016_1.easter.Domain.Session;

import bsi.pp_2016_1.easter.R;

public class FavoritedMediaListScreenActivity extends AppCompatActivity{
    private ListView list;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> sideBarOptions = new ArrayList<>();
    private ArrayList<Integer> sideBarImages = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorited_media_list);

        session = Session.getInstance();

        list = (ListView)findViewById(R.id.list_fav_medias);
        MediaListAdapter mediaListAdapter = new MediaListAdapter(this, session.getLoggedUser().getFavoritedMedias());
        list.setAdapter(mediaListAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent toMedia = new Intent(FavoritedMediaListScreenActivity.this, MediaScreenActivity.class);
                toMedia.putExtra("media", session.getLoggedUser().getFavoritedMedias().get(position));
                startActivity(toMedia);
            }
        });

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.fav_media_list_layout);

        setupDrawer();

        ImageView userImageSideBar = (ImageView)findViewById(R.id.userImage);
        TextView userNameSideBar = (TextView)findViewById(R.id.userName);

        userImageSideBar.setImageResource(session.getLoggedUser().getUserImage());
        userNameSideBar.setText(session.getLoggedUser().getUserName());

        ListView rightDrawer = (ListView) findViewById(R.id.navList);

        assert rightDrawer != null;
        rightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent toListMedia = new Intent(getApplicationContext(), MediaListScreenActivity.class);
                        startActivity(toListMedia);
                        break;
                    case 2:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });

        Collections.addAll(sideBarOptions, navArray);

        Collections.addAll(sideBarImages, imagId);

        SideBarListAdapter listAdapter = new SideBarListAdapter(this, sideBarOptions, sideBarImages);
        ListView lista = (ListView) findViewById(R.id.navList);
        assert lista != null;
        lista.setAdapter(listAdapter);
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);

        } else if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);

        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_openRight) {
            mDrawerLayout.openDrawer(GravityCompat.END);
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                mDrawerLayout.closeDrawer(GravityCompat.END);
            }
            return true;
        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
                mDrawerLayout.closeDrawer(GravityCompat.END);
                return false;
            } else {
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
