-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-03-2026 a las 21:41:55
-- Versión del servidor: 5.7.36
-- Versión de PHP: 8.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicaaerlinea`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `DNI` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `cod_vuelo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`DNI`, `nombre`, `telefono`, `cod_vuelo`) VALUES
('12344321Q', 'Asis', '147147147', 'AEA1-00004'),
('12345678A', 'Dani', '123456789', 'AEA1-00002'),
('87654321Q', 'Susana', '212343123', 'AEA1-00003');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `cod_vuelo` varchar(10) NOT NULL,
  `fecha_salida` date NOT NULL,
  `destino` varchar(50) NOT NULL,
  `procedencia` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`cod_vuelo`, `fecha_salida`, `destino`, `procedencia`) VALUES
('AEA1-00001', '2025-12-05', 'Madrid', 'Paris'),
('AEA1-00002', '2023-12-06', 'Berlin', 'Munich'),
('AEA1-00003', '2026-01-05', 'Bilbao', 'Londres'),
('AEA1-00004', '2026-10-04', 'New York', 'Hong Kong');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `cod_vuelo` (`cod_vuelo`),
  ADD KEY `cod_vuelo_2` (`cod_vuelo`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`cod_vuelo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD CONSTRAINT `cod_vuelo` FOREIGN KEY (`cod_vuelo`) REFERENCES `vuelos` (`cod_vuelo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
