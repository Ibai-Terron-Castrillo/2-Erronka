<?php

function konexioaSortu()
{

    $servername = "172.16.237.119";
    $username = "erabiltzaile";
    $password = "3Taldea3";
    $dbname = "erronka2";

    $conn = new mysqli($servername, $username, $password, $dbname);


    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    return $conn;
}