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

    	function find($tipoPesquisa,$obra){

    		if($tipoPesquisa == "title"){
    			return $this->findMediaByName($obra);
    		}

    		else if($tipoPesquisa == "id"){
    			return $this->procurarPorId($obra);
    		}

    	}

    	function findMediaByName($obra){
			$listaObras = array();
	 		$stringSQL = "SELECT * FROM obra WHERE titulo like '%$obra->titulo%'";
	 		$result_query = $this->connection->query($stringSQL);
	 		$cont = 0;
	 	    while($result = $result_query->fetch_assoc()){			
				$obra = new Obra($result['titulo'],$result['midia'],$result['midia'],$result['imagem']);
				$listaObras[$cont] = $obra;
				$cont +=1;
 			}	
			return $listaObras;		

		}

		function procurarPorId($obraRequest){

			$novaObra = $this->findMediaById($obraRequest->id);
			$novaObra->easterEggs = $this->procurarEggsPorId($novaObra->id);

			foreach ($novaObra->easterEggs as $easteregg) {
				if($novaObra->midia == "jogo"){				
					$easteregg->tasks = $this->findTasksById($easteregg->id);
				}
				$easteregg->referencias = $this->findReferencesById($easteregg->id);
			}

			return $novaObra;

		}

		function findMediaById($id){
			$novaObra = new Obra();
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