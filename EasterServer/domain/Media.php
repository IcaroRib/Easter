<?php

class Media implements JsonSerializable{

	private $id;
	private $title;
	private $category;
	private $image;
	private $isFavorite;
	private $easterEggs;

	function Media(){
		$this->id = 0;
		$this->title = "";
        $this->isFavorite = false;
	}

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return string
     */
    public function getTitle()
    {
        return $this->title;
    }

    /**
     * @param string $title
     */
    public function setTitle($title)
    {
        $this->title = $title;
    }

    /**
     * @return mixed
     */
    public function getCategory()
    {
        return $this->category;
    }

    /**
     * @param mixed $category
     */
    public function setCategory($category)
    {
        $this->category = $category;
    }

    /**
     * @return mixed
     */
    public function getImage()
    {
        return $this->image;
    }

    /**
     * @param mixed $image
     */
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


    /**
     * Specify data which should be serialized to JSON
     * @link http://php.net/manual/en/jsonserializable.jsonserialize.php
     * @return mixed data which can be serialized by <b>json_encode</b>,
     * which is a value of any type other than a resource.
     * @since 5.4.0
     */
    function jsonSerialize()
    {
        return [
            'id' => $this->id,
            'title' => $this->title,
            'category' => $this->category,
            'image' => $this->image,
            'isFavorite' => $this->isFavorite,
            'easterEggs' => $this->easterEggs
        ];
    }
}

?>