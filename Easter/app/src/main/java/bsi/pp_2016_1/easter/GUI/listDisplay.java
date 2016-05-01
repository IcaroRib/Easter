package bsi.pp_2016_1.easter.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 30/04/2016.
 */
public class listDisplay extends Activity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"
    +"IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X" +"IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"
    +"IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"
    +"IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"
    +"IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_list);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.testelayout, mobileArray);

        ListView listView = (ListView) findViewById(R.id.newsList);
        listView.setAdapter(adapter);
    }
}
