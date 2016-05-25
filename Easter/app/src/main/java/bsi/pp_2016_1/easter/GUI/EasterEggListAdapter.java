package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.R;

public class EasterEggListAdapter extends ArrayAdapter<EasterEgg> {

    private Activity context;
    private ArrayList<EasterEgg> easterEggsList;

    public EasterEggListAdapter(Activity context, ArrayList<EasterEgg> easterEggsList) {
        super(context, R.layout.item_media, easterEggsList);

        this.context = context;
        this.easterEggsList = easterEggsList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_easter, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        rtBar.setNumStars(5);

        txtTitle.setText(easterEggsList.get(position).getTitle());
        extratxt.setText("mopa");
        rtBar.setRating(easterEggsList.get(position).getRate());
        return rowView;
    }
}
