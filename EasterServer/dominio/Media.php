<?php

class Media{

	private $id;
	private $title;
	private $category;
	private $image;
	private $isFavorite;
	private $easterEggs;

	function Media(){
	}

	public function getId()
	{
		return $this->id;
	}


	public function setId($id)
	{
		$this->id = $id;
	}

	public function getTitle()
	{
		return $this->title;
	}

	public function setTitle($title)
	{
		$this->title = $title;
	}

	public function getCategory()
	{
		return $this->category;
	}


	public function setCategory($category)
	{
		$this->category = $category;
	}


	public function getImage()
	{
		return $this->image;
	}


	public function setImage($image)
	{
		$this->image = $image;
	}

	/**
	 * @return mixed
	 */
	public function getIsFavorite()
	{
		return $this->isFavorite;
	}

	public function setIsFavorite($isFavorite)
	{
		$this->isFavorite = $isFavorite;
	}

	public function getEasterEggs()
	{
		return $this->easterEggs;
	}

	public function setEasterEggs($easterEggs)
	{
		$this->easterEggs = $easterEggs;
	}
}

?>