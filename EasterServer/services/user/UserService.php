<?php

class UserService{

    private $userDB;

    function UserService(){

        $this->userDB = new UserDAO();

    }

    /**
     * @param $user
     * @param $profileType
     * @return string
     */
    public function update($user,$profileType) {

        if($profileType == "native"){
            $mensagem = $this->getUserDB()->updateUserProfile($user);
        }

        $this->getUserDB()->desconnect();
        return $mensagem;

    }

    /**
     * @param User $user
     * @param string $profileType
     * @return string|User
     */

    public function login($user,$profileType) {

        if($profileType == "native"){
            if($user->getEmail() != ""){
                $user = $this->verifyNativeProfile($user->getEmail(),$user->getPassword());
            }
            else{
                $user = $this->verifyUserNameProfile($user->getUserName(),$user->getPassword());
            }

        }

        if($profileType == "facebook"){
            $user = $this->verifyFacebookProfile($user->getFacebookAcessToken());

        }

        $this->getUserDB()->desconnect();
        return $user;

    }

    /**
     * @param User $user
     * @param string $profileType
     * @return string|User
     */
    public function insertUser($user,$profileType){
        if($profileType == "native"){
            /** @var User $selectedUser */
            $selectedUser= $this->getUserDB()->selectUserNativeByEmail($user->getEmail());
            if($selectedUser->getId() == 0){
                $selectedUser= $this->getUserDB()->selectUserNativeByUsername($user->getUserName());
                if($selectedUser->getId() == 0){
                    return $this->getUserDB()->insertNativeProfile($user);
                }
                 return "Nome de usuário em uso";
                
            }
            return "Email já cadastrado";
        }

        if($profileType == "facebook"){
            /** @var User $selectedUser */
            $selectedUser= $this->getUserDB()->selectUserNativeByAcessToken($user->getFacebookAcessToken());
            if($selectedUser->getId() == 0){
                return $this->getUserDB()->insertFacebookProfile($user);
            }
            else{
                return "Usuário já cadastrado";
            }
        }

        $this->getUserDB()->desconnect();

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
     * @param string $userName
     * @param string $password
     * @return string|User
     */
    private function verifyUserNameProfile($userName,$password){
        /** @var User $newUser */
        $newUser = $this->getUserDB()->selectUserNativeByUsernamePassword($userName,$password);
        if($newUser->getId() == 0){
            //Caso ele entre aqui significa que temos de verificar se ele não tem ou email cadastrado ou a senha está incorret
            return $this->verifyUsername($userName);
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

    private function verifyUserName($userName){

        /** @var User $selectedUser */
        $selectedUser = $this->getUserDB()->selectUserNativeByUsername($userName);
        if($selectedUser->getId() == 0){
            return "Usuário Não localizado";
        }
        else{
            return "Senha Incorreta. Tente novamente";
        }

    }

    private function verifyFacebookProfile($acessToken){

        /** @var User $selectedUser */
        $selectedUser = $this->getUserDB()->selectUserNativeByAcessToken($acessToken);
        if($selectedUser->getId() == 0){
            return "Usuário Não localizado";
        }

        else{
            return $selectedUser;
        }

    }

    /**
     * @param User $user
     */
    private function updateNativeProfile($user){
        /** @var User $selectedUser */
        $selectedUser = $this->getUserDB()->selectUserNativeByEmail($user->getProfileName());
        if ($selectedUser->getId() == 0){

            $selectedUser = $this->getUserDB()->selectUserNativeByUsername($user->getUserName());
            if($selectedUser->getId() == 0){
                return $this->getUserDB()->updateUserProfile($user);
            }

            else{
                return "Nome de usuário já cadastrado";
            }
        }
        else{
            return "Email já casdastro";
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