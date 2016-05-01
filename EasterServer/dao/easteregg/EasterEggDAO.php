<?php
include_once("../../dao/Connection.php");

class EasterEggDAO{

    public $connection;

    function EasterEggDAO(){
        $this->connection = new mysqli('localhost','root','JME.megasin-02','easter');
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
            $EasterEgg->getDescription(),
            $EasterEgg->getImageUrl(),
            0,
            $EasterEgg->getIdAuthor(),
            $EasterEgg->getAuthorName(),
            $time->format('Y-m-d H:i:s')
        );

        if (!empty($EasterEgg->tasklist)){

            array_push($values,$EasterEgg->tasklist);
            $stringSQL = "INSERT INTO EasterEgg (description,image, status,creatorid,creatorName, tasklist, createdAt) VALUES". implode("','", $values);

        } else {

            $stringSQL = "INSERT INTO EasterEgg (description,image, status,creatorid,creatorName, createdAt) VALUES". implode("','", $values);
        }

        $result_query = $this->connection->query($stringSQL);
    }

    function markTaskAsComplete($EasterEgg,$task){

        $stringSQL("UPDATE task set status = 1 where id = ". $task->id); /*Status is double type (?) */

        $result_query = $this->connection->query($stringSQL);
    }

    function onChange($EasterEgg){

        $stringSQL = "UPDATE EasterEgg set 
            description = ". $EasterEgg->description
            .", image = ". $EasterEgg->image
            .", status = ". $EasterEgg->status
            .", tasklist = ". $EasterEgg->tasklist
            ." WHERE id = ". $EasterEgg->id;

        $result_query = $this->connection->query($stringSQL);

    }

    function findCompleteById($id){
        $EElist =  array();
        $stringSQL = "SELECT idEasterEgg, description, easteregg.imageUrl, idWritter, AVG(score) as mediumScore 
                      FROM easteregg INNER JOIN user ON idUser = idWritter
                      INNER JOIN evaluatedeasteregg ON idEasterEgg = EasterEgg_idEasterEgg
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

    function findTasksById($id){
        $listaTasks = array();
        $stringSQL = "SELECT * FROM task WHERE EasterEgg_idEasterEgg = ". $id;
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $task = ClassCreator::createTaskFromArrayQuerry($result);
            $listaTasks[$cont] = $task;
            $cont +=1;
        }
        return $listaTasks;
    }

    function findReferencesById($id){
        $listaReferencias = array();
        $stringSQL = "SELECT * FROM reference INNER JOIN media ON Media_idMedia = idMedia
	 					  WHERE EasterEgg_idEasterEgg  = " . $id;
        $result_query = $this->connection->query($stringSQL);
        $cont = 0;
        while($result = $result_query->fetch_assoc()){
            $referencia = ClassCreator::createRefenceFromArrayQuerry($result);
            $listaReferencias[$cont] = $referencia;
            $cont +=1;
        }
        return $listaReferencias;
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
        $stringSQL = "UPDATE evaluatedesteregg SET score = " . $score .
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
        $stringSQL = "SELECT * FROM evaluatedesteregg WHERE EasterEgg_idEasterEgg = " . $idEasterEgg . " and User_idUser = " . $idUser;
        $result_query = $this->connection->query($stringSQL);
        while($result = $result_query->fetch_assoc()){
            return true;
        }
        return false;

    }

    function fallowEasterEgg($idEasterEgg, $idUser)
    {
        $time = new DateTime();
        $stringSQL = "INSERT INTO fallowedeasteregg (User_idUser, EasterEgg_idEasterEgg, createdAt) 
                          VALUES ($idUser,$idEasterEgg,'" . $time->format('Y-m-d H:i:s') . "')";
        $this->connection->query($stringSQL);
        echo $stringSQL;
        return "Obra seguida com sucesso";

    }

    function fallowTask($IdTask, $idUser)
    {
        $time = new DateTime();
        $stringSQL = "INSERT INTO fallowedTask (idUser, idTask, createdAt) 
                          VALUES ($idUser,$IdTask,'" . $time->format('Y-m-d H:i:s') . "')";
        echo $stringSQL;
        $this->connection->query($stringSQL);
        return "Obra seguida com sucesso";

    }
}
?>
