<?php
class Database {
    private $host = "localhost";
    private $user = "root";
    private $pass = "usbw";
    private $db   = "tienda";
    public $conexion;

    public function __construct() {
        $this->conexion = new mysqli($this->host, $this->user, $this->pass, $this->db);
        if ($this->conexion->connect_error) {
            die("Error de conexión: " . $this->conexion->connect_error);
        }
    }
}
?>