package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.R;

public class EasterEggAdapter extends BaseAdapter {

    private final Activity context;
    private final ArrayList<EasterEgg> easterEggList;

    public EasterEggAdapter(Activity context, ArrayList<EasterEgg> easterEggList) {
        this.context = context;
        this.easterEggList = easterEggList;
    }

    @Override
    public int getCount() {
        return easterEggList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_easter, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);
        rtBar.setNumStars(5);

        txtTitle.setText(easterEggList.get(position).getTitle());
        extratxt.setText(easterEggList.get(position).getDescription());
        rtBar.setRating(easterEggList.get(position).getRate());

        return rowView;
    }
}
