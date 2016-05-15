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

        if(isset($jsonMedia["authorName"])){
            $EasterEgg->setAuthorName($jsonMedia["authorName"]);
        }

        if(isset($jsonMedia["idAuthor"])){
            $EasterEgg->setIdAuthor($jsonMedia["idAuthor"]);
        }

        if(isset($jsonMedia["references"])){

            $cont = 0;
            $references = array();
            foreach ($jsonMedia["references"] as $referenceJson){
                $newReference = new Reference();
                $newReference->setIdMedia($referenceJson["idMedia"]);
                $newReference->setReferenceTitle($referenceJson["title"]);
                $references[$cont] = $newReference;
                $cont +=1;
            }
            $EasterEgg->setReferences($references);
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

    public static function createCommentFromArrayQuerry($commentArrayQuery){

        $comment = new Commentary();
        if(isset($commentArrayQuery["idComment"])){
            $comment->setId($commentArrayQuery["idComment"]);
        }

        if(isset($commentArrayQuery["text"])){
            $comment->setText($commentArrayQuery["text"]);
        }

        if(isset($commentArrayQuery["idUser"])){
            $comment->setIdAuthor($commentArrayQuery["idUser"]);
        }

        if(isset($commentArrayQuery["profileName"])){
            $comment->setAuthorName($commentArrayQuery["profileName"]);
        }

        if(isset($commentArrayQuery["qtyLikes"])){
            $comment->setQtdLikes($commentArrayQuery["qtyLikes"]);
        }

        if(isset($commentArrayQuery["qtyDislikes"])){
            $comment->setQtdDislikes($commentArrayQuery["qtyDislikes"]);
        }

        if(isset($commentArrayQuery["date"])){
            $comment->getDate($commentArrayQuery["date"]);
        }

        return $comment;
    }

    public static function createCommentFromJson($commentJson){

        $comment = new Commentary();

        if(isset($commentJson["idComment"])){
            $comment->setId($commentJson["idComment"]);
        }

        if(isset($commentJson["text"])){
            $comment->setText($commentJson["text"]);
        }

        if(isset($commentJson["idUser"])){
            $comment->setIdAuthor($commentJson["idUser"]);
        }

        if(isset($commentArrayQuery["profileName"])){
            $comment->setAuthorName($commentArrayQuery["profileName"]);
        }

        if(isset($commentJson["qtyLikes"])){
            $comment->setQtdLikes($commentJson["qtyLikes"]);
        }

        if(isset($commentJson["qtyDislikes"])){
            $comment->setQtdDislikes($commentJson["qtyDislikes"]);
        }

        if(isset($commentJson["date"])){
            $comment->setDate($commentJson["date"]);
        }

        return $comment;
    }

}