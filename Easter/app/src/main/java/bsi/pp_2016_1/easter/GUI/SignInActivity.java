package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 01/05/2016.
 */
public class SignInActivity extends Activity{

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

                Intent intent = new Intent(SignInActivity.this,MediaListScreenActivity.class);
                if (username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), ("Incorrect username or password"), Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    // LoginServices.login(username, password);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), ("Login feito"), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
