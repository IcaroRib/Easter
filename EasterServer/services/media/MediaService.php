
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

    public function findVarious($searchType, $start, $categories){

        if($searchType == "recents"){
            return $this->getMediaDB()->findRecents($categories,$start);
        }

        else if($searchType == "bests"){
            return $this->getMediaDB()->findBestEvalueteds($categories,$start);
        }

        else if($searchType == "falloweds"){
            return $this->getMediaDB()->findMostFallowed($categories,$start);
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
        $listEasterEggs = $this->getEasterEggsDB()->findCompleteById($newMedia->getId());
        $newMedia->setEasterEggs($listEasterEggs);
        
        /** @var EasterEgg $easteregg */
        foreach ($newMedia->getEasterEggs() as $easteregg) {
            if($newMedia->getCategory() == "jogo"){
                /** @var array $taskList */
                $taskList = $this->getEasterEggsDB()->findTasksById($easteregg->getId());
                $easteregg->setTasks($taskList);
            }
            $easteregg->setReferences($this->getEasterEggsDB()->findReferencesById($easteregg->getId()));
            $easteregg->setCommentaries($this->getEasterEggsDB()->findCommentariesById($easteregg->getId()));
        }

        $this->getMediaDB()->desconnect();
        return $newMedia;

    }

    /**
     * @param User $user
     * @param EasterEgg $easteregg
     * @return string
     */
    public function evalueteEasterEgg($user,$easteregg){

        $evaluation = $this->getEasterEggsDB()->selectEvaluation($easteregg->getId(), $user->getId());
        if($evaluation == true){

            return $this->getEasterEggsDB()->updateEasterEggEvaluation($easteregg->getId(), $user->getId(), $easteregg->getScore());
        }  
        else{
            return $this->getEasterEggsDB()->evaluateEasterEgg($easteregg->getId(), $user->getId(), $easteregg->getScore());   
        }

    }

    /**
     * @param User $user
     * @param Media $media
     */
    public function fallowMedia($user,$media){

        $this->getMediaDB()->fallowMedia($media->getId(), $user->getId());
        $media = $this->getMediaDB()->findMediaById($media->getId());
        $listEasterEggs = $this->getEasterEggsDB()->findByIdMedia($media->getId());
        $media->setEasterEggs($listEasterEggs);

        /** @var EasterEgg $easteregg */
        foreach ($media->getEasterEggs() as $easteregg) {
            $this->getEasterEggsDB()->fallowEasterEgg($easteregg->getId(),$user->getId());
            if($media->getCategory() == "jogo"){
                $taskList = $this->getEasterEggsDB()->findTasksById($easteregg->getId());
                $easteregg->setTasks($taskList);
                /** @var Task $task */
                foreach ($easteregg->getTasks() as $task) {
                    $this->getEasterEggsDB()->fallowTask($task->getId(),$user->getId());
                }
            }
            
        }

        $this->getMediaDB()->desconnect();

    }

    public function unFallowMedia($user, $media)
    {
        $this->getMediaDB()->unFallowMedia($media->getId(), $user->getId());
        $media = $this->getMediaDB()->findMediaById($media->getId());
        $listEasterEggs = $this->getEasterEggsDB()->findByIdMedia($media->getId());
        $media->setEasterEggs($listEasterEggs);

        /** @var EasterEgg $easteregg */
        foreach ($media->getEasterEggs() as $easteregg) {
            $this->getEasterEggsDB()->unFallowEasterEgg($easteregg->getId(),$user->getId());
            if($media->getCategory() == "jogo"){
                $taskList = $this->getEasterEggsDB()->findTasksById($easteregg->getId());
                $easteregg->setTasks($taskList);
                /** @var Task $task */
                foreach ($easteregg->getTasks() as $task) {
                    $this->getEasterEggsDB()->unFallowTask($task->getId(),$user->getId());
                }
            }

        }

        $this->getMediaDB()->desconnect();
    }

}