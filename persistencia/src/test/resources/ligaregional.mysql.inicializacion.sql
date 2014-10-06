-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2012-10-28 16:27:44
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for ligaregional
DROP DATABASE IF EXISTS `ligaregional`;
CREATE DATABASE IF NOT EXISTS `ligaregional` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `ligaregional`;


-- Dumping structure for table ligaregional.arbitros
DROP TABLE IF EXISTS `arbitros`;
CREATE TABLE IF NOT EXISTS `arbitros` (
  `arbitro_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `calle` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `provincia` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_postal` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `numero_colegiado` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`arbitro_id`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `numero_colegiado` (`numero_colegiado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Listado de �rbitros disponibles en la competici�n';

-- Data exporting was unselected.


-- Dumping structure for table ligaregional.equipos
DROP TABLE IF EXISTS `equipos`;
CREATE TABLE IF NOT EXISTS `equipos` (
  `equipo_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `temporada` bigint(10) unsigned NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`equipo_id`),
  UNIQUE KEY `temporada_nombre` (`temporada`,`nombre`),
  UNIQUE KEY `UNQ_Equipos_0` (`temporada`,`nombre`),
  CONSTRAINT `FK_equipos_temporadas` FOREIGN KEY (`temporada`) REFERENCES `temporadas` (`temporada_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Contiene los diferentes equipos dados de alta en la competici�n';

-- Data exporting was unselected.


-- Dumping structure for table ligaregional.jugadores
DROP TABLE IF EXISTS `jugadores`;
CREATE TABLE IF NOT EXISTS `jugadores` (
  `jugador_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `equipo` bigint(10) unsigned NOT NULL DEFAULT '0',
  `temporada` bigint(10) unsigned NOT NULL DEFAULT '0',
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `capitan` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`jugador_id`),
  UNIQUE KEY `equipo_dni` (`equipo`,`dni`),
  UNIQUE KEY `temporada_dni` (`temporada`,`dni`),
  UNIQUE KEY `UNQ_Jugadores_0` (`equipo`,`dni`),
  UNIQUE KEY `UNQ_Jugadores_1` (`temporada`,`dni`),
  KEY `DNI` (`dni`),
  CONSTRAINT `FK_jugadores_equipos` FOREIGN KEY (`equipo`) REFERENCES `equipos` (`equipo_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_jugadores_temporadas` FOREIGN KEY (`temporada`) REFERENCES `temporadas` (`temporada_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Datos de los jugadores de cada equipo';

-- Data exporting was unselected.


-- Dumping structure for table ligaregional.partidos
DROP TABLE IF EXISTS `partidos`;
CREATE TABLE IF NOT EXISTS `partidos` (
  `partido_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `temporada` bigint(10) unsigned NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `local` bigint(10) unsigned NOT NULL,
  `visitante` bigint(10) unsigned NOT NULL,
  `arbitro` bigint(10) unsigned NOT NULL,
  `polideportivo` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`partido_id`),
  UNIQUE KEY `temporada_local_visitante` (`temporada`,`local`,`visitante`),
  UNIQUE KEY `UNQ_Partidos_0` (`temporada`,`local`,`visitante`),
  KEY `FK_partidos_polideportivos` (`polideportivo`),
  KEY `FK_partidos_equipos_local` (`local`),
  KEY `FK_partidos_equipos_visitante` (`visitante`),
  KEY `FK_partidos_arbitros` (`arbitro`),
  CONSTRAINT `FK_partidos_arbitros` FOREIGN KEY (`arbitro`) REFERENCES `arbitros` (`arbitro_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_partidos_equipos` FOREIGN KEY (`local`) REFERENCES `equipos` (`equipo_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_partidos_equipos_2` FOREIGN KEY (`visitante`) REFERENCES `equipos` (`equipo_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_partidos_polideportivos` FOREIGN KEY (`polideportivo`) REFERENCES `polideportivos` (`polideportivo_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_partidos_temporadas` FOREIGN KEY (`temporada`) REFERENCES `temporadas` (`temporada_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Datos de los partidos para cada una de las temporadas';

-- Data exporting was unselected.


-- Dumping structure for table ligaregional.polideportivos
DROP TABLE IF EXISTS `polideportivos`;
CREATE TABLE IF NOT EXISTS `polideportivos` (
  `polideportivo_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `calle` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  `ciudad` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `provincia` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_postal` varchar(5) COLLATE latin1_spanish_ci NOT NULL,
  `campos_disponibles` int(4) unsigned NOT NULL,
  PRIMARY KEY (`polideportivo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Listado de polideportivos disponibles para la competici�n';

-- Data exporting was unselected.


-- Dumping structure for table ligaregional.temporadas
DROP TABLE IF EXISTS `temporadas`;
CREATE TABLE IF NOT EXISTS `temporadas` (
  `temporada_id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`temporada_id`),
  UNIQUE KEY `fecha_inicio_fecha_fin` (`fecha_inicio`,`fecha_fin`),
  UNIQUE KEY `UNQ_Temporadas_0` (`fecha_inicio`,`fecha_fin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Diferentes temporadas en las que se disputa la competici�n. Los partidos se asignan a una temporada concreta';

-- Data exporting was unselected.
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
