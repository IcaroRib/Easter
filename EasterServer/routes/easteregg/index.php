<?php
    include_once("../../dominio/Media.php");
	include_once("../../dominio/EasterEgg.php");
	include_once("../../services/EasterEggService.php");

    if(isset($_POST)){
        
        $ee = new EasterEgg();
        
        if(isset($_POST['id'])) $ee->setId($_POST['id']);
        if(isset($_POST['description'])) $ee->setDescription($_POST['description']);
        if (isset($_POST['idAuthor'])) $ee->setIdAuthor($_POST['idAuthor']);
        if (isset($_POST['authorName'])) $ee->setAuthorName($_POST['authorName']);
        if (isset($_POST['tasks'])) $ee->setTasks($_POST['tasks']);
        if (isset($_POST['references'])) $ee->setReferences($_POST['references']);
        
        if (empty($_POST['operation'])) return false;
        
        $operation = $_POST['operation'];
        if(!empty($_POST['completedTask'])) $task = $_POST['completedTask'];
        $eeService = new EasterEggService();
        
        switch ($operation){
            case "new":
                $eeService->insertNew($ee);
                break;
            case "edit":
                $eeService->onChange($ee);
                break;
            case "findById":
                $eeService->findById($ee->getId());
                break;
            case "completeTask":
                if (empty($task)) break;
                $eeService->maskTaskAsComplete($ee,$task);
                break;
            default:
                
        }
        
        
    }
?>