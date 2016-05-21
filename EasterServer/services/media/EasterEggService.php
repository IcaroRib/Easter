<?php

class EasterEggService{
    private $easterEggDB;

    public function EasterEggService(){

        $this->easterEggDB = new EasterEggDAO();

    }

    function insertNew($ee){
				var_dump($ee->getDescription());
				if (
					empty($ee->getDescription()) ||
					empty($ee->getIdAuthor()) ||
					empty($ee->getIdMedia())
				) return false;
        $this->easterEggDB->insertNew($ee);
    }

    function markTaskAsComplete ($ee,$task){

        if (empty($ee->tasks)) return false;
        if (!in_array($task, $ee->tasks)) return false;

        $this->markTaskAsComplete($ee,$task);
    }

    function onChange($ee){
        if (empty($ee->id)) return false;

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
