<?php

class UserService{

    private $userDB;

    function UserService(){

        $this->userDB = new UserDAO();

    }

    /**
     * @param User $user
     * @param string $profileType
     * @return string|User
     */

    function login($user,$profileType) {

        if($profileType == "native"){
            $user = $this->verifyNativeProfile($user->getEmail(),$user->getPassword());	    	
        }

        return $user;

    }

    /**
     * @param User $user
     * @param string $profileType
     * @return string|User
     */
    function insertUser($user,$profileType){
        if($profileType == "native"){
            /** @var User $selectedUser */
            $selectedUser= $this->getUserDB()->selectUserNativeByEmail($user->getEmail());
            if($selectedUser->getId() == 0){
                return $this->getUserDB()->insertNativeProfile($user);
            }
            else{
                return "Email já cadastrado";
            }
        }

    }

    /**
     * @param string $email
     * @param string $password
     * @return string|User
     */
    private function verifyNativeProfile($email,$password){
        /** @var User $newUser */
        $newUser = $this->getUserDB()->selectUserNativeByEmailPassword($email,$password);
        if($newUser->getId() == 0){
            //Caso ele entre aqui significa que temos de verificar se ele não tem ou email cadastrado ou a senha está incorret
            return $this->verifyEmail($email);
        }
        else{
            return $newUser;
        }

    }

    /**
     * @param string $email
     * @return string
     */
    private function verifyEmail($email){

        /** @var User $selectedUser */
        $selectedUser = $this->getUserDB()->selectUserNativeByEmail($email);
        if($selectedUser->getId() == 0){
            return "Email Não localizado";
        }
        else{
            return "Senha Incorreta. Tente novamente";
        }

    }

    /**
     * @return UserDAO
     */
    public function getUserDB()
    {
        return $this->userDB;
    }

    /**
     * @param userDAO $userDB
     */
    public function setUserDB($userDB)
    {
        $this->userDB = $userDB;
    }

}

?>