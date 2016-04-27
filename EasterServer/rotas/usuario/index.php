<?php
	
	include_once("../../dominio/Usuario.php");
	include_once("../../dao/usuario/usuarioDAO.php");

	if(isset($_POST["insert"])){

		$user = new Usuario($_POST["nomeUsuario"],$_POST["nomePerfil"],$_POST["idade"],$_POST["genero"],
							$_POST["imagemUrl"],$_POST["email"],$_POST["senha"]);
		$userDB = new UsuarioDAO();
		$tipoPerfil = $_POST["tipoPerfil"];		
		$jsonRetorno = $userDB->insert($user,$tipoPerfil);
		$userDB->desconnect();
		echo json_encode($jsonRetorno);
		
	}

	elseif(isset($_POST["update"])){

		$user = new Usuario($_POST["nomeUsuario"],$_POST["nomePerfil"],
							$_POST["idade"],$_POST["genero"],$_POST["imagemUrl"],$_POST["senha"]);
		$userDB = new UsuarioDAO();
		$jsonRetorno = $userDB->update($user);
		$userDB->desconnect();
		echo json_encode($jsonRetorno);

	}

	elseif(isset($_POST["login"])){

		$user = new Usuario($_POST["nomeUsuario"],$_POST["nomePerfil"],$_POST["idade"],$_POST["genero"],
							$_POST["imagemUrl"],$_POST["email"],$_POST["senha"]);
		$userDB = new UsuarioDAO();
		$tipoPerfil = $_POST["tipoPerfil"];		
		$jsonRetorno = $userDB->login($user,$tipoPerfil);
		$userDB->desconnect();
		echo json_encode($jsonRetorno);

	}


?>