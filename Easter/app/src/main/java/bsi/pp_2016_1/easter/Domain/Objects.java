package bsi.pp_2016_1.easter.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.round;

public class Objects {

    Random random = new Random();
    private ArrayList<Integer> generatedIds = new ArrayList<Integer>();
    private ArrayList<User> users = this.createUsers();
    private ArrayList<Media> medias = new ArrayList<Media>();


    private ArrayList<User> createUsers() {

//        this.users.clear();

        int lhamaPic;

        User u1 = new User();
        u1.setAcessToken("191919191");
        u1.setEmail("ex1@domain.com");
        u1.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u1.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u1.setPassword("cebola");
        u1.setProfileName("Ícaro Ribeiro");
        u1.setUserName("icaroribeiro");

        //-----------------------------------------------------------------

        User u2 = new User();
        u2.setAcessToken("222222222");
        u2.setEmail("ex2@domain.com");
        u2.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u2.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u2.setPassword("cebola");
        u2.setProfileName("François Michel");
        u2.setUserName("francois");

        //-----------------------------------------------------------------

        User u3 = new User();
        u3.setAcessToken("333333333");
        u3.setEmail("ex3@domain.com");
        u3.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u3.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u3.setPassword("cebola");
        u3.setProfileName("Guilherme Araújo");
        u3.setUserName("guih");

        //---------------------------------------------------------------

        User u4 = new User();
        u4.setAcessToken("444444444");
        u4.setEmail("ex4@domain.com");
        u4.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u4.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u4.setPassword("cebola");
        u4.setProfileName("João Neto");
        u4.setUserName("jneto");

        //--------------------------------------------------------------

        User u5 = new User();
        u5.setAcessToken("555555555");
        u5.setEmail("ex5@domain.com");
        u5.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u5.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u5.setPassword("cebola");
        u5.setProfileName("João Lucas");
        u5.setUserName("jlucas");

        //----------------------------------------------------------------

        User u6 = new User();
        u6.setAcessToken("223232323");
        u6.setEmail("ex6@domain.com");
        u6.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u6.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u6.setPassword("cebola");
        u6.setProfileName("Luís da Silva");
        u6.setUserName("lsilva");

        //-----------------------------------------------------------------

        User u7 = new User();
        u7.setAcessToken("777777777");
        u7.setEmail("ex7@domain.com");
        u7.setId(this.getNewId());
        lhamaPic = random.nextInt(16) + 1;
        u7.setImageUrl("../../../../../res/drawable/lhama"+ lhamaPic +".jpg");
        u7.setPassword("cebola");
        u7.setProfileName("Elba Ramalho");
        u7.setUserName("elba");

        //--------------------------------------------------------------

        ArrayList<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);

        return users;

    }

    private User getRandomUser() {
        int userIdx = this.random.nextInt(this.users.size());
        return this.users.get(userIdx);
    }

    private int getNewId() {
        int newid = this.generatedIds.size() + 1;
        while (this.generatedIds.contains(newid)) {
            newid += 1;
        }
        this.generatedIds.add(newid);
        return newid;
    }

    private HashMap getRandomAvaluation() {
        HashMap av = new HashMap();
        int rate = this.random.nextInt(5) + 1;
        String text;
        switch (rate){
            case 1:
                text = "Hate it!";
            case 2:
                text = "I'm quite disappointed.";
            case 3:
                text = "I kinda liked it.";
            case 4:
                text = "Super cool!";
            case 5:
                text = "I love it!";
            default:
                text = "Cool.";
        }

        av.put("rate",rate);
        av.put("text",text);

        return av;
    }

    private Commentary createRandomEasterEggCommentary() {

        User user =  this.getRandomUser();

        Commentary commentary = new Commentary();
        commentary.setId(this.getNewId());
        commentary.setDate(new Date());
        commentary.setUserName(user.getUserName());
        commentary.setUserPic(user.getUserImage());
        HashMap av1 = this.getRandomAvaluation();
        commentary.setText((String) av1.get("text"));
        commentary.setRate((int) av1.get("rate"));

        return commentary;
    }

    private ArrayList<Commentary> createListRandomEasterEggCommentary(int qt) {
        ArrayList<Commentary> comentaries = new ArrayList<Commentary>();
        for (int i = 0; i < qt; i++) {
            comentaries.add(this.createRandomEasterEggCommentary());
        }
        return comentaries;
    }

    private Commentary createRandomMediaCommentary() {

        User user =  this.getRandomUser();

        Commentary commentary = new Commentary();
        commentary.setId(this.getNewId());
        commentary.setDate(new Date());
        commentary.setUserName(user.getUserName());
        commentary.setUserPic(user.getUserImage());
        HashMap av1 = this.getRandomAvaluation();
        commentary.setText((String) av1.get("text"));

        return commentary;

    }

    private ArrayList<Commentary> createListRandomMediaCommentary(int qt) {
        ArrayList<Commentary> comentaries = new ArrayList<Commentary>();
        for (int i = 0; i < qt; i++) {
            comentaries.add(this.createRandomMediaCommentary());
        }
        return comentaries;
    }

    private EasterEgg createEasterEgg(String title,String description) {

        User creator = this.getRandomUser();
        EasterEgg easterEgg = new EasterEgg();
        easterEgg.setTitle(title);
        easterEgg.setCreatorId(creator.getId());
        easterEgg.setCreatorName(creator.getProfileName());
        easterEgg.setDescription(description);
        easterEgg.setId(this.getNewId());
        easterEgg.setCommentList(this.createListRandomEasterEggCommentary(3));
        int creatorIndex = this.users.indexOf(creator);
        this.users.get(creatorIndex).addPublishedEasterEgg(easterEgg);

        return easterEgg;

    }

    //TODO add Image to parameters
    private Media createMedia(String title, String category, ArrayList<EasterEgg> easterEggs){
        Media media = new Media();
        media.setId(this.getNewId());
        media.setCommentList(this.createListRandomMediaCommentary(3));
        media.setEasterEggs(easterEggs);
//      m1.setImageUrl();
        media.setMidiaCategory(category);
        media.setTitle(title);


        return media;
    }

    private Media createMedia(String title, String category){
        Media media = new Media();
        media.setId(this.getNewId());
        media.setCommentList(this.createListRandomMediaCommentary(3));
//      m1.setImageUrl();
        media.setMidiaCategory(category);
        media.setTitle(title);

        return media;
    }

    public void setFavMediasToUsers() {
        int randomMediaIndex;
        for (int i = 0; i < this.users.size() ; i++) {
            for (int u = 0; u < 3; u++) {
                randomMediaIndex = random.nextInt(this.medias.size());
                Media randomMedia = this.medias.get(randomMediaIndex);
                this.users.get(i).addFavoritedMidia(randomMedia);
            }
        }

    }

    public ArrayList<User> getAllUsers() {
        return this.users;
    }

    public ArrayList<Media> getMedias() {
        return this.medias;
    }

    public ArrayList<Media> createMedias() {

        this.medias.clear();

        EasterEgg e1 = this.createEasterEgg("Pizza Planet car","Same Pizza Planet car appears in many movies from Pixar, such as \"Cars\", \"Monster, Inc.\", etc.");
        EasterEgg e2 = this.createEasterEgg("Bugs from \"A Bug's Life\"","The characters Flik and Chucrute may be seen hiding among leaves in a Buzz Lightyear scene.");
        EasterEgg e3 = this.createEasterEgg("Finding Nemo reference","In Andy's room, when Woody is making an speech to the others, you can see a tiny Nemo in Andy's toy chest.");
        ArrayList<EasterEgg> elist1 = new ArrayList<EasterEgg>();
        elist1.add(e1);
        elist1.add(e2);
        elist1.add(e3);

        Media m1 = this.createMedia("Toy Story","movies",elist1);

        EasterEgg e4 = this.createEasterEgg("Luigi (from Cars) on the Street", "In the same scene where you see the Pizza Planet truck crossing the road when they are escaping in their water bags, you can also see Luigi from Cars, a movie that came out 3 years later from Pixar.");
        EasterEgg e5 = this.createEasterEgg("Mermaid from Knick-knack","When the fish tan gets realy dirty in the dentist office they show a close-up of a ship on the front is a mermaid, the same one from the end of pixars first short knick-knack only but this time she is covered in grime.");
        EasterEgg e6 = this.createEasterEgg("Comic Book","In the chaotic scene in the dentist's office when Marlin and Dory finally get to Nemo in the nick of time, in the 5-second shot in the waiting room, the boy inside is reading a \"The Incredibles\" comic book.");
        ArrayList<EasterEgg> elist2 = new ArrayList<EasterEgg>();
        elist1.add(e4);
        elist1.add(e5);
        elist1.add(e6);

        Media m2 = this.createMedia("Finding Nemo","movies",elist2);

        EasterEgg e7 = this.createEasterEgg("Coffee cup","Nas sequências em Slow-Motion durante a abertura, podemos ver um copo de café com o nome de “Rob L.” escrito, criador do Deadpool, Rob Liefeld.");
        EasterEgg e8 = this.createEasterEgg("Green Lantern","Onto the scene in Slow-Motion in the opening, you can see within the wallet of one of the bandits an image of what could be Ryan Reynolds' character Hal Jordan, in the movie Green Lantern 2011.");
        EasterEgg e9 = this.createEasterEgg("Hello Kitty","Inside the car, in the scene in slow motion, you see a Hello Kitty Lipbalm flying around. This is a reference to film's Twitter, which follows a single account, and the account is Hello Kitty. The Deadpool is declared fan of it!");
        ArrayList<EasterEgg> elist3 = new ArrayList<EasterEgg>();
        elist1.add(e7);
        elist1.add(e8);
        elist1.add(e9);

        Media m3 = this.createMedia("Deadpool","movies",elist3);

        EasterEgg e10 = this.createEasterEgg("The Entrance To Dumbledore's Office","According to the book, Dumbledore's office has a griffin knocker on the door. In other words, it's literally a Griffin Door.");
        EasterEgg e11 = this.createEasterEgg("The Marauders Map: A Prophecy?","As well you know, Mooney, Wormtail, Padfoot and Prongs are the Animagi names of Remus, Peter, Sirius and James, as well as the creators of the map. They also died in the reverse order of the names presented on the map.");
        EasterEgg e12 = this.createEasterEgg("The Chamber Of Secrets Reveals One Massive Secret!","If you read the Chamber Of Secrets, you uncover the truth that Harry is a Horcrux well before it was ever explicitly spelled out. Towards the end of the novel when the diary has been destroyed, Dumbledore tells Harry that what happened at Godrick's Hollow connected both him and Voldermort, which is why Harry can speak Parseltongue and see snippets from Voldemort's life. Or in other words, they're one person, with two souls.");
        ArrayList<EasterEgg> elist4 = new ArrayList<EasterEgg>();
        elist1.add(e10);
        elist1.add(e11);
        elist1.add(e12);

        Media m4 = this.createMedia("Harry Potter Series","books",elist4);

        EasterEgg e13 = this.createEasterEgg("Whiteboards","In The Big Bang Theory, any writing formula in the whiteboard is actually a scientific formula, that means something.");
        EasterEgg e14 = this.createEasterEgg("The Flash","In The Flash, Cisco Ramon (Carlos Valdes) wears a shirt with the slogan \"Bazinga\", much used by Sheldon Cooper (Jim Parsons) on The Big Bang Theory. Sheldon, in turn, has shown several times in the series that has a special affection by Flash.");
        EasterEgg e15 = this.createEasterEgg("Penny's Kitchen","The pictures in Penny's refrigerator door are the actress Kaley Cuoco with the team members of The Big Bang Theory.");
        ArrayList<EasterEgg> elist5 = new ArrayList<EasterEgg>();
        elist1.add(e13);
        elist1.add(e14);
        elist1.add(e15);

        Media m5 = this.createMedia("The Big Bang Theory","tv shows",elist5);

        // MEDIAS WITHOUT EASTER EGGS --------------------------------------------
        Media m6 = this.createMedia("Cars","movies");
        Media m7 = this.createMedia("Monsters, Inc.","movies");
        Media m8 = this.createMedia("A Bug's Life","movies");
        Media m9 = this.createMedia("The Incredibles","books");
        Media m10 = this.createMedia("Green Lantern","movies");
        Media m11 = this.createMedia("The Flash","tv series");
        // -------------------------------------------------------------------------

        ArrayList<Media> referencesList1 = new ArrayList<Media>();
        referencesList1.add(m6);
        referencesList1.add(m7);
        e1.setReferenceList(referencesList1);

        ArrayList<Media> referencesList2 = new ArrayList<Media>();
        referencesList2.add(m8);
        e2.setReferenceList(referencesList2);

        ArrayList<Media> referencesList3 = new ArrayList<Media>();
        referencesList3.add(m2);
        e3.setReferenceList(referencesList3);

        ArrayList<Media> referencesList4 = new ArrayList<Media>();
        referencesList4.add(m6);
        e4.setReferenceList(referencesList4);

        ArrayList<Media> referencesList6 = new ArrayList<Media>();
        referencesList6.add(m9);
        e6.setReferenceList(referencesList6);

        ArrayList<Media> referencesList8 = new ArrayList<Media>();
        referencesList8.add(m10);
        e8.setReferenceList(referencesList8);

        ArrayList<Media> referencesList10 = new ArrayList<Media>();
        referencesList10.add(m4);
        e10.setReferenceList(referencesList10);
        e11.setReferenceList(referencesList10);
        e12.setReferenceList(referencesList10);

        ArrayList<Media> referencesList14 = new ArrayList<Media>();
        referencesList14.add(m11);
        e14.setReferenceList(referencesList14);


        this.medias.add(m1);
        this.medias.add(m2);
        this.medias.add(m3);
        this.medias.add(m4);
        this.medias.add(m5);
        this.medias.add(m6);
        this.medias.add(m7);
        this.medias.add(m8);
        this.medias.add(m9);
        this.medias.add(m10);
        this.medias.add(m11);

        return this.medias;

    }

    public void createAll() {
        this.createUsers();
        this.createMedias();
/*        this.setFavMediasToUsers();
*/
    }


}
