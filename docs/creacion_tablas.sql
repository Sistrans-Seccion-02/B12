
-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-10-01 14:07:59 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE administradores (
    administrador_id NUMBER NOT NULL
);

ALTER TABLE administradores ADD CONSTRAINT administrador_pk PRIMARY KEY ( administrador_id );

CREATE TABLE aseos (
    nombre      VARCHAR2(255 BYTE),
    tipo_prenda VARCHAR2(255 BYTE),
    numero      NUMBER,
    costo       NUMBER,
    aseo_id     NUMBER NOT NULL,
    cuenta_id   NUMBER NOT NULL
);

CREATE UNIQUE INDEX aseo__idx ON
    aseos (
        cuenta_id
    ASC );

ALTER TABLE aseos ADD CONSTRAINT aseo_pk PRIMARY KEY ( aseo_id );

CREATE TABLE bares (
    estilo      VARCHAR2(255 BYTE),
    bar_id      NUMBER NOT NULL,
    producto_id NUMBER
);

ALTER TABLE bares ADD CONSTRAINT bar_pk PRIMARY KEY ( bar_id );

CREATE TABLE cadenas_hoteleras (
    id       VARCHAR2(255 BYTE),
    nombre   VARCHAR2(255 BYTE),
    hotel_id NUMBER NOT NULL
);

CREATE TABLE clientes (
    cliente_id           NUMBER NOT NULL,
    prestamo_id          NUMBER NOT NULL,
    cuenta_cuenta_id     NUMBER,
    servicio_servicio_id NUMBER NOT NULL
);

ALTER TABLE clientes ADD CONSTRAINT cliente_pk PRIMARY KEY ( cliente_id );

CREATE TABLE consumibles (
    consumible    NUMBER,
    valor         NUMBER,
    consumible_id NUMBER NOT NULL
);

ALTER TABLE consumibles ADD CONSTRAINT consumible_pk PRIMARY KEY ( consumible_id );

CREATE TABLE consumos (
    total        NUMBER,
    consumo_id   NUMBER NOT NULL,
    cliente_id   NUMBER NOT NULL,
    cuenta_id    NUMBER NOT NULL,
    descuento_id NUMBER,
    producto_id  NUMBER NOT NULL
);

CREATE UNIQUE INDEX consumo__idx ON
    consumos (
        cliente_id
    ASC );

CREATE UNIQUE INDEX consumo__idxv1 ON
    consumos (
        cuenta_id
    ASC );

ALTER TABLE consumos ADD CONSTRAINT consumo_pk PRIMARY KEY ( consumo_id );

CREATE TABLE cuentas (
    valor                NUMBER,
    cuenta_id            NUMBER NOT NULL,
    reserva_salon_id     NUMBER NOT NULL,
    servicio_servicio_id NUMBER
);

CREATE UNIQUE INDEX cuenta__idxv2 ON
    cuentas (
        reserva_salon_id
    ASC );

ALTER TABLE cuentas ADD CONSTRAINT cuenta_pk PRIMARY KEY ( cuenta_id );

CREATE TABLE descuentos (
    porcentaje   NUMBER,
    descuento_id NUMBER NOT NULL
);

ALTER TABLE descuentos ADD CONSTRAINT descuento_pk PRIMARY KEY ( descuento_id );

CREATE TABLE empleados (
    empleado_id NUMBER NOT NULL
);

ALTER TABLE empleados ADD CONSTRAINT empleado_pk PRIMARY KEY ( empleado_id );

CREATE TABLE gerente (
    gerente_id NUMBER NOT NULL,
    hotel_id   NUMBER NOT NULL
);

CREATE UNIQUE INDEX gerente__idx ON
    gerente (
        hotel_id
    ASC );

ALTER TABLE gerente ADD CONSTRAINT gerente_pk PRIMARY KEY ( gerente_id );

CREATE TABLE gimnasios (
    gimnasio_id NUMBER NOT NULL,
    maquina_id  NUMBER
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( gimnasio_id );

CREATE TABLE habitaciones (
    numero           NUMBER,
    tipo             VARCHAR2(255 BYTE),
    costo            NUMBER,
    capacidad        NUMBER,
    habitacion_id    NUMBER NOT NULL,
    consumible_id    NUMBER,
    cuenta_cuenta_id NUMBER
);

ALTER TABLE habitaciones ADD CONSTRAINT habitacion_pk PRIMARY KEY ( habitacion_id );

CREATE TABLE hoteles (
    id                             VARCHAR2(255 BYTE),
    nombre                         VARCHAR2(255 BYTE),
    ciudad                         VARCHAR2(255 BYTE),
    pais                           VARCHAR2(255 BYTE),
    direccion                      VARCHAR2(255 BYTE),
    capacidad                      NUMBER,
    estrellas                      NUMBER,
    hotel_id                       NUMBER NOT NULL,
    administrador_id               NUMBER,
    habitacion_id                  NUMBER,
    servicio_id                    NUMBER,
    recepcionista_recepcionista_id NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hotel_pk PRIMARY KEY ( hotel_id );

CREATE TABLE internet (
    costo_diario NUMBER,
    internet_id  NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( internet_id );

CREATE TABLE maquinas (
    nombre     VARCHAR2(255 BYTE),
    estado     VARCHAR2(255 BYTE),
    maquina_id NUMBER NOT NULL
);

ALTER TABLE maquinas ADD CONSTRAINT maquina_pk PRIMARY KEY ( maquina_id );

CREATE TABLE piscinas (
    profundidad NUMBER,
    piscina_id  NUMBER NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscina_pk PRIMARY KEY ( piscina_id );

CREATE TABLE planes_consumo (
    noches             NUMBER,
    costo              NUMBER,
    plan_consumo_id    NUMBER NOT NULL,
    descuento_id       NUMBER,
    reserva_reserva_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX planes_consumo__idx ON
    planes_consumo (
        reserva_reserva_id
    ASC );

ALTER TABLE planes_consumo ADD CONSTRAINT plan_consumo_pk PRIMARY KEY ( plan_consumo_id );

CREATE TABLE prestamos (
    valor       NUMBER,
    prestamo_id NUMBER NOT NULL,
    cuenta_id   NUMBER NOT NULL
);

CREATE UNIQUE INDEX prestamo__idx ON
    prestamos (
        cuenta_id
    ASC );

ALTER TABLE prestamos ADD CONSTRAINT prestamo_pk PRIMARY KEY ( prestamo_id );

CREATE TABLE productos (
    nombre                       VARCHAR2(255 BYTE),
    costo                        NUMBER,
    producto_id                  NUMBER NOT NULL,
    servicio_spa_servicio_spa_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX producto__idx ON
    productos (
        servicio_spa_servicio_spa_id
    ASC );

ALTER TABLE productos ADD CONSTRAINT producto_pk PRIMARY KEY ( producto_id );

CREATE TABLE recepcionistas (
    recepcionista_id NUMBER NOT NULL
);

ALTER TABLE recepcionistas ADD CONSTRAINT recepcionista_pk PRIMARY KEY ( recepcionista_id );

CREATE TABLE reservas (
    reserva_id       NUMBER NOT NULL,
    fecha_entrada    DATE,
    fecha_salida     DATE,
    personas         NUMBER,
    check_in         DATE,
    check_out        DATE,
    paz_salvo        NUMBER,
    recepcionista_id NUMBER,
    cliente_id       NUMBER NOT NULL
);

CREATE UNIQUE INDEX reserva__idx ON
    reservas (
        cliente_id
    ASC );

ALTER TABLE reservas ADD CONSTRAINT reserva_pk PRIMARY KEY ( reserva_id );

CREATE TABLE reservas_salones (
    usa_equipos      NUMBER,
    fecha            DATE,
    hora             DATE,
    duracion         NUMBER,
    limpieza         NUMBER,
    costo            NUMBER,
    reserva_salon_id NUMBER NOT NULL
);

ALTER TABLE reservas_salones ADD CONSTRAINT reserva_salon_pk PRIMARY KEY ( reserva_salon_id );

CREATE TABLE restaurantes (
    producto_id NUMBER
);

CREATE TABLE salones (
    tipo             VARCHAR2(255 BYTE),
    costo_hora       NUMBER,
    costo_equipo     NUMBER,
    salon_id         NUMBER NOT NULL,
    reserva_salon_id NUMBER
);

ALTER TABLE salones ADD CONSTRAINT salon_pk PRIMARY KEY ( salon_id );

CREATE TABLE servicios (
    nombre          VARCHAR2(255 BYTE),
    capacidad       NUMBER,
    servicio_id     NUMBER NOT NULL,
    aseo_id         NUMBER NOT NULL,
    bar_id          NUMBER NOT NULL,
    gimnasio_id     NUMBER NOT NULL,
    internet_id     NUMBER NOT NULL,
    piscina_id      NUMBER NOT NULL,
    prestamo_id     NUMBER NOT NULL,
    salon_id        NUMBER NOT NULL,
    spa_id          NUMBER NOT NULL,
    supermercado_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX servicio__idx ON
    servicios (
        aseo_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv1 ON
    servicios (
        bar_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv2 ON
    servicios (
        gimnasio_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv3 ON
    servicios (
        internet_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv4 ON
    servicios (
        piscina_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv5 ON
    servicios (
        prestamo_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv6 ON
    servicios (
        salon_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv7 ON
    servicios (
        spa_id
    ASC );

CREATE UNIQUE INDEX servicio__idxv8 ON
    servicios (
        supermercado_id
    ASC );

ALTER TABLE servicios ADD CONSTRAINT servicio_pk PRIMARY KEY ( servicio_id );

CREATE TABLE servicios_habitaciones (
    tipo_servicio          VARCHAR2(255 BYTE),
    contratado             NUMBER,
    servicio_habitacion_id NUMBER NOT NULL
);

ALTER TABLE servicios_habitaciones ADD CONSTRAINT servicio_habitacion_pk PRIMARY KEY ( servicio_habitacion_id );

CREATE TABLE servicios_spa (
    duracion        NUMBER,
    servicio_spa_id NUMBER NOT NULL
);

ALTER TABLE servicios_spa ADD CONSTRAINT servicio_spa_pk PRIMARY KEY ( servicio_spa_id );

CREATE TABLE spa (
    spa_id          NUMBER NOT NULL,
    servicio_spa_id NUMBER
);

ALTER TABLE spa ADD CONSTRAINT spa_pk PRIMARY KEY ( spa_id );

CREATE TABLE supermercados (
    nombre             VARCHAR2(255 BYTE),
    supermercado_id    NUMBER NOT NULL,
    tiendas_tiendas_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX supermercados__idx ON
    supermercados (
        tiendas_tiendas_id
    ASC );

ALTER TABLE supermercados ADD CONSTRAINT supermercado_pk PRIMARY KEY ( supermercado_id );

CREATE TABLE tiendas (
    tiendas_id  NUMBER NOT NULL,
    tipo_tienda VARCHAR2(255 BYTE)
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( tiendas_id );

CREATE TABLE tiene_plan_consumo (
    hotel_id        NUMBER NOT NULL,
    plan_consumo_id NUMBER NOT NULL
);

ALTER TABLE tiene_plan_consumo ADD CONSTRAINT tiene_plan_consumo_pk PRIMARY KEY ( hotel_id,
                                                                                  plan_consumo_id );

CREATE TABLE tiene_productos_supermercados (
    supermercado_id NUMBER NOT NULL,
    producto_id     NUMBER NOT NULL
);

ALTER TABLE tiene_productos_supermercados ADD CONSTRAINT tiene_prod_superm_pk PRIMARY KEY ( supermercado_id,
                                                                                            producto_id );

CREATE TABLE tiene_servicio_habitacion (
    habitacion_id          NUMBER NOT NULL,
    servicio_habitacion_id NUMBER NOT NULL
);

ALTER TABLE tiene_servicio_habitacion ADD CONSTRAINT tiene_servicio_habitacion_pk PRIMARY KEY ( habitacion_id,
                                                                                                servicio_habitacion_id );

CREATE TABLE tienen_consumos_empleados (
    empleado_id NUMBER NOT NULL,
    consumo_id  NUMBER NOT NULL
);

ALTER TABLE tienen_consumos_empleados ADD CONSTRAINT tienen_consumos_empleados_pk PRIMARY KEY ( empleado_id,
                                                                                                consumo_id );

CREATE TABLE tienen_descuentos_servicios (
    servicio_servicio_id    NUMBER NOT NULL,
    descuentos_descuento_id NUMBER NOT NULL
);

ALTER TABLE tienen_descuentos_servicios ADD CONSTRAINT tienen_desc_servicios_pk PRIMARY KEY ( servicio_servicio_id,
                                                                                              descuentos_descuento_id );

CREATE TABLE usuarios (
    nombre           VARCHAR2(255 BYTE),
    email            VARCHAR2(255 BYTE),
    tipo             VARCHAR2(255 BYTE),
    administrador_id NUMBER NOT NULL,
    cliente_id       NUMBER NOT NULL,
    empleado_id      NUMBER NOT NULL,
    gerente_id       NUMBER NOT NULL,
    recepcionista_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX usuario__idx ON
    usuarios (
        administrador_id
    ASC );

CREATE UNIQUE INDEX usuario__idxv1 ON
    usuarios (
        cliente_id
    ASC );

CREATE UNIQUE INDEX usuario__idxv2 ON
    usuarios (
        empleado_id
    ASC );

CREATE UNIQUE INDEX usuario__idxv3 ON
    usuarios (
        gerente_id
    ASC );

CREATE UNIQUE INDEX usuario__idxv4 ON
    usuarios (
        recepcionista_id
    ASC );

ALTER TABLE aseos
    ADD CONSTRAINT aseos_cuentas_fk FOREIGN KEY ( cuenta_id )
        REFERENCES cuentas ( cuenta_id );

ALTER TABLE bares
    ADD CONSTRAINT bares_productos_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( producto_id );

ALTER TABLE cadenas_hoteleras
    ADD CONSTRAINT cadenas_hoteleras_hoteles_fk FOREIGN KEY ( hotel_id )
        REFERENCES hoteles ( hotel_id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_cuentas_fk FOREIGN KEY ( cuenta_cuenta_id )
        REFERENCES cuentas ( cuenta_id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_prestamos_fk FOREIGN KEY ( prestamo_id )
        REFERENCES prestamos ( prestamo_id );

ALTER TABLE clientes
    ADD CONSTRAINT clientes_servicios_fk FOREIGN KEY ( servicio_servicio_id )
        REFERENCES servicios ( servicio_id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_clientes_fk FOREIGN KEY ( cliente_id )
        REFERENCES clientes ( cliente_id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_cuentas_fk FOREIGN KEY ( cuenta_id )
        REFERENCES cuentas ( cuenta_id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_descuentos_fk FOREIGN KEY ( descuento_id )
        REFERENCES descuentos ( descuento_id );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_productos_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( producto_id );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_reservas_salones_fk FOREIGN KEY ( reserva_salon_id )
        REFERENCES reservas_salones ( reserva_salon_id );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_servicios_fk FOREIGN KEY ( servicio_servicio_id )
        REFERENCES servicios ( servicio_id );

ALTER TABLE gerente
    ADD CONSTRAINT gerente_hoteles_fk FOREIGN KEY ( hotel_id )
        REFERENCES hoteles ( hotel_id );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_maquinas_fk FOREIGN KEY ( maquina_id )
        REFERENCES maquinas ( maquina_id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_consumibles_fk FOREIGN KEY ( consumible_id )
        REFERENCES consumibles ( consumible_id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_cuentas_fk FOREIGN KEY ( cuenta_cuenta_id )
        REFERENCES cuentas ( cuenta_id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_administradores_fk FOREIGN KEY ( administrador_id )
        REFERENCES administradores ( administrador_id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_habitaciones_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( habitacion_id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_recepcionistas_fk FOREIGN KEY ( recepcionista_recepcionista_id )
        REFERENCES recepcionistas ( recepcionista_id );

ALTER TABLE hoteles
    ADD CONSTRAINT hoteles_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( servicio_id );

ALTER TABLE planes_consumo
    ADD CONSTRAINT planes_consumo_descuentos_fk FOREIGN KEY ( descuento_id )
        REFERENCES descuentos ( descuento_id );

ALTER TABLE planes_consumo
    ADD CONSTRAINT planes_consumo_reservas_fk FOREIGN KEY ( reserva_reserva_id )
        REFERENCES reservas ( reserva_id );

ALTER TABLE prestamos
    ADD CONSTRAINT prestamos_cuentas_fk FOREIGN KEY ( cuenta_id )
        REFERENCES cuentas ( cuenta_id );

ALTER TABLE productos
    ADD CONSTRAINT productos_servicios_spa_fk FOREIGN KEY ( servicio_spa_servicio_spa_id )
        REFERENCES servicios_spa ( servicio_spa_id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_clientes_fk FOREIGN KEY ( cliente_id )
        REFERENCES clientes ( cliente_id );

ALTER TABLE reservas
    ADD CONSTRAINT reservas_recepcionistas_fk FOREIGN KEY ( recepcionista_id )
        REFERENCES recepcionistas ( recepcionista_id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_productos_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( producto_id );

ALTER TABLE salones
    ADD CONSTRAINT salones_reservas_salones_fk FOREIGN KEY ( reserva_salon_id )
        REFERENCES reservas_salones ( reserva_salon_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_aseos_fk FOREIGN KEY ( aseo_id )
        REFERENCES aseos ( aseo_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_bares_fk FOREIGN KEY ( bar_id )
        REFERENCES bares ( bar_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_gimnasios_fk FOREIGN KEY ( gimnasio_id )
        REFERENCES gimnasios ( gimnasio_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_internet_fk FOREIGN KEY ( internet_id )
        REFERENCES internet ( internet_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_piscinas_fk FOREIGN KEY ( piscina_id )
        REFERENCES piscinas ( piscina_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_prestamos_fk FOREIGN KEY ( prestamo_id )
        REFERENCES prestamos ( prestamo_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_salones_fk FOREIGN KEY ( salon_id )
        REFERENCES salones ( salon_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_spa_fk FOREIGN KEY ( spa_id )
        REFERENCES spa ( spa_id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_supermercados_fk FOREIGN KEY ( supermercado_id )
        REFERENCES supermercados ( supermercado_id );

ALTER TABLE spa
    ADD CONSTRAINT spa_servicios_spa_fk FOREIGN KEY ( servicio_spa_id )
        REFERENCES servicios_spa ( servicio_spa_id );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_tiendas_fk FOREIGN KEY ( tiendas_tiendas_id )
        REFERENCES tiendas ( tiendas_id );

ALTER TABLE tiene_plan_consumo
    ADD CONSTRAINT tiene_plan_consumo_fk FOREIGN KEY ( plan_consumo_id )
        REFERENCES planes_consumo ( plan_consumo_id );

ALTER TABLE tiene_plan_consumo
    ADD CONSTRAINT tiene_plan_consumo_hotel_fk FOREIGN KEY ( hotel_id )
        REFERENCES hoteles ( hotel_id );

ALTER TABLE tiene_productos_supermercados
    ADD CONSTRAINT tiene_prod_super_fk FOREIGN KEY ( supermercado_id )
        REFERENCES supermercados ( supermercado_id );

ALTER TABLE tiene_productos_supermercados
    ADD CONSTRAINT tiene_prod_super_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES productos ( producto_id );

ALTER TABLE tiene_servicio_habitacion
    ADD CONSTRAINT tiene_servicio_habitacion_fk FOREIGN KEY ( servicio_habitacion_id )
        REFERENCES servicios_habitaciones ( servicio_habitacion_id );

ALTER TABLE tiene_servicio_habitacion
    ADD CONSTRAINT tiene_serviciohabitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitaciones ( habitacion_id );

ALTER TABLE tienen_consumos_empleados
    ADD CONSTRAINT tienen_consumos_consumo_fk FOREIGN KEY ( consumo_id )
        REFERENCES consumos ( consumo_id );

ALTER TABLE tienen_consumos_empleados
    ADD CONSTRAINT tienen_consumos_empleado_fk FOREIGN KEY ( empleado_id )
        REFERENCES empleados ( empleado_id );

ALTER TABLE tienen_descuentos_servicios
    ADD CONSTRAINT tienen_desc_descuentos_fk FOREIGN KEY ( descuentos_descuento_id )
        REFERENCES descuentos ( descuento_id );

ALTER TABLE tienen_descuentos_servicios
    ADD CONSTRAINT tienen_descuento_servicio_fk FOREIGN KEY ( servicio_servicio_id )
        REFERENCES servicios ( servicio_id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_administradores_fk FOREIGN KEY ( administrador_id )
        REFERENCES administradores ( administrador_id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_clientes_fk FOREIGN KEY ( cliente_id )
        REFERENCES clientes ( cliente_id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_empleados_fk FOREIGN KEY ( empleado_id )
        REFERENCES empleados ( empleado_id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_gerente_fk FOREIGN KEY ( gerente_id )
        REFERENCES gerente ( gerente_id );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_recepcionistas_fk FOREIGN KEY ( recepcionista_id )
        REFERENCES recepcionistas ( recepcionista_id );

CREATE SEQUENCE administradores_administrador_ START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER administradores_administrador_ BEFORE
    INSERT ON administradores
    FOR EACH ROW
    WHEN ( new.administrador_id IS NULL )
BEGIN
    :new.administrador_id := administradores_administrador_.nextval;
END;
/

CREATE SEQUENCE aseos_aseo_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER aseos_aseo_id_trg BEFORE
    INSERT ON aseos
    FOR EACH ROW
    WHEN ( new.aseo_id IS NULL )
BEGIN
    :new.aseo_id := aseos_aseo_id_seq.nextval;
END;
/

CREATE SEQUENCE bares_bar_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER bares_bar_id_trg BEFORE
    INSERT ON bares
    FOR EACH ROW
    WHEN ( new.bar_id IS NULL )
BEGIN
    :new.bar_id := bares_bar_id_seq.nextval;
END;
/

CREATE SEQUENCE clientes_cliente_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER clientes_cliente_id_trg BEFORE
    INSERT ON clientes
    FOR EACH ROW
    WHEN ( new.cliente_id IS NULL )
BEGIN
    :new.cliente_id := clientes_cliente_id_seq.nextval;
END;
/

CREATE SEQUENCE consumibles_consumible_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER consumibles_consumible_id_trg BEFORE
    INSERT ON consumibles
    FOR EACH ROW
    WHEN ( new.consumible_id IS NULL )
BEGIN
    :new.consumible_id := consumibles_consumible_id_seq.nextval;
END;
/

CREATE SEQUENCE consumos_consumo_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER consumos_consumo_id_trg BEFORE
    INSERT ON consumos
    FOR EACH ROW
    WHEN ( new.consumo_id IS NULL )
BEGIN
    :new.consumo_id := consumos_consumo_id_seq.nextval;
END;
/

CREATE SEQUENCE cuentas_cuenta_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cuentas_cuenta_id_trg BEFORE
    INSERT ON cuentas
    FOR EACH ROW
    WHEN ( new.cuenta_id IS NULL )
BEGIN
    :new.cuenta_id := cuentas_cuenta_id_seq.nextval;
END;
/

CREATE SEQUENCE descuentos_descuento_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER descuentos_descuento_id_trg BEFORE
    INSERT ON descuentos
    FOR EACH ROW
    WHEN ( new.descuento_id IS NULL )
BEGIN
    :new.descuento_id := descuentos_descuento_id_seq.nextval;
END;
/

CREATE SEQUENCE empleados_empleado_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER empleados_empleado_id_trg BEFORE
    INSERT ON empleados
    FOR EACH ROW
    WHEN ( new.empleado_id IS NULL )
BEGIN
    :new.empleado_id := empleados_empleado_id_seq.nextval;
END;
/

CREATE SEQUENCE gerente_gerente_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER gerente_gerente_id_trg BEFORE
    INSERT ON gerente
    FOR EACH ROW
    WHEN ( new.gerente_id IS NULL )
BEGIN
    :new.gerente_id := gerente_gerente_id_seq.nextval;
END;
/

CREATE SEQUENCE gimnasios_gimnasio_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER gimnasios_gimnasio_id_trg BEFORE
    INSERT ON gimnasios
    FOR EACH ROW
    WHEN ( new.gimnasio_id IS NULL )
BEGIN
    :new.gimnasio_id := gimnasios_gimnasio_id_seq.nextval;
END;
/

CREATE SEQUENCE habitaciones_habitacion_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER habitaciones_habitacion_id_trg BEFORE
    INSERT ON habitaciones
    FOR EACH ROW
    WHEN ( new.habitacion_id IS NULL )
BEGIN
    :new.habitacion_id := habitaciones_habitacion_id_seq.nextval;
END;
/

CREATE SEQUENCE hoteles_hotel_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER hoteles_hotel_id_trg BEFORE
    INSERT ON hoteles
    FOR EACH ROW
    WHEN ( new.hotel_id IS NULL )
BEGIN
    :new.hotel_id := hoteles_hotel_id_seq.nextval;
END;
/

CREATE SEQUENCE internet_internet_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER internet_internet_id_trg BEFORE
    INSERT ON internet
    FOR EACH ROW
    WHEN ( new.internet_id IS NULL )
BEGIN
    :new.internet_id := internet_internet_id_seq.nextval;
END;
/

CREATE SEQUENCE maquinas_maquina_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER maquinas_maquina_id_trg BEFORE
    INSERT ON maquinas
    FOR EACH ROW
    WHEN ( new.maquina_id IS NULL )
BEGIN
    :new.maquina_id := maquinas_maquina_id_seq.nextval;
END;
/

CREATE SEQUENCE piscinas_piscina_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER piscinas_piscina_id_trg BEFORE
    INSERT ON piscinas
    FOR EACH ROW
    WHEN ( new.piscina_id IS NULL )
BEGIN
    :new.piscina_id := piscinas_piscina_id_seq.nextval;
END;
/

CREATE SEQUENCE planes_consumo_plan_consumo_id START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER planes_consumo_plan_consumo_id BEFORE
    INSERT ON planes_consumo
    FOR EACH ROW
    WHEN ( new.plan_consumo_id IS NULL )
BEGIN
    :new.plan_consumo_id := planes_consumo_plan_consumo_id.nextval;
END;
/

CREATE SEQUENCE prestamos_prestamo_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER prestamos_prestamo_id_trg BEFORE
    INSERT ON prestamos
    FOR EACH ROW
    WHEN ( new.prestamo_id IS NULL )
BEGIN
    :new.prestamo_id := prestamos_prestamo_id_seq.nextval;
END;
/

CREATE SEQUENCE productos_producto_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productos_producto_id_trg BEFORE
    INSERT ON productos
    FOR EACH ROW
    WHEN ( new.producto_id IS NULL )
BEGIN
    :new.producto_id := productos_producto_id_seq.nextval;
END;
/

CREATE SEQUENCE recepcionistas_recepcionista_i START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER recepcionistas_recepcionista_i BEFORE
    INSERT ON recepcionistas
    FOR EACH ROW
    WHEN ( new.recepcionista_id IS NULL )
BEGIN
    :new.recepcionista_id := recepcionistas_recepcionista_i.nextval;
END;
/

CREATE SEQUENCE reservas_reserva_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservas_reserva_id_trg BEFORE
    INSERT ON reservas
    FOR EACH ROW
    WHEN ( new.reserva_id IS NULL )
BEGIN
    :new.reserva_id := reservas_reserva_id_seq.nextval;
END;
/

CREATE SEQUENCE reservas_salones_reserva_salon START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER reservas_salones_reserva_salon BEFORE
    INSERT ON reservas_salones
    FOR EACH ROW
    WHEN ( new.reserva_salon_id IS NULL )
BEGIN
    :new.reserva_salon_id := reservas_salones_reserva_salon.nextval;
END;
/

CREATE SEQUENCE salones_salon_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER salones_salon_id_trg BEFORE
    INSERT ON salones
    FOR EACH ROW
    WHEN ( new.salon_id IS NULL )
BEGIN
    :new.salon_id := salones_salon_id_seq.nextval;
END;
/

CREATE SEQUENCE servicios_servicio_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicios_servicio_id_trg BEFORE
    INSERT ON servicios
    FOR EACH ROW
    WHEN ( new.servicio_id IS NULL )
BEGIN
    :new.servicio_id := servicios_servicio_id_seq.nextval;
END;
/

CREATE SEQUENCE servicios_habitaciones_servici START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicios_habitaciones_servici BEFORE
    INSERT ON servicios_habitaciones
    FOR EACH ROW
    WHEN ( new.servicio_habitacion_id IS NULL )
BEGIN
    :new.servicio_habitacion_id := servicios_habitaciones_servici.nextval;
END;
/

CREATE SEQUENCE servicios_spa_servicio_spa_id START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER servicios_spa_servicio_spa_id BEFORE
    INSERT ON servicios_spa
    FOR EACH ROW
    WHEN ( new.servicio_spa_id IS NULL )
BEGIN
    :new.servicio_spa_id := servicios_spa_servicio_spa_id.nextval;
END;
/

CREATE SEQUENCE spa_spa_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER spa_spa_id_trg BEFORE
    INSERT ON spa
    FOR EACH ROW
    WHEN ( new.spa_id IS NULL )
BEGIN
    :new.spa_id := spa_spa_id_seq.nextval;
END;
/

CREATE SEQUENCE supermercados_supermercado_id START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER supermercados_supermercado_id BEFORE
    INSERT ON supermercados
    FOR EACH ROW
    WHEN ( new.supermercado_id IS NULL )
BEGIN
    :new.supermercado_id := supermercados_supermercado_id.nextval;
END;
/

CREATE SEQUENCE tiendas_tiendas_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tiendas_tiendas_id_trg BEFORE
    INSERT ON tiendas
    FOR EACH ROW
    WHEN ( new.tiendas_id IS NULL )
BEGIN
    :new.tiendas_id := tiendas_tiendas_id_seq.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            37
-- CREATE INDEX                            24
-- ALTER TABLE                             88
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          29
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                         29
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
