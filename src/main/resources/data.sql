-- Inserción de datos en la tabla Frecuencia
INSERT INTO frecuencia (dias, tipo, descripcion) VALUES
('Lunes a Viernes', 'Diario', 'Frecuencia diaria de clases'),
('Lunes y Miércoles', 'Semanal', 'Clases lunes y miércoles'),
('Sábado', 'Semanal', 'Clases solo los sábados');

-- Inserción de datos en la tabla Vacante
INSERT INTO vacante (codigo_vacante, cantidad, descripcion) VALUES
('VAC001', 50, 'Vacante para el turno mañana'),
('VAC002', 30, 'Vacante para el turno tarde'),
('VAC003', 20, 'Vacante para el turno noche');

-- Inserción de datos en la tabla Colegio Procedencia (sin CRUD)
INSERT INTO colegio_procedencia (nombre_colegio, direccion, distrito, provincia, departamento) VALUES
('Colegio Nacional San Marcos', 'Av. Ejemplo 123', 'Lima', 'Lima', 'Lima'),
('Colegio Nuestra Señora de Fátima', 'Calle Ejemplo 456', 'Surco', 'Lima', 'Lima'),
('Colegio Santa María', 'Jr. Ejemplo 789', 'Miraflores', 'Lima', 'Lima');

-- Inserción de datos en la tabla Familiar Apoderado
INSERT INTO familiar_apoderado (apellido_paterno, apellido_materno, nombres, tipo_documento, numero_documento, parentesco, ocupacion, telefono_fijo, telefono_celular, correo_electronico) VALUES
('García', 'Pérez', 'Juan', 'DNI', '12345678', 'Padre', 'Ingeniero', '4455667', '987654321', 'juan.garcia@example.com'),
('Rodríguez', 'López', 'María', 'DNI', '87654321', 'Madre', 'Abogada', '4455668', '987654322', 'maria.rodriguez@example.com'),
('Fernández', 'Díaz', 'Carlos', 'DNI', '13579246', 'Tío', 'Contador', '4455669', '987654323', 'carlos.fernandez@example.com');

-- Inserción de datos en la tabla Turno Horario
INSERT INTO turno_horario (turno, horario_inicio, horario_fin, id_frecuencia) VALUES
('Mañana', '08:00:00', '12:00:00', 1),
('Tarde', '14:00:00', '18:00:00', 2),
('Noche', '18:00:00', '21:00:00', 3);

-- Inserción de datos en la tabla Alumnos
INSERT INTO alumno (dni, nombre, apellido, sexo, fecha_nacimiento, edad, direccion, id_frecuencia, id_vacante, id_colegio_procedencia, id_familiar_apoderado, id_turno_horario) VALUES
('98765432', 'Pedro', 'Sánchez', 'M', '2005-05-10', 19, 'Av. Universitaria 123', 1, 1, 1, 1, 1),
('87654321', 'Luis', 'Gómez', 'M', '2006-10-12', 18, 'Calle Principal 456', 2, 2, 2, 2, 2),
('76543210', 'Ana', 'Fernández', 'F', '2004-03-05', 20, 'Jr. Secundario 789', 3, 3, 3, 3, 3);

-- Inserción de datos en la tabla Postulante
INSERT INTO postulante (nombres, apellido_paterno, apellido_materno, genero, tipo_documento, numero_documento, discapacidad, id_turno_horario, id_familiar_apoderado, id_colegio_procedencia)
VALUES
('Carlos', 'González', 'Gutiérrez', 'M', 'DNI', '34567890', 'Ninguna', 1, 1, 1),
('Andrea', 'Martínez', 'Gómez', 'F', 'DNI', '23456789', 'Ninguna', 2, 2, 2),
('Lucía', 'Paredes', 'Sánchez', 'F', 'Pasaporte', '12345678', 'Leve', 3, 3, 3);


-- Inserción de datos en la tabla Secretaría Académica (sin CRUD)
INSERT INTO secretaria_academica (nombre, apellido, correo, telefono) VALUES
('María', 'Ramos', 'maria.ramos@secretaria.com', '987654321'),
('Carlos', 'Ortiz', 'carlos.ortiz@secretaria.com', '987654322'),
('Lucía', 'Pérez', 'lucia.perez@secretaria.com', '987654323');

-- Inserción de datos en la tabla Tesorero (sin CRUD)
INSERT INTO tesorero (nombre, apellido, dni, correo) VALUES
('José', 'Pérez', '98765433', 'jose.perez@example.com'),
('María', 'Gómez', '98765434', 'maria.gomez@example.com'),
('Carlos', 'Fernández', '98765435', 'carlos.fernandez@example.com');

-- Inserción de datos en la tabla Responsable Caja (sin CRUD)
INSERT INTO responsable_caja (codigo, dni, nombres, apellidos, correo) VALUES
('RC001', '99887766', 'Laura', 'Vega', 'laura.vega@example.com'),
('RC002', '88776655', 'Pablo', 'Ríos', 'pablo.rios@example.com'),
('RC003', '77665544', 'Sofía', 'Lopez', 'sofia.lopez@example.com');

-- Inserción de datos en la tabla Constancia Reserva
INSERT INTO constancia_reserva (codigo_constancia_reserva, fecha_emision, id_alumno, id_secretaria_academica) VALUES
('CR001', '2024-01-10', 1, 1),
('CR002', '2024-01-12', 2, 2),
('CR003', '2024-01-15', 3, 3);

-- Inserción de datos en la tabla Constancia Matricula
INSERT INTO constancia_matricula (codigo_constancia_matricula, fecha_emision, id_alumno) VALUES
('CM001', '2024-01-11', 1),
('CM002', '2024-01-13', 2),
('CM003', '2024-01-16', 3);

-- Inserción de datos en la tabla Orden Pago
INSERT INTO orden_pago (nro_orden, fecha_emision, monto_total, fecha_vencimiento, observaciones, id_alumno, id_tesorero) VALUES
('OP001', '2024-01-10', 500.00, '2024-01-30', 'Pago inicial', 1, 1),
('OP002', '2024-01-12', 300.00, '2024-01-25', 'Pago mensual', 2, 2),
('OP003', '2024-01-15', 400.00, '2024-01-28', 'Pago final', 3, 3);

-- Inserción de datos en la tabla Comprobante Pago
INSERT INTO comprobante_pago (codigo_comprobante, monto_pagado, fecha_pago, metodo_pago, id_alumno, id_responsable_caja) VALUES
('CP001', 500.00, '2024-01-11', 'Tarjeta de crédito', 1, 1),
('CP002', 300.00, '2024-01-13', 'Transferencia', 2, 2),
('CP003', 400.00, '2024-01-16', 'Efectivo', 3, 3);

-- Inserción de datos en la tabla Solicitud Constancia Reserva
INSERT INTO solicitud_constancia_reserva (codigo_solicitud, estado, observaciones, id_alumno) VALUES
('SCR001', 'Pendiente', 'Solicitud en proceso', 1),
('SCR002', 'Aprobada', 'Solicitud aprobada', 2),
('SCR003', 'Rechazada', 'Solicitud rechazada', 3);

-- Inserción de datos en la tabla Suscripción Informes (sin CRUD)
INSERT INTO suscripcion_informes (correo, estado, id_alumno) VALUES
('suscriptor1@example.com', 'Activo', 1),
('suscriptor2@example.com', 'Inactivo', 2),
('suscriptor3@example.com', 'Activo', 3);

-- Inserción de datos en la tabla usuario
INSERT INTO usuario (username, password)
SELECT 'admin', 'admin12345678' FROM DUAL
WHERE NOT EXISTS (SELECT * FROM usuario WHERE username='admin');

