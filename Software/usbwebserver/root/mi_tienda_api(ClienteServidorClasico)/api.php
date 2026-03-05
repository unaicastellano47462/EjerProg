<?php
header("Content-Type: application/json");

// Conexión MySQL
$conexion = new mysqli("localhost", "root", "usbw", "tienda");
if ($conexion->connect_error) {
    die(json_encode(["error" => "Error de conexión"]));
}

// Consultar productos
$resultado = $conexion->query("SELECT * FROM productos");
$productos = [];

while ($fila = $resultado->fetch_assoc()) {
    $productos[] = $fila;
}

echo json_encode($productos);
?>