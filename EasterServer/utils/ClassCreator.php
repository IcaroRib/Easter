
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
        $jsonMedia = json_decode($jsonMedia,TRUE);

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

        if(!empty($jsonUser["age"])){
            $user->setAge((int)$jsonUser["age"]);
        }

        if(!empty($jsonUser["gender"])){
            $user->setGender($jsonUser["gender"]);
        }

        if(!empty($jsonUser["imageUrl"])){
            $user->setImageUrl($jsonUser["imageUrl"]);
        }

        if(!empty($jsonUser["email"])){
            $user->setEmail($jsonUser["email"]);
        }

        if(!empty($jsonUser["password"])) {
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

        if (!empty($userArrayQuerry["age"])) {
            $user->setAge($userArrayQuerry["age"]);
        }

        if (!empty($userArrayQuerry["gender"])) {
            $user->setGender($userArrayQuerry["gender"]);
        }

        if (!empty($userArrayQuerry["imageUrl"])) {
            $user->setImageUrl($userArrayQuerry["imageUrl"]);
        }

        if (!empty($userArrayQuerry["email"])) {
            $user->setEmail($userArrayQuerry["email"]);
        }

        if (!empty($userArrayQuerry["password"])) {
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
        $jsonMedia = json_decode($jsonMedia,TRUE);

        if(!empty($jsonMedia["id"])){
            $media->setId($jsonMedia["id"]);
        }

        if(!empty($jsonMedia["title"])){
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
        $jsonMedia = json_decode($jsonMedia,TRUE);

        if(!empty($jsonMedia["id"])){
            $EasterEgg->setId($jsonMedia["id"]);
        }

        if(!empty($jsonMedia["idMedia"])){
            $EasterEgg->setIdMedia($jsonMedia["idMedia"]);
        }

        if(!empty($jsonMedia["description"]){
            $EasterEgg->setDescription($jsonMedia["description"]);
        }

        if(!empty($jsonMedia["score"])){
            $EasterEgg->setScore($jsonMedia["score"]);
        }

        if(!empty($jsonMedia["imageUrl"])){
            $EasterEgg->setImageUrl($jsonMedia["imageUrl"]);
        }

        if(!empty($jsonMedia["authorName"])){
            $EasterEgg->setAuthorName($jsonMedia["authorName"]);
        }

        if(!empty($jsonMedia["idAuthor"])){
            $EasterEgg->setIdAuthor($jsonMedia["idAuthor"]);
        }

        if(!empty($jsonMedia["references"])){

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
        if(!empty($mediaArrayQuery["idMedia"])){
            $media->setId($mediaArrayQuery["idMedia"]);
        }

        if(!empty($mediaArrayQuery["title"])){
            $media->setTitle($mediaArrayQuery["title"]);
        }

        if(!empty($mediaArrayQuery["category"])){
            $media->setCategory($mediaArrayQuery["category"]);
        }

        if(!empty($mediaArrayQuery["image"])){
            $media->setImage($mediaArrayQuery["image"]);
        }

        if(!empty($mediaArrayQuery["averageScore"])){
            $media->setAverageScore($mediaArrayQuery["averageScore"]);
        }

        if(!empty($mediaArrayQuery["User_idUser"])){
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
        if(!empty($taskArrayQuery["idTask"])){
            $task->setId($taskArrayQuery["idTask"]);
        }

        if(!empty($taskArrayQuery["description"])){
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
        if(!empty($taskArrayQuery["idMedia"])){
            $reference->setIdMedia($taskArrayQuery["idMedia"]);
        }

        if(!empty($taskArrayQuery["title"])){
            $reference->setReferenceTitle($taskArrayQuery["title"]);
        }

        return $reference;
    }

    public static function createEasterEggFromArrayQuerry($eeArrayQuery){

        $easterEgg = new EasterEgg();
        if(!empty($eeArrayQuery["idEasterEgg"])){
            $easterEgg->setId($eeArrayQuery["idEasterEgg"]);
        }

        if(!empty($eeArrayQuery["description"])){
            $easterEgg->setDescription($eeArrayQuery["description"]);
        }

        if(!empty($eeArrayQuery["idWritter"])){
            $easterEgg->setIdAuthor($eeArrayQuery["idWritter"]);
        }

        if(!empty($eeArrayQuery["profileName"])){
            $easterEgg->setAuthorName($eeArrayQuery["profileName"]);
        }

        if(!empty($eeArrayQuery["mediumScore"])){
            $easterEgg->setScore($eeArrayQuery["mediumScore"]);
        }
        if(!empty($eeArrayQuery["imageUrl"])){
            $easterEgg->setImageUrl($eeArrayQuery["imageUrl"]);
        }

        return $easterEgg;
    }

    public static function createCommentFromArrayQuerry($commentArrayQuery){

        $comment = new Commentary();
        if(!empty($commentArrayQuery["idComment"])){
            $comment->setId($commentArrayQuery["idComment"]);
        }

        if(!empty($commentArrayQuery["text"])){
            $comment->setText($commentArrayQuery["text"]);
        }

        if(!empty($commentArrayQuery["idUser"])){
            $comment->setIdAuthor($commentArrayQuery["idUser"]);
        }

        if(!empty($commentArrayQuery["profileName"])){
            $comment->setAuthorName($commentArrayQuery["profileName"]);
        }

        if(!empty($commentArrayQuery["qtyLikes"])){
            $comment->setQtdLikes($commentArrayQuery["qtyLikes"]);
        }

        if(!empty($commentArrayQuery["qtyDislikes"])){
            $comment->setQtdDislikes($commentArrayQuery["qtyDislikes"]);
        }

        if(!empty($commentArrayQuery["date"])){
            $comment->setDate($commentArrayQuery["date"]);
        }

        return $comment;
    }

    public static function createCommentFromJson($commentJson){

        $comment = new Commentary();
        $jsonMedia = json_decode($jsonMedia,TRUE);

        if(!empty($commentJson["idComment"])){
            $comment->setId($commentJson["idComment"]);
        }

        if(!empty($commentJson["text"])){
            $comment->setText($commentJson["text"]);
        }

        if(!empty($commentJson["idUser"])){
            $comment->setIdAuthor($commentJson["idUser"]);
        }

        if(!empty($commentJson->profileName)){
            $comment->setAuthorName($commentJson->profileName);
        }

        if(!empty($commentJson["qtyLikes"])){
            $comment->setQtdLikes($commentJson["qtyLikes"]);
        }

        if(!empty($commentJson["qtyDislikes"])){
            $comment->setQtdDislikes($commentJson["qtyDislikes"]);
        }

        if(!empty($commentJson["date"])){
            $comment->setDate($commentJson["date"]);
        }

        return $comment;
    }


}
