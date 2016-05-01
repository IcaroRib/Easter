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
    public static function createUserFromArrayQuerry($userArrayQuerry)
    {

        $user = new User();

        if (!empty($userArrayQuerry["idUser"])) {
            $user->setId((int)$userArrayQuerry["idUser"]);
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

        return $media;
    }

}