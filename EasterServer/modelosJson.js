/**
 * Created by Icaro on 21/05/2016.
 */

//---------  Rota User, atualizar dados  ------//

    //*Entrada*//
         data = {
             operation: 'update',
             user:{
                 id: 0,
                 userName: '',
                 profileName: '',
                 gender: '',
                 imageUrl: '',
                 email: '',
                 age: 0
             },
         profileType: '' //Opções: native, facebook

         };

        url = 'routes/user/';

    //*Saida*//

        data = "Dados atualizados com sucesso";


//---------  Rota User, criar usuario  ------//

    //*Entrada*//
        data = {
            operation: 'create',
            user:{
                acessToken: '', //é necessário ser preenchido apenas em caso de create pelo facebook
                userName: '', //caso o create seja por facebook user o userName do facebook
                profileName: '',
                gender: '',
                imageUrl: '',
                email: '',
                password: '', //é necessário ser preenchido apenas em caso de create pelo perfil nativo
                age: 0
            },
            profileType: '' //Opções: native, facebook

        };

        url = 'routes/user/';

    //*Saida*//

        data = {
            id: 0,
            acessToken: '', //é necessário ser preenchido apenas em caso de create pelo facebook
            userName: '', //caso o create seja por facebook user o userName do facebook
            profileName: '',
            gender: '',
            imageUrl: '',
            email: '',
            password: '', //é necessário ser preenchido apenas em caso de create pelo perfil nativo
            age: 0
        };

//---------  Rota User, login  ------//

    //*Entrada*//

        data = {
            operation: 'login',
            user:{
                acessToken: '', //é necessário ser preenchido apenas em caso de login pelo facebook
                userName: '', //em caso de login nativo, escolher preencher userName OU email
                email: '', //
                password: '', //necessario preencher apenas em login nativo
                age: 0
            },
            profileType: '' //Opções: native, facebook
        };

        url = 'routes/user/';

        //*Saida*//

            data = {
                id: 0,
                userName: '',
                profileName: '',
                gender: '',
                age: 0,
                imageUrl: '',
                email: ''

            };



//---------  Rota Media, procurar dados completos de uma obra  ------//

    //*Entrada*//

        data = {
            operation: 'find',
            media:{
                id: 0,
                title: ''
            },
            type: '' //opções: title, id

        };

        url = 'routes/user/';

    //*Saida*//

        media = {
            id: 0, //inteiro
            title: '', //string
            category: '', //string
            jogo: '', //string
            image: '', //string
            isFavorite: false, //boolean
            easterEggs: [ //array de eastereggs
                easterEgg = {
                    id: 0, //inteiro
                    description: '',
                    imageUrl: '',
                    idAuthor: 0,
                    authorName: '',
                    mediumScore: '0.0',
                    tasks: [ //array de tasks
                        task = {
                            id: 0,
                            description: '',
                            progress: ''
                        }
                    ],
                    reference: [ //array de referencias
                        reference = {
                            idMedia: 0,
                            referenceTitle: ''
                        }
                    ],
                    commentaries: [ //array de comentarios
                        comentary = {
                            id: 0,
                            data: '',
                            idAuthor: 0,
                            authorName: '',
                            qtdLikes: '',
                            qtdDislikes: '',
                            text: '',
                            evaluations: ''
                        }
                    ]
                }
            ]
        }



//---------  Rota Media, preencher feed  ------//

    //*Entrada*//
        data = {
            operation: 'findVarious',
            type: '', //string; opções: followeds, bests, recents
            categories: [], //array; opções: filme, jogo, anime, etc
            start: 0 //inteiro; o aplicativo deve aumentar este campo de 20 em 20 sempre que for realizar uma nova solicitação
        };

        url = 'routes/media/';

    //*Saida*//

        data = [  //array de obras
            media = {
                id: 0, //inteiro
                title: '', //string
                category: '', //string
                isFavorite: false //string
            }
        ]


//---------  Rota Media, avaliar easter egg  ------//

    //*Entrada*//
        data = {
            operation: 'evaluate',
            easteregg:{
                id: 0,
                score: 04
            },
            user:{
                id: 0
            }
        };

        url = 'routes/media/';

    //*Saida*//

        data = "Easter Egg avaliado com sucesso";

//---------  Rota Media, seguir obra  ------//

    //*Entrada*//
        data = {
            operation: 'fallow',
            media:{
                id: 0
            },
            user:{
                id: 0
            }
        };

    url = 'routes/media/';

    //*Saida*//

        data = "Obra seguida com sucesso";


//---------  Rota EasterEgg, criar referencia  ------//

    //*Entrada*//
        data = {
            operation: 'createReferences',
            easteregg:{
                id: 0,
                references: [ //array de referencias
                    referency = {
                        idMedia: 0,
                        title: ""
                    }

                ]
            }
        };

        url = 'routes/easteregg/';

    //*Saida*//

        data = "Referencias criadas com sucesso";


//---------  Rota EasterEgg, criar comentario  ------//

    //*Entrada*//
        data = {
            operation: 'createComment',
            comment: {
                idAuthor: 0,
                date: '', //data
                text: ""
            }

        };

        url = 'routes/easteregg/';

    //*Saida*//

        comment = {
            id: 0,
            idAuthor: 0,
            date: '', //data
            text: ""
        };

//---------  Rota EasterEgg, editar comentario  ------//

    //*Entrada*//
        data = {
            operation: 'editComment',
            comment: {
                id: 0,
                date: '', //data
                text: ""
            }
        };

        url = 'routes/easteregg/';

    //*Saida*//

        data = "Comentario editado com sucesso";