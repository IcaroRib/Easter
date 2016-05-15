<?php

/**
 * Created by PhpStorm.
 * User: Icaro
 * Date: 01/05/2016
 * Time: 09:56
 */
class ClassCreator
{
    /**
     * @param array $jsonUser
     * @return User
     */
    public static function createUserFromJson($jsonUser){

        $user = new User();

        if(!empty($jsonUser["id"])){
            $user->setId($jsonUser["id"]);
        }

        if(!empty($jsonUser["acessToken"])){
            $user->setFacebookAcessToken($jsonUser["acessToken"]);
        }

        if(!empty($jsonUser["profileName"])){
            $user->setProfileName($jsonUser["profileName"]);
        }

        if(!empty($jsonUser["userName"])){
            $user->setUserName($jsonUser["userName"]);
        }

        if(isset($jsonUser["age"])){
            $user->setAge((int)$jsonUser["age"]);
        }

        if(isset($jsonUser["gender"])){
            $user->setGender($jsonUser["gender"]);
        }

        if(isset($jsonUser["imageUrl"])){
            $user->setImageUrl($jsonUser["imageUrl"]);
        }

        if(isset($jsonUser["email"])){
            $user->setEmail($jsonUser["email"]);
        }

        if(isset($jsonUser["password"])) {
            $user->setPassword($jsonUser["password"]);
        }

        return $user;


    }


    /**
     * @param array $userArrayQuerry
     * @return User
     */
    public static function createUserFromArrayQuerry($userArrayQuerry){

        $user = new User();

        if (!empty($userArrayQuerry["idUser"])) {
            $user->setId((int)$userArrayQuerry["idUser"]);
        }

        if (!empty($userArrayQuerry["acessTokenFacebook"])) {
            $user->setFacebookAcessToken($userArrayQuerry["acessTokenFacebook"]);
        }

        if (!empty($userArrayQuerry["profileName"])) {
            $user->setProfileName($userArrayQuerry["profileName"]);
        }

        if (!empty($userArrayQuerry["userName"])) {
            $user->setUserName($userArrayQuerry["userName"]);
        }

        if (isset($userArrayQuerry["age"])) {
            $user->setAge($userArrayQuerry["age"]);
        }

        if (isset($userArrayQuerry["gender"])) {
            $user->setGender($userArrayQuerry["gender"]);
        }

        if (isset($userArrayQuerry["imageUrl"])) {
            $user->setImageUrl($userArrayQuerry["imageUrl"]);
        }

        if (isset($userArrayQuerry["email"])) {
            $user->setEmail($userArrayQuerry["email"]);
        }

        if (isset($userArrayQuerry["password"])) {
            $user->setPassword($userArrayQuerry["password"]);
        }

        return $user;
    }

    /**
     * @param array $jsonMedia
     * @return Media
     */
    public static function createMediaFromJson($jsonMedia){

        $media = new Media();
        if(isset($jsonMedia["id"])){
            $media->setId($jsonMedia["id"]);
        }

        if(isset($jsonMedia["title"])){
            $media->setTitle($jsonMedia["title"]);
        }

        return $media;
    }

    /**
     * @param array $jsonMedia
     * @return EasterEgg
     */
    public static function createEasterEggFromJson($jsonMedia){

        $EasterEgg = new EasterEgg();
        if(isset($jsonMedia["id"])){
            $EasterEgg->setId($jsonMedia["id"]);
        }

        if(isset($jsonMedia["description"])){
            $EasterEgg->setDescription($jsonMedia["description"]);
        }

        if(isset($jsonMedia["score"])){
            $EasterEgg->setScore($jsonMedia["score"]);
        }

        if(isset($jsonMedia["imageUrl"])){
            $EasterEgg->setImageUrl($jsonMedia["imageUrl"]);
        }

        if(isset($jsonMedia["setAuthorName"])){
            $EasterEgg->setAuthorName($jsonMedia["setAuthorName"]);
        }

        if(isset($jsonMedia["idAuthor"])){
            $EasterEgg->setIdAuthor($jsonMedia["idAuthor"]);
        }

        return $EasterEgg;
    }

    /**
     * @param array $mediaArrayQuery
     * @return Media
     */
    public static function createMediaFromArrayQuerry($mediaArrayQuery){

        $media = new Media();
        if(isset($mediaArrayQuery["idMedia"])){
            $media->setId($mediaArrayQuery["idMedia"]);
        }

        if(isset($mediaArrayQuery["title"])){
            $media->setTitle($mediaArrayQuery["title"]);
        }

        if(isset($mediaArrayQuery["category"])){
            $media->setCategory($mediaArrayQuery["category"]);
        }

        if(isset($mediaArrayQuery["image"])){
            $media->setImage($mediaArrayQuery["image"]);
        }

        if(isset($mediaArrayQuery["mediumScore"])){
            $media->setScore($mediaArrayQuery["mediumScore"]);
        }

        if(isset($mediaArrayQuery["User_idUser"])){
            if($mediaArrayQuery["User_idUser"] != null){
                $media->setIsFavorite(true);
            }
        }

        return $media;
    }

    /**
     * @param array $taskArrayQuery
     * @return Task
     */

    public static function createTaskFromArrayQuerry($taskArrayQuery){

        $task = new Task();
        if(isset($taskArrayQuery["idTask"])){
            $task->setId($taskArrayQuery["idTask"]);
        }

        if(isset($taskArrayQuery["description"])){
            $task->setDescription($taskArrayQuery["description"]);
        }
        return $task;
    }

    /**
     * @param array $taskArrayQuery
     * @return Reference
     */
    public static function createRefenceFromArrayQuerry($taskArrayQuery){

        $reference = new Reference();
        if(isset($taskArrayQuery["idMedia"])){
            $reference->setIdMedia($taskArrayQuery["idMedia"]);
        }

        if(isset($taskArrayQuery["title"])){
            $reference->setReferenceTitle($taskArrayQuery["title"]);
        }

        return $reference;
    }

    public static function createEasterEggFromArrayQuerry($eeArrayQuery){

        $easterEgg = new EasterEgg();
        if(isset($eeArrayQuery["idEasterEgg"])){
            $easterEgg->setId($eeArrayQuery["idEasterEgg"]);
        }

        if(isset($eeArrayQuery["description"])){
            $easterEgg->setDescription($eeArrayQuery["description"]);
        }

        if(isset($eeArrayQuery["idWritter"])){
            $easterEgg->setIdAuthor($eeArrayQuery["idWritter"]);
        }

        if(isset($eeArrayQuery["profileName"])){
            $easterEgg->setAuthorName($eeArrayQuery["profileName"]);
        }

        if(isset($eeArrayQuery["mediumScore"])){
            $easterEgg->setScore($eeArrayQuery["mediumScore"]);
        }

        return $easterEgg;
    }

}