package bsi.pp_2016_1.easter.GUI;

import android.content.Context;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Comentary;

public class ComentaryListAdapter extends ArrayList<Comentary> {

    private Context context;
    private ArrayList<Comentary> comentaries;


    public ComentaryListAdapter(Context context, ArrayList<Comentary> comentaries) {
        this.context = context;
        this.comentaries = comentaries;
    }

    /*public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_comment, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        rtBar.setNumStars(5);

        txtTitle.setText(easterEggsList.get(position).getTitle());
        extratxt.setText("mopa");
        rtBar.setRating(easterEggsList.get(position).getRate());
        return rowView;
    }*/
}
