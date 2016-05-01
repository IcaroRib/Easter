<?php

class EasterEgg implements JsonSerializable{

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


	public function setDescription($description)
	{
		$this->description = $description;
	}

	public function getIdAuthor()
	{
		return $this->idAuthor;
	}
	public function setIdAuthor($idAuthor)
	{
		$this->idAuthor = $idAuthor;
	}

	public function getAuthorName()
	{
		return $this->authorName;
	}

	public function setAuthorName($authorName)
	{
		$this->authorName = $authorName;
	}

	public function getTasks()
	{
		return $this->tasks;
	}

	public function setTasks($tasks)
	{
		$this->tasks = $tasks;
	}

	public function getReferences()
	{
		return $this->references;
	}

	public function setReferences($references)
	{
		$this->references = $references;
	}

	/**
	 * Specify data which should be serialized to JSON
	 * @link http://php.net/manual/en/jsonserializable.jsonserialize.php
	 * @return mixed data which can be serialized by <b>json_encode</b>,
	 * which is a value of any type other than a resource.
	 * @since 5.4.0
	 */
	function jsonSerialize()
	{
		// TODO: Implement jsonSerialize() method.
	}
}

?>