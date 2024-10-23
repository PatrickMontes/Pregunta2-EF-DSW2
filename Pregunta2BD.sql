CREATE DATABASE Pregunta2EFDSW;
/**DROP DATABASE Pregunta2EFDSW;**/
USE Pregunta2EFDSW;

CREATE TABLE estudiante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    carrera VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE profesor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    especialidad VARCHAR(50),
    email VARCHAR(50)
);

CREATE TABLE facultad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    descripcion VARCHAR(100)
);

CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    creditos INT,
    semestre VARCHAR(20),
    facultad_id INT,
    profesor_id INT,
    FOREIGN KEY (facultad_id) REFERENCES facultad(id),
    FOREIGN KEY (profesor_id) REFERENCES profesor(id)
);

CREATE TABLE matricula (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estudiante_id INT,
    curso_id INT,
    FOREIGN KEY (estudiante_id) REFERENCES estudiante(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);


INSERT INTO estudiante (nombre, apellido, carrera, email) VALUES
('Ana', 'López', 'Ingeniería de Sistemas', 'ana.lopez@example.com'),
('Carlos', 'Gómez', 'Derecho', 'carlos.gomez@example.com'),
('María', 'Pérez', 'Medicina', 'maria.perez@example.com'),
('Luis', 'Fernández', 'Ingeniería Civil', 'luis.fernandez@example.com'),
('Javier', 'Ramírez', 'Contabilidad', 'javier.ramirez@example.com'),
('Sofía', 'Martínez', 'Arquitectura', 'sofia.martinez@example.com'),
('Pedro', 'Hernández', 'Psicología', 'pedro.hernandez@example.com'),
('Valeria', 'Torres', 'Marketing', 'valeria.torres@example.com');


INSERT INTO profesor (nombre, especialidad, email) VALUES
('Dr. Alberto García', 'Matemáticas', 'agarcia@upc.edu.pe'),
('Dra. Elena Ruiz', 'Física', 'eruiz@upc.edu.pe'),
('Dr. José López', 'Ingeniería de Software', 'jlopez@upc.edu.pe'),
('Dra. Laura Salas', 'Derecho Penal', 'lsalas@upc.edu.pe'),
('Dr. Martín Vega', 'Economía', 'mvega@upc.edu.pe'),
('Dra. Gabriela Fuentes', 'Psicología Clínica', 'gfuentes@upc.edu.pe'),
('Dr. Andrés León', 'Arquitectura Moderna', 'aleon@upc.edu.pe'),
('Dra. Claudia Espinoza', 'Marketing Digital', 'cespinoza@upc.edu.pe');


INSERT INTO facultad (nombre, descripcion) VALUES
('Facultad de Ingeniería', 'Facultad enfocada en carreras técnicas y científicas.'),
('Facultad de Ciencias Sociales', 'Facultad especializada en ciencias humanas.'),
('Facultad de Derecho', 'Facultad dedicada al estudio de leyes.'),
('Facultad de Medicina', 'Facultad de formación en salud.'),
('Facultad de Arquitectura', 'Facultad de diseño y construcción.'),
('Facultad de Economía', 'Facultad de finanzas y economía.'),
('Facultad de Psicología', 'Facultad para el estudio del comportamiento humano.'),
('Facultad de Marketing', 'Facultad enfocada en estrategias de mercado.');


INSERT INTO curso (nombre, creditos, semestre, facultad_id, profesor_id) VALUES
('Cálculo Diferencial', 5, '2024-I', 1, 1),
('Física General', 4, '2024-I', 1, 2),
('Ingeniería de Software', 5, '2024-II', 1, 3),
('Derecho Penal I', 4, '2024-I', 3, 4),
('Microeconomía', 3, '2024-I', 6, 5),
('Psicología Clínica', 4, '2024-II', 7, 6),
('Diseño Arquitectónico', 5, '2024-I', 5, 7),
('Marketing Estratégico', 3, '2024-II', 8, 8);


INSERT INTO matricula (estudiante_id, curso_id) VALUES
(1, 1), (1, 2),
(2, 4), (2, 5),
(3, 6), (3, 1),
(4, 3), (4, 7),
(5, 2), (5, 8),
(6, 4), (6, 6),
(7, 5), (7, 3),
(8, 8), (8, 7);

