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
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.R;

public class TesteEasterEggAdapter extends BaseAdapter {

    private final Activity context;
    private final ArrayList<Media> mediaList;

    private static ArrayList<EasterEgg> easterEggs = null;

    private static int aux = 0;
    private static int aux2 = 0;

    public TesteEasterEggAdapter(Activity context, ArrayList<Media> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
    }

    @Override
    public int getCount() {
        int count = 0;
        for (Media med :mediaList) {
            count += med.getEasterEggs().size();
        }

        return count;
    }

    @Override
    public Object getItem(int position) {
        position = 0;
        for (Media media : mediaList) {
            position += media.getEasterEggs().size();
        }
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


        if(position%10==0){
            aux = position/10;
        }else{
            aux2 = position%10;
        }

        txtTitle.setText(mediaList.get(aux).getEasterEggs().get(aux2).getTitle());
        extratxt.setText(mediaList.get(aux).getTitle());
        rtBar.setRating(mediaList.get(aux).getEasterEggs().get(aux2).getRate());
        return rowView;
    }
}
