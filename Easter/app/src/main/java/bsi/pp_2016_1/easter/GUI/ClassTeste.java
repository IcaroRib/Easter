package bsi.pp_2016_1.easter.gui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import bsi.pp_2016_1.easter.R;
/**
 * Created by franc on 30/04/2016.
 */
public class ClassTeste extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        String nick = extras.getString("username");
        String pass = extras.getString("password");

        Toast.makeText(getApplicationContext(),(nick + " " + pass), Toast.LENGTH_LONG).show();

    }
}
