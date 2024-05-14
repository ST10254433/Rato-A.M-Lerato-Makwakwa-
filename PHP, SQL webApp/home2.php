<?php
include "DBConn.php";

$username = (string) $_POST['username'];
$password = (string) $_POST['password'];

// insert values into the table.

$query = "insert into student_info values(NULL, '$username', '$password'); ";

$insert = mysqli_query($connect, $query);

// Check 
if(!$insert){
    // Login successful, append user information to User.txt
    $file = fopen("User.txt", "a"); // Open file in append mode
    fwrite($file, "$username $password\n"); // Append user information
    fclose($file); // Close the file
    // Redirect to home page or wherever you want
    echo " Data Inserted!";
} else {
    echo " Data Not Inserted!";
}
?>