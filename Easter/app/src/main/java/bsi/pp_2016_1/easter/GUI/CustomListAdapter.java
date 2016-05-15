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

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 14/05/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    //private final String[] itemname;
    //private final Integer[] imgid;
    private final ArrayList<String> itName;
    private final ArrayList<Integer> imgId;

    public CustomListAdapter(Activity context, ArrayList<String> itName, ArrayList<Integer> imgId) {
        super(context, R.layout.activity_item_media, itName);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itName=itName;
        this.imgId=imgId;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_item_media, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        rtBar.setNumStars(5);
        rtBar.setRating(2);


        txtTitle.setText(itName.get(position));
        imageView.setImageResource(imgId.get(position));
        extratxt.setText("Category");
        return rowView;

    }
}
