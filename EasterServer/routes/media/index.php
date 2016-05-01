<?php

	include_once("../../utils/ClassCreator.php");
	include_once("../../domain/Media.php");
	include_once("../../domain/EasterEgg.php");
    include_once("../../domain/Task.php");
    include_once("../../domain/Reference.php");
	include_once("../../dao/media/mediaDAO.php");
	include_once("../../dao/easteregg/EasterEggDAO.php");
	include_once("../../services/media/mediaService.php");

	if($_POST["operation"] == "find"){

		$media = ClassCreator::createMediaFromJson($_POST['media']);
		$searchType = $_POST["type"];
		$mediaService = new MediaService();
        echo json_encode($mediaService->find($searchType,$media));
	}

?>