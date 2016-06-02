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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Collections;

import bsi.pp_2016_1.easter.Domain.Commentary;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.R;


public class MediaScreenActivity extends AppCompatActivity {

    private Media media;
    private ArrayList<Commentary> comentarios;

    private TextView mediaName;
    private TextView mediaCategory;
    private Switch isFollowing;
    private RatingBar ratingBar;

    private ListView listOfEggs;
    private ListView listOfComments;
    private ListView listOfReferences;

    private TabHost host;

    private Button addEasterEgg;
    private Button addMediaComment;

    //NEW COMMENT COMPONENTS
    private EditText textComment;
    private Button sendMediaComment;
    private Button cancelMediaContent;

    //NEW EASTER EGG COMPONENTS
    private EditText newEasterEggTitle;
    private EditText newEasterEggDescription;
    private Button createNewEasterEgg;
    private Button cancelNewEasterEgg;

    private ViewFlipper vf;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private ListView rightDrawer;

    private ComentaryListAdapter comentList;

    private ArrayList<String> sideBarOptions = new ArrayList<>();
    private ArrayList<Integer> sideBarImages = new ArrayList<>();

    String[] navArray = {"My profile", "Easter feed", "Followed media", "Rate the app", "Sign out"};
    Integer[] imagId = {R.drawable.patient, R.drawable.rss_icon, R.drawable.heart_icon, R.drawable.half_star_icon, R.drawable.logout_icon};
    private ImageView mediaImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        final Session session = Session.getInstance();

        media = (Media) getIntent().getSerializableExtra("media");
        comentarios = media.getCommentList();

        mediaImage = (ImageView)findViewById(R.id.media_image);
        mediaName = (TextView) findViewById(R.id.media_name);
        mediaCategory = (TextView) findViewById(R.id.media_category);
        isFollowing = (Switch) findViewById(R.id.is_following);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar3);

        listOfEggs = (ListView) findViewById(R.id.list_easter_eggs);
        listOfComments = (ListView)findViewById(R.id.list_comments);
        listOfReferences = (ListView)findViewById(R.id.media_references);

        addEasterEgg = (Button)findViewById(R.id.bt_add_easter_egg);
        addMediaComment = (Button)findViewById(R.id.bt_add_comment_media);

        vf = (ViewFlipper) findViewById(R.id.view_flipper_media);
        comentList = new ComentaryListAdapter(this, media.getCommentList());
        listOfComments.setAdapter(comentList);

        mediaImage.setImageResource(R.drawable.lhama_glasses);
        mediaName.setText(media.getTitle());
        mediaCategory.setText(media.getMidiaCategory());
        isFollowing.setChecked(true);

        for (Media m: session.getLoggedUser().getFavoritedMedias()) {
            if (m.getTitle().equals(media.getTitle())){
                isFollowing.setChecked(true);
                Toast.makeText(MediaScreenActivity.this, "mopa", Toast.LENGTH_SHORT).show();
            }else {
                isFollowing.setChecked(false);
            }
        }


        ratingBar.setRating(media.getRate());

        isFollowing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && !session.getLoggedUser().getFavoritedMedias().contains(media)){
                    session.getLoggedUser().addFavoritedMidia(media);
                }else {
                    session.getLoggedUser().removeFavoritedMidia(media);
                }
            }
        });


        EasterEggListAdapter eggsList = new EasterEggListAdapter(this, media.getEasterEggs());
        if (listOfEggs != null){

            listOfEggs.setAdapter(eggsList);

            listOfEggs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent openEasterEgg = new Intent(MediaScreenActivity.this, EasterEggScreenActivity.class);
                    openEasterEgg.putExtra("easterEgg", media.getEasterEggs().get(position));
                    startActivity(openEasterEgg);
                }
            });
        }
        if (listOfReferences != null){

            ReferencedMediaAdapter referencedMediaAdapter = new ReferencedMediaAdapter(this, media.getEasterEggs());
            listOfReferences.setAdapter(referencedMediaAdapter);

            listOfReferences.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int aux = 0, aux2 = 0;

                    Intent intent = new Intent(MediaScreenActivity.this, MediaScreenActivity.class);

                    if(position%1==0){
                        aux = position/1;
                    }else{
                        aux2 = position%1;
                    }
                    intent.putExtra("media",media.getEasterEggs().get(aux).getReferenceList().get(aux2));
                    startActivity(intent);
                }
            });
        }else {
            Toast.makeText(MediaScreenActivity.this, "No Media Related Found", Toast.LENGTH_SHORT).show();
        }

        host = (TabHost) findViewById(R.id.tabHost_mediaScrenActivity);

        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab_easter_egg);
        spec.setIndicator("Eggs");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab_Comments);
        spec.setIndicator("Comments");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab_references);
        spec.setIndicator("Related");
        host.addTab(spec);

        addEasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.third)));

                newEasterEggTitle = (EditText)findViewById(R.id.title_new_easter_egg);
                newEasterEggDescription = (EditText)findViewById(R.id.add_description_easter_egg);
                createNewEasterEgg = (Button)findViewById(R.id.send_new_easter_egg);
                cancelNewEasterEgg = (Button)findViewById(R.id.cancel_new_easter_egg);

                createNewEasterEgg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SideBarStatus(false);

                        EasterEgg easterEgg = new EasterEgg();
                        easterEgg.setTitle(newEasterEggTitle.getText().toString());
                        easterEgg.setDescription(newEasterEggDescription.getText().toString());
                        media.getEasterEggs().add(easterEgg);
                        comentList.notifyDataSetChanged();

                        newEasterEggTitle.setText(null);
                        newEasterEggDescription.setText(null);

                        SideBarStatus(true);
                        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.first)));
                    }
                });
                cancelNewEasterEgg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.first)));
                        SideBarStatus(true);
                    }
                });
            }
        });


        addMediaComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.second)));

                SideBarStatus(false);

                textComment = (EditText)findViewById(R.id.text_comment);
                sendMediaComment = (Button)findViewById(R.id.send_new_media_comment);
                sendMediaComment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Commentary commentary = new Commentary();
                        commentary.setUserName(media.getCommentList().get(0).getUserName());
                        commentary.setUserPic(media.getCommentList().get(0).getUserPic());
                        commentary.setText(textComment.getText().toString());
                        media.getCommentList().add(commentary);
                        comentList.notifyDataSetChanged();

                        textComment.setText(null);

                        SideBarStatus(true);
                        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.first)));
                    }
                });
                cancelMediaContent = (Button)findViewById(R.id.cancel_new_media_comment);
                cancelMediaContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SideBarStatus(true);
                        vf.setDisplayedChild(vf.indexOfChild(findViewById(R.id.first)));
                    }
                });

            }
        });

        //CÓDIGO REFERENTE AOS MENUS LATERAIS

        SideBarStatus(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_media);

        ImageView userImageSideBar = (ImageView)findViewById(R.id.userImage);
        TextView userNameSideBar = (TextView)findViewById(R.id.userName);

        userImageSideBar.setImageResource(session.getLoggedUser().getUserImage());
        userNameSideBar.setText(session.getLoggedUser().getUserName());

        setupDrawer();

        rightDrawer = (ListView) findViewById(R.id.navList);

        rightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent toProfile = new Intent(MediaScreenActivity.this, ProfileActivity.class);
                        startActivity(toProfile);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        finish();
                        break;
                    case 1:
                        Intent toFeed = new Intent(MediaScreenActivity.this, MediaListScreenActivity.class);
                        startActivity(toFeed);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        finish();
                        break;
                    case 2:
                        Intent toFavMedias = new Intent(getApplicationContext(), FavoritedMediaListScreenActivity.class);
                        startActivity(toFavMedias);
                        overridePendingTransition(R.layout.push_right_in, R.layout.push_right_out);
                        finish();
                        break;
                }
            }
        });

        SideBarListAdapter listAdapter = new SideBarListAdapter(this, sideBarOptions, sideBarImages);
        ListView rightDrawer = (ListView) findViewById(R.id.navList);
        rightDrawer.setAdapter(listAdapter);

        Collections.addAll(sideBarOptions, navArray);

        Collections.addAll(sideBarImages, imagId);
    }

    private void SideBarStatus(boolean situation) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(situation);
        getSupportActionBar().setHomeButtonEnabled(situation);
    }

    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);

        }else if(mDrawerLayout.isDrawerOpen(GravityCompat.END)){
            mDrawerLayout.closeDrawer(GravityCompat.END);

        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_openEdit){
            if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
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
}
