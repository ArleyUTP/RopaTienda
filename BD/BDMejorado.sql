CREATE DATABASE TiendaGamarra;
USE TiendaGamarra;
USE TiendaDeRopas;
SELECT * FROM Usuarios;
DELETE FROM Usuarios
WHERE id = 2;
-------------------------------------------USUARIOS----------------------------------------------------
CREATE TABLE Usuarios (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(MAX) NOT NULL,
    apellido NVARCHAR(MAX) NOT NULL,
    dni NVARCHAR(50) UNIQUE NOT NULL,
    correo NVARCHAR(255) UNIQUE NOT NULL,
    usuario NVARCHAR(50) UNIQUE NOT NULL,
    clave NVARCHAR(255) NOT NULL,
    estado NVARCHAR(20) CHECK (estado IN ('activo', 'inactivo')) NOT NULL,
    rol NVARCHAR(20) CHECK (rol IN ('admin', 'vendedor')) NOT NULL,
    fecha_nacimiento DATE CHECK(fecha_nacimiento < GETDATE()) NOT NULL,
    foto VARBINARY(MAX),
    fecha_creacion DATETIME2 DEFAULT GETDATE()
);
CREATE TABLE UsuariosRecordados (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
    fecha_recordado DATETIME2 DEFAULT GETDATE(),
    UNIQUE (usuario_id)  -- Para evitar duplicados
);
CREATE PROCEDURE SP_CrearUsuario 
    @nombre NVARCHAR(MAX),
    @apellido NVARCHAR(MAX),
    @dni NVARCHAR(50),
    @correo NVARCHAR(255),
    @usuario NVARCHAR(50),
    @clave NVARCHAR(255),
    @estado NVARCHAR(20),
    @rol NVARCHAR(20),
    @fecha_nacimiento DATE,
    @foto VARBINARY(MAX) -- Cambiar a VARBINARY
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
        
        PRINT 'Usuario creado exitosamente';
    END TRY
    BEGIN CATCH
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

CREATE PROCEDURE SP_EliminarUsuario
@id BIGINT
AS
BEGIN
	DELETE FROM Usuarios
	WHERE id = @id;
END;
SELECT * FROM Usuarios
INSERT INTO Usuarios (nombre,apellido,dni,correo,usuario,clave,estado,rol,fecha_nacimiento,foto)
VALUES ('Juan','Pérez','12345678','juan.perez@example.com','juanp','claveSegura123','activo','admin','1985-05-16',NULL),
('Juan','Marie','12334438','juan.pereexample.com','juandimal','vidaer45','activo','vendedor','1990-01-01',NULL),
('Jomina','Manani','76222323','jose@utp.edu.pe','josem23','Qu3?8Ln%','activo','vendedor','2024-01-01', NULL),
('Esperanza','Josema','83883838','josema@utp.edu.pe','esperanzaj38','PU2v+8?3','activo','vendedor','2024-01-01',NULL)
CREATE TABLE SP_UsuariosRecordados (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
    fecha_recordado DATETIME2 DEFAULT GETDATE(),
    UNIQUE (usuario_id)  -- Para evitar duplicados
);
INSERT INTO UsuariosRecordados (usuario_id)
VALUES(2)
CREATE PROCEDURE SP_InsertarUsuarioRecordado
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
CREATE PROCEDURE SP_ObtenerUsuariosRecordados
AS
BEGIN
	SELECT U.usuario
	FROM UsuariosRecordados UR
	INNER JOIN Usuarios U ON UR.usuario_id=U.id
END
--PROCEDIMIENTO ALMACENADO QUE PERMITE EL ELIMINAR UN USUARIO RECORDADO
ALTER PROC SP_EliminarUsuarioRecordado
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
		WHERE usuario_id = @usuarioID;
	END
	ELSE
	BEGIN
		-- Manejo de errores si no se encuentra el usuario
        RAISERROR('Usuario no encontrado', 16, 1);
	END
END;
--PROCEDIMIENTO ALMACENADO QUE PERMITE VALIDAR EL INGREDO DE DATOS EN EL LOGIN Y ME PERMITE CAPTURAR DATOS DEL
--USUARIO ACTUAL
CREATE PROC SP_validarCredenciales
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
CREATE PROCEDURE SP_InsertarUsuarioRecordado
@usuario NVARCHAR(50)
AS
BEGIN
	INSERT INTO UsuariosRecordados (usuario_id)
	VALUES (SELECT id
			FROM Usuarios
			WHERE usuario = @usuario)
END;
CREATE PROC SP_VerificarAdmin
@usuario NVARCHAR(50),
@clave NVARCHAR(255)
AS
BEGIN
	SELECT rol FROM Usuarios
	WHERE usuario = @usuario AND clave = @clave;
END
--GENERAR
--USUARIO
CREATE PROCEDURE SP_GenerarUsuarioUnico
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
CREATE FUNCTION SP_GenerarUsuario
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
--PASSWORD

------------------------------------------PRODUCTOS-----------------------------------------------------
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

CREATE TABLE Tallas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(10) UNIQUE CHECK (nombre IN ('S', 'M', 'L', 'XL','XXL'))
);

INSERT INTO Tallas(nombre)
VALUES ('S'),('M'),('L'),('XL'),('XXL');

CREATE TABLE ProductosTallas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    talla_id BIGINT FOREIGN KEY REFERENCES Tallas(id),
    cantidad INT CHECK (cantidad >= 0),
    UNIQUE (producto_id, talla_id)
);
CREATE TABLE Generos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(20) UNIQUE CHECK (nombre IN ('Hombre', 'Niño', 'Mujer', 'Niña'))
);
INSERT INTO Generos VALUES ('Hombre'),('Niño'),('Mujer'),('Niña');
CREATE TABLE ProductosGeneros (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    genero_id BIGINT FOREIGN KEY REFERENCES Generos(id),
    cantidad INT CHECK (cantidad >= 0),
    UNIQUE (producto_id, genero_id)
);
CREATE TABLE Marcas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE
);

CREATE TABLE ProductosMarcas (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    marca_id BIGINT FOREIGN KEY REFERENCES Marcas(id),
    cantidad INT CHECK (cantidad >= 0),
    UNIQUE (producto_id, marca_id)
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

CREATE TABLE Colores (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(50) UNIQUE,
	codigo_hexdecimal NVARCHAR(50)UNIQUE
);
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Rojo', '#FF0000');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Verde', '#00FF00');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Azul', '#0000FF');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Negro', '#000000');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Blanco', '#FFFFFF');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Amarillo', '#FFFF00');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Cyan', '#00FFFF');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Magenta', '#FF00FF');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Gris', '#808080');
INSERT INTO Colores (nombre, codigo_hexdecimal) VALUES ('Naranja', '#FFA500');
CREATE TABLE ProductosColores (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    color_id BIGINT FOREIGN KEY REFERENCES Colores(id),
    cantidad INT CHECK (cantidad >= 0),
    UNIQUE (producto_id, color_id)
);
CREATE TABLE Fotos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    producto_id BIGINT FOREIGN KEY REFERENCES Productos(id),
    url NVARCHAR(MAX) -- Almacena la URL o la ruta de la imagen
);

CREATE TABLE Productos (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    codigo NVARCHAR(50) UNIQUE,
    nombre NVARCHAR(MAX),
    categoria_id BIGINT FOREIGN KEY REFERENCES Categorias(id),
    stock INT CHECK (stock >= 0),
    stockMinimo INT CHECK (stockMinimo >= 0),
    precio_compra DECIMAL(18, 2),
    precio_venta DECIMAL(18, 2),
    estado_promocion BIT,
    fecha_caducidad_promocion DATE,
    foto NVARCHAR(MAX)
);
INSERT INTO Productos 
(codigo, nombre, categoria_id, stock, stockMinimo, precio_compra, precio_venta, estado_promocion, fecha_caducidad_promocion, foto)
VALUES
('PROD001', 'Camiseta Básica', 1, 100, 10, 20.50, 30.00, 0, NULL, 'C:\Users\user\Desktop\RopaTienda\src\main\resources\Perfiles\pexels-creationhill-1681010.png'),
('PROD002', 'Pantalón Casual', 2, 50, 5, 35.00, 50.00, 1, '2024-12-31', 'C:\Users\user\Desktop\RopaTienda\src\main\resources\Perfiles\pexels-creationhill-1681010.png'),
('PROD003', 'Chaqueta Ligera', 3, 20, 2, 60.00, 90.00, 0, NULL, 'C:\Users\user\Desktop\RopaTienda\src\main\resources\Perfiles\pexels-creationhill-1681010.png'),
('PROD004', 'Vestido Elegante', 4, 30, 3, 45.00, 70.00, 1, '2024-11-30', 'C:\Users\user\Desktop\RopaTienda\src\main\resources\Perfiles\pexels-creationhill-1681010.png'),
('PROD005', 'Falda Larga', 5, 25, 4, 25.00, 40.00, 0, NULL, 'C:\Users\user\Desktop\RopaTienda\src\main\resources\Perfiles\pexels-creationhill-1681010.png');
SELECT * FROM Productos
-------------------------------------PROCEDIMIENTO ALMACENDADOS----------------------------------------
--CATEGORIAS

CREATE PROCEDURE SP_InsertarCategoria
    @nombre NVARCHAR(50)
AS
BEGIN
    INSERT INTO Categorias (nombre)
    VALUES (@nombre);
END;

CREATE PROCEDURE SP_ObtenerTodasLasCategorias
AS
BEGIN
    SELECT * FROM Categorias ORDER BY id;
END;

CREATE PROCEDURE SP_ActualizarCategoria
    @id BIGINT,
    @nombre NVARCHAR(50)
AS
BEGIN
    UPDATE Categorias
    SET nombre = @nombre
    WHERE id = @id;
END;

CREATE PROCEDURE SP_EliminarCategoria
    @id BIGINT
AS
BEGIN
    DELETE FROM Categorias WHERE id = @id;
END;

CREATE PROCEDURE SP_OptenerCategoriaPorId
@id BIGINT
AS
BEGIN
	SELECT nombre
	FROM Categorias
	WHERE id = @id;
END;
--TALLAS

CREATE PROCEDURE SP_InsertarTalla
    @nombre NVARCHAR(10)
AS
BEGIN
    INSERT INTO Tallas (nombre)
    VALUES (@nombre);
END;

CREATE PROCEDURE SP_ObtenerTodasLasTallas
AS
BEGIN
    SELECT * FROM Tallas ORDER BY id;
END;

CREATE PROCEDURE SP_InsertarProductoTalla
    @producto_id BIGINT,
    @talla_id BIGINT
AS
BEGIN
    INSERT INTO ProductosTallas (producto_id, talla_id)
    VALUES (@producto_id, @talla_id);
END;

CREATE PROCEDURE SP_ObtenerTallasPorProducto
    @ProductoID BIGINT
AS
BEGIN
    SELECT t.id, t.nombre
    FROM ProductosTallas pt
    INNER JOIN Tallas t ON pt.talla_id = t.id
    WHERE pt.producto_id = @ProductoID;
END

--GENEROS

CREATE PROCEDURE SP_InsertarGenero
    @nombre NVARCHAR(20)
AS
BEGIN
    INSERT INTO Generos (nombre)
    VALUES (@nombre);
END;

CREATE PROCEDURE SP_ObtenerTodosLosGeneros
AS
BEGIN
    SELECT * FROM Generos ORDER BY id;
END;

CREATE PROCEDURE SP_ObtenerGenerosPorProducto
    @ProductoID BIGINT
AS
BEGIN
    SELECT g.id, g.nombre
    FROM ProductosGeneros pg
    INNER JOIN Generos g ON pg.genero_id = g.id
    WHERE pg.producto_id = @ProductoID;
END

--MARCAS

CREATE PROCEDURE SP_InsertarMarca
    @nombre NVARCHAR(50)
AS
BEGIN
    INSERT INTO Marcas (nombre)
    VALUES (@nombre);
END;

CREATE PROCEDURE SP_ObtenerTodasLasMarcas
AS
BEGIN
    SELECT * FROM Marcas ORDER BY id;
END;

CREATE PROCEDURE SP_EliminarMarca
	@Id BIGINT
AS
BEGIN
	DELETE FROM Marcas
	WHERE id = @id;
END;

CREATE PROCEDURE SP_ObtenerMarcasPorProducto
    @ProductoID BIGINT
AS
BEGIN
    SELECT m.id, m.nombre
    FROM ProductosMarcas pm
    INNER JOIN Marcas m ON pm.marca_id = m.id
    WHERE pm.producto_id = @ProductoID;
END

--COLORES

CREATE PROCEDURE SP_InsertarColor
    @nombre NVARCHAR(50),
    @codigo_hexdecimal NVARCHAR(50)
AS
BEGIN
    INSERT INTO Colores (nombre, codigo_hexdecimal)
    VALUES (@nombre, @codigo_hexdecimal);
END;

CREATE PROCEDURE SP_ObtenerTodosLosColores
AS
BEGIN
    SELECT * FROM Colores ORDER BY id;
END;

CREATE PROCEDURE SP_ObtenerColoresPorProducto
    @ProductoID BIGINT
AS
BEGIN
    SELECT c.id, c.nombre, c.codigo_hexdecimal
    FROM ProductosColores pc
    INNER JOIN Colores c ON pc.color_id = c.id
    WHERE pc.producto_id = @ProductoID;
END

--FOTOS

CREATE PROCEDURE SP_ObtenerFotosPorProducto
    @ProductoID BIGINT
AS
BEGIN
    SELECT f.id, f.url
    FROM Fotos f
    WHERE f.producto_id = @ProductoID;
END

--Productos

CREATE PROCEDURE SP_InsertarProducto
    @codigo NVARCHAR(50),
    @nombre NVARCHAR(MAX),
    @categoria_id BIGINT,
    @stock INT,
    @stockMinimo INT,
    @precio_compra DECIMAL(18, 2),
    @precio_venta DECIMAL(18, 2),
    @estado_promocion BIT,
    @fecha_caducidad_promocion DATE,
    @foto NVARCHAR(MAX)
AS
BEGIN
    INSERT INTO Productos (codigo, nombre, categoria_id, stock, stockMinimo, precio_compra, precio_venta, estado_promocion, fecha_caducidad_promocion, foto)
    VALUES (@codigo, @nombre, @categoria_id, @stock, @stockMinimo, @precio_compra, @precio_venta, @estado_promocion, @fecha_caducidad_promocion, @foto);
END;

CREATE PROCEDURE SP_ObtenerTodosLosProductos
AS
BEGIN
    SELECT * FROM Productos ORDER BY id;
END;

CREATE PROCEDURE SP_ActualizarProducto
    @id BIGINT,
    @codigo NVARCHAR(50),
    @nombre NVARCHAR(MAX),
    @categoria_id BIGINT,
    @stock INT,
    @stockMinimo INT,
    @precio_compra DECIMAL(18, 2),
    @precio_venta DECIMAL(18, 2),
    @estado_promocion BIT,
    @fecha_caducidad_promocion DATE,
    @foto NVARCHAR(MAX)
AS
BEGIN
    UPDATE Productos
    SET codigo = @codigo,
        nombre = @nombre,
        categoria_id = @categoria_id,
        stock = @stock,
        stockMinimo = @stockMinimo,
        precio_compra = @precio_compra,
        precio_venta = @precio_venta,
        estado_promocion = @estado_promocion,
        fecha_caducidad_promocion = @fecha_caducidad_promocion,
        foto = @foto
    WHERE id = @id;
END;

CREATE PROCEDURE SP_EliminarProducto
    @id BIGINT
AS
BEGIN
    DELETE FROM Productos WHERE id = @id;
END;

