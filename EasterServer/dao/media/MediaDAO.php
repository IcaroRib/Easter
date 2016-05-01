<?php 

	include_once("../../dao/Connection.php");

	class MediaDAO{

		private $connection;

		function MediaDAO() {
        	//$this->connection = new Connection();
        	$this->connection = new mysqli('localhost','root','JME.megasin-02','easter');
    	}

    	function desconnect(){
    		$this->connection->close();

    	}

		/**
		 * @param string $title
		 * @return array
		 */
    	function findMediaByName($title){
			$listaObras = array();
	 		$stringSQL = "SELECT * FROM media WHERE title like '%$title%'";
	 		$result_query = $this->connection->query($stringSQL);
	 		$cont = 0;
	 	    while($result = $result_query->fetch_assoc()){
				/** @var Media $media */
				$media = ClassCreator::createMediaFromArrayQuerry($result);
				$listaObras[$cont] = $media;
				$cont +=1;
 			}	
			return $listaObras;		

		}

		function findMediaById($id)
		{
			$newMedia = new Media();
			$stringSQL = "SELECT * FROM media WHERE idMedia = " . $id;
			$result_query = $this->connection->query($stringSQL);
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				break;
			}
			return $newMedia;

		}

		
	}
?>