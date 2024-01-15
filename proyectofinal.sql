-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2024 a las 20:02:40
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
-- Base de datos: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `idLogin` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `contrasenia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`idLogin`, `dni`, `contrasenia`) VALUES
(1, 30303030, 'restaurantegpfm'),
(7, 10101010, 'restaurantegpfm'),
(8, 20202020, 'restaurantegpfm'),
(9, 50505050, 'restaurantegpfm'),
(10, 40404040, 'restaurantegpfm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE `mesa` (
  `idMesa` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `estadoMesa` tinyint(1) NOT NULL,
  `libre` tinyint(1) NOT NULL,
  `capacidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`idMesa`, `numero`, `estadoMesa`, `libre`, `capacidad`) VALUES
(1, 0, 1, 0, 4),
(2, 1, 1, 0, 6),
(3, 2, 1, 0, 6),
(4, 3, 1, 0, 4),
(5, 4, 1, 0, 4),
(6, 5, 1, 0, 4),
(7, 6, 1, 0, 2),
(8, 7, 1, 0, 2),
(9, 8, 1, 0, 2),
(10, 9, 1, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesero`
--

CREATE TABLE `mesero` (
  `idMesero` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mesero`
--

INSERT INTO `mesero` (`idMesero`, `dni`, `nombre`, `estado`) VALUES
(1, 10101010, 'Gonzalo', 1),
(2, 20202020, 'Macarena', 1),
(3, 30303030, 'Florencia', 1),
(4, 40404040, 'Paula', 1),
(5, 50505050, 'Mauricio', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idMesero` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `importe` double NOT NULL DEFAULT 0,
  `cobrada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`idPedido`, `idMesa`, `idMesero`, `fechaHora`, `importe`, `cobrada`) VALUES
(3, 5, 2, '2023-10-28 17:15:24', 7000, 0),
(4, 8, 3, '2023-10-28 17:16:23', 2800, 0),
(5, 1, 1, '2023-10-28 17:17:26', 26900, 0),
(6, 4, 2, '2023-10-28 17:18:26', 5450, 0),
(7, 7, 1, '2023-10-28 17:19:24', 22800, 1),
(8, 9, 4, '2023-10-28 17:20:16', 26000, 1),
(9, 5, 4, '2023-10-28 17:24:07', 2500, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidoproducto`
--

CREATE TABLE `pedidoproducto` (
  `idPedidoProd` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidoproducto`
--

INSERT INTO `pedidoproducto` (`idPedidoProd`, `idPedido`, `idProducto`, `cantidad`) VALUES
(3, 3, 15, 1),
(4, 3, 12, 3),
(5, 4, 4, 1),
(6, 5, 6, 2),
(7, 5, 2, 9),
(8, 6, 7, 3),
(9, 6, 6, 2),
(10, 7, 11, 4),
(11, 7, 4, 6),
(12, 8, 16, 4),
(13, 8, 14, 4),
(14, 8, 13, 4),
(15, 9, 5, 6),
(16, 9, 10, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombreProducto` varchar(40) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombreProducto`, `precio`, `stock`, `estado`) VALUES
(1, 'Pizza Muzzarella', 2000, 40, 1),
(2, 'Pizza Napolitana', 2500, 40, 1),
(3, 'Hamburguesa simple con guarnición', 2400, 30, 1),
(4, 'Hamburguesa completa con guarnición', 2800, 30, 1),
(5, 'Empanada (unidad)', 200, 60, 1),
(6, 'Empanadas (docena)', 2200, 20, 1),
(7, 'Gaseosa 500ml', 350, 40, 1),
(8, 'Gaseosa 1.5 lt', 700, 80, 1),
(9, 'Agua 500ml', 200, 40, 1),
(10, 'Cerveza 473ml', 650, 50, 1),
(11, 'Vermut', 1500, 40, 1),
(12, 'Vino botella', 1700, 40, 1),
(13, 'Fernet vaso', 1600, 20, 1),
(14, 'Papas con cheddar', 3500, 45, 1),
(15, 'Bocha helado (3)', 1900, 50, 1),
(16, 'Flan', 1400, 50, 1),
(17, 'Budin de pan ', 1400, 50, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idLogin`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `dni_2` (`dni`);

--
-- Indices de la tabla `mesa`
--
ALTER TABLE `mesa`
  ADD PRIMARY KEY (`idMesa`),
  ADD UNIQUE KEY `numero` (`numero`);

--
-- Indices de la tabla `mesero`
--
ALTER TABLE `mesero`
  ADD PRIMARY KEY (`idMesero`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `pedido_ibfk_1` (`idMesa`),
  ADD KEY `idMesero` (`idMesero`);

--
-- Indices de la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  ADD PRIMARY KEY (`idPedidoProd`),
  ADD KEY `pedidoproducto_ibfk_1` (`idPedido`),
  ADD KEY `pedidoproducto_ibfk_2` (`idProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mesa`
--
ALTER TABLE `mesa`
  MODIFY `idMesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mesero`
--
ALTER TABLE `mesero`
  MODIFY `idMesero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  MODIFY `idPedidoProd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `mesero` (`dni`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idMesa`) REFERENCES `mesa` (`idMesa`) ON DELETE CASCADE,
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idMesero`) REFERENCES `mesero` (`idMesero`);

--
-- Filtros para la tabla `pedidoproducto`
--
ALTER TABLE `pedidoproducto`
  ADD CONSTRAINT `pedidoproducto_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`) ON DELETE CASCADE,
  ADD CONSTRAINT `pedidoproducto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
