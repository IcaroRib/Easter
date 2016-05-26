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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.R;

public class ProfileActivity extends AppCompatActivity {

    private Spinner spinner;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> mopa = new ArrayList<>();

    ArrayList<Integer> imagemId = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};




    RelativeLayout buttonsLayout;
    TesteEasterEggAdapter insideEggsAdapter;

    TesteEasterEggAdapter eggsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

// ------------------------------------------INICIO DE CODIGO DE TESTES----------------------------------------------------------------------

        final ArrayList<EasterEgg> easterEggs = new ArrayList<>();

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

        int cont = 0;
        for (EasterEgg egg : easterEggs) {
            egg.setDescription("Easter egg " + cont);
            egg.setId(cont);
            cont++;
        }
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


        int cont2 = 0;
        for (Media media : listaMedias) {
            media.setId(cont2);
            media.setTitle("Media " + cont2);
            media.setMidiaCategory("Movie");
            media.setImageUrl(String.valueOf(R.drawable.globe));
            media.setEasterEggs(easterEggs);
            if (cont2 > 5) {
                media.setRate(cont2 - 5);
            } else {
                media.setRate(cont2);
            }
            cont2++;
        }

        // final ArrayList<EasterEgg> easterEggs = (ArrayList<EasterEgg>)getIntent().getSerializableExtra("dados");

// -------------------------------------------FIM DE CODIGO DE TESTES ------------------------------------------------------------------------

        buttonsLayout = (RelativeLayout) findViewById(R.id.linearVanish);
        assert buttonsLayout != null;
        buttonsLayout.setVisibility(View.GONE);

        MediaListAdapter followedAdapter = new MediaListAdapter(this, listaMedias);
        ListView followed_list = (ListView) findViewById(R.id.list_followed);
        assert followed_list != null;
        followed_list.setAdapter(followedAdapter);

        followed_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "mopa", Toast.LENGTH_SHORT).show();
            }
        });

        eggsAdapter = new TesteEasterEggAdapter(this, listaMedias);
        ListView eggs_list = (ListView) findViewById(R.id.list_easter_eggs);
        assert eggs_list != null;
        eggs_list.setAdapter(eggsAdapter);

        eggs_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Toast.makeText(getApplicationContext(), "mopa", Toast.LENGTH_SHORT).show();

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

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab_rating);
        spec.setIndicator("Ratings");
        host.addTab(spec);

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout2);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.filter_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(ProfileActivity.this, "Most Recents", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(ProfileActivity.this, "Most Popular", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(ProfileActivity.this, "Best Rating", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setupDrawer();

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
            System.exit(0);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
