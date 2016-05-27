<?php

	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/utils/ClassCreator.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/User.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/EasterEgg.php");
    include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/Task.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/Media.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/Commentary.php");
    include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/domain/Reference.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/dao/media/MediaDAO.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/dao/easteregg/EasterEggDAO.php");
	include_once($_SERVER['DOCUMENT_ROOT'] . "/EasterServer/services/media/MediaService.php");
	

	if($_POST["operation"] == "find"){

		$media = ClassCreator::createMediaFromJson($_POST['media']);
		$searchType = $_POST["type"];
		$mediaService = new MediaService();
        echo json_encode($mediaService->find($searchType,$media));
	}

	if($_POST["operation"] == "findVarious"){
	
		$searchType = $_POST["type"];
		$categories = array();
		if(!empty($_POST["categories"])){
			$categories = json_decode($_POST["categories"],TRUE);
		}
		$start = $_POST["start"];
		$mediaService = new MediaService();
		echo json_encode($mediaService->findVarious($searchType,$start,$categories));
	}

	if($_POST["operation"] == "evaluate"){

		$easteregg = ClassCreator::createEasterEggFromJson($_POST['easteregg']);
		$user = ClassCreator::createUserFromJson($_POST['user']);
		$mediaService = new MediaService();
		echo json_encode($mediaService->evalueteEasterEgg($user,$easteregg));
	}

	if($_POST["operation"] == "fallow"){

		$media = ClassCreator::createMediaFromJson($_POST['media']);
		$user = ClassCreator::createUserFromJson($_POST['user']);
		$mediaService = new MediaService();
		echo json_encode($mediaService->fallowMedia($user,$media));
	}

	if($_POST["operation"] == "unfallow"){
	
		$media = ClassCreator::createMediaFromJson($_POST['media']);
		$user = ClassCreator::createUserFromJson($_POST['user']);
		$mediaService = new MediaService();
		echo json_encode($mediaService->unFallowMedia($user,$media));
	}


?>