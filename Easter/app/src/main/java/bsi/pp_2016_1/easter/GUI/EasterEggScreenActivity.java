package bsi.pp_2016_1.easter.GUI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.R;

public class EasterEggScreenActivity extends AppCompatActivity {

    private EasterEgg easterEgg;

    private TextView easterTitle;
    private RatingBar easterRating;
    private TextView easterDescription;
    private TabHost easterTabs;
    private ListView eggComments;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

        easterEgg = (EasterEgg) getIntent().getSerializableExtra("easterEgg");
        easterTitle = (TextView) findViewById(R.id.egg_title);
        easterRating = (RatingBar) findViewById(R.id.egg_rating);
        easterDescription = (TextView) findViewById(R.id.egg_description);

        eggComments = (ListView) findViewById(R.id.egg_comments);


        easterTabs = (TabHost) findViewById(R.id.egg_tabs);

        easterTitle.setText(easterEgg.getTitle());
        easterRating.setRating(easterEgg.getRate());
        easterDescription.setText(easterEgg.getDescription());


    }
}
