<?php    
	

	class Connection{

		private $servername = 'localhost';
		private $username = 'root';
		private $password = 'JME.megasin-02';
		private $dbname = 'easter';
		private $connector = null;

		function Connection(){

			$this->connector = $this->connect();

		}

		private function connect(){
			$this->connector = new mysqli($this->servername, $this->username, $this->password, $this->dbname);
		
		}

		public function desconnect(){
			$this->connector->close();

		}


	}
	

?>