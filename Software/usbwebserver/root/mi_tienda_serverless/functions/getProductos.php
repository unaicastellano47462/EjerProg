<?php
header("Content-Type: application/json");

$conexion = new mysqli("localhost", "root", "usbw", "tienda");
if ($conexion->connect_error) {
    http_response_code(500);
    echo json_encode(["error" => "Error en la conexión"]);
    exit;
}

$resultado = $conexion->query("SELECT * FROM productos");
$productos = [];

while ($fila = $resultado->fetch_assoc()) {
    $productos[] = $fila;
}

echo json_encode($productos);
?>
