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
			$stringSQL = "SELECT * FROM media left outer join fallowedmedia on idMedia = Media_idMedia WHERE idMedia = " . $id;
			$result_query = $this->connection->query($stringSQL);
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				break;
			}
			return $newMedia;

		}

		/**
		 * @return array
		 */
		function findRecents()
		{
			$listMedia = array();
			$stringSQL = "SELECT idMedia, category, image, title FROM media ORDER BY createdAt DESC LIMIT 20";
			$result_query = $this->connection->query($stringSQL);
			$cont = 0;
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				$listMedia[$cont] = $newMedia;
				$cont +=1;
			}
			return $listMedia;

		}

        /**
         * @param int $idMedia
         * @param int $idAuthor
         * @return string
         */
        function fallowMedia($idMedia, $idAuthor)
        {   
            $time = new DateTime();
            $stringSQL = "INSERT INTO fallowedmedia (User_idUser, Media_idMedia, createdAt) 
                          VALUES ($idAuthor,$idMedia,'" . $time->format('Y-m-d H:i:s') . "')";
            $this->connection->query($stringSQL);
            echo $stringSQL;
            return "Obra seguida com sucesso";

        }
		
	}
?>