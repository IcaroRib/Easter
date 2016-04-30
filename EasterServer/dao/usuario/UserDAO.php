<?php 

	include_once("../../dao/Connection.php");

	class UserDAO{

		public $connection;

		function UserDAO() {
        	//$this->connection = new Connection();
        	$this->connection = new mysqli('localhost','root','JME.megasin-02','easter');
    	}

    	function desconnect(){
    		$this->connection->close();

    	}

		/**
		 * @param User $user
		 * @return User
         */
		function insertNativeProfile($user) {

			$user = new User();

			$stringSQL = "". "INSERT INTO user (userName,profileName,age,genre,imagemUrl,email,senha) VALUES"
						 . "( '$user->getName()',  '$user->getProfileName()' , '$user->getAge()', 
							'$user->getGender()', '$user->getImageUrl()', '$user->getEmail()', '$user->getPassword()' )";

			echo $stringSQL;
			//$this->connection->query($stringSQL);
			//$user = $this->selectUserNativeById($this->connection->$connector->insert_id);
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