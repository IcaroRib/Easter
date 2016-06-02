package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import bsi.pp_2016_1.easter.Domain.Commentary;
import bsi.pp_2016_1.easter.Domain.EasterEgg;
import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.Objects;
import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.R;

public class SignInActivity extends Activity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final EditText et_password = (EditText) findViewById(R.id.et_password);

        Button bt_signIn = (Button) findViewById(R.id.bt_go);

        bt_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String username = et_username.getEditableText().toString();
            String password = et_password.getEditableText().toString();
            session = Session.getInstance();

            Objects objects = new Objects();

            objects.createAll();

            for (User user: objects.getAllUsers() ) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {

                    session.login(objects.getAllUsers().get(0));
                    Intent i = new Intent(SignInActivity.this, MediaListScreenActivity.class);

                    session.setMedias(objects.getMedias());

                    startActivity(i);
                }
            }
            }
        });
    }
}
