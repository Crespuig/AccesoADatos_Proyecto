-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-11-2020 a las 20:40:33
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `basicdata`
--

CREATE TABLE `basicdata` (
  `idBasicData` int(20) UNSIGNED NOT NULL,
  `idService` int(20) NOT NULL,
  `language` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `web` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multimedia`
--

CREATE TABLE `multimedia` (
  `idMultimedia` int(20) UNSIGNED NOT NULL,
  `idService` int(20) NOT NULL,
  `medias` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `url` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `type` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `service`
--

CREATE TABLE `service` (
  `idService` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `basicdata`
--
ALTER TABLE `basicdata`
  ADD PRIMARY KEY (`idBasicData`),
  ADD UNIQUE KEY `id` (`idBasicData`),
  ADD KEY `F_idService` (`idService`);

--
-- Indices de la tabla `multimedia`
--
ALTER TABLE `multimedia`
  ADD PRIMARY KEY (`idMultimedia`),
  ADD UNIQUE KEY `id` (`idMultimedia`),
  ADD KEY `FK_idService` (`idService`);

--
-- Indices de la tabla `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`idService`),
  ADD UNIQUE KEY `id` (`idService`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `basicdata`
--
ALTER TABLE `basicdata`
  MODIFY `idBasicData` int(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `multimedia`
--
ALTER TABLE `multimedia`
  MODIFY `idMultimedia` int(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `service`
--
ALTER TABLE `service`
  MODIFY `idService` int(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `basicdata`
--
ALTER TABLE `basicdata`
  ADD CONSTRAINT `F_idService` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `multimedia`
--
ALTER TABLE `multimedia`
  ADD CONSTRAINT `FK_idService` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
