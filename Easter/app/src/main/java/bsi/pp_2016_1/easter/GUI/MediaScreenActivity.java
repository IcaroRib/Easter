package bsi.pp_2016_1.easter.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Space;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.R;


public class MediaScreenActivity extends AppCompatActivity {

    private Media media;
    private ArrayList<Comentary> comentarios;

    private TextView mediaName;
    private TextView mediaCategory;
    private Switch isFollowing;
    private RatingBar ratingBar;

    private ListView listOfEggs;

    private TabHost host;
    private ListView listOfComments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        media = (Media) getIntent().getSerializableExtra("media");
        comentarios = (ArrayList<Comentary>) getIntent().getSerializableExtra("comentarios");
        mediaName = (TextView) findViewById(R.id.media_name);
        mediaCategory = (TextView) findViewById(R.id.media_category);
        isFollowing = (Switch) findViewById(R.id.is_following);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar3);

        listOfEggs = (ListView) findViewById(R.id.list_easter_eggs);
        listOfComments = (ListView)findViewById(R.id.list_comments);

        mediaName.setText(media.getTitle());
        mediaCategory.setText(media.getMidiaCategory());
        isFollowing.setChecked(true);
        Toast.makeText(MediaScreenActivity.this, Integer.toString(media.getRate()), Toast.LENGTH_SHORT).show();
        ratingBar.setNumStars(5);
        ratingBar.setRating(media.getRate());

        EasterEggListAdapter eggsList = new EasterEggListAdapter(this, media.getEasterEggs());
        listOfEggs.setAdapter(eggsList);

        listOfEggs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent enterEasterEgg = new Intent(MediaScreenActivity.this, EasterEggScreenActivity.class);
                enterEasterEgg.putExtra("easterEgg", media.getEasterEggs().get(position));
                startActivity(enterEasterEgg);

            }
        });

        ComentaryListAdapter comentList = new ComentaryListAdapter(this, comentarios);
        listOfComments.setAdapter(comentList);

        host = (TabHost) findViewById(R.id.tabHost_mediaScrenActivity);
        assert host != null;
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.list_easter_eggs);
        spec.setIndicator("Easter Eggs");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab_Comments);
        spec.setIndicator("Comments");
        host.addTab(spec);

    }

}
