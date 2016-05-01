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

			$stringSQL = "INSERT INTO user (userName,profileName,age,gender,imageUrl,email,password) VALUES('"
							. $user->getUserName() . "',  '"
							. $user->getProfileName() . "' , '"
							. $user->getAge() . "',	'"
							. $user->getGender() . "', '"
							. $user->getImageUrl() . "', '"
							. $user->getEmail() . "', '"
							. $user->getPassword() . "' )";

			echo $stringSQL;
			$this->connection->query($stringSQL);
			$user->setId($this->getConnection()->insert_id);
			return $user;

		}

		function updateUserProfile() {
		    
		}

		/**
		 * @param int $id
		 * @return User
		 */
		function selectUserNativeById($id) {
		    
			$user = new User();
	 		$stringSQL = "SELECT * FROM user WHERE idUser = " .$id;
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){			
				$user = ClassCreator::createUserFromArrayQuerry($result);
				break;
			}	

			return $user;			
		}

		/**
		 * @param string $email
		 * @return User
		 */
		function selectUserNativeByEmail($email) {

			$user = new User();
	 		$stringSQL = "SELECT * FROM user WHERE email = '". $email . "'";
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){
				$user = ClassCreator::createUserFromArrayQuerry($result);
				break;
			}	

			return $user;			
		}

		/**
		 * @param string $email
		 * @param string $senha
		 * @return User
		 */

		function selectUserNativeByEmailPassword($email,$senha) {
		    
			$user = new User();
	 		$stringSQL = "SELECT * FROM user WHERE email = '" . $email . "' and password = '" . $senha . "'";
	 		$result_query = $this->connection->query($stringSQL);
	 	    while($result = $result_query->fetch_assoc()){			
				$user = ClassCreator::createUserFromArrayQuerry($result);
				break;
			}	

			return $user;			
		}

		/**
		 * @param $userName
		 * @return User
		 */
		function selectUserNativeByUsername($userName) {

			$user = new User();
			$stringSQL = "SELECT * FROM user WHERE userName = '". $userName . "'";
			$result_query = $this->connection->query($stringSQL);
			while($result = $result_query->fetch_assoc()){
				$user = ClassCreator::createUserFromArrayQuerry($result);
				break;
			}

			return $user;
		}

		/**
		 * @param string $userName
		 * @param string $senha
		 * @return User
		 */

		function selectUserNativeByUsernamePassword($userName,$senha) {

			$user = new User();
			$stringSQL = "SELECT * FROM user WHERE userName = '" . $userName . "' and password = '" . $senha . "'";
			$result_query = $this->connection->query($stringSQL);
			while($result = $result_query->fetch_assoc()){
				$user = ClassCreator::createUserFromArrayQuerry($result);
				break;
			}

			return $user;
		}

		/**
		 * @return mysqli
		 */
		public function getConnection()
		{
			return $this->connection;
		}

		/**
		 * @param mysqli $connection
		 */
		public function setConnection($connection)
		{
			$this->connection = $connection;
		}
	}
?>