<?php
session_start();
header("Content-Type: application/json");

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $data = json_decode(file_get_contents("php://input"), true);
    $_SESSION['carrito'][] = $data['producto'];
    echo json_encode(["mensaje" => "Producto agregado"]);
} else {
    echo json_encode(isset($_SESSION['carrito']) ? $_SESSION['carrito'] : []);
}
?>