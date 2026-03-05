<?php
header("Content-Type: application/json");
require_once("../datos/db.php");

$db = new Database();
$sql = "SELECT * FROM productos";
$resultado = $db->conexion->query($sql);

$productos = [];
while ($fila = $resultado->fetch_assoc()) {
    $productos[] = $fila;
}

echo json_encode($productos);
?>