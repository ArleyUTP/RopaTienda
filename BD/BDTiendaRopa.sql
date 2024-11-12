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
CREATE TABLE UsuariosRecordados (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
    fecha_recordado DATETIME2 DEFAULT GETDATE(),
    UNIQUE (usuario_id)  -- Para evitar duplicados
);

CREATE TABLE Tallas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(10) UNIQUE CHECK (nombre IN ('S', 'M', 'L', 'XL','XXL'))
);
--PROCEDIMIENTO ALMACENDADO QUE ME PERMITE RECUPERAR TODAS TALLAS
CREATE PROCEDURE ObtenerTodasLasTallas
AS
BEGIN
	SELECT * FROM Tallas
	ORDER BY id;
END
EXEC ObtenerTodasLasTallas
INSERT INTO Tallas(nombre)
VALUES ('S'),('M'),('L'),('XL'),('XXL');
CREATE TABLE Categorias (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);
INSERT INTO Categorias (nombre) VALUES 
('Camisetas'),
('Pantalones'),
('Chaquetas'),
('Vestidos'),
('Faldas'),
('Abrigos'),
('Ropa Interior'),
('Accesorios'),
('Zapatos'),
('Ropa de Deporte');
SELECT * FROM Categorias;
--PROCEDIMEINTO PARA OBTENER TODAS LAS CATEGORIAS
CREATE PROCEDURE SP_ObtenerTodasLasCategorias
AS
BEGIN
	SELECT * FROM Categorias
	ORDER BY id;
END
EXEC SP_ObtenerTodasLasCategorias
CREATE TABLE Generos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(20) UNIQUE CHECK (nombre IN ('Hombre', 'Niño', 'Mujer', 'Niña'))
);

INSERT INTO Generos VALUES ('Hombre'),('Niño'),('Mujer'),('Niña');
--PROCEDIMIENTO PARA OBTENR TODAS LOS GENEROS
CREATE PROCEDURE SP_ObtenerTodosLosGeneros
AS
BEGIN
	SELECT * FROM Generos
	ORDER BY id;
END
CREATE TABLE Marcas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);
INSERT INTO Marcas (nombre) VALUES 
('Gamarra Fashion'),
('Moda Lima'),
('Estilo Urbano'),
('Ropa Chic'),
('Tendencias Gamarra'),
('Diseños Peruanos'),
('Textiles del Perú'),
('Gamarra Style'),
('Prendas Únicas'),
('Cultura Textil');
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
    fecha_caducidad_promocion DATE,
	foto NVARCHAR(MAX)
);
CREATE TABLE Fotos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    url NVARCHAR(MAX) -- Almacena la URL o la ruta de la imagen
);

CREATE TABLE Carritos(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
	fecha_creacion DATETIME2 DEFAULT GETDATE(),
	estado NVARCHAR(20) CHECK(estado IN ('activo','inactivo'))
);

CREATE TABLE DetalleCarrito(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	carrito_id BIGINT FOREIGN KEY REFERENCES Carritos(id),
	producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
	cantidad INT CHECK (cantidad>0),
	precio_unitario DECIMAL(18,2) CHECK (precio_unitario >=0)
);
CREATE TABLE Pedidos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
    fecha DATETIME2 DEFAULT GETDATE(),
    metodo_pago NVARCHAR(50),
	codigo_orden NVARCHAR(50) UNIQUE,
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
CREATE PROCEDURE InsertarUsuarioRecordado
    @usuario NVARCHAR(50)
AS
BEGIN
    DECLARE @usuarioId BIGINT;

    -- Obtener el ID del usuario a partir del nombre de usuario
    SELECT @usuarioId = id
    FROM Usuarios
    WHERE usuario = @usuario;

    -- Verificar si se encontró un usuario
    IF @usuarioId IS NOT NULL
    BEGIN
        -- Insertar en UsuariosRecordados
        INSERT INTO UsuariosRecordados (usuario_id)
        VALUES (@usuarioId);
    END
    ELSE
    BEGIN
        -- Manejo de errores si no se encuentra el usuario
        RAISERROR('Usuario no encontrado', 16, 1);
    END
END;

--PROCEDIMIENTO ALMACENDAO QUE PERMITE EL RECUPERAR LOS USUARIOS RECORDADOS
CREATE PROC ObtenerUsuariosRecordados
AS
BEGIN
	SELECT U.usuario
	FROM UsuariosRecordados UR
	INNER JOIN Usuarios U ON UR.usuario_id=U.id
END
--PROCEDIMIENTO ALMACENADO QUE PERMITE EL ELIMINAR UN USUARIO RECORDADO
CREATE PROC EliminarUsuarioRecordado
@usuario NVARCHAR(50)
AS
BEGIN
	DECLARE @usuarioID BIGINT;
	-- Obtener el ID del usuario a partir del nombre de usuario
	SELECT @usuarioID = id
	FROM Usuarios
	WHERE usuario = @usuario
	-- Verificar si se encontró un usuario
    IF @usuarioId IS NOT NULL
	BEGIN
		DELETE FROM UsuariosRecordados
		WHERE id = @usuarioID;
	END
	ELSE
	BEGIN
		-- Manejo de errores si no se encuentra el usuario
        RAISERROR('Usuario no encontrado', 16, 1);
	END
END;
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

--PROCEDIMIENTO ALMACENADO QUE ME PERMITE INGRESAR UN USUARIO PARA RECORDAR USUARIO
CREATE PROC InsertarUsuarioRecordado
@usuario NVARCHAR(50)
AS
BEGIN
	INSERT INTO UsuariosRecordados (usuario_id)
	VALUES (SELECT id
			FROM Usuarios
			WHERE usuario = @usuario)
END


EXEC VerificarAdmin 'juanp','claveSegura123'
INSERT INTO Usuarios (nombre, apellido, dni, correo, usuario, clave, estado, rol, fecha_nacimiento, foto)
VALUES ('Juan', 'Pérez', '12345678', 'juan.perez@example.com', 'juanp', 'claveSegura123', 'activo', 'admin', '1985-05-15', NULL);

--PROCEDIMIENTO ALMACENADO PARA CREAR UN USUARIO:

CREATE PROCEDURE CrearUsuario 
    @nombre NVARCHAR(MAX),
    @apellido NVARCHAR(MAX),
    @dni NVARCHAR(50),
    @correo NVARCHAR(255),
    @usuario NVARCHAR(50),
    @clave NVARCHAR(255),
    @estado NVARCHAR(20),
    @rol NVARCHAR(20),
    @fecha_nacimiento DATE,
    @foto NVARCHAR(MAX)
AS
BEGIN
    BEGIN TRY
        INSERT INTO Usuarios (
            nombre, 
            apellido, 
            dni, 
            correo, 
            usuario, 
            clave, 
            estado, 
            rol, 
            fecha_nacimiento, 
            foto
        ) VALUES (
            @nombre, 
            @apellido, 
            @dni, 
            @correo, 
            @usuario, 
            @clave, 
            @estado, 
            @rol, 
            @fecha_nacimiento, 
            @foto
        );
        
        -- Mensaje opcional de confirmación
        PRINT 'Usuario creado exitosamente';
    END TRY
    BEGIN CATCH
        -- Manejo de errores
        DECLARE @ErrorMessage NVARCHAR(4000);
        DECLARE @ErrorSeverity INT;
        DECLARE @ErrorState INT;

        SELECT 
            @ErrorMessage = ERROR_MESSAGE(),
            @ErrorSeverity = ERROR_SEVERITY(),
            @ErrorState = ERROR_STATE();

        RAISERROR (@ErrorMessage, @ErrorSeverity, @ErrorState);
    END CATCH
END;
SELECT * FROM Usuarios;
DELETE FROM Usuarios
WHERE id = 10008;
--Fucion para generar nombre se usuario:
CREATE FUNCTION dbo.GenerarUsuario
(
	@nombre NVARCHAR(50),
	@apellido NVARCHAR(50),
	@dni NVARCHAR(50)
)
RETURNS NVARCHAR(50)
AS
BEGIN
	DECLARE @usuarioGenerado NVARCHAR(50);
	SET @usuarioGenerado = LOWER(@nombre+LEFT(@apellido,1)+RIGHT(@dni,2));
	RETURN @usuarioGenerado;
END;
PRINT dbo.GenerarUsuario('Arley','Ticse','71451008')

--PROCEDIMIENTO QUE GENERA EL USUARIO USANDO LA FUNCION Y HACE LA COMPARACION DE QUE ES UNICO
CREATE PROC GenerarUsuarioUnico
    @nombre NVARCHAR(50),
    @apellido NVARCHAR(50),
    @dni NVARCHAR(50),
    @usuarioGenerado NVARCHAR(50) OUTPUT
AS
BEGIN
	DECLARE @usuarioBase NVARCHAR(50) = dbo.GenerarUsuario(@nombre, @apellido, @dni);
	DECLARE @Contador INT = 1;

	--Verificar si existe
	WHILE EXISTS(SELECT 1 FROM Usuarios WHERE usuario = @usuarioBase)
	BEGIN
		SET @usuarioBase = dbo.GenerarUsuario(@nombre, @apellido, @dni) + CAST(@contador AS NVARCHAR(10));
        SET @contador = @contador + 1
	END
	--Asignar el usuario generado a la variable de salida
	SET @usuarioGenerado=@usuarioBase
END;

CREATE PROCEDURE ObtenerUsuarioPorId
    @Id BIGINT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        id,
        nombre,
        apellido,
        dni,
        correo,
        usuario,
        clave,
        estado,
        rol,
        fecha_nacimiento,
        foto,
        fecha_creacion
    FROM Usuarios
    WHERE id = @Id;
END;
CREATE PROCEDURE ActualizarUsuario
    @Id BIGINT,
    @Nombre NVARCHAR(MAX),
    @Apellido NVARCHAR(MAX),
    @DNI NVARCHAR(50),
    @Correo NVARCHAR(255),
    @Usuario NVARCHAR(50),
    @Clave NVARCHAR(255),
    @Estado NVARCHAR(20),
    @Rol NVARCHAR(20),
    @FechaNacimiento DATE,
    @Foto NVARCHAR(MAX)
AS
BEGIN
    UPDATE Usuarios
    SET 
        nombre = @Nombre,
        apellido = @Apellido,
        dni = @DNI,
        correo = @Correo,
        usuario = @Usuario,
        clave = @Clave,
        estado = @Estado,
        rol = @Rol,
        fecha_nacimiento = @FechaNacimiento,
        foto = @Foto
    WHERE 
	id = @Id;
END;
CREATE PROCEDURE ObtenerTodosLosUsuarios
AS
BEGIN
    SELECT 
        id,
        nombre,
        apellido,
        dni,
        correo,
        usuario,
        estado,
        rol,
        fecha_nacimiento,
        foto,
        fecha_creacion
    FROM Usuarios;
END;
SELECT * FROM Usuarios;

UPDATE Usuarios
SET nombre = 'Jomina'
WHERE id = 3

CREATE PROCEDURE BuscarUsuario
@Caracteres NVARCHAR(100)
AS
BEGIN
	SELECT * FROM Usuarios
	WHERE apellido LIKE '%'+@Caracteres+'%';
END
GO
EXEC BuscarUsuario ''