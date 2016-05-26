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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.Reference;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.R;

public class MediaListScreenActivity extends AppCompatActivity {

    private ListView list;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> sideBarOptions = new ArrayList<>();
    private ArrayList<Integer> sideBarImages = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};

    private MediaListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_list);

// ------------------------------------------INICIO DE CODIGO DE TESTES----------------------------------------------------------------------

        final ArrayList<EasterEgg> easterEggs = new ArrayList<>();
        final ArrayList<Media> referenceList = new ArrayList<>();

        EasterEgg e0 = new EasterEgg();
        easterEggs.add(e0);
        EasterEgg e1 = new EasterEgg();
        easterEggs.add(e1);
        EasterEgg e2 = new EasterEgg();
        easterEggs.add(e2);
        EasterEgg e3 = new EasterEgg();
        easterEggs.add(e3);
        EasterEgg e4 = new EasterEgg();
        easterEggs.add(e4);
        EasterEgg e5 = new EasterEgg();
        easterEggs.add(e5);
        EasterEgg e6 = new EasterEgg();
        easterEggs.add(e6);
        EasterEgg e7 = new EasterEgg();
        easterEggs.add(e7);
        EasterEgg e8 = new EasterEgg();
        easterEggs.add(e8);
        EasterEgg e9 = new EasterEgg();
        easterEggs.add(e9);

        final ArrayList<Media> listaMedias = new ArrayList<>();

        Media m0 = new Media();
        listaMedias.add(m0);
        Media m1 = new Media();
        listaMedias.add(m1);
        Media m2 = new Media();
        listaMedias.add(m2);
        Media m3 = new Media();
        listaMedias.add(m3);
        Media m4 = new Media();
        listaMedias.add(m4);
        Media m5 = new Media();
        listaMedias.add(m5);
        Media m6 = new Media();
        listaMedias.add(m6);
        Media m7 = new Media();
        listaMedias.add(m7);
        Media m8 = new Media();
        listaMedias.add(m8);
        Media m9 = new Media();
        listaMedias.add(m9);


        referenceList.add(m0);
        referenceList.add(m5);
        referenceList.add(m3);
        referenceList.add(m2);
        referenceList.add(m7);

        int cont = 0;
        for (EasterEgg egg : easterEggs) {
            egg.setTitle("Easter egg " + cont);
            egg.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            egg.setId(cont);
            egg.setReferenceList(referenceList);
            if (cont > 5) {
                egg.setRate(cont - 5);
            } else {
                egg.setRate(cont);
            }
            cont++;
        }

        int cont2 = 0;
        for (Media media : listaMedias) {
            media.setId(cont2);
            media.setTitle("Media " + cont2);
            media.setMidiaCategory("Movie");
            media.setImageUrl(R.drawable.globe);
            media.setEasterEggs(easterEggs);
            if (cont2 > 5) {
                media.setRate(cont2 - 5);
            } else {
                media.setRate(cont2);
            }
            cont2++;
        }

        User user = new User();
        user.setUserImage(R.drawable.ic_launcher);
        user.setUserName("Francois");
        ArrayList<Media> favoritos = new ArrayList<>();
        favoritos.add(m2);
        favoritos.add(m5);
        favoritos.add(m3);

        User user2 = new User();
        user.setUserImage(R.drawable.ic_launcher);
        user.setUserName("Francois");

        final ArrayList<Comentary> comentaries = new ArrayList<>();
        Comentary c1 = new Comentary();
        Comentary c2 = new Comentary();
        Comentary c3 = new Comentary();
        Comentary c4 = new Comentary();
        Comentary c5 = new Comentary();

        c1.setUserName(user.getUserName());
        c1.setText("Comentário tal");
        c1.setUserPic(user.getUserImage());

        c2.setUserName(user.getUserName());
        c2.setText("Comentário tal");
        c2.setUserPic(user.getUserImage());
        c3.setUserName(user.getUserName());
        c3.setText("Comentário tal");
        c3.setUserPic(user.getUserImage());
        c4.setUserName(user.getUserName());
        c4.setText("Comentário tal");
        c4.setUserPic(user.getUserImage());
        c5.setUserName(user.getUserName());
        c5.setText("Comentário tal");
        c5.setUserPic(user.getUserImage());

        comentaries.add(c1); comentaries.add(c2); comentaries.add(c3); comentaries.add(c4); comentaries.add(c5);


// -------------------------------------------FIM DE CODIGO DE TESTES ------------------------------------------------------------------------

        adapter = new MediaListAdapter(this, listaMedias);
        list=(ListView)findViewById(R.id.list);
        assert list != null;


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent enterActivity = new Intent(MediaListScreenActivity.this, MediaScreenActivity.class);
                enterActivity.putExtra("media", listaMedias.get(position));
                enterActivity.putExtra("comentarios", comentaries);
                startActivity(enterActivity);
            }
        });


        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        //DIREITA
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        List<String> categories = new ArrayList<>();
        categories.add("Most recents");
        categories.add("Most popular");
        categories.add("Best rating");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        assert spinner != null;
        spinner.setAdapter(adapter2);


        setupDrawer();
        SideBarListAdapter listAdapter = new SideBarListAdapter(this, sideBarOptions, sideBarImages);
        ListView rightDrawer = (ListView) findViewById(R.id.navList);
        rightDrawer.setAdapter(listAdapter);

        assert rightDrawer != null;
        rightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MediaListScreenActivity.this, ProfileActivity.class);
                        intent.putExtra("dados", listaMedias);
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

    @Override
    protected void onStart() {
        super.onStart();
        list.setAdapter(adapter);
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
