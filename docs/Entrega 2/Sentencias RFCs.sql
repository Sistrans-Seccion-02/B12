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



--RFC12 - CONSULTAR LOS CLIENTES EXCELENTES


