package bsi.pp_2016_1.easter.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bsi.pp_2016_1.easter.R;
import bsi.pp_2016_1.easter.services.LoginServices;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        
        final EditText etUsername = (EditText) findViewById(R.id.et_Username);
        final EditText etPassword = (EditText) findViewById(R.id.et_Password);

        Button btGames =(Button) findViewById(R.id.bt_Games);
        Button btMovies = (Button) findViewById(R.id.bt_Movies);
        Button btSeries = (Button) findViewById(R.id.bt_Series);
        Button btBooks = (Button) findViewById(R.id.bt_Books);
        Button btLogin = (Button) findViewById(R.id.bt_Login);

        btGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Button games", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MediaListActivity.class);
                intent.putExtra("category","GAMES");
                startActivity(intent);
            }
        });

        btMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Button movies", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MediaListActivity.class);
                intent.putExtra("category","Movies");
                startActivity(intent);
            }
        });

        btSeries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Button series", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MediaListActivity.class);
                intent.putExtra("category","Series");
                startActivity(intent);
            }
        });

        btBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Button books", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MediaListActivity.class);
                intent.putExtra("category","Books");
                startActivity(intent);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getEditableText().toString();
                String password = etPassword.getEditableText().toString();

                Intent intent = new Intent(MainActivity.this,ClassTeste.class);
                if (username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), ("Incorrect username or password"), Toast.LENGTH_SHORT).show();
                }else {
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    LoginServices.login(username, password);
                    startActivity(intent);
                }


            }
        });
    }
}
