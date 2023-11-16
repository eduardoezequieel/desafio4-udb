CREATE DATABASE library;
USE library;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2023 a las 06:38:50
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `library`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `borrowedmaterial`
--

CREATE TABLE `borrowedmaterial` (
  `borrowedMaterialId` int(11) NOT NULL,
  `loanId` int(11) DEFAULT NULL,
  `inventoryMaterialId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creator`
--

CREATE TABLE `creator` (
  `creatorId` int(11) NOT NULL,
  `creatorName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editorial`
--

CREATE TABLE `editorial` (
  `editorialId` int(11) NOT NULL,
  `editorialName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventory`
--

CREATE TABLE `inventory` (
  `inventoryId` int(11) NOT NULL,
  `materialCode` char(8) DEFAULT NULL,
  `libraryId` int(11) DEFAULT NULL,
  `isbn` char(18) DEFAULT NULL,
  `issn` char(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `library`
--

CREATE TABLE `library` (
  `libraryId` int(11) NOT NULL,
  `libraryName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loan`
--

CREATE TABLE `loan` (
  `loanId` int(11) NOT NULL,
  `loanStateId` int(11) DEFAULT NULL,
  `loanOverdueId` int(11) DEFAULT NULL,
  `yearlyOverdueId` int(11) DEFAULT NULL,
  `userId` char(8) DEFAULT NULL,
  `adminId` char(8) DEFAULT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loanoverdue`
--

CREATE TABLE `loanoverdue` (
  `loanOverdueId` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `pendingDays` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `loanstate`
--

CREATE TABLE `loanstate` (
  `loanStateId` int(11) NOT NULL,
  `loanStateName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `code` char(8) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `duration` varchar(10) DEFAULT NULL,
  `songNumber` int(11) DEFAULT NULL,
  `publishDate` date DEFAULT NULL,
  `materialTypeId` int(11) DEFAULT NULL,
  `creatorId` int(11) DEFAULT NULL,
  `editorialId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materialtopic`
--

CREATE TABLE `materialtopic` (
  `materialTopicId` int(11) NOT NULL,
  `materialCode` char(8) DEFAULT NULL,
  `topicId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materialtype`
--

CREATE TABLE `materialtype` (
  `materialTypeId` int(11) NOT NULL,
  `materialTypeName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `topic`
--

CREATE TABLE `topic` (
  `topicId` int(11) NOT NULL,
  `topicName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `identificationCode` char(8) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `userTypeId` int(11) DEFAULT NULL,
  `hasToResetPassword` tinyint(1) DEFAULT NULL,
  `phone` char(8) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`identificationCode`, `password`, `email`, `userTypeId`, `hasToResetPassword`, `phone`, `name`) VALUES
('CV238942', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'cv@gmail.com', 1, 0, '08934732', NULL),
('JK123423', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'diegoesnard10@gmail.com', 3, 0, '32438274', 'Diego Esnard'),
('LR230061', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'riv.edu10@gmail.com', 1, 0, '75247643', 'Eduardo López'),
('OM128343', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'davidorellana@gmail.com', 2, 0, '23894234', NULL),
('RS123894', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'diegolopez@gmail.com', 1, 0, '18274329', NULL),
('ZX123893', 'ae48a48d2fd0d0475de2a3388623a556d64f7bf9', 'zx1234@gmail.com', 1, 0, '18974327', NULL),
('ZX128923', '90c0a9862b6bd28ef7054da13bb9c5f8fb3b7527', 'jesucristo@gmail.com', 3, 1, '12343433', 'Jesucristo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usertype`
--

CREATE TABLE `usertype` (
  `userTypeId` int(11) NOT NULL,
  `userTypeName` varchar(50) NOT NULL,
  `allowedBorrowedMaterials` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usertype`
--

INSERT INTO `usertype` (`userTypeId`, `userTypeName`, `allowedBorrowedMaterials`) VALUES
(1, 'Administrador', 0),
(2, 'Profesor', 6),
(3, 'Estudiante', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `yearlyoverdue`
--

CREATE TABLE `yearlyoverdue` (
  `yearlyOverdueId` int(11) NOT NULL,
  `year` year(4) NOT NULL,
  `cost` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `borrowedmaterial`
--
ALTER TABLE `borrowedmaterial`
  ADD PRIMARY KEY (`borrowedMaterialId`),
  ADD KEY `loanId` (`loanId`),
  ADD KEY `inventoryMaterialId` (`inventoryMaterialId`);

--
-- Indices de la tabla `creator`
--
ALTER TABLE `creator`
  ADD PRIMARY KEY (`creatorId`);

--
-- Indices de la tabla `editorial`
--
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`editorialId`);

--
-- Indices de la tabla `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventoryId`),
  ADD KEY `libraryId` (`libraryId`),
  ADD KEY `materialCode` (`materialCode`);

--
-- Indices de la tabla `library`
--
ALTER TABLE `library`
  ADD PRIMARY KEY (`libraryId`);

--
-- Indices de la tabla `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`loanId`),
  ADD KEY `loanStateId` (`loanStateId`),
  ADD KEY `loanOverdueId` (`loanOverdueId`),
  ADD KEY `yearlyOverdueId` (`yearlyOverdueId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `adminId` (`adminId`);

--
-- Indices de la tabla `loanoverdue`
--
ALTER TABLE `loanoverdue`
  ADD PRIMARY KEY (`loanOverdueId`);

--
-- Indices de la tabla `loanstate`
--
ALTER TABLE `loanstate`
  ADD PRIMARY KEY (`loanStateId`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`code`),
  ADD KEY `materialTypeId` (`materialTypeId`),
  ADD KEY `creatorId` (`creatorId`),
  ADD KEY `editorialId` (`editorialId`);

--
-- Indices de la tabla `materialtopic`
--
ALTER TABLE `materialtopic`
  ADD PRIMARY KEY (`materialTopicId`),
  ADD KEY `materialCode` (`materialCode`),
  ADD KEY `topicId` (`topicId`);

--
-- Indices de la tabla `materialtype`
--
ALTER TABLE `materialtype`
  ADD PRIMARY KEY (`materialTypeId`);

--
-- Indices de la tabla `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`topicId`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`identificationCode`),
  ADD KEY `userTypeId` (`userTypeId`);

--
-- Indices de la tabla `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`userTypeId`);

--
-- Indices de la tabla `yearlyoverdue`
--
ALTER TABLE `yearlyoverdue`
  ADD PRIMARY KEY (`yearlyOverdueId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `borrowedmaterial`
--
ALTER TABLE `borrowedmaterial`
  MODIFY `borrowedMaterialId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `creator`
--
ALTER TABLE `creator`
  MODIFY `creatorId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `editorial`
--
ALTER TABLE `editorial`
  MODIFY `editorialId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inventory`
--
ALTER TABLE `inventory`
  MODIFY `inventoryId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `library`
--
ALTER TABLE `library`
  MODIFY `libraryId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `loan`
--
ALTER TABLE `loan`
  MODIFY `loanId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `loanoverdue`
--
ALTER TABLE `loanoverdue`
  MODIFY `loanOverdueId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `loanstate`
--
ALTER TABLE `loanstate`
  MODIFY `loanStateId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `materialtopic`
--
ALTER TABLE `materialtopic`
  MODIFY `materialTopicId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `materialtype`
--
ALTER TABLE `materialtype`
  MODIFY `materialTypeId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `topic`
--
ALTER TABLE `topic`
  MODIFY `topicId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usertype`
--
ALTER TABLE `usertype`
  MODIFY `userTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `yearlyoverdue`
--
ALTER TABLE `yearlyoverdue`
  MODIFY `yearlyOverdueId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `borrowedmaterial`
--
ALTER TABLE `borrowedmaterial`
  ADD CONSTRAINT `borrowedmaterial_ibfk_1` FOREIGN KEY (`loanId`) REFERENCES `loan` (`loanId`),
  ADD CONSTRAINT `borrowedmaterial_ibfk_2` FOREIGN KEY (`inventoryMaterialId`) REFERENCES `inventory` (`inventoryId`);

--
-- Filtros para la tabla `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`libraryId`) REFERENCES `library` (`libraryId`),
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`materialCode`) REFERENCES `material` (`code`);

--
-- Filtros para la tabla `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`loanStateId`) REFERENCES `loanstate` (`loanStateId`),
  ADD CONSTRAINT `loan_ibfk_2` FOREIGN KEY (`loanOverdueId`) REFERENCES `loanoverdue` (`loanOverdueId`),
  ADD CONSTRAINT `loan_ibfk_3` FOREIGN KEY (`yearlyOverdueId`) REFERENCES `yearlyoverdue` (`yearlyOverdueId`),
  ADD CONSTRAINT `loan_ibfk_4` FOREIGN KEY (`userId`) REFERENCES `user` (`identificationCode`),
  ADD CONSTRAINT `loan_ibfk_5` FOREIGN KEY (`adminId`) REFERENCES `user` (`identificationCode`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`materialTypeId`) REFERENCES `materialtype` (`materialTypeId`),
  ADD CONSTRAINT `material_ibfk_2` FOREIGN KEY (`creatorId`) REFERENCES `creator` (`creatorId`),
  ADD CONSTRAINT `material_ibfk_3` FOREIGN KEY (`editorialId`) REFERENCES `editorial` (`editorialId`);

--
-- Filtros para la tabla `materialtopic`
--
ALTER TABLE `materialtopic`
  ADD CONSTRAINT `materialtopic_ibfk_1` FOREIGN KEY (`materialCode`) REFERENCES `material` (`code`),
  ADD CONSTRAINT `materialtopic_ibfk_2` FOREIGN KEY (`topicId`) REFERENCES `topic` (`topicId`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userTypeId`) REFERENCES `usertype` (`userTypeId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
