<?php
// Include DB connection
include 'DBConn.php';

// Execute SQL queries
if ($conn->query($sql1) === TRUE && $conn->query($sql2) === TRUE &&
    $conn->query($sql3) === TRUE && $conn->query($sql4) === TRUE) {
    echo "Tables created successfully";
} else {
    echo "Error creating tables: " . $conn->error;
}

// Close connection
$conn->close();
?>


