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

        function insertNew($EasterEgg){
            
         $values = array(
                $EasterEgg->description,
                $EasterEgg->image,
                0,
                $EasterEgg->creatorId,
                $EasterEgg->creatorName
        );    
            
        if (!empty($EasterEgg->tasklist)){
            
            array_push($values,$EasterEgg->tasklist);
            $stringSQL = "INSERT INTO EasterEgg (description,image, status,creatorid,creatorName, tasklist) VALUES". implode("','", $values);
            
          } else {
            
            $stringSQL = "INSERT INTO EasterEgg (description,image, status,creatorid,creatorName) VALUES". implode("','", $values);
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
	 		$stringSQL = "SELECT * FROM easteregg INNER JOIN usuario ON idUsuario = idAutor
	 					  WHERE idObra = $id";
	 		$result_query = $this->connection->query($stringSQL);
	 		$cont = 0;
	 	    while($result = $result_query->fetch_assoc()){			
				$easteregg = new EasterEgg($result['idEasterEgg'],$result['descricao'],$result['idAutor'],$result['nomeperfil']);
				$EElist[$cont] = $easteregg;
				$cont +=1;
 			}	
			return $EElist;				
		}
    }
?>
