<?php

/**
 * Created by PhpStorm.
 * User: Icaro
 * Date: 01/05/2016
 * Time: 11:32
 */
class Reference implements JsonSerializable
{
    private $idMedia;
    private $referenceTitle;

    public function Reference(){

        $this->idMedia = 0;
    }

    /**
     * @return int
     */
    public function getIdMedia()
    {
        return $this->idMedia;
    }

    /**
     * @param int $idMedia
     */
    public function setIdMedia($idMedia)
    {
        $this->idMedia = $idMedia;
    }

    /**
     * @return mixed
     */
    public function getReferenceTitle()
    {
        return $this->referenceTitle;
    }

    /**
     * @param mixed $referenceTitle
     */
    public function setReferenceTitle($referenceTitle)
    {
        $this->referenceTitle = $referenceTitle;
    }


    function jsonSerialize()
    {
        return [
            'idMedia' => $this->idMedia,
            'referenceTitle' => $this->referenceTitle
        ];
    }
}