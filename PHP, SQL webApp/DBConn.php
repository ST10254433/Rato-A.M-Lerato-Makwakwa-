<?php

// Server info
$server =(string) "localhost";
$username =(string) "root";
$password =(string) "";
$database =(string) "students_db";
$port_number =(int) 3306;

//execute connection.
$connect = mysqli_connect($server,$username,$password,$database);

//check if it is getting connection.
if($connect){
    // display message.
    echo "Connected, ";
} else{

    // display message.
    echo "Disconnected, ";
}

?>


