<?php

class EasterEggService{
    private $easterEggDB;

    public function EasterEggService(){

        $this->easterEggDB = new EasterEggDAO();

    }

    function insertNew($ee){
        if (
					empty($ee->getDescription()) ||
					empty($ee->getIdAuthor()) ||
					empty($ee->getIdMedia())
				) return false;
        $this->easterEggDB->insertNew($ee);
    }

    function onChange($eeNew){
        if (empty($eeNew->getId())) return false;

        $ee = $this->easterEggDB->findById($eeNew->getId());

        if (!empty($eeNew->getDescription())){
          $ee->setDescription($eeNew->getDescription());
        }

        if (!empty($eeNew->getImageUrl())){
          $ee->setImageUrl($eeNew->getImageUrl());
        }

        $this->easterEggDB->onChange($ee);
    }

     function findById($id){
         $this->easterEggDB->findCompleteById($id);
     }

    /**
     * @param EasterEgg $easterEgg
     */
    public function createReferences($easterEgg){

        $cont = 0;
        /** @var Reference $reference */
        foreach ($easterEgg->getReferences() as $reference) {
            $this->easterEggDB->createReference($easterEgg->getId(),$reference);
        }
        return "Referencias criadas com sucesso";

    }

    /**
     * @param EasterEgg $easterEgg
     * @param Commentary $comment
     * @return string
     */
    public function createComment($easterEgg,$comment){

        return $this->easterEggDB->createComment($comment->getIdAuthor(),$easterEgg->getId(), $comment);

    }

    public function editComment($comment){

        return $this->easterEggDB->editComment($comment);

    }

}

?>
