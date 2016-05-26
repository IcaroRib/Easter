package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 14/05/2016.
 */
public class MediaListAdapter extends ArrayAdapter<Media> {

    private final Activity context;
    private final ArrayList<Media> mediaList;

    public MediaListAdapter(Activity context, ArrayList<Media> mediaList) {
        super(context, R.layout.item_media, mediaList);

        this.context=context;
        this.mediaList = mediaList;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_media, null, true);

        ImageView mediaImage = (ImageView) rowView.findViewById(R.id.icon);
        TextView mediaName = (TextView) rowView.findViewById(R.id.item);
        TextView mediaCategory = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar mediaRatingBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        mediaRatingBar.setNumStars(5);
        mediaImage.setImageResource(mediaList.get(position).getImageUrl());
        mediaName.setText(mediaList.get(position).getTitle());
        mediaCategory.setText(mediaList.get(position).getMidiaCategory());
        mediaRatingBar.setRating(mediaList.get(position).getRate());
        return rowView;

    }
}
