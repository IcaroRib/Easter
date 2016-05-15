<?php

/**
 * Created by PhpStorm.
 * User: Icaro
 * Date: 15/05/2016
 * Time: 14:19
 */
class Commentary implements JsonSerializable{

    private $id;
    private $idAuthor;
    private $authorName;
    private $date;
    private $qtdLikes;
    private $qtdDislikes;
    private $text;
    private $evaluations;

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
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @param mixed $date
     */
    public function setDate($date)
    {
        $this->date = $date;
    }

    /**
     * @return mixed
     */
    public function getQtdLikes()
    {
        return $this->qtdLikes;
    }

    /**
     * @param mixed $qtdLikes
     */
    public function setQtdLikes($qtdLikes)
    {
        $this->qtdLikes = $qtdLikes;
    }

    /**
     * @return mixed
     */
    public function getQtdDislikes()
    {
        return $this->qtdDislikes;
    }

    /**
     * @param mixed $qtdDislikes
     */
    public function setQtdDislikes($qtdDislikes)
    {
        $this->qtdDislikes = $qtdDislikes;
    }

    /**
     * @return mixed
     */
    public function getText()
    {
        return $this->text;
    }

    /**
     * @param mixed $text
     */
    public function setText($text)
    {
        $this->text = $text;
    }

    /**
     * @return mixed
     */
    public function getEvaluations()
    {
        return $this->evaluations;
    }

    /**
     * @param mixed $evaluations
     */
    public function setEvaluations($evaluations)
    {
        $this->evaluations = $evaluations;
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

    function jsonSerialize()
    {
        return [
            'id' => $this->id,
            'date' => $this->date,
            'idAuthor' => $this->idAuthor,
            'authorName' => $this->authorName,
            'qtdLikes' => $this->qtdLikes,
            'qtdDislikes' => $this->qtdDislikes,
            'text' => $this->text,
            'evaluations' => $this->evaluations

        ];
    }


}