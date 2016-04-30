<?php

class UsuarioService{

		private $usuarioDB = new UsuarioDAO();

		function UsuarioService(){

		}

		function login($user,$tipoPerfil) {

			if($tipoPerfil == "nativo"){
				$user = $this->usuarioDB->verificarPerfilNativo($user->email,$user->senha);	    	
			}

			return $user;

		}

		function insertUsuario($user,$tipoPerfil){
			if($tipoPerfil == "nativo"){
				$retorno = $this->usuarioDB->selectUserNativeEmail($user->email);	
				echo $user->nomeUsuario;
				if($retorno['idUsuario'] == 0){

					return $this->usuarioDB->insertNativeProfile($user);
		    	}
		    	else{
		    		return "Email já cadastrado";
		    	}    	
			}

		}

	}

?>