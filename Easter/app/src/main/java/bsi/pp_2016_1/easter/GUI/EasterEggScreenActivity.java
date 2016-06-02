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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;

import bsi.pp_2016_1.easter.Domain.Commentary;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.R;

public class EasterEggScreenActivity extends AppCompatActivity {

    private EasterEgg easterEgg;
    ComentaryListAdapterWithRate comentList;
    Commentary commentary;

    private TextView easterTitle;
    private RatingBar easterRating;
    private TextView eggDescription;
    private TabHost easterTabs;
    private ListView eggComments;
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

        final Session session = Session.getInstance();

        easterEgg = (EasterEgg) getIntent().getSerializableExtra("easterEgg");
        easterTitle = (TextView) findViewById(R.id.egg_title);
        easterRating = (RatingBar) findViewById(R.id.egg_rating);
        eggDescription = (TextView) findViewById(R.id.egg_description);

        easterTitle.setText(easterEgg.getTitle());
        easterRating.setRating(easterEgg.getRate());
        eggDescription.setText(easterEgg.getDescription());

        eggComments = (ListView) findViewById(R.id.egg_comments);
        easterTabs = (TabHost) findViewById(R.id.egg_tabs);


        if(easterEgg.getCommentList() != null) {
            comentList = new ComentaryListAdapterWithRate(this, easterEgg.getCommentList());
            eggComments.setAdapter(comentList);
        }
        ListView eggReferences = (ListView) findViewById(R.id.referenced_medias);

        if (easterEgg.getReferenceList() != null) {
        final MediaListAdapter referencedMedias = new MediaListAdapter(this, easterEgg.getReferenceList());
            eggReferences.setAdapter(referencedMedias);
        }
        eggReferences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent enterActivity = new Intent(EasterEggScreenActivity.this, MediaScreenActivity.class);
                enterActivity.putExtra("media", easterEgg.getReferenceList().get(position));
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

        textComment = (EditText)findViewById(R.id.easter_egg_comment);

        addCommentEasterEgg = (Button)findViewById(R.id.bt_add_comment_egg);
        addCommentEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.second_easter_egg)));

                addListenerRatingBar();

                SideBarVisible(false);

                commentary = new Commentary();
                commentary.setText(textComment.getText().toString());
                commentary.setUserName(session.getLoggedUser().getUserName());
                commentary.setUserPic(session.getLoggedUser().getUserImage());
                sendEasterEggComment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        easterEgg.addCommentary(commentary);
                        comentList.notifyDataSetChanged();
                        SideBarVisible(true);

                        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
                    }
                });
                cancelEasterEggContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SideBarVisible(true);
                        flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
                    }
                });
            }
        });

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        //ESQUERDA
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ImageView userImageSideBar = (ImageView)findViewById(R.id.userImage);
        TextView userNameSideBar = (TextView)findViewById(R.id.userName);

        userImageSideBar.setImageResource(session.getLoggedUser().getUserImage());
        userNameSideBar.setText(session.getLoggedUser().getUserName());


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_easter_egg);

        setupDrawer();
        SideBarListAdapter listAdapter = new SideBarListAdapter(this, sideBarOptions, sideBarImages);
        ListView rightDrawer = (ListView) findViewById(R.id.navList);
        rightDrawer.setAdapter(listAdapter);

        rightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
                case 2:
                    Intent toFavMedias = new Intent(EasterEggScreenActivity.this, FavoritedMediaListScreenActivity.class);
                    startActivity(toFavMedias);
                    overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                    finish();
                    break;
            }
            }
        });

        Collections.addAll(sideBarOptions, navArray);

        Collections.addAll(sideBarImages, imagId);
    }

    private void addListenerRatingBar(){
        ratingBar = (RatingBar)findViewById(R.id.rating_bar_easter_egg_comment);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                commentary.setRate(4);
            }
        });
    };


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
                SideBarVisible(false);

                easterEgg.setTitle(editEasterEggTitle.getText().toString());
                easterEgg.setDescription(editEasterEggDescription.getText().toString());

                easterTitle.setText(easterEgg.getTitle());
                easterRating.setRating(easterEgg.getRate());
                eggDescription.setText(easterEgg.getDescription());

                SideBarVisible(true);
                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
            }
        });
        cancelEditEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);

                flipper.setDisplayedChild(flipper.indexOfChild(findViewById(R.id.first_easter_egg)));
            }
        });

    }

    private void SideBarVisible(boolean situation) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(situation);
        getSupportActionBar().setHomeButtonEnabled(situation);
        mDrawerToggle.setDrawerIndicatorEnabled(situation);
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
