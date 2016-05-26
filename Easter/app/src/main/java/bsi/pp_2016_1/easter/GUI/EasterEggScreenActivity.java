package bsi.pp_2016_1.easter.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
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
