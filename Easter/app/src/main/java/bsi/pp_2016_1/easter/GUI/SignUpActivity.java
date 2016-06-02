package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.Domain.UserRequisition;
import bsi.pp_2016_1.easter.Integration.Requisition.UserIntegration;
import bsi.pp_2016_1.easter.R;
import bsi.pp_2016_1.easter.Integration.Callback.UserCallback;

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

            if (name.equals("") || email.equals("") || username.equals("") || password.equals("") ){
                Toast.makeText(getApplicationContext(), ("Please complete all fields"), Toast.LENGTH_SHORT).show();
            }else {

                User user = new User();
                user.setUserImage(R.drawable.lhama_glasses);
                user.setEmail(email);
                user.setAge(54262);
                user.setPassword(password);
                user.setProfileName(username);
                user.setUserName(username);
                Session session = Session.getInstance();
                session.login(user);
                Toast.makeText(getApplicationContext(), ("Account created"), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUpActivity.this, MediaListScreenActivity.class);
                startActivity(i);
            }
            }
        });
    }
}
