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

		function findMediaById($id){
			$novaObra = new Media();
			$stringSQL = "SELECT * FROM obra WHERE idObra = ". $id;
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){
				$novaObra->id = $result['idObra'];
				$novaObra->titulo = $result['titulo'];
				$novaObra->midia = $result['midia'];
				$novaObra->imagem = $result['imagem'];
				break;
 			}	
			return $novaObra;		

		}

		function findTasksById($id){
			$listaTasks = array();
	 		$stringSQL = "SELECT * FROM task WHERE EasterEgg_idEasterEgg = ". $id;
	 		$result_query = $this->connection->query($stringSQL);
	 		$cont = 0;
	 	    while($result = $result_query->fetch_assoc()){			
				$task = array("id"=>$result['idTask'],"descricao"=>$result['descricao']);
				$listaTasks[$cont] = $task;
				$cont +=1;
 			}	
			return $listaTasks;				
		}

		function findReferencesById($id){
			$listaReferencias = array();
	 		$stringSQL = "SELECT * FROM referencia INNER JOIN obra ON Obra_idObra = idObra
	 					  WHERE EasterEgg_idEasterEgg  = " . $id;
	 		$result_query = $this->connection->query($stringSQL);
	 		$cont = 0;
	 	    while($result = $result_query->fetch_assoc()){			
				$referencia = array("id"=>$result['idObra'],"titulo"=>$result['titulo']);
				$listaReferencias[$cont] = $referencia;
				$cont +=1;
 			}	
			return $listaReferencias;				
		}



	}
?>