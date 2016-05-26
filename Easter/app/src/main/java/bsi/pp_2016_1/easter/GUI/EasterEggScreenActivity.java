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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.R;

public class EasterEggScreenActivity extends AppCompatActivity {

    private EasterEgg easterEgg;

    private TextView easterTitle;
    private RatingBar easterRating;
    private TextView easterDescription;
    private TabHost easterTabs;
    private ListView eggComments;
    private ListView eggReferences;
    private Button addCommentEasterEgg;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ArrayList<String> sideBarOptions = new ArrayList<>();
    private ArrayList<Integer> sideBarImages = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};

    private ViewFlipper flipper;

    //NEW COMMENT COMPONENTS
    private Button sendEasterEggComment;
    private Button cancelEasterEggContent;
    private RatingBar ratingBar;
    private EditText textComment;


    //EDIT EASTER EGG COMPONENTS
    private EditText editEasterEggTitle;
    private EditText editEasterEggDescription;
    private Button editEasterEgg;
    private Button cancelEditEasterEgg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

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


        easterEgg = (EasterEgg) getIntent().getSerializableExtra("easterEgg");
        easterTitle = (TextView) findViewById(R.id.egg_title);
        easterRating = (RatingBar) findViewById(R.id.egg_rating);
        easterDescription = (TextView) findViewById(R.id.egg_description);

        easterTitle.setText(easterEgg.getTitle());
        easterRating.setRating(easterEgg.getRate());
        easterDescription.setText(easterEgg.getDescription());

        eggComments = (ListView) findViewById(R.id.egg_comments);
        easterTabs = (TabHost) findViewById(R.id.egg_tabs);

        final ComentaryListAdapterWithRate comentList = new ComentaryListAdapterWithRate(this, comentaries);
        eggComments.setAdapter(comentList);

        eggReferences = (ListView) findViewById(R.id.referenced_medias);
        final MediaListAdapter referencedMedias = new MediaListAdapter(this, easterEgg.getReferenceList());
        eggReferences.setAdapter(referencedMedias);
        eggReferences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent enterActivity = new Intent(EasterEggScreenActivity.this, MediaScreenActivity.class);
                enterActivity.putExtra("media", easterEgg.getReferenceList().get(position));
                enterActivity.putExtra("comentarios", comentaries);
                startActivity(enterActivity);
            }
        });

        easterTabs.setup();

        TabHost.TabSpec spec = easterTabs.newTabSpec("Tab One");
        spec.setContent(R.id.referenced_medias);
        spec.setIndicator("References");
        easterTabs.addTab(spec);

        spec = easterTabs.newTabSpec("Tab Two");
        spec.setContent(R.id.comments);
        spec.setIndicator("Comments");
        easterTabs.addTab(spec);


        flipper = (ViewFlipper)findViewById(R.id.view_flipper_easter_egg);

        editEasterEggTitle = (EditText)findViewById(R.id.title_new_easter_egg);
        editEasterEggDescription = (EditText)findViewById(R.id.add_description_easter_egg);
        editEasterEgg = (Button)findViewById(R.id.send_new_easter_egg);
        cancelEditEasterEgg = (Button)findViewById(R.id.cancel_new_easter_egg);

        sendEasterEggComment = (Button) findViewById(R.id.send_easter_egg_comment);
        cancelEasterEggContent = (Button)findViewById(R.id.cancel_easter_egg_comment);
        ratingBar = (RatingBar)findViewById(R.id.rating_bar_easter_egg_comment); 
        textComment = (EditText)findViewById(R.id.easter_egg_comment);

        addCommentEasterEgg = (Button)findViewById(R.id.bt_add_comment_egg);
        addCommentEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.second_easter_egg)));
                final Comentary comentario = new Comentary();
                comentario.setText(textComment.getText().toString());
                comentario.setRate((int) ratingBar.getRating());
                sendEasterEggComment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        comentaries.add(comentario);
                        comentList.notifyDataSetChanged();
                        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
                    }
                });
                cancelEasterEggContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
                    }
                });
            }
        });

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        //DIREITA
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_easter_egg);

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
                        Intent toProfile = new Intent(EasterEggScreenActivity.this, ProfileActivity.class);
                        startActivity(toProfile);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        finish();
                        break;
                    case 1:
                        Intent toFeed = new Intent(EasterEggScreenActivity.this, MediaListScreenActivity.class);
                        startActivity(toFeed);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        finish();
                        break;
                }
            }
        });

        Collections.addAll(sideBarOptions, navArray);

        Collections.addAll(sideBarImages, imagId);
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
        if (id == R.id.action_openEdit) {
            if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
            editItem();

            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void editItem() {
        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.third_easter_egg)));
        editEasterEggTitle.setText(easterEgg.getTitle());
        editEasterEggDescription.setText(easterEgg.getDescription());
        editEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easterEgg.setTitle(editEasterEggTitle.getText().toString());
                easterEgg.setDescription(editEasterEggDescription.getText().toString());

                easterTitle.setText(easterEgg.getTitle());
                easterRating.setRating(easterEgg.getRate());
                easterDescription.setText(easterEgg.getDescription());

                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
            }
        });
        cancelEditEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
            }
        });

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
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }



}
