--RFC1 - MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN EN EL ÚLTIMO AÑO CORRIDO

Select h.numero, co.costo
FROM Consumos Co, Habitaciones H, Servicios S
WHERE co.habitaciones_numero = H.numero
AND co.servicios_id_servicio = s.id_servicio;


--RFC2 - MOSTRAR LOS 20 SERVICIOS MÁS POPULARES
Select s.nombre, Count(nombre) as popularidad
FROM servicios s, Consumos c
WHERE c.servicios_id_servicio = s.id_servicio AND ROWNUM <= 20
GROUP BY s.nombre
ORDER BY popularidad DESC;


--RFC3 - MOSTRAR EL ÍNDICE DE OCUPACIÓN DE CADA UNA DE LAS HABITACIONES DEL HOTEL
SELECT
    H.numero,
    (SUM(TO_DATE(Fecha_Fin, 'YYYY-MM-DD') - TO_DATE(Fecha_Inicio, 'YYYY-MM-DD')) * 100.0 / 365) AS IndiceOcupacion
FROM
    HabitacionUsuario HU
JOIN
    Habitaciones H ON hu.habitaciones_numero = H.numero
WHERE
    (TO_DATE(Fecha_Fin, 'YYYY-MM-DD') >= (TO_DATE(Fecha_Inicio, 'YYYY-MM-DD')))
GROUP BY
    H.numero;


--RFC4 - MOSTRAR LOS SERVICIOS QUE CUMPLEN CON CIERTA CARACTERÍSTICA
SELECT
    s.id_servicio,
    s.descripcion AS descripcion_servicio,
    s.nombre AS nombre_servicio,
    c.fecha AS fecha_consumo,
    c.costo AS costo_consumo,
    e.nombre AS nombre_empleado,
    t.nombre AS tipo_servicio,
    c.categoria AS categoria_servicio
FROM servicios s
INNER JOIN consumos c ON s.id_servicio = c.servicios_id_servicio
LEFT JOIN empleados e ON c.empleado_id = e.id_empleado
INNER JOIN tipos_servicio t ON s.tipo_servicio_id = t.id_tipo_servicio
WHERE
    c.costo BETWEEN 50 AND 100
    AND c.fecha BETWEEN '2022-01-01' AND '2023-01-01'
    AND e.nombre = 'Nombre del Empleado'
    AND t.nombre = 'Tipo de Servicio'
    AND s.categoria = 'Categoría del Servicio';



--RFC5 - MOSTRAR EL CONSUMO EN HOTELANDES POR UN USUARIO DADO, EN UN RANGO DE FECHAS INDICADO
Select u.nombre ,hu.usuarios_numeros_documento, cu.costo
from HabitacionUsuario HU, Usuarios U, Habitaciones H, Consumos CU
WHERE hu.usuarios_numeros_documento = u.numero_documento
AND hu.habitaciones_numero = h.numero
AND h.numero = cu.Habitaciones_numero
AND "?" >= hu.fecha_inicio AND "?" <= hu.fecha_fin;


--RFC6 - ANALIZAR LA OPERACIÓN DE HOTELANDES

    --Mayor concurrencia
SELECT Fecha, CantidadUsuarios
FROM (
    SELECT Fecha, COUNT(*) AS CantidadUsuarios
    FROM (
        SELECT DISTINCT HU.Fecha_Inicio AS Fecha FROM HabitacionUsuario HU
        UNION ALL
        SELECT DISTINCT HU.Fecha_fin AS Fecha FROM HabitacionUsuario HU
    ) Fechas
    GROUP BY Fecha
    ORDER BY CantidadUsuarios DESC
)
WHERE ROWNUM <= 5;
    --Menor concurrencia
SELECT Fecha, CantidadUsuarios
FROM (
    SELECT Fecha, COUNT(*) AS CantidadUsuarios
    FROM (
        SELECT DISTINCT HU.Fecha_Inicio AS Fecha FROM HabitacionUsuario HU
        UNION ALL
        SELECT DISTINCT HU.Fecha_fin AS Fecha FROM HabitacionUsuario HU
    ) Fechas
    GROUP BY Fecha
    ORDER BY CantidadUsuarios ASC
)
WHERE ROWNUM <= 5;


--RFC7 - ENCONTRAR LOS BUENOS CLIENTES
Select u.nombre, hu.usuarios_numeros_documento, hu.fecha_inicio, hu.fecha_fin
FROM HabitacionUsuario hu, Usuarios u
WHERE hu.usuarios_numeros_documento = u.numero_documento
AND (TO_DATE(HU.Fecha_fin, 'YYYY-MM-DD') - TO_DATE(HU.Fecha_Inicio, 'YYYY-MM-DD')) >= 14
ORDER BY u.nombre;


--RFC8 - ENCONTRAR LOS SERVICIOS QUE NO TIENEN MUCHA DEMANDA

Select s.nombre, COUNT(SR.servicios_id_servicio) AS CantidadDemandas
FROM ServicioReservado SR, Servicios S
WHERE sr.servicios_id_servicio = s.id_servicio
GROUP BY S.nombre
Order by CantidadDemandas asc;

--RFC9 - CONSULTAR CONSUMO EN HOTELANDES

SELECT u.nombre, s.nombre
FROM HabitacionUsuario hu, Usuarios u, habitaciones h, consumos co, servicios s
WHERE hu.usuarios_numeros_documento = u.numero_documento
AND hu.habitaciones_numero = h.numero
AND h.numero = co.habitaciones_numero
AND co.servicios_id_servicio = s.id_servicio
AND s.id_servicio = 12
ORDER BY u.nombre ASC;

--RFC10 - CONSULTAR CONSUMO EN HOTELANDES – RFC9-V2

SELECT u.nombre, consul.nombre
FROM HabitacionUsuario hu, Usuarios u, habitaciones h,
(
SELECT co.habitaciones_numero, s.id_servicio, s.nombre
FROM Consumos co, Servicios s
Where co.servicios_id_servicio = s.id_servicio
) consul
WHERE hu.usuarios_numeros_documento = u.numero_documento
AND h.numero = hu.habitaciones_numero
AND consul.habitaciones_numero = h.numero
AND consul.id_servicio != 10;

--RFC11 - CONSULTAR FUNCIONAMIENTO
WITH Semanas AS (
  SELECT
    TO_CHAR(fecha, 'IYYY-IW') AS semana,
    TO_DATE(TO_CHAR(fecha, 'IYYY-IW') || '6', 'IYYY-IWd') AS inicio_semana,
    TO_DATE(TO_CHAR(fecha, 'IYYY-IW') || '12', 'IYYY-IWd') AS fin_semana
  FROM consumos
)
SELECT
  s.semana AS semana_del_anio,
  (
    SELECT descripcion
    FROM servicios
    WHERE id_servicio = (
      SELECT servicios_id_servicio
      FROM (
        SELECT servicios_id_servicio, COUNT(*) AS cantidad
        FROM consumos c
        WHERE c.fecha BETWEEN s.inicio_semana AND s.fin_semana
        GROUP BY servicios_id_servicio
        ORDER BY cantidad DESC
      ) WHERE ROWNUM = 1
    )
  ) AS servicio_mas_consumido,
  (
    SELECT descripcion
    FROM servicios
    WHERE id_servicio = (
      SELECT servicios_id_servicio
      FROM (
        SELECT servicios_id_servicio, COUNT(*) AS cantidad
        FROM consumos c
        WHERE c.fecha BETWEEN s.inicio_semana AND s.fin_semana
        GROUP BY servicios_id_servicio
        ORDER BY cantidad ASC
      ) WHERE ROWNUM = 1
    )
  ) AS servicio_menos_consumido,
  (
    SELECT TO_CHAR(habitaciones_numero)
    FROM (
      SELECT habitaciones_numero, COUNT(*) AS cantidad
      FROM servicioreservado sr
      WHERE sr.fecha_reserva BETWEEN s.inicio_semana AND s.fin_semana
      GROUP BY habitaciones_numero
      ORDER BY cantidad DESC
    ) WHERE ROWNUM = 1
  ) AS habitacion_mas_solicitada,
  (
    SELECT TO_CHAR(habitaciones_numero)
    FROM (
      SELECT habitaciones_numero, COUNT(*) AS cantidad
      FROM servicioreservado sr
      WHERE sr.fecha_reserva BETWEEN s.inicio_semana AND s.fin_semana
      GROUP BY habitaciones_numero
      ORDER BY cantidad ASC
    ) WHERE ROWNUM = 1
  ) AS habitacion_menos_solicitada
FROM Semanas s
GROUP BY s.semana, s.inicio_semana, s.fin_semana
ORDER BY s.semana;



--RFC12 - CONSULTAR LOS CLIENTES EXCELENTES
SELECT
    u.numeros_documento AS numero_documento,
    u.nombre AS nombre_cliente,
    u.email AS correo_cliente,
    u.fecha_entrada AS fecha_entrada,
    u.fecha_salida AS fecha_salida,
    SUM(CASE
        WHEN c.fecha >= TO_DATE(TO_CHAR(TRUNC(u.fecha_entrada, 'Q'), 'YYYY-MM-DD'), 'YYYY-MM-DD')
             AND c.fecha < TO_DATE(TO_CHAR(ADD_MONTHS(TRUNC(u.fecha_entrada, 'Q'), 3), 'YYYY-MM-DD'), 'YYYY-MM-DD')
        THEN 1
        ELSE 0
    END) AS estancias_trimestrales,
    MAX(s.precio) AS max_precio_consumido,
    MAX(CASE
        WHEN s.precio > 300000
        THEN 1
        ELSE 0
    END) AS consumo_costoso,
    MAX(CASE
        WHEN (sr.fecha_reserva IS NOT NULL AND sr.codigo IS NOT NULL
              AND (s.descripcion = 'SPA' OR s.descripcion = 'Salones de Reuniones')
              AND (sr.check_out - sr.check_in) > 4)
        THEN 1
        ELSE 0
    END) AS consumo_spa_o_salones
FROM usuarios u
LEFT JOIN consumos c ON u.numeros_documento = c.usuarios_numeros_documento
LEFT JOIN servicios s ON c.servicios_id_servicio = s.id_servicio
LEFT JOIN servicioreservado sr ON u.numeros_documento = sr.usuarios_numeros_documento
WHERE
    (SUM(CASE
        WHEN c.fecha >= TO_DATE(TO_CHAR(TRUNC(u.fecha_entrada, 'Q'), 'YYYY-MM-DD'), 'YYYY-MM-DD')
             AND c.fecha < TO_DATE(TO_CHAR(ADD_MONTHS(TRUNC(u.fecha_entrada, 'Q'), 3), 'YYYY-MM-DD'), 'YYYY-MM-DD')
        THEN 1
        ELSE 0
    END) > 0
    OR MAX(s.precio) > 300000
    OR MAX(CASE
        WHEN (sr.fecha_reserva IS NOT NULL AND sr.codigo IS NOT NULL
              AND (s.descripcion = 'SPA' OR s.descripcion = 'Salones de Reuniones')
              AND (sr.check_out - sr.check_in) > 4)
        THEN 1
        ELSE 0
    END) = 1)
GROUP BY
    u.numeros_documento,
    u.nombre,
    u.email,
    u.fecha_entrada,
    u.fecha_salida
HAVING
    (SUM(CASE
        WHEN c.fecha >= TO_DATE(TO_CHAR(TRUNC(u.fecha_entrada, 'Q'), 'YYYY-MM-DD'), 'YYYY-MM-DD')
             AND c.fecha < TO_DATE(TO_CHAR(ADD_MONTHS(TRUNC(u.fecha_entrada, 'Q'), 3), 'YYYY-MM-DD'), 'YYYY-MM-DD')
        THEN 1
        ELSE 0
    END) > 0
    OR MAX(s.precio) > 300000
    OR MAX(CASE
        WHEN (sr.fecha_reserva IS NOT NULL AND sr.codigo IS NOT NULL
              AND (s.descripcion = 'SPA' OR s.descripcion = 'Salones de Reuniones')
              AND (sr.check_out - sr.check_in) > 4)
        THEN 1
        ELSE 0
    END) = 1)
ORDER BY u.numeros_documento;


