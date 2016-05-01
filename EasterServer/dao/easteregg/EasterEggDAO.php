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

    function findById($id){
        $EElist =  array();
        $stringSQL = "SELECT * FROM easteregg INNER JOIN user ON idUser = idWritter
	 				  WHERE idMedia =" . $id;
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
}
?>
