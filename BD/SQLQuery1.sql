CREATE TABLE Categoria(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(100) NOT NULL,
);
INSERT INTO Categoria (nombre) VALUES
('Camisas'),
('Pantalones'),
('Zapatos'),
('Accesorios'),
('Vestidos'),
('Chaquetas'),
('Suéteres'),
('Shorts'),
('Bermudas'),
('Ropa Deportiva'),
('Ropa de baño'),
('Jerseys'),
('Faldas'),
('Blusas');

DBCC CHECKIDENT ('dbo.Categoria', RESEED, 0);
EXEC sp_help Usuarios
CREATE TABLE Producto(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(255) NOT NULL,
	descripcion NVARCHAR(MAX) NOT NULL,
	categoria_id BIGINT FOREIGN KEY REFERENCES Categoria(id)
	ON DELETE CASCADE,
	precio_compra DECIMAL(10,2) NOT NULL,
	precio_venta DECIMAL(10,2) NOT NULL,
	foto_pricipal VARBINARY(MAX),
	estado_promocion BIT DEFAULT 0,
);

ALTER PROCEDURE SP_ImagenesPrueba
@id BIGINT,
@foto VARBINARY(MAX)
AS
BEGIN
	UPDATE Producto
	SET Foto_Principal = @foto
	WHERE id = @id;
END;
SELECT * FROM Producto
CREATE PROCEDURE SP_ObtenerTodosLosProductos
AS
BEGIN
	SELECT P.id,P.nombre,P.descripcion,P.precio_compra,precio_venta
	FROM Producto P
END;

INSERT INTO Producto (nombre, descripcion, categoria_id, precio_compra, precio_venta) VALUES
('Camisa Polo', 'Camisa tipo polo de algodón, ideal para climas cálidos, disponible en varios colores.', 1, 25.00, 45.00),
('Pantalón de mezclilla', 'Pantalón de mezclilla de corte clásico, cómodo y duradero.', 2, 30.00, 60.00),
('Zapatos de cuero', 'Zapatos formales de cuero de alta calidad, perfectos para ocasiones especiales.', 3, 40.00, 90.00),
('Accesorio de reloj', 'Reloj de pulsera elegante con correa de cuero, diseño clásico y moderno.', 4, 15.00, 35.00),
('Vestido de noche', 'Vestido elegante para ocasiones formales, diseño único con detalles finos.', 5, 50.00, 120.00),
('Chaqueta de invierno', 'Chaqueta acolchonada para invierno, resistente al frío y viento.', 6, 60.00, 120.00),
('Suéter de lana', 'Suéter de lana para el invierno, cómodo y cálido.', 7, 20.00, 40.00),
('Short deportivo', 'Short cómodo para actividades deportivas y de ocio, en materiales de alta transpiración.', 8, 18.00, 35.00),
('Bermuda casual', 'Bermuda de algodón, ideal para el verano y días cálidos.', 9, 15.00, 25.00),
('Ropa Deportiva', 'Conjunto deportivo, camiseta y pantalón en materiales livianos para entrenamientos.', 10, 20.00, 40.00),
('Bikini de baño', 'Bikini de baño femenino con diseño moderno, ideal para días de playa o piscina.', 11, 12.00, 25.00),
('Jersey de fútbol', 'Jersey oficial de fútbol, fabricado con materiales de alta calidad.', 12, 25.00, 50.00),
('Falda corta', 'Falda corta de algodón, cómoda y fresca, ideal para el verano.', 13, 12.00, 25.00),
('Blusa de seda', 'Blusa femenina de seda, elegante y liviana para ocasiones formales o casuales.', 14, 30.00, 60.00),
('Pantalón de lino', 'Pantalón de lino ligero y cómodo, perfecto para el clima cálido.', 2, 28.00, 55.00);

CREATE TABLE Talla(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL
);

SELECT * FROM Producto

DBCC CHECKIDENT ('dbo.Talla', RESEED, 0);

INSERT INTO Talla (nombre) VALUES
('XS'),
('S'),
('M'),
('L'),
('XL'),
('XXL'),
('XXXL');


CREATE TABLE Color(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL,
	valor_hex NVARCHAR(100) NOT NULL
);
DELETE FROM Color
DBCC CHECKIDENT ('dbo.Color', RESEED, 0);
INSERT INTO Color (nombre, valor_hex) VALUES
('Rojo Mexicano', '#D50032'),
('Amarillo Oro', '#FFCC00'),
('Verde Esperanza', '#00A859'),
('Azul Caribe', '#0077B6'),
('Púrpura Andino', '#6A0DAD'),
('Naranja Tropical', '#FF7F00'),
('Rojo Fuego', '#FF4500'),
('Verde Lima', '#00FF00'),
('Celeste Claro', '#4AC6D8'),
('Amarillo Sol', '#FFEB3B'),
('Fucsia Viva', '#D500F9'),
('Marrón Tierra', '#8B4513'),
('Turquesa Maya', '#00B3B3'),
('Azul Cielo Caribeño', '#00BFFF'),
('Lavanda Andina', '#C8A2D6');


CREATE TABLE Inventario(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	producto_id BIGINT FOREIGN KEY REFERENCES Producto(id)
	ON DELETE CASCADE,
	talla_id BIGINT FOREIGN KEY REFERENCES Talla(id)
	ON DELETE CASCADE,
	color_id BIGINT FOREIGN KEY REFERENCES Color(id)
	ON DELETE CASCADE,
	cantidad INT NOT NULL,
);
CREATE TABLE FotosInventario (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    inventario_id BIGINT FOREIGN KEY REFERENCES Inventario(id) ON DELETE CASCADE,
    foto VARBINARY(MAX) NOT NULL,
);

-- Insertar productos en el inventario con tallas y colores
INSERT INTO Inventario (producto_id, talla_id, color_id, cantidad) VALUES
(1, 2, 1, 10),  -- Camisa Polo (S, Rojo Mexicano)
(1, 3, 2, 8),   -- Camisa Polo (M, Amarillo Oro)
(1, 4, 3, 5),   -- Camisa Polo (L, Verde Esperanza)
(1, 5, 4, 6),   -- Camisa Polo (XL, Azul Caribe)
(1, 6, 5, 7),   -- Camisa Polo (XXL, Púrpura Andino)

(2, 2, 6, 15),  -- Pantalón de mezclilla (S, Naranja Tropical)
(2, 3, 7, 12),  -- Pantalón de mezclilla (M, Rojo Fuego)
(2, 4, 8, 18),  -- Pantalón de mezclilla (L, Verde Lima)
(2, 5, 9, 20),  -- Pantalón de mezclilla (XL, Celeste Claro)
(2, 6, 10, 14), -- Pantalón de mezclilla (XXL, Amarillo Sol)

(3, 3, 11, 6),  -- Zapatos de cuero (M, Fucsia Viva)
(3, 4, 12, 8),  -- Zapatos de cuero (L, Marrón Tierra)
(3, 5, 13, 10), -- Zapatos de cuero (XL, Turquesa Maya)
(3, 6, 14, 7),  -- Zapatos de cuero (XXL, Azul Cielo Caribeño)

(4, 2, 1, 20),  -- Accesorio de reloj (S, Rojo Mexicano)
(4, 3, 2, 25),  -- Accesorio de reloj (M, Amarillo Oro)
(4, 4, 3, 30),  -- Accesorio de reloj (L, Verde Esperanza)

(5, 5, 4, 3),   -- Vestido de noche (XL, Azul Caribe)
(5, 6, 5, 4),   -- Vestido de noche (XXL, Púrpura Andino)
(5, 7, 6, 5),   -- Vestido de noche (XXXL, Naranja Tropical)

(6, 3, 7, 8),   -- Chaqueta de invierno (M, Rojo Fuego)
(6, 4, 8, 12),  -- Chaqueta de invierno (L, Verde Lima)
(6, 5, 9, 10),  -- Chaqueta de invierno (XL, Celeste Claro)

(7, 2, 10, 18), -- Suéter de lana (S, Amarillo Sol)
(7, 3, 11, 25), -- Suéter de lana (M, Fucsia Viva)
(7, 4, 12, 20), -- Suéter de lana (L, Marrón Tierra)

(8, 5, 13, 16), -- Short deportivo (XL, Turquesa Maya)
(8, 6, 14, 12), -- Short deportivo (XXL, Azul Cielo Caribeño)
(8, 7, 1, 10),  -- Short deportivo (XXXL, Rojo Mexicano)

(9, 2, 2, 22),  -- Bermuda casual (S, Amarillo Oro)
(9, 3, 3, 18),  -- Bermuda casual (M, Verde Esperanza)
(9, 4, 4, 25),  -- Bermuda casual (L, Azul Caribe)
(9, 5, 5, 30),  -- Bermuda casual (XL, Púrpura Andino)

(10, 6, 6, 35), -- Ropa Deportiva (XXL, Naranja Tropical)
(10, 7, 7, 28), -- Ropa Deportiva (XXXL, Rojo Fuego)
(10, 2, 8, 22), -- Ropa Deportiva (S, Verde Lima)

(11, 4, 9, 12), -- Bikini de baño (L, Celeste Claro)
(11, 5, 10, 15), -- Bikini de baño (XL, Amarillo Sol)
(11, 6, 11, 10), -- Bikini de baño (XXL, Fucsia Viva)

(12, 2, 12, 7),  -- Jersey de fútbol (S, Marrón Tierra)
(12, 3, 13, 8),  -- Jersey de fútbol (M, Turquesa Maya)
(12, 4, 14, 5),  -- Jersey de fútbol (L, Azul Cielo Caribeño)

(13, 5, 1, 30), -- Falda corta (XL, Rojo Mexicano)
(13, 6, 2, 25), -- Falda corta (XXL, Amarillo Oro)
(13, 7, 3, 20), -- Falda corta (XXXL, Verde Esperanza)

(14, 3, 4, 18), -- Blusa de seda (M, Azul Caribe)
(14, 4, 5, 22), -- Blusa de seda (L, Púrpura Andino)
(14, 5, 6, 15), -- Blusa de seda (XL, Naranja Tropical)

(15, 2, 7, 25), -- Pantalón de lino (S, Rojo Fuego)
(15, 3, 8, 30), -- Pantalón de lino (M, Verde Lima)
(15, 4, 9, 28); -- Pantalón de lino (L, Celeste Claro)


CREATE PROCEDURE SP_ObtenerColoresPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT DISTINCT c.id,c.nombre,c.valor_hex
	FROM Producto P
	INNER JOIN Inventario I ON P.id=I.producto_id
	INNER JOIN Color C ON I.color_id=C.id
	WHERE P.id = 1
		AND I.cantidad > 0; 
END;
ALTER PROCEDURE SP_ObtenerColoresPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT c.id, c.nombre, c.valor_hex
	FROM Color C
	WHERE C.id IN (
		SELECT I.color_id
		FROM Inventario I
		WHERE I.producto_id = @id
		AND I.cantidad > 0
	);
END;
EXEC SP_ObtenerColoresPorIdProducto 1
CREATE PROCEDURE SP_ObtenerTallasPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT t.id, t.nombre
	FROM Talla T
	WHERE T.id IN (
		SELECT I.talla_id
		FROM Inventario I
		WHERE I.producto_id = @id
		AND I.cantidad > 0
	);
END;

CREATE TABLE Carrito_Compra(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
	producto_id BIGINT FOREIGN KEY REFERENCES Producto(id),
	talla_id BIGINT FOREIGN KEY REFERENCES Talla(id),
	color_id BIGINT FOREIGN KEY REFERENCES Color(id),
	cantidad INT,
	precio DECIMAL(10,2),
);

CREATE PROCEDURE SP_TallasParaEsteColor
    @idColo BIGINT,
    @idProducto BIGINT
AS
BEGIN
    SELECT DISTINCT T.id, T.nombre
    FROM Talla T
    INNER JOIN Inventario I ON T.id = I.talla_id
    WHERE I.color_id = @idColo
      AND I.producto_id = @idProducto
      AND I.cantidad > 0;  -- Aseguramos que haya cantidad disponible
END;


DROP PROCEDURE SP_CrearProductoConVariantes
    @nombre NVARCHAR(255),
    @descripcion NVARCHAR(MAX),
    @categoria_id BIGINT,
    @precio_compra DECIMAL(10,2),
    @precio_venta DECIMAL(10,2),
    @foto_principal VARBINARY(MAX),
    @estado_promocion BIT,
    @variantes NVARCHAR(MAX) -- JSON con las variantes
AS
BEGIN
    BEGIN TRANSACTION;
    BEGIN TRY
        -- Insertar el producto en la tabla Producto
        DECLARE @producto_id BIGINT;
        INSERT INTO Producto (nombre, descripcion, categoria_id, precio_compra, precio_venta, foto_principal, estado_promocion)
        VALUES (@nombre, @descripcion, @categoria_id, @precio_compra, @precio_venta, @foto_principal, @estado_promocion);

        SET @producto_id = SCOPE_IDENTITY();

        -- Procesar las variantes desde el JSON
        DECLARE @jsonTabla TABLE (
            talla_id BIGINT,
            color_id BIGINT,
            cantidad INT,
            fotos NVARCHAR(MAX)
        );

        INSERT INTO @jsonTabla (talla_id, color_id, cantidad, fotos)
        SELECT 
            JSON_VALUE(value, '$.talla_id') AS talla_id,
            JSON_VALUE(value, '$.color_id') AS color_id,
            JSON_VALUE(value, '$.cantidad') AS cantidad,
            JSON_VALUE(value, '$.fotos') AS fotos
        FROM OPENJSON(@variantes);

        -- Recorrer las variantes
        DECLARE @talla_id BIGINT;
        DECLARE @color_id BIGINT;
        DECLARE @cantidad INT;
        DECLARE @fotos NVARCHAR(MAX);
        DECLARE @inventario_id BIGINT;

        DECLARE variantes_cursor CURSOR FOR
        SELECT talla_id, color_id, cantidad, fotos FROM @jsonTabla;

        OPEN variantes_cursor;

        FETCH NEXT FROM variantes_cursor INTO @talla_id, @color_id, @cantidad, @fotos;

        WHILE @@FETCH_STATUS = 0
        BEGIN
            -- Insertar la variante en Inventario
            INSERT INTO Inventario (producto_id, talla_id, color_id, cantidad)
            VALUES (@producto_id, @talla_id, @color_id, @cantidad);

            SET @inventario_id = SCOPE_IDENTITY();

            -- Procesar las fotos asociadas en formato Base64
            DECLARE @jsonFotos TABLE (fotoBase64 NVARCHAR(MAX));

            INSERT INTO @jsonFotos (fotoBase64)
            SELECT value
            FROM OPENJSON(@fotos);

            DECLARE @fotoBase64 NVARCHAR(MAX);
            DECLARE @foto VARBINARY(MAX);

            DECLARE fotos_cursor CURSOR FOR
            SELECT fotoBase64 FROM @jsonFotos;

            OPEN fotos_cursor;

            FETCH NEXT FROM fotos_cursor INTO @fotoBase64;

            WHILE @@FETCH_STATUS = 0
            BEGIN
                -- Convertir Base64 a VARBINARY
                SET @foto = CAST('' AS XML).value('xs:base64Binary(sql:variable("@fotoBase64"))', 'VARBINARY(MAX)');

                -- Insertar la foto en FotosInventario
                INSERT INTO FotosInventario (inventario_id, foto)
                VALUES (@inventario_id, @foto);

                FETCH NEXT FROM fotos_cursor INTO @fotoBase64;
            END;

            CLOSE fotos_cursor;
            DEALLOCATE fotos_cursor;

            FETCH NEXT FROM variantes_cursor INTO @talla_id, @color_id, @cantidad, @fotos;
        END;

        CLOSE variantes_cursor;
        DEALLOCATE variantes_cursor;

        COMMIT TRANSACTION;
    END TRY
    BEGIN CATCH
        ROLLBACK TRANSACTION;
        THROW;
    END CATCH
END;


CREATE PROCEDURE [dbo].[SP_CrearProductoConVariantes]
    @nombre NVARCHAR(255),
    @descripcion NVARCHAR(MAX),
    @categoria_id BIGINT,
    @precio_compra DECIMAL(10, 2),
    @precio_venta DECIMAL(10, 2),
    @foto_principal VARBINARY(MAX),
    @estado_promocion BIT,
    @producto_id BIGINT OUTPUT -- Parámetro de salida
AS
BEGIN
    BEGIN TRY
        INSERT INTO Producto (nombre, descripcion, categoria_id, precio_compra, precio_venta, foto_principal, estado_promocion)
        VALUES (@nombre, @descripcion, @categoria_id, @precio_compra, @precio_venta, @foto_principal, @estado_promocion);

        SET @producto_id = SCOPE_IDENTITY(); -- Devuelve el ID insertado
    END TRY
    BEGIN CATCH
        THROW;
    END CATCH
END;

CREATE PROCEDURE [dbo].[SP_CrearVariantes]
    @producto_id BIGINT,
    @talla_id BIGINT,
    @color_id BIGINT,
    @cantidad INT,
    @inventario_id BIGINT OUTPUT -- Parámetro de salida
AS
BEGIN
    BEGIN TRY
        INSERT INTO Inventario (producto_id, talla_id, color_id, cantidad)
        VALUES (@producto_id, @talla_id, @color_id, @cantidad);

        SET @inventario_id = SCOPE_IDENTITY(); -- Devuelve el ID de la variante insertada
    END TRY
    BEGIN CATCH
        THROW;
    END CATCH
END;

CREATE PROCEDURE [dbo].[SP_CrearImagenesInventario]
    @inventario_id BIGINT,
    @foto VARBINARY(MAX)
AS
BEGIN
    BEGIN TRY
        INSERT INTO FotosInventario (inventario_id, foto)
        VALUES (@inventario_id, @foto);
    END TRY
    BEGIN CATCH
        THROW;
    END CATCH
END;
