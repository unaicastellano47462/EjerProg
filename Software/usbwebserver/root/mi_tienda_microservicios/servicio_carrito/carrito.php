<?php
session_start();
header("Content-Type: application/json");

if (!isset($_SESSION["carrito"])) {
    $_SESSION["carrito"] = [];
}

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $input = json_decode(file_get_contents("php://input"), true);
    if (isset($input["producto"])) {
        $_SESSION["carrito"][] = $input["producto"];
    }
}

echo json_encode($_SESSION["carrito"]);
?>