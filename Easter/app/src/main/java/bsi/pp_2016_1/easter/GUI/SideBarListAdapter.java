package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 14/05/2016.
 */
public class SideBarListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> itName;
    private final ArrayList<Integer> imgId;

    public SideBarListAdapter(Activity context, ArrayList<String> itName, ArrayList<Integer> imgId) {
        super(context, R.layout.itemlist, itName);

        this.context = context;
        this.itName = itName;
        this.imgId = imgId;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.itemlist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.navItem);
        ImageView imgIcon = (ImageView) rowView.findViewById(R.id.iconLeftSide);

        txtTitle.setText(itName.get(position));
        imgIcon.setImageResource(imgId.get(position));
        return rowView;

    }
}