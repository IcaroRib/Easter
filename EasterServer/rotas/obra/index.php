<?php
	
	include_once("../../dominio/Media.php");
	include_once("../../dominio/EasterEgg.php");
	include_once("../../dao/obra/obraDAO.php");

	if(isset($_POST["find"])){

		$obra = new Obra();
		$obra->setId($_POST["id"]);
		$obra->setTitle($_POST["titulo"]);
        
		$obraDB = new obraDAO();
		$tipoPesquisa = $_POST["find"];
		$jsonRetorno = $obraDB->find($tipoPesquisa,$obra);
		$obraDB->desconnect();
		echo json_encode($jsonRetorno);		
	}

?>