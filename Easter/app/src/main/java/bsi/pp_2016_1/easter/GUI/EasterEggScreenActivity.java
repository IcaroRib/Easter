package bsi.pp_2016_1.easter.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

        User user = new User();
        user.setUserImage(R.drawable.ic_launcher);
        user.setUserName("Francois");

        final ArrayList<Comentary> comentaries = new ArrayList<>();
        Comentary c1 = new Comentary();
        Comentary c2 = new Comentary();
        Comentary c3 = new Comentary();
        Comentary c4 = new Comentary();
        Comentary c5 = new Comentary();
        Comentary c6 = new Comentary();
        Comentary c7 = new Comentary();
        Comentary c8 = new Comentary();
        Comentary c12 = new Comentary();
        Comentary c9 = new Comentary();
        Comentary c10 = new Comentary();
        Comentary c11 = new Comentary();
        Comentary c13 = new Comentary();
        Comentary c14 = new Comentary();
        Comentary c15 = new Comentary();
        Comentary c16 = new Comentary();
        Comentary c17 = new Comentary();
        Comentary c18 = new Comentary();
        Comentary c19 = new Comentary();
        Comentary c20 = new Comentary();

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
        c6.setUserName(user.getUserName());
        c6.setText("Comentário tal");
        c6.setUserPic(user.getUserImage());
        c7.setUserName(user.getUserName());
        c7.setText("Comentário tal");
        c7.setUserPic(user.getUserImage());
        c8.setUserName(user.getUserName());
        c8.setText("Comentário tal");
        c8.setUserPic(user.getUserImage());
        c9.setUserName(user.getUserName());
        c9.setText("Comentário tal");
        c9.setUserPic(user.getUserImage());
        c10.setUserName(user.getUserName());
        c10.setText("Comentário tal");
        c10.setUserPic(user.getUserImage());
        c11.setUserName(user.getUserName());
        c11.setText("Comentário tal");
        c11.setUserPic(user.getUserImage());
        c12.setUserName(user.getUserName());
        c12.setText("Comentário tal");
        c12.setUserPic(user.getUserImage());
        c13.setUserName(user.getUserName());
        c13.setText("Comentário tal");
        c13.setUserPic(user.getUserImage());
        c14.setUserName(user.getUserName());
        c14.setText("Comentário tal");
        c14.setUserPic(user.getUserImage());
        c15.setUserName(user.getUserName());
        c15.setText("Comentário tal");
        c15.setUserPic(user.getUserImage());
        c16.setUserName(user.getUserName());
        c16.setText("Comentário tal");
        c16.setUserPic(user.getUserImage());
        c17.setUserName(user.getUserName());
        c17.setText("Comentário tal");
        c17.setUserPic(user.getUserImage());
        c18.setUserName(user.getUserName());
        c18.setText("Comentário tal");
        c18.setUserPic(user.getUserImage());
        c19.setUserName(user.getUserName());
        c19.setText("Comentário tal");
        c19.setUserPic(user.getUserImage());
        c20.setUserName(user.getUserName());
        c20.setText("Comentário tal");
        c20.setUserPic(user.getUserImage());


        comentaries.add(c1); comentaries.add(c2); comentaries.add(c3); comentaries.add(c4); comentaries.add(c5);
        comentaries.add(c6); comentaries.add(c7); comentaries.add(c8); comentaries.add(c9); comentaries.add(c10);
        comentaries.add(c11); comentaries.add(c12); comentaries.add(c13); comentaries.add(c14); comentaries.add(c15);
        comentaries.add(c16); comentaries.add(c17); comentaries.add(c18); comentaries.add(c19); comentaries.add(c20);

        easterEgg = (EasterEgg) getIntent().getSerializableExtra("easterEgg");
        easterTitle = (TextView) findViewById(R.id.egg_title);
        easterRating = (RatingBar) findViewById(R.id.egg_rating);
        easterDescription = (TextView) findViewById(R.id.egg_description);

        easterTitle.setText(easterEgg.getTitle());
        easterRating.setRating(easterEgg.getRate());
        easterDescription.setText(easterEgg.getDescription());

        eggComments = (ListView) findViewById(R.id.egg_comments);
        easterTabs = (TabHost) findViewById(R.id.egg_tabs);


        ComentaryListAdapter comentList = new ComentaryListAdapter(this, comentaries);
        eggComments.setAdapter(comentList);

        eggReferences = (ListView) findViewById(R.id.referenced_medias);
        final MediaListAdapter referencedMedias = new MediaListAdapter(this, easterEgg.getReferenceList());
        eggReferences.setAdapter(referencedMedias);
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
        spec.setContent(R.id.comments);
        spec.setIndicator("Comments");
        easterTabs.addTab(spec);

        spec = easterTabs.newTabSpec("Tab Two");
        spec.setContent(R.id.referenced_medias);
        spec.setIndicator("References");
        easterTabs.addTab(spec);




    }
}
