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

    ArrayList<Comentary> comentaries;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

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
