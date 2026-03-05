<?php
// Conexión a la base de datos
$conexion = new mysqli("localhost", "root", "usbw", "tienda");
if ($conexion->connect_error) {
    die("Error de conexión: " . $conexion->connect_error);
}

// Consultar productos
$resultado = $conexion->query("SELECT * FROM productos");
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mi Tienda Monolítica</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Bienvenido a Mi Tienda</h1>
    <div id="productos">
        <?php while ($fila = $resultado->fetch_assoc()) { ?>
            <div class="producto">
                <h2><?= $fila['nombre'] ?></h2>
                <p>Precio: <?= $fila['precio'] ?></p>
                <button onclick="agregarCarrito('<?= $fila['nombre'] ?>')">Agregar al carrito</button>
            </div>
        <?php } ?>
    </div>

    <h2>Carrito:</h2>
    <ul id="carrito"></ul>

    <script src="script.js"></script>
</body>
</html>
