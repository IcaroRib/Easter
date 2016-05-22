<!DOCTYPE html>
<html>

<head>
    <title>
        Facebook Login JavaScript Example
    </title>
    <meta charset="UTF-8">
</head>

<body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>
</div>

<script>


   /* data = {
     operation: 'update',
     user:{
         id: 8,
         userName: 'icarofelipe',
         profileName: 'Icaro Ribeiro',
         gender: 'Male',
         imageUrl: 'abcde',
         email: 'icarofeliperibeiro@gmail.com',
         age: 20
         },
     profileType: 'native'

     };

     var url = 'routes/user/';*/

   /* data = {
        operation: 'create',
        user:{
            acessToken: 'abcde',
            userName: 'icaro.ribeiro13',
            profileName: 'Icaro Ribeiro',
            gender: 'Male',
            imageUrl: '',
            email: 'icarofeliperibeiro@gmail.com',
            password: '123',
            age: 20
        },
        profileType: 'facebook'

    };

    var url = 'routes/user/';*/

    /*data = {
        operation: 'login',
        user:{
            acessToken: 'abcde'
        },
        profileType: 'facebook'

    };
     var url = 'routes/user/';*/

    /*data = {
        operation: 'find',
        media:{
            id: 0,
            title: 'deadpool'
        },
        type: 'title'

    };*/

   /* data = {
        operation: 'find',
        media:{
            id: 1
        },
        type: 'id'

    };

    var url = 'routes/media/';*/



    /*data = {
        operation: 'find',
        media: '',
        type: 'recents'

    };

    var url = 'routes/media/';*/

   /*data = {
       operation: 'evaluate',
       easteregg:{
           id: 4,
           score: 4
       },
       user:{
           id: 8
       },

   };

   var url = 'routes/media/';*/

   /*data = {
       operation: 'fallow',
       media:{
           id: 3
       },
       user:{
           id: 8
       },

   };

   var url = 'routes/media/';*/

   /*data = {
       operation: 'createReferences',
       easteregg:{
            id: 5,
            references: [
                {
                    idMedia: 7,
                    title: "Pernas do robô"
                }

            ]
        }
    };

    var url = 'routes/easteregg/';*/

   /*data = {
       operation: 'createComment',
       easteregg:{
           id: 5
       },
       comment: {
           idUser: 8,
           date: '2016-04-06',
           text: "nunca iria imaginar"
       }
   };

   var url = 'routes/easteregg/';*/

   /*data = {
       operation: 'editComment',
       easteregg: {
           idEasterEgg: 4
       },
       comment: {
           idComment: 1,
           text: "nunca iria imaginar LOL "
       }
   };

   var url = 'routes/easteregg/';*/

   data = {
       operation: 'findVarious',
       type: 'recents',
       categories: [],
       start: 0
   };

   var url = 'routes/media/';

    $.post(url,data,function(data){
        console.log(data);
       // var array = JSON.parse(data);
        //console.log(array[0]);
    });
</script>
</body>

</html>