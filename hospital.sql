-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-09-2021 a las 03:23:12
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospitals`
--

CREATE TABLE `hospitals` (
  `id_hospital` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `telephone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hospitals`
--

INSERT INTO `hospitals` (`id_hospital`, `name`, `address`, `telephone`) VALUES
(1, 'Juarez', 'Calle 24A Pensiones ', '1234567111'),
(2, 'General Norte', 'Calle 24 x 54 Caucel', '678323421'),
(3, 'Medica Sur', 'Calle 82 #518 x 25 Cd.México', '999604322'),
(4, 'IMSS', 'Calle 24 x 75 Siglo XXI', '857132734');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscriptions`
--

CREATE TABLE `inscriptions` (
  `id_inscription` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  `id_hospital` int(11) NOT NULL,
  `date_Inscription` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inscriptions`
--

INSERT INTO `inscriptions` (`id_inscription`, `id_patient`, `id_hospital`, `date_Inscription`) VALUES
(1, 1, 2, '2021-09-25'),
(2, 2, 1, '2021-09-25'),
(4, 4, 4, '2021-09-25'),
(5, 5, 2, '2021-09-25'),
(7, 7, 3, '2021-09-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patients`
--

CREATE TABLE `patients` (
  `Id_patient` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `date_birth` date NOT NULL,
  `origin_city` varchar(100) NOT NULL,
  `tutor_name` varchar(100) NOT NULL,
  `telephone` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patients`
--

INSERT INTO `patients` (`Id_patient`, `name`, `last_name`, `age`, `gender`, `date_birth`, `origin_city`, `tutor_name`, `telephone`) VALUES
(1, 'Shannon', 'Sen Perdomo', 15, 'F', '2000-02-18', 'Merida', 'Michelle Aurora', '9995872208'),
(2, 'David Alejandro', 'Romero Segura', 16, 'M', '2021-06-07', 'Putumayo', 'Lizzy Romero', '9992590201'),
(4, 'Javier', 'Chan Vasquez', 2, 'M', '2021-12-16', 'Yucatan', 'Audri Vasquez', '1234567818'),
(5, 'Fernando', 'Chu Mendez', 9, 'M', '2021-11-18', 'Oaxaca', 'Pedro Chu', '8693050925'),
(7, 'Jimena Luu', 'Chan Perez', 10, 'F', '2021-11-12', 'Mexico', 'Maria Perez', '1964532896');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hospitals`
--
ALTER TABLE `hospitals`
  ADD PRIMARY KEY (`id_hospital`);

--
-- Indices de la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  ADD PRIMARY KEY (`id_inscription`),
  ADD KEY `id_patient` (`id_patient`),
  ADD KEY `id_hospital` (`id_hospital`);

--
-- Indices de la tabla `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`Id_patient`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hospitals`
--
ALTER TABLE `hospitals`
  MODIFY `id_hospital` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  MODIFY `id_inscription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `patients`
--
ALTER TABLE `patients`
  MODIFY `Id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  ADD CONSTRAINT `inscriptions_ibfk_1` FOREIGN KEY (`id_hospital`) REFERENCES `hospitals` (`id_hospital`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inscriptions_ibfk_2` FOREIGN KEY (`id_patient`) REFERENCES `patients` (`Id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
