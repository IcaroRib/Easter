package bsi.pp_2016_1.easter.GUI;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.R;

public class ProfileActivity extends AppCompatActivity {

    private Spinner spinner;

    private User user;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> mopa = new ArrayList<>();

    ArrayList<Integer> imagemId = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};

    EasterEggAdapter eggsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = Session.getInstance().getLoggedUser();

        ImageView userImage = (ImageView)findViewById(R.id.user_image);
        TextView userName = (TextView)findViewById(R.id.user_name_profile);
        TextView profileName = (TextView)findViewById(R.id.profile_name);
        TextView userAge = (TextView)findViewById(R.id.user_age);
        TextView userGender = (TextView)findViewById(R.id.user_gender);

        userImage.setImageResource(user.getUserImage());
        userName.setText(user.getUserName());
        profileName.setText(user.getProfileName());


        MediaListAdapter followedAdapter = new MediaListAdapter(this, user.getFavoritedMedias());
        ListView followed_list = (ListView) findViewById(R.id.list_followed);
        followed_list.setAdapter(followedAdapter);

        followed_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent enterActivity = new Intent(ProfileActivity.this, MediaScreenActivity.class);
                enterActivity.putExtra("media", user.getFavoritedMedias().get(position));
                startActivity(enterActivity);

            }
        });

        eggsAdapter = new EasterEggAdapter(this, user.getPublishedEasterEggs());
        ListView eggs_list = (ListView) findViewById(R.id.list_easter_eggs);

        eggs_list.setAdapter(eggsAdapter);

        eggs_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent enterEasterEgg = new Intent(ProfileActivity.this, EasterEggScreenActivity.class);
                enterEasterEgg.putExtra("easterEgg", user.getPublishedEasterEggs().get(position));
                startActivity(enterEasterEgg);
            }
        });

        TabHost host = (TabHost) findViewById(R.id.tabHost_profile);
        assert host != null;
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab_followed);
        spec.setIndicator("Followed");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab_eggs);
        spec.setIndicator("Your Eggs");
        host.addTab(spec);

        //CÓDIGO REFERENTE AOS MENUS LATERAIS
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout2);

        setupDrawer();

        Session session = Session.getInstance();
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
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent = new Intent(ProfileActivity.this, MediaListScreenActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        for (String item : navArray) {
            mopa.add(item);
        }

        for (Integer imagem : imagId) {
            imagemId.add(imagem);
        }

        SideBarListAdapter listAdapter = new SideBarListAdapter(this, mopa, imagemId);
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
            return true;
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
