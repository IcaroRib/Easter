<?php

class Obra{

		public $id;
		public $titulo;
		public $midia;
		public $imagem;
		public $favorito;
		public $easterEggs;

		function Obra($id=0,$titulo="",$midia = "",$imagem = "",$favorito=false,$easterEggs = array()){

			$this->titulo = $titulo;
			$this->midia = $midia;
			$this->imagem = $imagem;
			$this->easterEggs = $easterEggs;
			$this->id = $id;
			$this->favorito = $favorito;
		}

	}

?>