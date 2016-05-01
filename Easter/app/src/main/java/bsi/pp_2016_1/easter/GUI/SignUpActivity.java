package bsi.pp_2016_1.easter.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsi.pp_2016_1.easter.R;
import bsi.pp_2016_1.easter.services.Requisition;

/**
 * Created by franc on 01/05/2016.
 */
public class SignUpActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText etName = (EditText) findViewById(R.id.et_name_user);
        final EditText etEmail = (EditText) findViewById(R.id.et_email);
        final EditText etUsername = (EditText) findViewById(R.id.et_username);
        final EditText etPassword = (EditText) findViewById(R.id.et_password);

        Button btSignUp = (Button) findViewById(R.id.bt_sign_up);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getEditableText().toString();
                String email = etEmail.getEditableText().toString();
                String username = etUsername.getEditableText().toString();
                String password = etPassword.getEditableText().toString();

                Intent intent = new Intent(SignUpActivity.this,ClassTeste.class);
                if (name.equals("") || email.equals("") || username.equals("") || password.equals("") ){
                    Toast.makeText(getApplicationContext(), ("Please complete all fields"), Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    Requisition.SignUpReq(name, email, username, password);
                    startActivity(intent);
                }
            }
        });
    }
}
