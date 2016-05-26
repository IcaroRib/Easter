<?php

class EasterEggDAO{

    public $connection;

    function EasterEggDAO(){
        $this->connection = new mysqli('localhost','','','easter');
    }

    function desconnect(){
        $this->connection->close();
    }

    /**
     * @param EasterEgg $EasterEgg
     */
    function insertNew($EasterEgg){
        $time = new DateTime();
        $values = array(
            "'".$EasterEgg->getDescription()."'",
            "'".$EasterEgg->getImageUrl()."'",
            intval($EasterEgg->getIdMedia()),
            intval($EasterEgg->getidAuthor())
        );
        $stringSQL = "INSERT INTO easteregg (description,imageUrl,idMedia,idWritter) VALUES (". implode(",", $values) .")";
        $result_query = $this->connection->query($stringSQL);
    }

    function onChange($EasterEgg){

        $stringSQL = "UPDATE easteregg set
            description = '". utf8_decode($EasterEgg->getDescription())
            ."', imageUrl = '". utf8_decode($EasterEgg->getImageUrl())
            ."' WHERE idEasterEgg = ". $EasterEgg->getId();

        $result_query = $this->connection->query($stringSQL);

    }

    function findCompleteById($id){
        $EElist =  array();
        $stringSQL = "SELECT idEasterEgg, description, easteregg.imageUrl, idWritter, AVG(score) as mediumScore
                      FROM easteregg INNER JOIN user ON idUser = idWritter
                      INNER JOIN evaluateeasteregg ON idEasterEgg = easteregg.idEasterEgg
	 				  WHERE idMedia =" . $id . " GROUP BY idEasterEgg";
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $easteregg = ClassCreator::createEasterEggFromArrayQuerry($result);
            $EElist[$cont] = $easteregg;
            $cont +=1;
        }
        return $EElist;
    }


    function findByIdMedia($id){

        $EElist =  array();
        $stringSQL = "SELECT idEasterEgg FROM easteregg WHERE idMedia =" . $id . " GROUP BY idEasterEgg";
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $easteregg = ClassCreator::createEasterEggFromArrayQuerry($result);
            $EElist[$cont] = $easteregg;
            $cont +=1;
        }
        return $EElist;
    }

    function findById($id){
        $newEE = new EasterEgg();
        $stringSQL = "SELECT * FROM easteregg WHERE idEasterEgg = " . $id;
        $result_query = $this->connection->query($stringSQL);
        while ($result = $result_query->fetch_assoc()) {
            $newEE = ClassCreator::createEasterEggFromArrayQuerry($result);
            break;
        }
        return $newEE;

    }

    function findTasksById($id){
        $taskList = array();
        $stringSQL = "SELECT * FROM task WHERE EasterEgg_idEasterEgg = ". $id;
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $task = ClassCreator::createTaskFromArrayQuerry($result);
            $taskList[$cont] = $task;
            $cont +=1;
        }
        return $taskList;
    }

    function findReferencesById($id){
        $referencesList = array();
        $stringSQL = "SELECT * FROM reference INNER JOIN media ON Media_idMedia = idMedia
	 					  WHERE EasterEgg_idEasterEgg  = " . $id;
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $reference = ClassCreator::createRefenceFromArrayQuerry($result);
            $referencesList[$cont] = $reference;
            $cont +=1;
        }
        return $referencesList;
    }

    function findCommentariesById($id){
        $listComentarys = array();
        $stringSQL = "SELECT * FROM comment INNER JOIN user ON idUser = idAuthor
	 					  WHERE idEasterEgg  = " . $id;
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $comment = ClassCreator::createCommentFromArrayQuerry($result);
            $listComentarys[$cont] = $comment;
            $cont +=1;
        }
        return $listComentarys;
    }

    /**
     * @param int $idEasterEgg
     * @param int $idUser
     * @param int $score
     * @return string
     */

    function evaluateEasterEgg($idEasterEgg,$idUser,$score)
    {
        $time = new DateTime();
        $stringSQL = "INSERT INTO evaluatedeasteregg (EasterEgg_idEasterEgg,User_idUser,score,createdAt) VALUES (
                       $idEasterEgg, $idUser, $score " . ",'" . $time->format('Y-m-d H:i:s') . "')" ;
        $this->connection->query($stringSQL);
        return "Easter Egg avaliado com sucesso";

    }

    function updateEasterEggEvaluation($idEasterEgg,$idUser,$score)
    {
        $stringSQL = "UPDATE evaluatedeasteregg SET score = " . $score .
                    " WHERE EasterEgg_idEasterEgg = " . $idEasterEgg . " and User_idUser = " . $idUser;
        $this->connection->query($stringSQL);
        return "Easter Egg avaliado com sucesso";

    }

    /**
     * @param int $idEasterEgg
     * @param int $idUser
     * @return bool
     */
    function selectEvaluation($idEasterEgg,$idUser)
    {
        $stringSQL = "SELECT * FROM evaluatedeasteregg WHERE EasterEgg_idEasterEgg = " . $idEasterEgg . " and User_idUser = " . $idUser;
        $result_query = $this->connection->query($stringSQL);
        while($result = $result_query->fetch_assoc()){
            return true;
        }
        return false;

    }

    public function fallowEasterEgg($idEasterEgg, $idUser){
        $time = new DateTime();
        $stringSQL = "INSERT INTO fallowedeasteregg (User_idUser, EasterEgg_idEasterEgg, createdAt)
                          VALUES ($idUser,$idEasterEgg,'" . $time->format('Y-m-d H:i:s') . "')";
        $this->connection->query($stringSQL);

    }

    public function unFallowEasterEgg($idEasterEgg, $idUser){
        $stringSQL = "DELETE FROM fallowedeasteregg WHERE EasterEgg_idEasterEgg = $idEasterEgg and User_idUser = $idUser; ";
        $this->connection->query($stringSQL);
    }

    public function fallowTask($IdTask, $idUser){
        $time = new DateTime();
        $stringSQL = "INSERT INTO fallowedTask (idUser, idTask, createdAt)
                          VALUES ($idUser,$IdTask,'" . $time->format('Y-m-d H:i:s') . "')";
        $this->connection->query($stringSQL);

    }

    public function unFallowTask($IdTask, $idUser){
        $stringSQL = "DELETE FROM fallowedTask WHERE idTask = $IdTask and idUser = $idUser; ";
        $this->connection->query($stringSQL);
    }

    /**
     * @param int $idEE
     * @param Reference $reference
     * @return void
     */
    function createReference($idEE, $reference){

        $time = new DateTime();
        $idMedia = $reference->getIdMedia();
        $stringSQL = "INSERT INTO reference (EasterEgg_idEasterEgg, Media_idMedia, title, createdAt)
                      VALUES ($idEE,$idMedia,'" . $reference->getReferenceTitle() . "','" . $time->format('Y-m-d H:i:s') . "')";
        echo $stringSQL;
        $this->connection->query($stringSQL);

    }

    /**
     * @param int $getId
     * @param Commentary $comment
     * @return Commentary
     */
    public function createComment($idAuthor, $idEasterEgg, $comment){
        $time = new DateTime();
        $stringSQL = "INSERT INTO comment (idAuthor, idEasterEgg,text, date, createdAt)
                      VALUES ($idAuthor,$idEasterEgg,'"
                    . $comment->getText() . "','"
                    . $comment->getDate() . "','"
                    . $time->format('Y-m-d H:i:s') . "')";

        $this->connection->query($stringSQL);
        $comment->setId($this->connection->insert_id);

        return $comment;
    }

    /**
     * @param Commentary $comment
     * @return string
     */
    public function editComment($comment){

        $stringSQL = "UPDATE comment set text = '". $comment->getText() ."' WHERE idComment = ". $comment->getId();
        $this->connection->query($stringSQL);
        return "Comentário editado com sucesso";
    }

}
?>
