<?php

	include_once("../../dominio/User.php");
	include_once("../../dao/usuario/UserDAO.php");

	if(isset($_POST["insert"])){

    }

    elseif(isset($_POST["update"])){


    }

    elseif(isset($_POST["login"])){

        $user = createUser($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo "aqui";
        //return $userService->login($user,$profileType);

    }

    function createUser($jsonUser){

        $user = new User();
        if(isset($jsonUser["profileName"])){
            $user->setProfileName("a");            
        }

        if(isset($jsonUser["userName"])){
            $user->setUserName($jsonUser["userName"]);
        }

        if(isset($jsonUser["age"])){
            $user->setAge($jsonUser["age"]);
        }

        if(isset($jsonUser["gender"])){
            $user->setGender($jsonUser["gender"]);
        }

        if(isset($jsonUser["imageUrl"])){
            $user->setImageUrl($jsonUser["imageUrl"]);
        }

        if(isset($jsonUser["email"])){
            $user->setEmail($jsonUser["email"]);
        }

        if(isset($jsonUser["password"])) {
            $user->setPassword($jsonUser["password"]);
        }

        return $user;


    }


?>