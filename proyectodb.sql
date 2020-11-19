-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 19-11-2020 a les 10:26:13
-- Versió del servidor: 10.4.11-MariaDB
-- Versió de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `proyectodb`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `basicdata`
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
-- Estructura de la taula `multimedia`
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
-- Estructura de la taula `service`
--

CREATE TABLE `service` (
  `idService` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `basicdata`
--
ALTER TABLE `basicdata`
  ADD PRIMARY KEY (`idBasicData`),
  ADD UNIQUE KEY `id` (`idBasicData`);

--
-- Índexs per a la taula `multimedia`
--
ALTER TABLE `multimedia`
  ADD PRIMARY KEY (`idMultimedia`),
  ADD UNIQUE KEY `id` (`idMultimedia`),
  ADD KEY `FK_idService` (`idService`);

--
-- Índexs per a la taula `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`idService`),
  ADD UNIQUE KEY `id` (`idService`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `basicdata`
--
ALTER TABLE `basicdata`
  MODIFY `idBasicData` int(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la taula `multimedia`
--
ALTER TABLE `multimedia`
  MODIFY `idMultimedia` int(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la taula `service`
--
ALTER TABLE `service`
  MODIFY `idService` int(20) NOT NULL AUTO_INCREMENT;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `multimedia`
--
ALTER TABLE `multimedia`
  ADD CONSTRAINT `FK_idService` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
