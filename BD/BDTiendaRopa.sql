--CREAR BASE DE DATOS TiendaDeRopas
CREATE DATABASE TiendaDeRopas;
USE TiendaDeRopas;
--CREACION DE LA TABLA Usuarios
CREATE TABLE Usuarios (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(MAX),
    apellido NVARCHAR(MAX),
    dni NVARCHAR(50),
    correo NVARCHAR(255) UNIQUE,
    usuario NVARCHAR(50) UNIQUE,
    clave NVARCHAR(255),
    estado NVARCHAR(20) CHECK (estado IN ('activo', 'inactivo')),
    rol NVARCHAR(20) CHECK (rol IN ('admin', 'vendedor')),
    fecha_nacimiento DATE,
    foto NVARCHAR(MAX),
    fecha_creacion DATETIME2 DEFAULT GETDATE()
);

CREATE TABLE Tallas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(10) UNIQUE CHECK (nombre IN ('S', 'M', 'L', 'XL'))
);

CREATE TABLE Categorias (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);

CREATE TABLE Generos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(20) UNIQUE CHECK (nombre IN ('hombre', 'niño', 'mujer', 'niña'))
);

CREATE TABLE Marcas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);

CREATE TABLE Productos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    codigo NVARCHAR(50) UNIQUE,
    nombre NVARCHAR(MAX),
    categoria_id BIGINT FOREIGN KEY REFERENCES Categorias(id),
    talla_id BIGINT FOREIGN KEY REFERENCES Tallas(id),
    genero_id BIGINT FOREIGN KEY REFERENCES Generos(id),
    marca_id BIGINT FOREIGN KEY REFERENCES Marcas(id),
    stock INT CHECK (stock >= 0),
    stockMinimo INT CHECK (stockMinimo >= 0),
    precio_compra DECIMAL(18, 2),
    precio_venta DECIMAL(18, 2),
    estado_promocion BIT,
    fecha_caducidad_promocion DATE
);

CREATE TABLE Pedidos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
    fecha DATETIME2 DEFAULT GETDATE(),
    metodo_pago NVARCHAR(50),
    total DECIMAL(18, 2) CHECK (total >= 0)
);

CREATE TABLE DetallePedido (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    pedido_id BIGINT FOREIGN KEY REFERENCES Pedidos(id),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    cantidad INT CHECK (cantidad > 0),
    precio_unitario DECIMAL(18, 2) CHECK (precio_unitario >= 0)
);

CREATE TABLE Facturas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    pedido_id BIGINT FOREIGN KEY REFERENCES Pedidos(id),
    fecha DATETIME2 DEFAULT GETDATE(),
    detalles NVARCHAR(MAX)
);

CREATE TABLE Ventas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    fecha DATE,
    total DECIMAL(18, 2) CHECK (total >= 0),
    metodo_pago NVARCHAR(50)
);

CREATE TABLE Configuraciones (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    limite_uso_dias INT CHECK (limite_uso_dias > 0),
    max_dispositivos INT CHECK (max_dispositivos > 0)
);

CREATE TABLE Promociones (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    descripcion NVARCHAR(MAX),
    fecha_inicio DATE,
    fecha_fin DATE
);
--PROCEMIENTO ALMACENADO QUE ME PERMITE VERFICAR SI ES UN ADMINISTRADOR A PARTIR DE
--EL USUARIO Y LA CONTRASEÑA
CREATE PROC VerificarAdmin
@usuario NVARCHAR(50),
@clave NVARCHAR(255)
AS
BEGIN
	SELECT rol FROM Usuarios
	WHERE usuario = @usuario AND clave = @clave;
END
--PROCEDIMIENTO ALMACENADO QUE PERMITE VALIDAR EL INGREDO DE DATOS EN EL LOGIN Y ME PERMITE CAPTURAR DATOS DEL
--USUARIO ACTUAL
CREATE PROC validarCredenciales
@Usuario NVARCHAR(50),
@Clave NVARCHAR(255)
AS
BEGIN
	SELECT id,nombre,apellido,estado,rol
	FROM Usuarios
	WHERE usuario = @Usuario
		AND clave = @Clave
		AND estado = 'activo';
END;




EXEC VerificarAdmin 'juanp','claveSegura123'
INSERT INTO Usuarios (nombre, apellido, dni, correo, usuario, clave, estado, rol, fecha_nacimiento, foto)
VALUES ('Juan', 'Pérez', '12345678', 'juan.perez@example.com', 'juanp', 'claveSegura123', 'activo', 'admin', '1985-05-15', NULL);