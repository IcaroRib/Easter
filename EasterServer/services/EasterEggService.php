<?php
	
class EasterEggService.php{
    private $eeBD = new EasterEggDAO();
    
    function insertNew($ee){
        if (empty($ee->description) || empty($ee->creatorId) || empty($ee->creatorName) return false; 
        $eeBD->insertNew($ee);
    }
    
    function markTaskAsComplete ($ee,$task){
        
        if (empty($EasterEgg->tasks)) return false;
        if (!in_array($task, $EasterEgg->tasks)) return false;
        
        $eeBD->maskTaskAsComplete($ee,$task);
    }
    
    function onChange($ee){
        if (empty($ee->id)) return false;
        
        $eeBD->onChange($ee);
    }
            
     function findById($id){
         $eeBD->findById($id);			
     }
    
}

?>