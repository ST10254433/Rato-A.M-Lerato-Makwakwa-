<?php
include "DBConn.php";

$username = (string) $_POST['username'];
$email = (string) $_POST['email'];
$password = (string) $_POST['password'];

// Hash the password for security
$hashed_password = password_hash($password, PASSWORD_DEFAULT);

// insert values into the table.

$query = "insert into student_info values(NULL, '$username', '$email', '$password'); ";

$insert = mysqli_query($connect, $query);

if(mysqli_query($connect, $query)){
    $file = fopen("User.txt", "a"); // Open file in append mode
    fwrite($file, "$username $email $hashed_password\n"); // Append user information
    fclose($file); // Close the file
    // Registration successful, redirect to login page
    header("Location: login.php");
    exit(); // Ensure script execution stops after redirection
} else {
    echo "Error: " . $query . "<br>" . mysqli_error($connect);
}
?>
