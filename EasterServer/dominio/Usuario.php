<?php

class Usuario{

		public $nomeUsuario;
		public $nomePerfil;
		public $idade;
		public $genero;
		public $imagemUrl;
		public $email;
		public $senha;

		function Usuario($nomeUsuario,$nomePerfil,$idade,$genero,$imagemUrl,$email,$senha){

			$this->nomeUsuario = $nomeUsuario;
			$this->nomePerfil = $nomePerfil;
			$this->genero = $genero;
			$this->imagemUrl = $imagemUrl;
			$this->idade = $idade;
			$this->email = $email;
			$this->senha = $senha;
		}

	}

?>