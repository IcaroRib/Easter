<?php    
	

	class Connection{

		public $servername = 'localhost';
		public $username = 'root';
		public $password = 'JME.megasin-02';
		public $dbname = 'easter';
		public $connector = null;

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