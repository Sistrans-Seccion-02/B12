--RF1
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

