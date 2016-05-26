package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.R;

public class ComentaryListAdapter extends ArrayList<Comentary> {

    private Activity context;
    private ArrayList<Comentary> comentaries;



    public ComentaryListAdapter(Activity context, ArrayList<Comentary> comentaries) {
        this.context = context;
        this.comentaries = comentaries;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_comment, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);


        return rowView;
    }
}