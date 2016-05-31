package bsi.pp_2016_1.easter.GUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import bsi.pp_2016_1.easter.Domain.Media;
import bsi.pp_2016_1.easter.Domain.Session;
import bsi.pp_2016_1.easter.Domain.User;
import bsi.pp_2016_1.easter.Domain.UserRequisition;
import bsi.pp_2016_1.easter.Integration.Callback.MediaCallback;
import bsi.pp_2016_1.easter.Integration.Requisition.MediaIntegration;
import bsi.pp_2016_1.easter.Integration.Requisition.UserIntegration;
import bsi.pp_2016_1.easter.R;
import bsi.pp_2016_1.easter.Integration.Callback.UserCallback;

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

                if (username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), ("Incorrect username or password"), Toast.LENGTH_SHORT).show();
                }

                else {
                    UserRequisition userReq = new UserRequisition();

                    userReq.setPassword(password);
                    userReq.setUsername(username);

                    Context context = getApplicationContext();

                    UserCallback callback = new UserCallback(){
                        @Override
                        public Object onSuccess(String response) {
                            System.out.println(response);
                            User user = (User)super.onSuccess(response);
                            Session session = Session.getInstance();
                            session.login(user);
                            Toast.makeText(getApplicationContext(), ("Welcome "+ user.getUserName()), Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignInActivity.this, MediaListScreenActivity.class);
                            startActivity(i);
                            return null;
                        }

                        @Override
                        public void onFailure(String response) {
                            System.out.println(response);
                            super.onFailure(response);
                            Toast.makeText(getApplicationContext(), (response), Toast.LENGTH_SHORT).show();
                        }
                    };

                    UserIntegration integration = new UserIntegration();
                    integration.login(userReq,callback,context);
                }
            }
        });

    }
}
