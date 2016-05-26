package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Comentary;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.R;

public class ComentaryListAdapter extends ArrayAdapter<Comentary> {

    private Activity context;
    private ArrayList<Comentary> comentaries;

    public ComentaryListAdapter(Activity context, ArrayList<Comentary> comentaries) {
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
        View rowView = inflater.inflate(R.layout.activity_comment, null, true);

        ImageView userImage = (ImageView)rowView.findViewById(R.id.userImage);
        TextView userName = (TextView) rowView.findViewById(R.id.userName);
        TextView comment = (TextView) rowView.findViewById(R.id.comment);

        userImage.setImageResource(comentaries.get(position).getUserPic());
        userName.setText(comentaries.get(position).getUserName());
        comment.setText(comentaries.get(position).getText());

        return rowView;
    }
}
