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

    ArrayList<Media> mediaList;
    ArrayList<EasterEgg> easterEggs;
    private ArrayList<Media> referenceList;
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

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), ("Incorrect username or password"), Toast.LENGTH_SHORT).show();
                } else {
                 /*   User user = new User();
                    user.setId(0);
                    user.setUserName("Icaro");
                    user.setEmail("icaroribeiro@gmail.com");
                    user.setUserImage(R.drawable.lhama_glasses);
                    user.setProfileName("IcaroR");
*/
                    Objects objects = new Objects();

                    objects.createAll();

                    session = Session.getInstance();
                    session.login(objects.getAllUsers().get(0));
//                  Toast.makeText(SignInActivity.this, objects.getAllUsers().get(0).getUserName(), Toast.LENGTH_SHORT).show();

//                  CriaConteudo(user);

                    Intent i = new Intent(SignInActivity.this, MediaListScreenActivity.class);


                    session.setMedias(objects.getMedias());

                    startActivity(i);

                /*UserRequisition userReq = new UserRequisition();

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
                integration.login(userReq,callback,context);*/
                }
            }
        });

    }

    private void CriaConteudo(User user) {

        ArrayList<Commentary> listComments = new ArrayList<>();
        Commentary c1 = new Commentary();
        c1.setUserName(user.getUserName());
        c1.setUserPic(user.getUserImage());
        listComments.add(c1);
        Commentary c2 = new Commentary();
        c2.setUserName(user.getUserName());
        c2.setUserPic(user.getUserImage());
        listComments.add(c2);
        Commentary c3 = new Commentary();
        c3.setUserName(user.getUserName());
        c3.setUserPic(user.getUserImage());
        listComments.add(c3);
        Commentary c4 = new Commentary();
        c4.setUserName(user.getUserName());
        c4.setUserPic(user.getUserImage());
        listComments.add(c4);
        Commentary c5 = new Commentary();
        c5.setUserName(user.getUserName());
        c5.setUserPic(user.getUserImage());
        listComments.add(c5);
        Commentary c6 = new Commentary();
        c6.setUserName(user.getUserName());
        c6.setUserPic(user.getUserImage());
        listComments.add(c6);
        Commentary c7 = new Commentary();
        c7.setUserName(user.getUserName());
        c7.setUserPic(user.getUserImage());
        listComments.add(c7);
        Commentary c8 = new Commentary();
        c8.setUserName(user.getUserName());
        c8.setUserPic(user.getUserImage());
        listComments.add(c8);
        Commentary c9 = new Commentary();
        c9.setUserName(user.getUserName());
        c9.setUserPic(user.getUserImage());
        listComments.add(c9);
        Commentary c10 = new Commentary();
        c10.setUserName(user.getUserName());
        c10.setUserPic(user.getUserImage());
        listComments.add(c10);

        int countComments = 0;
        for (Commentary comment : listComments) {
            comment.setText("Comentario " + countComments);
            comment.setRate(countComments);

            countComments++;
        }

        referenceList = new ArrayList<>();

        Media m10 = new Media();
        Media m11 = new Media();
        Media m12 = new Media();
        Media m13 = new Media();

        referenceList.add(m10);
        referenceList.add(m11);
        referenceList.add(m12);
        referenceList.add(m13);

        int contReference = 0;
        for (Media media : referenceList) {
            media.setId(contReference);
            media.setTitle("Media " + contReference);
            media.setMidiaCategory("Movie");
            media.setImageUrl(R.drawable.user_image);

            media.setEasterEggs(easterEggs);
            media.setCommentList(listComments);

            contReference++;
        }

        easterEggs = new ArrayList<>();

        EasterEgg e0 = new EasterEgg();

        easterEggs.add(e0);
        EasterEgg e1 = new EasterEgg();
        easterEggs.add(e1);
        EasterEgg e2 = new EasterEgg();
        easterEggs.add(e2);
        EasterEgg e3 = new EasterEgg();
        easterEggs.add(e3);
        EasterEgg e4 = new EasterEgg();
        easterEggs.add(e4);
        EasterEgg e5 = new EasterEgg();
        easterEggs.add(e5);
        EasterEgg e6 = new EasterEgg();
        easterEggs.add(e6);
        EasterEgg e7 = new EasterEgg();
        easterEggs.add(e7);
        EasterEgg e8 = new EasterEgg();
        easterEggs.add(e8);
        EasterEgg e9 = new EasterEgg();
        easterEggs.add(e9);

        int cont = 0;
        for (EasterEgg egg : easterEggs) {
            egg.setTitle("Easter egg " + cont);
            egg.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

            egg.setReferenceList(referenceList);
            egg.setCommentList(listComments);

            egg.setId(cont);
            cont++;
        }



        mediaList = new ArrayList<>();

        Media m0 = new Media();
        mediaList.add(m0);
        Media m1 = new Media();
        mediaList.add(m1);
        Media m2 = new Media();
        mediaList.add(m2);
        Media m3 = new Media();
        mediaList.add(m3);
        Media m4 = new Media();
        mediaList.add(m4);
        Media m5 = new Media();
        mediaList.add(m5);
        Media m6 = new Media();
        mediaList.add(m6);
        Media m7 = new Media();
        mediaList.add(m7);
        Media m8 = new Media();
        mediaList.add(m8);
        Media m9 = new Media();
        mediaList.add(m9);



        int cont2 = 0;
        for (Media media : mediaList) {
            media.setId(cont2);
            media.setTitle("Media " + cont2);
            media.setMidiaCategory("Movie");
            media.setImageUrl(R.drawable.user_image);

            media.setEasterEggs(easterEggs);
            media.setCommentList(listComments);

            cont2++;
        }

        for (Media media : referenceList) {
            media.setEasterEggs(easterEggs);
        Toast.makeText(SignInActivity.this, Integer.toString(mediaList.size()), Toast.LENGTH_SHORT).show();

        }

        user.setPublishedEasterEggs(easterEggs);
        user.setFavoritedMedias(mediaList);

    }
}
