<?php
    include_once("../../utils/ClassCreator.php");
    include_once("../../domain/EasterEgg.php");
    include_once("../../domain/Reference.php");
    include_once("../../domain/Commentary.php");
    include_once("../../services/media/EasterEggService.php");
    include_once("../../dao/easteregg/EasterEggDAO.php");

    if(isset($_POST)){
        
        $ee = ClassCreator::createEasterEggFromJson($_POST["easteregg"]);
        
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
            case "createReferences":
                $eeService->createReferences($ee);
                break;
            case "createComment":
                $comment = ClassCreator::createCommentFromJson($_POST["comment"]);
                $eeService->createComment($ee,$comment);
                break;
            case "editComment":
                $comment = ClassCreator::createCommentFromJson($_POST["comment"]);
                $eeService->editComment($comment);
                break;
            case "completeTask":
                if (empty($task)) break;
                $eeService->maskTaskAsComplete($ee,$task);
                break;
            default:
                
        }
        
        
    }
?>