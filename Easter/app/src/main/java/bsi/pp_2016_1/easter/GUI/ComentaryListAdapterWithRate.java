package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.R;

public class ComentaryListAdapterWithRate extends ArrayAdapter<Comentary> {

    private Activity context;
    private ArrayList<Comentary> comentaries;

    public ComentaryListAdapterWithRate(Activity context, ArrayList<Comentary> comentaries) {
        super(context, R.layout.activity_comment, comentaries);
        this.context = context;
        this.comentaries = comentaries;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_comment_egg_with_rate, null, true);

        ImageView userImage = (ImageView)rowView.findViewById(R.id.userImage);
        TextView userName = (TextView) rowView.findViewById(R.id.userName);
        TextView comment = (TextView) rowView.findViewById(R.id.userComment);
        RatingBar rate = (RatingBar) rowView.findViewById(R.id.userRatingBar);

        Toast.makeText(context, comentaries.get(position).getUserName(), Toast.LENGTH_SHORT).show();

        userImage.setImageResource(comentaries.get(position).getUserPic());
        userName.setText(comentaries.get(position).getUserName());
        comment.setText(comentaries.get(position).getText());
        rate.setRating(comentaries.get(position).getRate());

        return rowView;
    }
}
