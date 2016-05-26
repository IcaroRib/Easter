package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import bsi.pp_2016_1.easter.R;

public class StartScreenActivity extends Activity{

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    //public FacebookCallback<LoginResult> callback;


    public FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Profile profile = Profile.getCurrentProfile();
            nextActivity(profile);
        }
        @Override
        public void onCancel() {
            System.out.println("aaa");
        }
        @Override
        public void onError(FacebookException error) {
            System.out.println("aaa");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        System.out.println("Dentro do oncreate");
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_start_screen);

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken newAccessToken) {
            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                nextActivity(newProfile);
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        Button bt_signIn = (Button) findViewById(R.id.bt_sign_in);
        Button bt_signUp = (Button) findViewById(R.id.bt_sign_up);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions("user_friends");
        loginButton.setReadPermissions("public_profile");

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


        callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("StartScreenActivity", "Entrou2!");
                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                //Toast.makeText(getApplicationContext(), profile.toString(), Toast.LENGTH_SHORT).show();
                System.out.println("mop " + accessToken.getToken());

                System.out.println("mop " + Profile.getCurrentProfile());
                System.out.println("mop " + loginResult);

                Intent main = new Intent(StartScreenActivity.this, MediaListScreenActivity.class);
                    startActivity(main);

                nextActivity(profile);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        };

        loginButton.setHeight(bt_signIn.getHeight());


        /*loginButton.registerCallback(callbackManager, callback);



        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), accessToken.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartScreenActivity.this,MediaListScreenActivity.class );
                intent.putExtra("accessToken", accessToken);
                startActivity(intent);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
            }
        });*/



    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void nextActivity(Profile profile){
        if (profile != null){
            Log.i("StartScreenActivity", "Entrou!");
            Intent main = new Intent(StartScreenActivity.this, MediaListScreenActivity.class);
            startActivity(main);
        }
    }

    public void p(){
        Log.i("StartScreenActivity", "Printou");
    }

}
