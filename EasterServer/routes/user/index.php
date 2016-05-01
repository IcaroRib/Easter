<?php

    include_once("../../utils/ClassCreator.php");
	include_once("../../domain/User.php");
	include_once("../../dao/user/UserDAO.php");
    include_once("../../services/user/UserService.php");

	if($_POST["operation"] == "login"){
        $user = ClassCreator::createUserFromJson($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo json_encode($userService->login($user,$profileType));

    }

    elseif($_POST["operation"] == "update"){
        $user = ClassCreator::createUserFromJson($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo json_encode($userService->update($user,$profileType));
    }

    elseif($_POST["operation"] == "create"){
        $user = ClassCreator::createUserFromJson($_POST['user']);
        $profileType = $_POST['profileType'];
        $userService = new UserService();
        echo json_encode($userService->insertUser($user,$profileType));


    }

?>