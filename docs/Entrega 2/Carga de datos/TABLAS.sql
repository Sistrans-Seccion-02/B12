CREATE TABLE bares (
    id_servicio NUMBER NOT NULL,
    capacidad   NUMBER,
    estilo      VARCHAR2(255 BYTE)
);

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id_servicio );

CREATE TABLE consumos (
    numero_factura        NUMBER NOT NULL,
    costo                 NUMBER,
    fecha                 DATE,
    habitaciones_numero   NUMBER NOT NULL,
    servicios_id_servicio NUMBER NOT NULL
);

CREATE UNIQUE INDEX consumos__idx ON
    consumos (
        servicios_id_servicio
    ASC );

ALTER TABLE consumos ADD CONSTRAINT consumos_pk PRIMARY KEY ( numero_factura,
                                                              habitaciones_numero );

CREATE TABLE gimnasios (
    id_servicio NUMBER NOT NULL,
    horario     VARCHAR2(255 BYTE),
    capacidad   NUMBER
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasios_pk PRIMARY KEY ( id_servicio );

CREATE TABLE habitaciones (
    numero                 NUMBER NOT NULL,
    tiposhabitacion_nombre VARCHAR2(255 BYTE) NOT NULL
);

CREATE UNIQUE INDEX habitaciones__idx ON
    habitaciones (
        tiposhabitacion_nombre
    ASC );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numero );

CREATE TABLE habitacionusuario (
    habitaciones_numero        NUMBER NOT NULL,
    usuarios_numeros_documento NUMBER NOT NULL,
    codigo                     NUMBER,
    fecha_inicio               DATE,
    fecha_fin                  DATE,
    check_in                   DATE,
    check_out                  DATE
);

ALTER TABLE habitacionusuario ADD CONSTRAINT habitacionusuario_pk PRIMARY KEY ( habitaciones_numero,
                                                                                usuarios_numeros_documento );

CREATE TABLE internet (
    id_servicio NUMBER NOT NULL,
    capacidad   NUMBER,
    costo       NUMBER
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( id_servicio );

CREATE TABLE piscinas (
    id_servicio NUMBER NOT NULL,
    horario     VARCHAR2(255 BYTE),
    capacidad   NUMBER,
    profundidad NUMBER
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id_servicio );

CREATE TABLE planesconsumo (
    nombre                     VARCHAR2(255 BYTE) NOT NULL,
    descripcion                VARCHAR2(255 BYTE),
    usuarios_numeros_documento NUMBER NOT NULL
);

CREATE UNIQUE INDEX planesconsumo__idx ON
    planesconsumo (
        usuarios_numeros_documento
    ASC );

ALTER TABLE planesconsumo ADD CONSTRAINT planesconsumo_pk PRIMARY KEY ( nombre );

CREATE TABLE productos (
    codigo                    NUMBER NOT NULL,
    nombre                    NUMBER,
    precio                    NUMBER,
    supermercados_id_servicio NUMBER NOT NULL,
    tiendas_id_servicio       NUMBER NOT NULL,
    restaurantes_id_servicio  NUMBER NOT NULL,
    bares_id_servicio         NUMBER NOT NULL
);

ALTER TABLE productos
    ADD CONSTRAINT productos_pk PRIMARY KEY ( codigo,
                                              supermercados_id_servicio,
                                              tiendas_id_servicio,
                                              restaurantes_id_servicio,
                                              bares_id_servicio );

CREATE TABLE restaurantes (
    id_servicio NUMBER NOT NULL,
    capacidad   NUMBER,
    estilo      VARCHAR2(255 BYTE)
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id_servicio );

CREATE TABLE salasconferencias (
    id_servicio NUMBER NOT NULL,
    costo       NUMBER,
    capacidad   NUMBER
);

ALTER TABLE salasconferencias ADD CONSTRAINT salasconferencias_pk PRIMARY KEY ( id_servicio );

CREATE TABLE salasreuniones (
    id_servicio  NUMBER NOT NULL,
    costo        NUMBER,
    capacidad    NUMBER,
    equipo_extra NUMBER
);

ALTER TABLE salasreuniones ADD CONSTRAINT salasreuniones_pk PRIMARY KEY ( id_servicio );

CREATE TABLE servicioreservado (
    habitaciones_numero   NUMBER NOT NULL,
    servicios_id_servicio NUMBER NOT NULL,
    fecha_reserva         VARCHAR2(255 BYTE),
    codigo                NUMBER
);

ALTER TABLE servicioreservado ADD CONSTRAINT servicioreservado_pk PRIMARY KEY ( habitaciones_numero,
                                                                                servicios_id_servicio );

CREATE TABLE servicios (
    id_servicio NUMBER NOT NULL,
    descripcion VARCHAR2(255) NOT NULL,
    nombre      VARCHAR2(255 BYTE)
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id_servicio );

CREATE TABLE servicioslavanderia (
    id_servicio NUMBER NOT NULL,
    costo       NUMBER
);

ALTER TABLE servicioslavanderia ADD CONSTRAINT servicioslavanderia_pk PRIMARY KEY ( id_servicio );

CREATE TABLE serviciosspa (
    id_servicio NUMBER NOT NULL,
    costo       NUMBER
);

ALTER TABLE serviciosspa ADD CONSTRAINT serviciosspa_pk PRIMARY KEY ( id_servicio );

CREATE TABLE supermercados (
    id_servicio NUMBER NOT NULL
);

ALTER TABLE supermercados ADD CONSTRAINT supermercados_pk PRIMARY KEY ( id_servicio );

CREATE TABLE tiendas (
    id_servicio NUMBER NOT NULL
);

ALTER TABLE tiendas ADD CONSTRAINT tiendas_pk PRIMARY KEY ( id_servicio );

CREATE TABLE tiposhabitacion (
    nombre    VARCHAR2(255 BYTE) NOT NULL,
    capacidad NUMBER,
    costo     NUMBER
);

ALTER TABLE tiposhabitacion ADD CONSTRAINT tiposhabitacion_pk PRIMARY KEY ( nombre );

CREATE TABLE tiposusuario (
    nombre      VARCHAR2(255 BYTE) NOT NULL,
    descripcion VARCHAR2(255 BYTE)
);

ALTER TABLE tiposusuario ADD CONSTRAINT tiposusuario_pk PRIMARY KEY ( nombre );

CREATE TABLE usuarios (
    numeros_documento   NUMBER NOT NULL,
    tipo_documento      VARCHAR2(255 BYTE),
    email               VARCHAR2(255 BYTE),
    nombre              VARCHAR2(255 BYTE),
    fecha_entrada       DATE,
    fecha_salida        DATE,
    tiposusuario_nombre VARCHAR2(255 BYTE) NOT NULL
);

CREATE UNIQUE INDEX usuarios__idx ON
    usuarios (
        tiposusuario_nombre
    ASC );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( numeros_documento );

CREATE TABLE utensiliosprestamo (
    id_servicio NUMBER NOT NULL,
    prestado    NUMBER,
    devuelto    NUMBER,
    mal_estado  NUMBER,
    costo_extra NUMBER
);

ALTER TABLE utensiliosprestamo ADD CONSTRAINT utensiliosprestamo_pk PRIMARY KEY ( id_servicio );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_habitaciones_fk FOREIGN KEY ( habitaciones_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE consumos
    ADD CONSTRAINT consumos_servicios_fk FOREIGN KEY ( servicios_id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE gimnasios
    ADD CONSTRAINT gimnasios_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tiposhab_fk FOREIGN KEY ( tiposhabitacion_nombre )
        REFERENCES tiposhabitacion ( nombre );

ALTER TABLE habitacionusuario
    ADD CONSTRAINT habitacionusuario_hab_fk FOREIGN KEY ( habitaciones_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE habitacionusuario
    ADD CONSTRAINT habitacionusuario_usu_fk FOREIGN KEY ( usuarios_numeros_documento )
        REFERENCES usuarios ( numeros_documento );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE planesconsumo
    ADD CONSTRAINT planesconsumo_usuarios_fk FOREIGN KEY ( usuarios_numeros_documento )
        REFERENCES usuarios ( numeros_documento );

ALTER TABLE productos
    ADD CONSTRAINT productos_bares_fk FOREIGN KEY ( bares_id_servicio )
        REFERENCES bares ( id_servicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_restaurantes_fk FOREIGN KEY ( restaurantes_id_servicio )
        REFERENCES restaurantes ( id_servicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_supermercados_fk FOREIGN KEY ( supermercados_id_servicio )
        REFERENCES supermercados ( id_servicio );

ALTER TABLE productos
    ADD CONSTRAINT productos_tiendas_fk FOREIGN KEY ( tiendas_id_servicio )
        REFERENCES tiendas ( id_servicio );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE salasconferencias
    ADD CONSTRAINT salasconferencias_ser_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE salasreuniones
    ADD CONSTRAINT salasreuniones_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE servicioreservado
    ADD CONSTRAINT servicioreservado_hab_fk FOREIGN KEY ( habitaciones_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE servicioreservado
    ADD CONSTRAINT servicioreservado_ser_fk FOREIGN KEY ( servicios_id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE servicioslavanderia
    ADD CONSTRAINT servicioslavanderia_ser_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE serviciosspa
    ADD CONSTRAINT serviciosspa_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE supermercados
    ADD CONSTRAINT supermercados_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE tiendas
    ADD CONSTRAINT tiendas_servicios_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );

ALTER TABLE usuarios
    ADD CONSTRAINT usuarios_tiposusuario_fk FOREIGN KEY ( tiposusuario_nombre )
        REFERENCES tiposusuario ( nombre );

ALTER TABLE utensiliosprestamo
    ADD CONSTRAINT utensiliosprestamo_ser_fk FOREIGN KEY ( id_servicio )
        REFERENCES servicios ( id_servicio );