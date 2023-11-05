--RF1
-- Inserción de una cadena hotelera
INSERT INTO cadenas_hoteleras (id, nombre, hotel_id)
VALUES
    (1, 'Cadena Hotelera Ejemplo', 1);

-- Inserción de la tabla 'hotel'
INSERT INTO hoteles (id, nombre, ciudad, pais, direccion, capacidad, estrellas, hotel_id, administrador_id, habitacion_id, servicio_id, recepcionista_recepcionista_id)
VALUES
    ('H1', 'Hotel Ejemplo 1', 'Ciudad Ejemplo', 'País Ejemplo', 'Dirección Ejemplo 123', 100, 4, 1, 1, 1, 1, 5);

-- Insertar usuarios en la tabla 'usuarios'
INSERT INTO usuarios (nombre, email, tipo, administrador_id, cliente_id, empleado_id, gerente_id, recepcionista_id)
VALUES
    ('Usuario1', 'usuario1@email.com', 'Administrador', 1, NULL, NULL, NULL, NULL),
    ('Usuario2', 'usuario2@email.com', 'Cliente', NULL, 2, NULL, NULL, NULL),
    ('Usuario3', 'usuario3@email.com', 'Empleado', NULL, NULL, 3, NULL, NULL),
    ('Usuario4', 'usuario4@email.com', 'Gerente', NULL, NULL, NULL, 4, NULL),
    ('Usuario5', 'usuario5@email.com', 'Recepcionista', NULL, NULL, NULL, NULL, 5);


--RF2
-- Insertar administradores en la tabla 'administradores'
INSERT INTO administradores (administrador_id)
VALUES (1);


--RF3
-- Insertar clientes en la tabla 'clientes'
INSERT INTO clientes (cliente_id, prestamo_id, cuenta_cuenta_id, servicio_servicio_id)
VALUES (2, 1, 1, 1);


--RF4
-- Insertar empleados en la tabla 'empleados'
INSERT INTO empleados (empleado_id)
VALUES (3);


--RF5
-- Insertar gerentes en la tabla 'gerente'
INSERT INTO gerente (gerente_id, hotel_id)
VALUES (4, 1);


--R6
-- Insertar recepcionistas en la tabla 'recepcionistas'
INSERT INTO recepcionistas (recepcionista_id)
VALUES (5);


--RF7
INSERT INTO reservas (fecha_entrada, fecha_salida, personas, check_in, check_out, paz_salvo, recepcionista_id, cliente_id)
VALUES ('2023-10-15', '2023-10-20', 2, '2023-10-15', '2023-10-20', 0, 1, 1);

UPDATE habitaciones SET cuenta_cuenta_id = (SELECT cuenta_id FROM cuentas WHERE cliente_id = 1) WHERE habitacion_id = 101;

INSERT INTO consumos (cliente_id, cuenta_id, producto_id)
VALUES (1, (SELECT cuenta_id FROM cuentas WHERE cliente_id = 1), 1);


--RF8
UPDATE reservas SET check_in = '2023-10-15' WHERE cliente_id = 1;

INSERT INTO consumos (cliente_id, cuenta_id, producto_id, total)
VALUES (1, (SELECT cuenta_id FROM cuentas WHERE cliente_id = 1), 1, (SELECT costo FROM productos WHERE producto_id = 1));


--RF9
UPDATE reservas SET check_out = '2023-10-20' WHERE cliente_id = 1;

SELECT SUM(total) AS total_a_pagar
FROM consumos
WHERE cliente_id = 1;
