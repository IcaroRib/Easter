package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.R;

public class ReferencedMediaAdapter extends BaseAdapter {

    private Activity context;
    private ArrayList<EasterEgg> easterEggs;

    private static int aux = 0;
    private static int aux2 = 0;

    public ReferencedMediaAdapter(Activity context, ArrayList<EasterEgg> easterEggs) {
        this.context = context;
        this.easterEggs = easterEggs;
    }

    @Override
    public int getCount() {
        int count = 0;

        for (EasterEgg easter :easterEggs) {
            count += easter.getReferenceList().size();
        }

        return count;
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
        View rowView = inflater.inflate(R.layout.item_media, null, true);


        ImageView mediaIcon = (ImageView) rowView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        RatingBar rtBar = (RatingBar) rowView.findViewById(R.id.ratingBar);

        rtBar.setNumStars(5);

        if(position%1==0){
            aux = position/1;
        }else{
            aux2 = position%1;
        }

        mediaIcon.setImageResource(easterEggs.get(aux).getReferenceList().get(aux2).getImageUrl());
        txtTitle.setText(easterEggs.get(aux).getReferenceList().get(aux2).getTitle());
        extratxt.setText(easterEggs.get(aux).getTitle());
        rtBar.setRating(easterEggs.get(aux).getReferenceList().get(aux2).getRate());
        return rowView;
    }
}