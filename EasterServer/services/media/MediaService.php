<?php

/**
 * Created by PhpStorm.
 * User: Icaro
 * Date: 01/05/2016
 * Time: 09:14
 */
class MediaService
{

    private $mediaDB;
    private $easterEggsDB;

    public function MediaService(){

        $this->mediaDB = new MediaDAO();
        $this->easterEggsDB = new EasterEggDAO();
    }

    /**
     * @return EasterEggDAO
     */
    public function getEasterEggsDB()
    {
        return $this->easterEggsDB;
    }

    /**
     * @param EasterEggDAO $easterEggsDB
     */
    public function setEasterEggsDB($easterEggsDB)
    {
        $this->easterEggsDB = $easterEggsDB;
    }
    
    /**
     * @return MediaDAO
     */
    public function getMediaDB()
    {
        return $this->mediaDB;
    }

    /**
     * @param MediaDAO $mediaDB
     */
    public function setMediaDB($mediaDB)
    {
        $this->mediaDB = $mediaDB;
    }

    /**
     * @param string $searchType
     * @param Media $media
     * @return Media|array
     */
    public function find($searchType, $media){

        if($searchType == "title"){
            return $this->getMediaDB()->findMediaByName($media->getTitle());
        }

        else if($searchType == "id"){
            return $this->findById($media);
        }

        $this->getMediaDB()->desconnect();

    }

    /**
     * @param Media $mediaRequest
     * @return Media
     */
    public function findById($mediaRequest){

        /** @var Media $newMedia */
        /** @var array $listEasterEggs */
        $newMedia = $this->getMediaDB()->findMediaById($mediaRequest->getId());
        $listEasterEggs = $this->getEasterEggsDB()->findById($newMedia->getId());
        $newMedia->setEasterEggs($listEasterEggs);
        
        /** @var EasterEgg $easteregg */
        foreach ($newMedia->getEasterEggs() as $easteregg) {
            if($newMedia->getCategory() == "jogo"){
                /** @var array $taskList */
                $taskList = $this->getEasterEggsDB()->findTasksById($easteregg->getId());
                $easteregg->setTasks($taskList);
            }
            $easteregg->setReferences($this->getEasterEggsDB()->findReferencesById($easteregg->getId()));
        }

        return $newMedia;

    }


}