package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import bsi.pp_2016_1.easter.R;

/**
 * Created by franc on 01/05/2016.
 */
public class StartScreenActivity extends Activity{
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button bt_signIn = (Button) findViewById(R.id.bt_sign_in);
        Button bt_signUp = (Button) findViewById(R.id.bt_sign_up);
        loginButton = (LoginButton) findViewById(R.id.login_button);

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


    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Logged in!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
