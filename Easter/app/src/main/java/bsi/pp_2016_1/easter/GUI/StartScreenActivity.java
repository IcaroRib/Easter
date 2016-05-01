package bsi.pp_2016_1.easter.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 01/05/2016.
 */
public class StartScreenActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button bt_enterNotLogged = (Button) findViewById(R.id.bt_enter_not_logged);
        Button bt_signIn = (Button) findViewById(R.id.bt_sign_in);
        Button bt_signUp = (Button) findViewById(R.id.bt_sign_up);

        bt_enterNotLogged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "BT entrar sem login", Toast.LENGTH_SHORT).show();
/*
                Intent intent = new Intent(StartScreenActivity.this, listDisplay.class);
                startActivity(intent);
*/          }
        });

        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        bt_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}
