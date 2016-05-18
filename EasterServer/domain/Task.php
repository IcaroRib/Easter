<?php

/**
 * Created by PhpStorm.
 * User: Icaro
 * Date: 01/05/2016
 * Time: 11:29
 */
class Task implements JsonSerializable
{
    private $id;
    private $description;
    private $progress;

    public function Task(){

        $this->id = 0;
        $this->description = "";
        $this->progress = 0;
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
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }

    /**
     * @return double
     */
    public function getProgress()
    {
        return $this->progress;
    }

    /**
     * @param double $progress
     */
    public function setProgress($progress)
    {
        $this->progress = $progress;
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
            'description' => $this->description,
            'progress' => $this->progress
        ];
    }
}