<?php
	
class EasterEggService{
    private $easterEggDB;

    public function EasterEggService(){

        $this->easterEggDB = new EasterEggDAO();

    }
    
    function insertNew($ee){
        if (empty($ee->description) || empty($ee->creatorId) || empty($ee->creatorName)) return false;
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
         $this->easterEggDB->findById($id);
     }
    
}

?>