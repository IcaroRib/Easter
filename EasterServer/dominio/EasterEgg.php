<?php

class EasterEgg{

		public $id;
		public $descricao;
		public $idAutor;
		public $nomeAutor;
		public $tasks;
		public $referencias;

		function EasterEgg($id=0,$descricao,$idAutor = 0,$nomeAutor = "",$publicado=false,$tasks = array(),$referencias = array()){

			$this->descricao = $descricao;
			$this->tasks = $tasks;
			$this->referencias = $referencias;
			$this->id = $id;
			$this->idAutor = $idAutor;
			$this->nomeAutor = $nomeAutor;
			$this->publicado = $publicado;
		}

	}

?>