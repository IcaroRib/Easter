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

}

?>
