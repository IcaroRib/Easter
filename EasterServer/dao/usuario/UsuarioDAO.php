<?php 

	include_once("../../dao/Connection.php");

	class UsuarioDAO{

		public $connection;

		function UsuarioDAO() {
        	//$this->connection = new Connection();
        	$this->connection = new mysqli('localhost','root','JME.megasin-02','easter');
    	}

    	function desconnect(){
    		$this->connection->close();

    	}

    	function verifyNativeProfile($email,$senha){
			$user = array();
			$user = $this->selectUserNativeEmail_Senha($email,$senha);
			if($user['idUsuario'] == 0){ 
				//Caso ele entre aqui significa que temos de verificar se ele não tem ou email cadastrado ou a senha está incorreta
				return $this->verificarEmail($email);
			}
			else{
				return $user;
			}

		}

		function verifyEmail($email){

			$user = array();
			$user = $this->selectUserNativeEmail($email);
			if($user['idUsuario'] == 0){
				return "Email Não localizado";
			}
			else{
				return "Senha Incorreta. Tente novamente";
			}

		}

		function login($user,$tipoPerfil) {

			if($tipoPerfil == "nativo"){
				$user = $this->verificarPerfilNativo($user->email,$user->senha);	    	
			}

			return $user;

		}

		function insertUser($user,$tipoPerfil){
			if($tipoPerfil == "nativo"){
				$retorno = $this->selectUserNativeEmail($user->email);	
				echo $user->nomeUsuario;
				if($retorno['idUsuario'] == 0){

					return $this->insertNativeProfile($user);
		    	}
		    	else{
		    		return "Email já cadastrado";
		    	}    	
			}

		}

		function insertNativeProfile($user) {

			$stringSQL = "INSERT INTO usuario(nomeUsuario,nomePerfil,idade,genero,imagemUrl,email,senha) VALUES 
						('$user->nomeUsuario', '$user->nomePerfil', '$user->idade','$user->genero', '$user->imagemUrl','$user->email','$user->senha')";
			
			$this->connection->query($stringSQL);
			$user = $this->selectUserNativeById($this->connection->$connector->insert_id);
			return $user;

		}

		function updateUserProfile() {
		    
		}

		function selectUserNativeById($id) {
		    
			$user = array();
			$user['idUsuario'] = 0;
	 		$stringSQL = "SELECT * FROM usuario WHERE idUsuario = $id";
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){			
				$user = $result;
				break;
			}	

			return $user;			
		}

		function selectUserNativeByEmail($email) {
		    
			$user = array();
			$user['idUsuario'] = 0;
	 		$stringSQL = "SELECT * FROM usuario WHERE email = '$email'";
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){			
				$user = $result;
				break;
			}	

			return $user;			
		}

		function selectUserNativeByEmailPassword($email,$senha) {
		    
			$user = array();
			$user['idUsuario'] = 0;
	 		$stringSQL = "SELECT * FROM usuario WHERE email = '$email' and senha = '$senha'";
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){			
				$user = $result;
				break;
			}	

			return $user;			
		}

	}
?>