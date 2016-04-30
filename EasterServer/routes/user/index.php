<?php

	include_once("../../domain/User.php");
	include_once("../../dao/user/UserDAO.php");
    include_once("../../services/user/UserService.php");

	if($_POST["operation"] == "login"){
        $user = createUser($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo json_encode($userService->login($user,$profileType));

    }

    elseif($_POST["operation"] == "update"){


    }

    elseif($_POST["operation"] == "create"){
        $user = createUser($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo json_encode($userService->insertUser($user,$profileType));


    }

    function createUser($jsonUser){

        $user = new User();
        if(!empty($jsonUser["profileName"])){
            $user->setProfileName($jsonUser["profileName"]);
        }

        if(!empty($jsonUser["userName"])){
            $user->setUserName($jsonUser["userName"]);
        }

        if(isset($jsonUser["age"])){
            $user->setAge((int)$jsonUser["age"]);
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