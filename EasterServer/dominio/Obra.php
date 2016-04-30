<?php

class Work{

	private $id;
	private $title;
	private $midia;
	private $imagem;
	private $isFavorite;
	private $easterEggs;

	function Obra(){
	}

	/**
	 * @return mixed
	 */
	public function getId()
	{
		return $this->id;
	}

	/**
	 * @param mixed $id
	 */
	public function setId($id)
	{
		$this->id = $id;
	}

	/**
	 * @return mixed
	 */
	public function getTitle()
	{
		return $this->title;
	}

	/**
	 * @param mixed $title
	 */
	public function setTitle($title)
	{
		$this->title = $title;
	}

	/**
	 * @return mixed
	 */
	public function getMidia()
	{
		return $this->midia;
	}

	/**
	 * @param mixed $midia
	 */
	public function setMidia($midia)
	{
		$this->midia = $midia;
	}

	/**
	 * @return mixed
	 */
	public function getImagem()
	{
		return $this->imagem;
	}

	/**
	 * @param mixed $imagem
	 */
	public function setImagem($imagem)
	{
		$this->imagem = $imagem;
	}

	/**
	 * @return mixed
	 */
	public function getIsFavorite()
	{
		return $this->isFavorite;
	}

	/**
	 * @param mixed $isFavorite
	 */
	public function setIsFavorite($isFavorite)
	{
		$this->isFavorite = $isFavorite;
	}

	/**
	 * @return mixed
	 */
	public function getEasterEggs()
	{
		return $this->easterEggs;
	}

	/**
	 * @param mixed $easterEggs
	 */
	public function setEasterEggs($easterEggs)
	{
		$this->easterEggs = $easterEggs;
	}




}

?>