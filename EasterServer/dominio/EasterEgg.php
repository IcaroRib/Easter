<?php

class EasterEgg{

	private $id;
	private $description;
	private $idAuthor;
	private $authorName;
	private $tasks;
	private $references;

	function EasterEgg(){
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
	public function getDescription()
	{
		return $this->description;
	}

	/**
	 * @param mixed $description
	 */
	public function setDescription($description)
	{
		$this->description = $description;
	}

	/**
	 * @return mixed
	 */
	public function getIdAuthor()
	{
		return $this->idAuthor;
	}

	/**
	 * @param mixed $idAuthor
	 */
	public function setIdAuthor($idAuthor)
	{
		$this->idAuthor = $idAuthor;
	}

	/**
	 * @return mixed
	 */
	public function getAuthorName()
	{
		return $this->authorName;
	}

	/**
	 * @param mixed $authorName
	 */
	public function setAuthorName($authorName)
	{
		$this->authorName = $authorName;
	}

	/**
	 * @return mixed
	 */
	public function getTasks()
	{
		return $this->tasks;
	}

	/**
	 * @param mixed $tasks
	 */
	public function setTasks($tasks)
	{
		$this->tasks = $tasks;
	}

	/**
	 * @return mixed
	 */
	public function getReferences()
	{
		return $this->references;
	}

	/**
	 * @param mixed $references
	 */
	public function setReferences($references)
	{
		$this->references = $references;
	}
	
}

?>