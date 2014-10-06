INSERT INTO `temporadas` (`fecha_inicio`, `fecha_fin`) VALUES ('2012-06-19', '2013-06-20');
INSERT INTO `arbitros` (`nombre`, `apellido1`, `apellido2`, `dni`, `calle`, `ciudad`, `provincia`, `codigo_postal`, `numero_colegiado`) VALUES ('Juan', 'Martínez', 'Campos', '12345678E', 'Calle Real, 3', 'Madrid', 'Madrid', '28028', '12341234');
INSERT INTO `equipos` (`temporada`, `nombre`) VALUES (1, 'Esteagua del grifo');
INSERT INTO `equipos` (`temporada`, `nombre`) VALUES (1, 'Aceros Caquita');
INSERT INTO `equipos` (`temporada`, `nombre`) VALUES (1, 'Riberberecho');
INSERT INTO `equipos` (`temporada`, `nombre`) VALUES (1, 'Bufandas');
INSERT INTO `jugadores` (`equipo`, `temporada`, `nombre`, `apellido1`, `apellido2`, `dni`, `capitan`) VALUES (1, 1, 'Carlos', 'Fernández', 'González', '87654321R', 1);
INSERT INTO `polideportivos` (`nombre`, `calle`, `ciudad`, `provincia`, `codigo_postal`, `campos_disponibles`) VALUES ('Breogán', 'Calle Silvela, 3', 'Madrid', 'Madrid', '28028', 3);