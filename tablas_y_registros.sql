-- TABLAS

-- Eliminacion de tablas
DROP TABLE IF EXISTS solicitud_de_libro;
DROP SEQUENCE IF EXISTS secuencia_de_solicitud;
DROP TABLE IF EXISTS descarga_de_libro;
DROP TABLE IF EXISTS prestamo_de_libro;
DROP SEQUENCE IF EXISTS secuencia_de_prestamo;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS multa;
DROP TABLE IF EXISTS profesores_y_areas;
DROP TABLE IF EXISTS area_de_interes;
DROP TABLE IF EXISTS profesor;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS libros_y_autores;
DROP TABLE IF EXISTS autor;
DROP TABLE IF EXISTS libro_digital;
DROP TABLE IF EXISTS libro_fisico;
DROP TABLE IF EXISTS libro;
DROP TABLE IF EXISTS editorial;
DROP TABLE IF EXISTS area_de_conocimiento;

-- Area de conocimiento
CREATE TABLE area_de_conocimiento (
	codigo_area_de_conocimiento CHAR(10),
	nombre_area_de_conocimiento VARCHAR(100),
	descripcion_area_de_conocimiento VARCHAR(500),
	codigo_area_padre CHAR(10),
	PRIMARY KEY (codigo_area_de_conocimiento),
	FOREIGN KEY (codigo_area_padre) REFERENCES area_de_conocimiento(codigo_area_de_conocimiento));

-- Editorial
CREATE TABLE editorial (
	codigo_editorial CHAR(10),
	nombre_editorial VARCHAR(100),
	pagina_web_editorial VARCHAR(100),
	pais_de_origen_editorial VARCHAR(50),
	PRIMARY KEY (codigo_editorial));

-- Libro
CREATE TABLE libro (
	isbn_libro CHAR(13),
	titulo_libro VARCHAR(50),
	anyo_de_publicacion_libro CHAR(4),
	idioma_libro VARCHAR(10),
	numero_de_paginas_libro VARCHAR(4),
	codigo_area_de_conocimiento_libro VARCHAR(10),
	codigo_editorial_libro VARCHAR(10),
	PRIMARY KEY (isbn_libro),
	FOREIGN KEY (codigo_area_de_conocimiento_libro) REFERENCES area_de_conocimiento(codigo_area_de_conocimiento),
	FOREIGN KEY (codigo_editorial_libro) REFERENCES editorial(codigo_editorial));

-- Libro fisico (ejemplar)
CREATE TABLE libro_fisico (
	isbn_libro_ejemplar CHAR(13),
	numero_ejemplar VARCHAR(3),
	sala_ejemplar VARCHAR(8),
	pasillo_ejemplar VARCHAR(11),
	estante_ejemplar VARCHAR(10),
	cajon_ejemplar VARCHAR(8),
	PRIMARY KEY (isbn_libro_ejemplar, numero_ejemplar),
	FOREIGN KEY (isbn_libro_ejemplar) REFERENCES libro(isbn_libro));

-- Libro digital
CREATE TABLE libro_digital (
	isbn_libro_digital CHAR(13),
	url_libro_digital VARCHAR(100),
	formato_libro_digital VARCHAR(10),
	tamanyo_libro_digital VARCHAR(10),
	PRIMARY KEY (isbn_libro_digital),
	FOREIGN KEY (isbn_libro_digital) REFERENCES libro(isbn_libro));

-- Autor
CREATE TABLE autor (
	codigo_autor CHAR(10),
	primer_nombre_autor VARCHAR(50),
	segundo_nombre_autor VARCHAR(50),
	primer_apellido_autor VARCHAR(50),
	segundo_apellido_autor VARCHAR(50),
	PRIMARY KEY (codigo_autor));

-- Libros y autores
CREATE TABLE libros_y_autores (
	codigo_autor_lya CHAR(10),
	isbn_libro_lya CHAR(13),
	PRIMARY KEY (codigo_autor_lya, isbn_libro_lya),
	FOREIGN KEY (codigo_autor_lya) REFERENCES autor(codigo_autor),
	FOREIGN KEY (isbn_libro_lya) REFERENCES libro(isbn_libro));

-- Usuario
CREATE TABLE usuario (
	codigo_usuario CHAR(10),
	nombre_usuario VARCHAR(100),
	direccion_usuario VARCHAR(30),
	telefono_usuario CHAR(10),
	e_mail_usuario VARCHAR(100),
	contrasenya_usuario VARCHAR(10),
	PRIMARY KEY (codigo_usuario));

-- Estudiante
CREATE TABLE estudiante (
	codigo_usuario_estudiante CHAR(10),
	universidad_estudiante VARCHAR(100),
	carrera_estudiante VARCHAR(50),
	PRIMARY KEY (codigo_usuario_estudiante),
	FOREIGN KEY (codigo_usuario_estudiante) REFERENCES usuario(codigo_usuario));

-- Profesor
CREATE TABLE profesor (
	codigo_usuario_profesor CHAR(10),
	titulo_profesor VARCHAR(50),
	dependencia_profesor VARCHAR(100),
	PRIMARY KEY (codigo_usuario_profesor),
	FOREIGN KEY (codigo_usuario_profesor) REFERENCES usuario(codigo_usuario));

-- Area de interes
CREATE TABLE area_de_interes (
	codigo_area_de_interes VARCHAR(10),
	nombre_area_de_interes VARCHAR(50),
	PRIMARY KEY (codigo_area_de_interes));

-- Profesores y areas
CREATE TABLE profesores_y_areas(
	codigo_usuario_profesor_pya CHAR(10),
	codigo_area_de_interes_pya VARCHAR(10),
	PRIMARY KEY (codigo_usuario_profesor_pya, codigo_area_de_interes_pya),
	FOREIGN KEY (codigo_usuario_profesor_pya) REFERENCES profesor(codigo_usuario_profesor),
	FOREIGN KEY (codigo_area_de_interes_pya) REFERENCES area_de_interes(codigo_area_de_interes));

-- Multa
CREATE TABLE multa (
	codigo_multa CHAR(10),
	fecha_multa DATE,
	valor_multa INT,
	descripcion_multa VARCHAR(500),
	codigo_usuario_multa CHAR(10),
	PRIMARY KEY (codigo_multa),
	FOREIGN KEY (codigo_usuario_multa) REFERENCES usuario(codigo_usuario));

-- Empleado
CREATE TABLE empleado (
	identificacion_empleado CHAR(10),
	nombre_empleado VARCHAR(100),
	cargo_empleado VARCHAR(100),
	contrasenya_empleado VARCHAR(10),
	PRIMARY KEY (identificacion_empleado));

-- Prestamo de libro
CREATE SEQUENCE secuencia_de_prestamo
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
	
CREATE TABLE prestamo_de_libro (
	numero_consecutivo_prestamo INTEGER DEFAULT nextval('secuencia_de_prestamo'::regclass),
	codigo_usuario_prestamo CHAR(10),
	identificacion_empleado_prestamo CHAR(10),
	isbn_libro_ejemplar_prestamo CHAR(13),
	numero_ejemplar_prestamo VARCHAR(3),
	fecha_de_realizacion_prestamo DATE,
	descripcion_prestamo VARCHAR(500),
	fecha_de_devolucion_prestamo DATE,
	PRIMARY KEY (numero_consecutivo_prestamo),
	FOREIGN KEY (codigo_usuario_prestamo) REFERENCES usuario(codigo_usuario),
	FOREIGN KEY (identificacion_empleado_prestamo) REFERENCES empleado(identificacion_empleado),
	FOREIGN KEY (isbn_libro_ejemplar_prestamo, numero_ejemplar_prestamo) REFERENCES libro_fisico(isbn_libro_ejemplar, numero_ejemplar));

-- Descarga de libro
CREATE TABLE descarga_de_libro (
	ip_descarga CHAR(14),
	codigo_usuario_descarga CHAR(10),
	isbn_libro_digital_descarga CHAR(13),
	fecha_descarga DATE,
	hora_deacarga TIME,
	PRIMARY KEY (ip_descarga),
	FOREIGN KEY (codigo_usuario_descarga) REFERENCES usuario(codigo_usuario));/*,
	FOREIGN KEY (isbn_libro_digital_descarga) REFERENCES libro_digital(isbn_libro_digital));*/

-- Solicitud de libro
CREATE SEQUENCE secuencia_de_solicitud
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
	
CREATE TABLE solicitud_de_libro (
	numero_consecutivo_solicitud INTEGER DEFAULT nextval('secuencia_de_solicitud'::regclass),
	isbn_libro_solicitud CHAR(13),
	codigo_usuario_solicitud CHAR(10),
	identificacion_empleado_solicitud CHAR(10),
	fecha_solicitud DATE,
	descripcion VARCHAR(500),
	PRIMARY KEY (numero_consecutivo_solicitud),
	FOREIGN KEY (codigo_usuario_solicitud) REFERENCES usuario(codigo_usuario),
	FOREIGN KEY (identificacion_empleado_solicitud) REFERENCES empleado(identificacion_empleado));
	

-- REGISTROS

-- Area de conocimiento
INSERT INTO area_de_conocimiento (codigo_area_de_conocimiento, nombre_area_de_conocimiento, descripcion_area_de_conocimiento, codigo_area_padre)
VALUES 
	('001', 'Ciencias Naturales', 'Área de estudio de los fenómenos naturales', NULL),
	('002', 'Matemáticas', 'Área de estudio de las propiedades y relaciones de los números', NULL),
	('003', 'Física', 'Área de estudio de las propiedades de la materia y la energía', '001'),
	('004', 'Química', 'Área de estudio de la composición, estructura y propiedades de las sustancias', '001'),
	('005', 'Biología', 'Área de estudio de los seres vivos y sus procesos vitales', '001'),
	('006', 'Álgebra', 'Área de estudio de las estructuras y las relaciones matemáticas', '002'),
	('007', 'Geometría', 'Área de estudio de las formas, las figuras y las propiedades del espacio', '002'),
	('008', 'Análisis Matemático', 'Área de estudio de las funciones y el cálculo', '002'),
	('009', 'Termodinámica', 'Área de estudio de los procesos de transferencia de calor y energía', '003'),
	('010', 'Bioquímica', 'Área de estudio de las reacciones químicas en los seres vivos', '004');

-- Editorial
INSERT INTO editorial (codigo_editorial, nombre_editorial, pagina_web_editorial, pais_de_origen_editorial)
VALUES
	('001', 'Editorial ABC', 'www.editorialabc.com', 'España'),
	('002', 'Editorial XYZ', 'www.editorialxyz.com', 'México'),
	('003', 'Editorial DEF', 'www.editorialdef.com', 'Estados Unidos'),
	('004', 'Editorial GHI', 'www.editorialghi.com', 'Argentina'),
	('005', 'Editorial JKL', 'www.editorialjkl.com', 'Francia'),
	('006', 'Editorial MNO', 'www.editorialmno.com', 'Brasil'),
	('007', 'Editorial PQR', 'www.editorialpqr.com', 'Alemania'),
	('008', 'Editorial STU', 'www.editorialstu.com', 'Italia'),
	('009', 'Editorial VWX', 'www.editorialvwx.com', 'Canadá'),
	('010', 'Editorial YZ', 'www.editorialyz.com', 'Australia');

-- Libro
INSERT INTO libro (isbn_libro, titulo_libro, anyo_de_publicacion_libro, idioma_libro, numero_de_paginas_libro, codigo_area_de_conocimiento_libro, codigo_editorial_libro)
VALUES
	('9780141439579', '1984', '1949', 'Inglés', '328', '001', '001'),
	('9780061120084', 'To Kill a Mockingbird', '1960', 'Inglés', '324', '001', '002'),
	('9780307474278', 'The Alchemist', '1988', 'Inglés', '208', '002', '003'),
	('9780307277675', 'The Catcher in the Rye', '1951', 'Inglés', '224', '001', '002'),
	('9780743273565', 'The Great Gatsby', '1925', 'Inglés', '180', '001', '004'),
	('9780060256654', 'Where the Wild Things Are', '1963', 'Inglés', '48', '003', '005'),
	('9780439708180', 'Harry Potter and the Sorcerer´s Stone', '1997', 'Inglés', '309', '001', '006'),
	('9780060935467', 'To the Lighthouse', '1927', 'Inglés', '209', '001', '007'),
	('9780140283334', 'The Little Prince', '1943', 'Francés', '96', '001', '008'),
	('9788408166763', 'Cien años de soledad', '1967', 'Español', '471', '001', '009');

-- Libro fisico (ejemplar)
INSERT INTO libro_fisico (isbn_libro_ejemplar, numero_ejemplar, sala_ejemplar, pasillo_ejemplar, estante_ejemplar, cajon_ejemplar)
VALUES
	('9780141439579', '001', 'Sala A', 'Pasillo 1', 'Estante 2', 'Cajón 3'),
	('9780061120084', '002', 'Sala B', 'Pasillo 2', 'Estante 1', 'Cajón 2'),
	('9780061120084', '003', 'Sala B', 'Pasillo 2', 'Estante 1', 'Cajón 2'),
	('9780307474278', '003', 'Sala C', 'Pasillo 3', 'Estante 3', 'Cajón 1'),
	('9780307277675', '004', 'Sala A', 'Pasillo 1', 'Estante 2', 'Cajón 2'),
	('9780743273565', '005', 'Sala B', 'Pasillo 2', 'Estante 1', 'Cajón 1'),
	('9780060256654', '006', 'Sala C', 'Pasillo 3', 'Estante 3', 'Cajón 2'),
	('9780439708180', '007', 'Sala A', 'Pasillo 1', 'Estante 2', 'Cajón 3'),
	('9780060935467', '008', 'Sala B', 'Pasillo 2', 'Estante 1', 'Cajón 2'),
	('9780140283334', '009', 'Sala C', 'Pasillo 3', 'Estante 3', 'Cajón 1'),
	('9788408166763', '010', 'Sala A', 'Pasillo 1', 'Estante 2', 'Cajón 1');

-- Libro digital
INSERT INTO libro_digital (isbn_libro_digital, url_libro_digital, formato_libro_digital, tamanyo_libro_digital)
VALUES
	('9780141439579', 'http://www.ejemplo.com/libro1.pdf', 'PDF', '2.5 MB'),
	('9780061120084', 'http://www.ejemplo.com/libro2.epub', 'ePub', '1.8 MB'),
	('9780307474278', 'http://www.ejemplo.com/libro3.mobi', 'MOBI', '1.2 MB'),
	('9780307277675', 'http://www.ejemplo.com/libro4.pdf', 'PDF', '3.1 MB'),
	('9780743273565', 'http://www.ejemplo.com/libro5.epub', 'ePub', '2.9 MB'),
	('9780060256654', 'http://www.ejemplo.com/libro6.mobi', 'MOBI', '1.5 MB'),
	('9780439708180', 'http://www.ejemplo.com/libro7.pdf', 'PDF', '2.7 MB'),
	('9780060935467', 'http://www.ejemplo.com/libro8.epub', 'ePub', '2.2 MB'),
	('9780140283334', 'http://www.ejemplo.com/libro9.mobi', 'MOBI', '1.9 MB'),
	('9788408166763', 'http://www.ejemplo.com/libro10.pdf', 'PDF', '2.4 MB');

-- Autor
INSERT INTO autor (codigo_autor, primer_nombre_autor, segundo_nombre_autor, primer_apellido_autor, segundo_apellido_autor)
VALUES
	('001', 'Juan', 'Carlos', 'García', 'Pérez'),
	('002', 'María', 'Elena', 'López', 'Hernández'),
	('003', 'Pedro', NULL, 'Rodríguez', 'Gómez'),
	('004', 'Ana', 'Isabel', 'Martínez', 'Sánchez'),
	('005', 'Luis', 'Miguel', 'Flores', 'Romero'),
	('006', 'Laura', 'Patricia', 'González', 'Ramírez'),
	('007', 'Carlos', NULL, 'Vargas', 'Mendoza'),
	('008', 'Sofía', 'Alejandra', 'Torres', 'Cortés'),
	('009', 'Javier', 'Ignacio', 'Herrera', 'Silva'),
	('010', 'Paula', 'Gabriela', 'Rojas', 'Molina');

-- Libros y autores
INSERT INTO libros_y_autores (codigo_autor_lya, isbn_libro_lya)
VALUES
	('001', '9780141439579'),
	('002', '9780061120084'),
	('003', '9780307474278'),
	('004', '9780307277675'),
	('005', '9780743273565'),
	('006', '9780060256654'),
	('007', '9780439708180'),
	('008', '9780060935467'),
	('009', '9780140283334'),
	('010', '9788408166763');

-- Usuario
INSERT INTO usuario (codigo_usuario, nombre_usuario, direccion_usuario, telefono_usuario, e_mail_usuario, contrasenya_usuario)
VALUES
	('U00001', 'Juan Pérez', 'Calle 123, Ciudad', '1234567890', 'juan@example.com', '1'),
	('U00002', 'María López', 'Avenida 456, Ciudad', '9876543210', 'maria@example.com', '22222'),
	('U00003', 'Pedro Rodríguez', 'Plaza 789, Ciudad', '5678901234', 'pedro@example.com', '33333'),
	('U00004', 'Ana Sánchez', 'Carrera 321, Ciudad', '4321098765', 'ana@example.com', '44444'),
	('U00005', 'Luis Romero', 'Camino 654, Ciudad', '9012345678', 'luis@example.com', '55555'),
	('U00006', 'Laura González', 'Paseo 987, Ciudad', '3456789012', 'laura@example.com', '66666'),
	('U00007', 'Carlos Vargas', 'Callejón 234, Ciudad', '6789012345', 'carlos@example.com', '77777'),
	('U00008', 'Sofía Torres', 'Avenida 567, Ciudad', '1234509876', 'sofia@example.com', '88888'),
	('U00009', 'Javier Herrera', 'Plaza 890, Ciudad', '9876512340', 'javier@example.com', '99999'),
	('U00010', 'Paula Rojas', 'Carrera 432, Ciudad', '5678904321', 'paula@example.com', '1010101010'),
	('U00011', 'Miguel Gómez', 'Calle 456, Ciudad', '1234567890', 'miguel@example.com', '1111111111'),
	('U00012', 'Andrea López', 'Avenida 789, Ciudad', '9876543210', 'andrea@example.com', '1212121212'),
	('U00013', 'David Martínez', 'Plaza 123, Ciudad', '5678901234', 'david@example.com', '1313131313'),
	('U00014', 'Carolina Sánchez', 'Carrera 654, Ciudad', '4321098765', 'carolina@example.com', '1414141414'),
	('U00015', 'Gabriel Romero', 'Camino 987, Ciudad', '9012345678', 'gabriel@example.com', '1515151515'),
	('U00016', 'Valeria González', 'Paseo 234, Ciudad', '3456789012', 'valeria@example.com', '1616161616'),
	('U00017', 'Luisa Vargas', 'Callejón 567, Ciudad', '6789012345', 'luisa@example.com', '1717171717'),
	('U00018', 'Daniel Torres', 'Avenida 890, Ciudad', '1234509876', 'daniel@example.com', '1818181818'),
	('U00019', 'Camila Herrera', 'Plaza 432, Ciudad', '9876512340', 'camila@example.com', '1919191919'),
	('U00020', 'Roberto Rojas', 'Carrera 789, Ciudad', '5678904321', 'roberto@example.com', '2020202020');

-- Estudiante
INSERT INTO estudiante (codigo_usuario_estudiante, universidad_estudiante, carrera_estudiante)  
VALUES
	('U00007', 'Universidad Nacional de Colombia', 'Ingeniería de Sistemas'),
	('U00018', 'Universidad de los Andes', 'Medicina'),
	('U00009', 'Universidad de Antioquia', 'Administración de Empresas'),
	('U00006', 'Universidad del Rosario', 'Derecho'),
	('U00005', 'Universidad de Medellín', 'Psicología'),
	('U00013', 'Universidad del Valle', 'Ingeniería Industrial'),
	('U00001', 'Universidad de Bogotá Jorge Tadeo Lozano', 'Comunicación Social'),
	('U00016', 'Pontificia Universidad Javeriana', 'Arquitectura'),
	('U00019', 'Universidad EAFIT', 'Economía'),
	('U00008', 'Universidad de Caldas', 'Enfermería');

-- Profesor
INSERT INTO Profesor (codigo_usuario_profesor, titulo_profesor, dependencia_profesor)  
VALUES
	('U00011', 'Doctor en Física', 'Departamento de Física'),
	('U00014', 'Doctora en Química', 'Departamento de Química'),
	('U00010', 'Máster en Administración de Empresas', 'Departamento de Administración'),
	('U00015', 'Doctor en Biología', 'Departamento de Biología'),
	('U00003', 'Doctor en Ingeniería Civil', 'Departamento de Ingeniería Civil'),
	('U00017', 'Doctora en Psicología', 'Departamento de Psicología'),
	('U00012', 'Doctora en Economía', 'Departamento de Economía'),
	('U00004', 'Máster en Derecho', 'Departamento de Derecho'),
	('U00020', 'Doctor en Medicina', 'Departamento de Medicina'),
	('U00002', 'Máster en Educación', 'Departamento de Educación');

-- Area de interes
INSERT INTO area_de_interes (codigo_area_de_interes, nombre_area_de_interes)
VALUES
	('A00001', 'Biología'),
	('A00002', 'Educación'),
	('A00003', 'Medicina'),
	('A00004', 'Física'),
	('A00005', 'Economía'),
	('A00006', 'Administración'),
	('A00007', 'Ingeniería Civil'),
	('A00008', 'Psicología'),
	('A00009', 'Derecho'),
	('A00010', 'Química');

-- Profesores y areas
INSERT INTO profesores_y_areas( codigo_usuario_profesor_pya, codigo_area_de_interes_pya)
VALUES
	('U00015', 'A00001'),
	('U00014', 'A00010'),
	('U00003', 'A00001'),
	('U00004', 'A00008'),
	('U00011', 'A00004'),
	('U00020', 'A00003'),
	('U00014', 'A00009'),
	('U00012', 'A00005'),
	('U00002', 'A00002'),
	('U00002', 'A00007');

-- Multa
INSERT INTO multa (codigo_multa, fecha_multa, valor_multa, descripcion_multa, codigo_usuario_multa)
VALUES
	('M00001', '2009-12-21', '5828400', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN:  ', 'U00009'),
	('M00002', '2020-03-30', '938400', 'Entrega de libro dañado o en mal estado. Se cobra multa de 1200 pesos diarios hasta la reposición del libro con ISBN: 9780061120084 ', 'U00009'),
	('M00003', '2009-10-08', '5761200', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN: 9780307474278 ', 'U00003'),
	('M00004', '2022-02-05', '564000', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN: 9780307277675 ', 'U00020'),
	('M00005', '2011-11-12', '5122800', 'Entrega de libro dañado o en mal estado. Se cobra multa de 1200 pesos diarios hasta la reposición del libro con ISBN: 9780743273565 ', 'U00015'),
	('M00006', '2018-08-06', '1207200', 'Entrega de libro dañado o en mal estado. Se cobra multa de 1200 pesos diarios hasta la reposición del libro con ISBN: 9780060256654 ', 'U00004'),
	('M00007', '2007-12-26', '6619200', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN: 9780439708180 ', 'U00001'),
	('M00008', '2023-03-22', '72000', 'Entrega de libro dañado o en mal estado. Se cobra multa de 1200 pesos diarios hasta la reposición del libro con ISBN: 9788408166763 ', 'U00010'),
	('M00009', '2023-05-21', '1200', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN: 9780060935467 ', 'U00006'),
	('M00010', '2014-07-24', '3417600 ', 'Tiempo de entrega del libro agotada. Se cobra multa de 1200 pesos diarios hasta la devolución o reposición del libro con ISBN: 9780140283334 ', 'U00008');

-- Empleado
INSERT INTO empleado (identificacion_empleado, nombre_empleado, cargo_empleado, contrasenya_empleado)
VALUES
	('1', 'Andres Zuluaga', 'Administrador', '1'),
	('3659863', 'Juan Vargas', 'Responsable de Sala', '22222'),
	('1003985632', 'Felipe Gutierrez', 'Bibliotecario', '33333'),
	('11589663', 'Jhon Alvarez', 'Secretario', '44444'),
	('8596325', 'Camilo Vargas', 'Encargado de Prestamos', '55555'),
	('10059862', 'Sara Medina', 'Encargado de Prestamos', '66666'),
	('1004563144', 'Abel Angels', 'Responsable de Sala', '77777'),
	('38596325', 'William Shall', 'Administrador', '88888'),
	('1005981683', 'Catalina Bolanos', 'Encargado de Prestamos', '99999'),
	('11801779', 'Alma Smith', 'Responsable de Sala', '1010101010');

-- Prestamo de libro
INSERT INTO prestamo_de_libro (codigo_usuario_prestamo, identificacion_empleado_prestamo, isbn_libro_ejemplar_prestamo,numero_ejemplar_prestamo, fecha_de_realizacion_prestamo, descripcion_prestamo, fecha_de_devolucion_prestamo)
VALUES
	( 'U00009', '8596325' ,'9780061120084' , '002','2009-10-21' ,'Libro en buen estado' , '2009-12-21'),
	( 'U00009', '8596325' ,'9780061120084' , '003','2020-01-30' ,'Libro en buen estado' , '2020-03-30'),
	( 'U00003', '10059862','9780307474278' , '003','2009-08-08' ,'Libro en buen estado' ,'2009-10-08'), 
	( 'U00020', '8596325' ,'9780307277675' , '004','2021-12-05' ,'Libro en buen estado' , '2022-02-05'), 
	( 'U00015', '10059862','9780743273565' , '005','2011-09-12' ,'Libro en buen estado' , '2011-11-12'),
	( 'U00004', '8596325' ,'9780060256654' , '006','2018-06-06' ,'Libro en buen estado' , '2018-08-06'),
	( 'U00001', '10059862','9780439708180' , '007','2007-10-26' ,'Libro en buen estado' , '2007-12-26'),
	( 'U00010', '8596325' ,'9788408166763' , '010','2023-01-22' ,'Libro en buen estado' , '2023-03-22'),
	( 'U00006', '10059862','9780060935467' , '008','2023-03-21' ,'Libro en buen estado' , '2023-05-21'),
	( 'U00008', '8596325' ,'9780140283334' , '009','2014-05-24' ,'Libro en buen estado' , '2014-07-24');
  
  
-- Descarga de libro
INSERT INTO descarga_de_libro (ip_descarga, codigo_usuario_descarga, isbn_libro_digital_descarga, fecha_descarga, hora_deacarga)
VALUES
	('192.168.0.1'  , 'U00009' , '9780141439579' ,'2021-01-02' , '10:05:00' ),
	('192.168.0.11' , 'U00009' , '9780061120084' ,'2022-03-06' , '11:05:00' ),
	('192.168.0.12' , 'U00003' , '9780307474278' ,'2021-05-03' , '12:05:00' ),
	('192.168.0.15' , 'U00020' , '9780307277675' ,'2022-05-06' , '10:05:00' ),
	('192.168.0.10' , 'U00015' , '9780743273565' ,'2021-02-03' , '11:05:00' ),
	('192.168.0.2'  , 'U00004' , '9780060256654' ,'2021-07-03' , '12:05:00' ),
	('192.168.0.16' , 'U00001' , '9780439708180' ,'2022-08-03' , '13:05:00' ),
	('192.168.0.13' , 'U00010' , '9780060935467' ,'2021-09-03' , '14:05:00' ),
	('192.168.0.14' , 'U00006' , '9780140283334' ,'2023-02-08' , '14:05:00' ),
	('192.168.0.17' , 'U00008' , '9788408166763' ,'2023-02-12' , '13:05:00' );

-- Solicitud de libro
INSERT INTO  solicitud_de_libro  (isbn_libro_solicitud, codigo_usuario_solicitud, identificacion_empleado_solicitud, fecha_solicitud, descripcion ) 
VALUES
	( '9780133507645' ,'U00009' , '8596325' , '2021-01-02' ,'Organizational Behavior' ),
	( '9781118477700' ,'U00009' , '8596325' , '2022-03-06' ,'Materials Science and Engineering : An Introduction' ),
	( '9780321836960' ,'U00003' , '10059862', '2021-05-03' ,'Elementary Statistics' ),
	( '9781118539712' ,'U00020' , '8596325' , '2022-05-06' ,'Applied Statistics and Probability for Engineers' ),
	( '9780078024290' ,'U00015' , '10059862', '2021-02-03' ,'Hole''s Human Anatomy and Physiology' ),
	( '9781435488182' ,'U00004' , '8596325' , '2021-07-03' ,'Shortell and Kaluzny''s Healthcare Management: Organization Design and Behavior' ),
	( '9780077537104' ,'U00001' , '10059862', '2022-08-03' ,'Loose-Leaf Crafting and Executing Strategy: the Quest for Competitive Advantage: Concepts' ),
	( '9780077596101' ,'U00010' , '8596325' , '2021-09-03' ,'Loose Leaf Version for Human Biology' ),
	( '9780133050691' ,'U00006' , '10059862', '2023-02-08' ,'Management Information Systems' ),
	( '9780073398068' ,'U00008' , '8596325' , '2023-02-12' ,'System Dynamics' );

