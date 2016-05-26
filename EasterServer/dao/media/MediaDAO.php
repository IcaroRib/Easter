<?php 

	include_once("../../dao/Connection.php");

	class MediaDAO{

		private $connection;

		function MediaDAO() {
        	//$this->connection = new Connection();
        	$this->connection = new mysqli('localhost','root','','easter');
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
			$stringSQL = "SELECT *, AVG(score) as averageScore FROM media left outer join fallowedmedia on media.idMedia = Media_idMedia
 							FROM media INNER JOIN easteregg ON media.idMedia = easteregg.idMedia
 							INNER JOIN evaluatedeasteregg ON idEasterEgg = EasterEgg_idEasterEgg
 							WHERE mdia.idMedia = " . $id . " GROUP BY media.idMedia";
			$result_query = $this->connection->query($stringSQL);
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				break;
			}
			return $newMedia;

		}

		/** @param array $filters
		 * @return array
		 */
		function findRecents($categories,$start){
			$listMedia = array();
			$stringSQL = "SELECT *, AVG(score) as averageScore FROM media left outer join fallowedmedia on media.idMedia = Media_idMedia
 							INNER JOIN easteregg ON media.idMedia = easteregg.idMedia
 							INNER JOIN evaluatedeasteregg ON idEasterEgg = EasterEgg_idEasterEgg";

			$mark = 0;
			foreach ($categories as $category){
				if ($mark == 0){
					$stringSQL = $stringSQL . " WHERE category = '$category'";
					$mark +=1;
				}
				else{
					$stringSQL = $stringSQL . " or category = '$category'";
				}
			}
			$stringSQL = $stringSQL . " GROUP BY media.idMedia";
			$stringSQL = $stringSQL . " ORDER BY media.createdAt DESC LIMIT " . $start . ", 20";
			$result_query = $this->connection->query($stringSQL);
			$cont = 0;
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				$listMedia[$cont] = $newMedia;
				$cont +=1;
			}
			return $listMedia;

		}

		/** @param $filters
		 * @return array
		 */
		function findMostFallowed($categories,$start){
			$listMedia = array();
			$stringSQL = "SELECT media.idMedia, category, image, title, count(fallowedmedia.User_idUser) as qtyFallowers, AVG(score) as averageScore 
							FROM media left outer join fallowedmedia on media.idMedia = Media_idMedia
 							INNER JOIN easteregg ON media.idMedia = easteregg.idMedia
 							INNER JOIN evaluatedeasteregg ON idEasterEgg = EasterEgg_idEasterEgg";
			$mark = 0;
			foreach ($categories as $category){
				if ($mark == 0){
					$stringSQL = $stringSQL . " WHERE category = '$category'";
					$mark +=1;
				}
				else{
					$stringSQL = $stringSQL . " or category = '$category'";
				}
			}

			$stringSQL = $stringSQL. " GROUP BY media.idMedia";
			$stringSQL = $stringSQL. " ORDER BY qtyFallowers DESC LIMIT " . $start . ", 20";
			$result_query = $this->connection->query($stringSQL);
			$cont = 0;
			echo $stringSQL;
			while ($result = $result_query->fetch_assoc()) {
				$newMedia = ClassCreator::createMediaFromArrayQuerry($result);
				$listMedia[$cont] = $newMedia;
				$cont +=1;
			}
			return $listMedia;

		}

		/** @param $filters
		 * @return array
		 */
		function findBestEvalueteds($categories,$start){
			$listMedia = array();
			$stringSQL = "SELECT media.idMedia, category, image, title, AVG(score) as averageScore
 							FROM media INNER JOIN easteregg ON media.idMedia = easteregg.idMedia
 							INNER JOIN evaluatedeasteregg ON idEasterEgg = EasterEgg_idEasterEgg";

			$mark = 0;
			foreach ($categories as $category){
				if ($mark == 0){
					$stringSQL = $stringSQL . " WHERE category = '$category'";
					$mark +=1;
				}
				else{
					$stringSQL = $stringSQL . " or category = '$category'";
				}
			}

			$stringSQL = $stringSQL. " GROUP BY media.idMedia";
			$stringSQL = $stringSQL. " ORDER BY averageScore DESC LIMIT " . $start . ", 20";
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
            return "Obra seguida com sucesso";

        }

		function unFallowMedia($idMedia, $idAuthor){
			$stringSQL = "DELETE FROM fallowedmedia WHERE Media_idMedia = $idMedia and User_idUser = $idAuthor; ";
			$this->connection->query($stringSQL);
		}
		
	}
?>