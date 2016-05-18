package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 01/05/2016.
 */
public class MediaListScreenActivity extends Activity{

    ListView list;
    ArrayList<String> itName = new ArrayList<String>();
    ArrayList<Integer> imgId = new ArrayList<Integer>();
    String[] itemname ={
            "Safari",

            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };


    Integer[] mudar ={
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,

    };

    private void addItens(){
        for (int i = 0; i <= 10; i++){
            itName.add(i,"Dilmãe");
            imgId.add(i,R.drawable.ic_launcher);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*
        itName.add(0,"Safari");
        itName.add(1,"Camera");
        itName.add(2,"Global");
        itName.add(3,"Fire");
        itName.add(4,"UC Browser");
        itName.add(5,"Android Folder");
        itName.add(6,"VLC Player");
        itName.add(7,"Cold War");

        imgId.add(0,R.drawable.ic_launcher);
        imgId.add(1,R.drawable.ic_launcher);
        imgId.add(2,R.drawable.ic_launcher);
        imgId.add(3,R.drawable.ic_launcher);
        imgId.add(4,R.drawable.ic_launcher);
        imgId.add(5,R.drawable.ic_launcher);
        imgId.add(6,R.drawable.ic_launcher);
        imgId.add(7,R.drawable.ic_launcher);
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_list);

        addItens();

        CustomListAdapter adapter=new CustomListAdapter(this, itName, imgId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
