package bsi.pp_2016_1.easter.GUI;

import android.content.Context;
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
import java.util.List;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.Integration.Callback.MediaCallback;
import bsi.pp_2016_1.easter.Integration.Requisition.MediaIntegration;
import bsi.pp_2016_1.easter.R;

public class MediaListScreenActivity extends AppCompatActivity {

    private ListView list;
    private MediaIntegration integration;
    private Context context;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> sideBarOptions = new ArrayList<>();
    private ArrayList<Integer> sideBarImages = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};

    private MediaListAdapter adapter;

    private ArrayList<Media> listMedia;

    private String filtro  = "bests";

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_list);

        listMedia = (ArrayList<Media>) getIntent().getSerializableExtra("mediaList");

        Session session = Session.getInstance();

        context = getApplicationContext();
        List<String> filterCategories = new ArrayList<String>();

        CheckBox check_movie = (CheckBox) findViewById(R.id.check_movie);
        CheckBox check_game = (CheckBox) findViewById(R.id.check_games);
        CheckBox check_book = (CheckBox) findViewById(R.id.check_books);
        CheckBox check_tv = (CheckBox) findViewById(R.id.check_tv);

        CheckBox checkList[] = {check_book,check_game,check_movie,check_tv};

        for (CheckBox cb : checkList) {
            if (cb.isChecked()) {
                filterCategories.add(cb.getText().toString());
            }
        }

        List<String> categories = new ArrayList<>();
        categories.add("Most recents");
        categories.add("Most popular");
        categories.add("Best rating");

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.filter_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    default:
                    case 0:
                        filtro = "recents";
                        break;
                    case 1:
                        filtro = "followeds";
                        break;
                    case 2:
                        filtro = "bests";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new MediaListAdapter(MediaListScreenActivity.this, session.getMedias());
        list=(ListView)findViewById(R.id.list);

            list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent enterActivity = new Intent(MediaListScreenActivity.this, MediaScreenActivity.class);
                enterActivity.putExtra("media",listMedia.get(position));

                startActivity(enterActivity);

            }
        });

        //setListener();


        /*MediaCallback callback = new MediaCallback(){
            @Override
            public Object onSuccess(String response) {

                listMedia = (ArrayList<Media>) super.onSuccess("L" + response);

                adapter = new MediaListAdapter(MediaListScreenActivity.this, listMedia);
                list=(ListView)findViewById(R.id.list);
                if (listMedia.size() < 1) {
                    Toast.makeText(MediaListScreenActivity.this, "No media could be fetched!", Toast.LENGTH_SHORT).show();
                }
                else {
                    list.setAdapter(adapter);
                }

                setListener();

                return null;
            }

            @Override
            public void onFailure(String response) {
                super.onFailure(response);
            }
        };

        integration = new MediaIntegration();
        integration.fetchMedias(callback,context, filtro, filterCategories, 0);
*/

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        //DIREITA
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ImageView userImageSideBar = (ImageView)findViewById(R.id.userImage);
        TextView userNameSideBar = (TextView)findViewById(R.id.userName);

        userImageSideBar.setImageResource(session.getLoggedUser().getUserImage());
        userNameSideBar.setText(session.getLoggedUser().getUserName());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setupDrawer();
        SideBarListAdapter listAdapter = new SideBarListAdapter(this, sideBarOptions, sideBarImages);
        ListView rightDrawer = (ListView) findViewById(R.id.navList);
        rightDrawer.setAdapter(listAdapter);

        rightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MediaListScreenActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        break;
                    case 1:
                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });

        Collections.addAll(sideBarOptions, navArray);

        Collections.addAll(sideBarImages, imagId);
    }
/*
    private void setListener(){

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Media media = listMedia.get(position);

                MediaCallback callback = new MediaCallback(){

                    @Override
                    public Object onSuccess(String response) {

                        Media media = (Media) super.onSuccess(response);
                        Intent enterActivity = new Intent(MediaListScreenActivity.this, MediaScreenActivity.class);
                        enterActivity.putExtra("media",media);
                        startActivity(enterActivity);

                        return  null;
                    }

                    @Override
                    public void onFailure(String response) {
                        super.onFailure(response);
                    }

                };

                integration.findById(media, callback, context );

            }
        });

    }*/

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
            System.exit(0);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_openRight) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
