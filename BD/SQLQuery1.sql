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
SELECT id
FROM Inventario
WHERE talla_id = @idTalla AND color_id =@idcolor;
ALTER TABLE Inventario
ADD CONSTRAINT UQ_producto_talla_color UNIQUE (producto_id, talla_id, color_id);

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

CREATE PROCEDURE SP_ActualizarProducto
    @id BIGINT,
    @nombre NVARCHAR(255),
    @descripcion NVARCHAR(MAX),
    @categoria_id BIGINT,
    @precio_compra DECIMAL(10,2),
    @precio_venta DECIMAL(10,2),
    @foto_principal VARBINARY(MAX),
    @estado_promocion BIT
AS
BEGIN
    UPDATE Producto
    SET nombre = @nombre,
        descripcion = @descripcion,
        categoria_id = @categoria_id,
        precio_compra = @precio_compra,
        precio_venta = @precio_venta,
        foto_Principal = @foto_principal,
        estado_promocion = @estado_promocion
    WHERE id = @id;
END;
CREATE PROCEDURE SP_ActualizarVariante
    @id BIGINT,
    @producto_id BIGINT,
    @talla_id BIGINT,
    @color_id BIGINT,
    @cantidad INT
AS
BEGIN
    UPDATE Inventario
    SET talla_id = @talla_id,
        color_id = @color_id,
        cantidad = @cantidad
    WHERE id = @id AND producto_id = @producto_id;
END;
CREATE PROCEDURE SP_EliminarVariante
	@id BIGINT
AS
BEGIN
	DELETE FROM Inventario
	WHERE id=@id;
END;
SELECT * FROM Inventario
CREATE PROCEDURE SP_ActualizarFotoInventario
    @id BIGINT,
    @inventario_id BIGINT,
    @foto VARBINARY(MAX)
AS
BEGIN
    UPDATE FotosInventario
    SET foto = @foto
    WHERE id = @id AND inventario_id = @inventario_id;
END;

SELECT * FROM Producto
SELECT* FROM Inventario
SELECT * FROM FotosInventario

CREATE PROCEDURE SP_CrearFotoInventario
	@inventario_id BIGINT,
	@foto VARBINARY(MAX)
AS
BEGIN
	INSERT INTO FotosInventario(inventario_id,foto)
	VALUES(@inventario_id,@foto)
END

CREATE PROCEDURE SP_EliminarFotoInventario
	@id BIGINT
AS
BEGIN
	DELETE FROM FotosInventario
	WHERE id=@id;
END

SELECT * FROM Producto

CREATE TABLE CarritoCompras (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    usuario_id BIGINT NOT NULL FOREIGN KEY REFERENCES Usuarios(id) ON DELETE CASCADE,
    fecha_creacion DATETIME2 DEFAULT GETDATE(),
    estado NVARCHAR(15) DEFAULT 'activo',
    CHECK (estado IN ('activo', 'inactivo'))
);


CREATE TABLE DetallesCarritoComprar (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    carrito_id BIGINT NOT NULL FOREIGN KEY REFERENCES CarritoCompras(id) ON DELETE CASCADE,
    inventario_id BIGINT NOT NULL FOREIGN KEY REFERENCES Inventario(id) ON DELETE CASCADE,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL, -- El precio se guarda en el momento de la transacción
    subtotal AS (cantidad * precio) -- Columna calculada
);

SELECT GETDATE()


CREATE PROCEDURE SP_ObtenerIdVariantePorTallayColor
	@idTalla BIGINT,
	@idColor BIGINT
AS
BEGIN
	SELECT TOP 1 id
	FROM Inventario
	WHERE talla_id =@idTalla AND color_id =@idColor
END

CREATE PROCEDURE SP_ObtenerOCrearCarrito
    @usuario_id BIGINT,
    @id_carrito BIGINT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    -- Intentar buscar un carrito activo
    SELECT TOP 1 @id_carrito = id
    FROM CarritoCompras
    WHERE usuario_id = @usuario_id AND estado = 'activo';

    -- Si no existe un carrito activo, crear uno nuevo
    IF @id_carrito IS NULL
    BEGIN
        INSERT INTO CarritoCompras (usuario_id, fecha_creacion, estado)
        VALUES (@usuario_id, GETDATE(), 'activo');

        SET @id_carrito = SCOPE_IDENTITY(); -- Obtener el ID del carrito recién creado
    END
END;
GO

ALTER PROCEDURE SP_CrearCarritoDetalle
    @carrito_id BIGINT,
    @inventario_id BIGINT,
    @cantidad INT,
    @precio DECIMAL(10, 2),
    @resultado BIT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    -- Inicializar el resultado como fallo
    SET @resultado = 0;

    -- Validar si el inventario existe (sin verificar stock, ya que no se reduce aquí)
    IF EXISTS (
        SELECT 1 
        FROM Inventario 
        WHERE id = @inventario_id
    )
    BEGIN
        -- Verificar si ya existe un registro en el carrito con el mismo producto
        IF EXISTS (
            SELECT 1
            FROM DetallesCarritoComprar
            WHERE carrito_id = @carrito_id AND inventario_id = @inventario_id
        )
        BEGIN
            -- Si existe, actualizar la cantidad sumando la nueva
            UPDATE DetallesCarritoComprar
            SET cantidad = cantidad + @cantidad
            WHERE carrito_id = @carrito_id AND inventario_id = @inventario_id;

            -- Indicar éxito
            SET @resultado = 1;
        END
        ELSE
        BEGIN
            -- Si no existe, insertar un nuevo detalle en el carrito
            INSERT INTO DetallesCarritoComprar (carrito_id, inventario_id, cantidad, precio)
            VALUES (@carrito_id, @inventario_id, @cantidad, @precio);

            -- Indicar éxito
            SET @resultado = 1;
        END
    END
END;

CREATE PROCEDURE SP_ObtenerCarritoActivo
    @usuario_id BIGINT
AS
BEGIN
    SET NOCOUNT ON;

    -- Retornar el carrito activo del usuario
    SELECT TOP 1 id, usuario_id, fecha_creacion, estado
    FROM CarritoCompras
    WHERE usuario_id = @usuario_id AND estado = 'activo';
END;

CREATE PROCEDURE SP_ObtenerDetallesPorCarrito
    @carrito_id BIGINT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        d.id AS idCarritoDetalle,
        d.carrito_id,
        d.inventario_id,
		i.producto_id,
        d.cantidad,
        d.precio
    FROM DetallesCarritoComprar d
    INNER JOIN Inventario i ON d.inventario_id = i.id
    WHERE d.carrito_id = 1;
END;

CREATE PROCEDURE SP_ObtenerProductoPorId
	@id BIGINT
AS
BEGIN
	SELECT id,nombre,descripcion,categoria_id,precio_compra,precio_venta,foto_Principal,estado_promocion
	FROM Producto
	WHERE id=@id;
END
CREATE PROCEDURE SP_CalcularSubTotalPorCarrito
@carrito_id BIGINT
AS
BEGIN
    -- Calcula el subtotal usando la columna calculada
    SELECT SUM(subtotal) AS subtotal
    FROM DetallesCarritoComprar
    WHERE carrito_id = @carrito_id;
END
SELECT * FROM Producto
SELECT * FROM Inventario
SELECT * FROM DetallesCarritoComprar
EXEC SP_CalcularSubTotalPorCarrito 1

CREATE PROCEDURE SP_AumentarCantidadCarrito
	@idCarritoDeta BIGINT
AS
BEGIN
	UPDATE DetallesCarritoComprar
	SET cantidad = cantidad+1
	WHERE id=@idCarritoDeta
END

CREATE PROCEDURE SP_DisminuirCantidadCarrito
	@idCarritoDeta BIGINT
AS
BEGIN
	UPDATE DetallesCarritoComprar
	SET cantidad = cantidad-1
	WHERE id=@idCarritoDeta
END

CREATE PROCEDURE SP_EliminarCarritoDetalle
	@idCarritoDeta BIGINT
AS
BEGIN
	DELETE FROM DetallesCarritoComprar
	WHERE id=@idCarritoDeta
END

CREATE TABLE OrdenPedido (
    id BIGINT PRIMARY KEY IDENTITY(1,1), -- Identificador único de la orden
    fecha_emision DATETIME2 NOT NULL DEFAULT GETDATE(), -- Fecha de creación de la orden
    importe_total DECIMAL(10, 2) NOT NULL, -- Total del pedido
    forma_pago NVARCHAR(50) NOT NULL, -- Forma de pago: Efectivo, Tarjeta, etc.
    estado NVARCHAR(20) DEFAULT 'pendiente', -- Estado del pedido: pendiente, procesado, cancelado
    
    -- Relación con cliente
    cliente_id BIGINT NOT NULL FOREIGN KEY REFERENCES Clientes(id) ON DELETE CASCADE,

    -- Relación con el vendedor
    vendedor_id BIGINT NOT NULL FOREIGN KEY REFERENCES Usuarios(id),

    -- Relación con el carrito de compras
    carrito_id BIGINT NOT NULL FOREIGN KEY REFERENCES CarritoCompras(id) ON DELETE CASCADE,

    -- Restricción para el estado
    CHECK (estado IN ('pendiente', 'procesado', 'cancelado'))
);
CREATE TABLE Clientes (
    id BIGINT PRIMARY KEY IDENTITY(1,1), -- Identificador único del cliente
    nombre NVARCHAR(100) NOT NULL, -- Nombre completo del cliente
    tipo_documento NVARCHAR(50) NOT NULL, -- Ej: DNI, Pasaporte, etc.
    numero_documento NVARCHAR(20) NOT NULL UNIQUE, -- Número único del documento
    telefono NVARCHAR(15), -- Teléfono del cliente (opcional)
    email NVARCHAR(100), -- Correo electrónico (opcional
    -- Restricción para evitar duplicados de cliente con tipo y número de documento
    UNIQUE (tipo_documento, numero_documento),
	distrito_id INT FOREIGN KEY REFERENCES Distritos(id) ON DELETE CASCADE
);
ALTER TABLE Clientes
ADD distrito_id INT NOT NULL FOREIGN KEY REFERENCES Distritos(id) ON DELETE CASCADE;

CREATE TABLE Departamentos (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL UNIQUE -- Nombre único del departamento
);
CREATE TABLE Provincias (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL,
    departamento_id INT NOT NULL FOREIGN KEY REFERENCES Departamentos(id) ON DELETE CASCADE, -- Relación con Departamentos
    -- Evita duplicados de provincia dentro del mismo departamento
    UNIQUE (nombre, departamento_id)
);

CREATE TABLE Distritos (
    id INT PRIMARY KEY IDENTITY(1,1),
    nombre NVARCHAR(100) NOT NULL,
    provincia_id INT NOT NULL FOREIGN KEY REFERENCES Provincias(id) ON DELETE CASCADE, -- Relación con Provincias
    -- Evita duplicados de distrito dentro de la misma provincia
    UNIQUE (nombre, provincia_id)
);

INSERT INTO Departamentos (nombre)
VALUES
('Amazonas'),
('Áncash'),
('Apurímac'),
('Arequipa'),
('Ayacucho'),
('Cajamarca'),
('Callao'),
('Cusco'),
('Huancavelica'),
('Huánuco'),
('Ica'),
('Junín'),
('La Libertad'),
('Lambayeque'),
('Lima'),
('Loreto'),
('Madre de Dios'),
('Moquegua'),
('Pasco'),
('Piura'),
('Puno'),
('San Martín'),
('Tacna'),
('Tumbes'),
('Ucayali');
INSERT INTO Provincias (nombre, departamento_id)
VALUES
-- Amazonas
('Chachapoyas', 1),
('Bagua', 1),
-- Áncash
('Huaraz', 2),
('Chimbote', 2),
-- Apurímac
('Abancay', 3),
('Andahuaylas', 3),
-- Arequipa
('Arequipa', 4),
('Camaná', 4),
-- Ayacucho
('Huamanga', 5),
('Huanta', 5),
-- Cajamarca
('Cajamarca', 6),
('Jaén', 6),
-- Callao
('Callao', 7),
-- Cusco
('Cusco', 8),
('Urubamba', 8),
-- Huancavelica
('Huancavelica', 9),
('Angaraes', 9),
-- Huánuco
('Huánuco', 10),
('Tingo María', 10),
-- Ica
('Ica', 11),
('Chincha', 11),
-- Junín
('Huancayo', 12),
('Tarma', 12),
-- La Libertad
('Trujillo', 13),
('Pacasmayo', 13),
-- Lambayeque
('Chiclayo', 14),
('Lambayeque', 14),
-- Lima
('Lima', 15),
('Huaral', 15),
-- Loreto
('Iquitos', 16),
('Nauta', 16),
-- Madre de Dios
('Tambopata', 17),
-- Moquegua
('Moquegua', 18),
('Ilo', 18),
-- Pasco
('Cerro de Pasco', 19),
('Oxapampa', 19),
-- Piura
('Piura', 20),
('Sullana', 20),
-- Puno
('Puno', 21),
('Juliaca', 21),
-- San Martín
('Moyobamba', 22),
('Tarapoto', 22),
-- Tacna
('Tacna', 23),
('Candarave', 23),
-- Tumbes
('Tumbes', 24),
('Zarumilla', 24),
-- Ucayali
('Pucallpa', 25),
('Atalaya', 25);

INSERT INTO Distritos (nombre, provincia_id)
VALUES
-- Chachapoyas (Amazonas)
('Chachapoyas', 1),
('Molinopampa', 1),
-- Huaraz (Áncash)
('Huaraz', 2),
('Independencia', 2),
-- Abancay (Apurímac)
('Abancay', 3),
('Tamburco', 3),
-- Arequipa (Arequipa)
('Arequipa', 4),
('Yanahuara', 4),
-- Huamanga (Ayacucho)
('Ayacucho', 5),
('Carmen Alto', 5),
-- Cajamarca (Cajamarca)
('Cajamarca', 6),
('Baños del Inca', 6),
-- Callao (Callao)
('Callao', 7),
('Bellavista', 7),
-- Cusco (Cusco)
('Cusco', 8),
('Wanchaq', 8),
-- Huancavelica (Huancavelica)
('Huancavelica', 9),
('Ascensión', 9),
-- Huánuco (Huánuco)
('Huánuco', 10),
('Pillco Marca', 10),
-- Ica (Ica)
('Ica', 11),
('La Tinguiña', 11),
-- Huancayo (Junín)
('Huancayo', 12),
('El Tambo', 12),
-- Trujillo (La Libertad)
('Trujillo', 13),
('Florencia de Mora', 13),
-- Chiclayo (Lambayeque)
('Chiclayo', 14),
('José Leonardo Ortiz', 14),
-- Lima (Lima)
('Miraflores', 15),
('San Isidro', 15),
-- Iquitos (Loreto)
('Iquitos', 16),
('Punchana', 16),
-- Tambopata (Madre de Dios)
('Tambopata', 17),
-- Moquegua (Moquegua)
('Moquegua', 18),
('Samegua', 18),
-- Cerro de Pasco (Pasco)
('Cerro de Pasco', 19),
('Yanacancha', 19),
-- Piura (Piura)
('Piura', 20),
('Castilla', 20),
-- Puno (Puno)
('Puno', 21),
('Juli', 21),
-- Moyobamba (San Martín)
('Moyobamba', 22),
('Soritor', 22),
-- Tacna (Tacna)
('Tacna', 23),
('Alto de la Alianza', 23),
-- Tumbes (Tumbes)
('Tumbes', 24),
('Corrales', 24),
-- Pucallpa (Ucayali)
('Pucallpa', 25),
('Yarinacocha', 25);

CREATE PROCEDURE SP_ObtenerDepartamentos
AS
BEGIN
    SELECT id, nombre
    FROM Departamentos
    ORDER BY nombre;
END;
CREATE PROCEDURE SP_ObtenerProvinciasPorDepartamento
    @DepartamentoId INT
AS
BEGIN
    SELECT id, nombre
    FROM Provincias
    WHERE departamento_id = @DepartamentoId
    ORDER BY nombre;
END;
CREATE PROCEDURE SP_ObtenerDistritosPorProvincia
    @ProvinciaId INT
AS
BEGIN
    SELECT id, nombre
    FROM Distritos
    WHERE provincia_id = @ProvinciaId
    ORDER BY nombre;
END;

CREATE PROCEDURE SP_GenerarOrdenPedido
    @cliente_id BIGINT,
    @vendedor_id BIGINT,
    @carrito_id BIGINT,
    @forma_pago NVARCHAR(50),
    @resultado BIT OUTPUT -- Indicador de éxito
AS
BEGIN
    SET NOCOUNT ON;

    -- Inicializar variables
    DECLARE @orden_id_table TABLE (id BIGINT); -- Usar tabla para capturar el OUTPUT
    DECLARE @importe_total DECIMAL(10, 2) = 0;

    -- Inicializar el resultado como fallo
    SET @resultado = 0;

    -- Validar que el carrito exista y esté activo
    IF NOT EXISTS (
        SELECT 1 
        FROM CarritoCompras 
        WHERE id = @carrito_id AND usuario_id = @cliente_id AND estado = 'activo'
    )
    BEGIN
        RETURN; -- Salir si no hay carrito válido
    END

    -- Verificar stock suficiente en inventario para los productos del carrito
    IF EXISTS (
        SELECT 1
        FROM DetallesCarritoComprar d
        JOIN Inventario i ON d.inventario_id = i.id
        WHERE d.carrito_id = @carrito_id AND i.cantidad < d.cantidad
    )
    BEGIN
        RETURN; -- Salir si algún producto no tiene suficiente stock
    END

    -- Calcular el importe total del carrito
    SELECT @importe_total = SUM(d.subtotal)
    FROM DetallesCarritoComprar d
    WHERE d.carrito_id = @carrito_id;

    -- Crear la orden y capturar el ID generado
    INSERT INTO OrdenPedido (fecha_emision, importe_total, forma_pago, estado, cliente_id, vendedor_id, carrito_id)
    OUTPUT INSERTED.id INTO @orden_id_table
    VALUES (
        GETDATE(),
        @importe_total,
        @forma_pago,
        'pendiente',
        @cliente_id,
        @vendedor_id,
        @carrito_id
    );

    -- Obtener el ID de la orden insertada
    DECLARE @orden_id BIGINT;
    SELECT @orden_id = id FROM @orden_id_table;

    -- Reducir el inventario basado en los productos del carrito
    UPDATE i
    SET i.cantidad = i.cantidad - d.cantidad
    FROM Inventario i
    JOIN DetallesCarritoComprar d ON i.id = d.inventario_id
    WHERE d.carrito_id = @carrito_id;

    -- Cambiar el estado del carrito a inactivo
    UPDATE CarritoCompras
    SET estado = 'inactivo'
    WHERE id = @carrito_id;

    -- Indicar éxito
    SET @resultado = 1;
END;

GO

CREATE PROCEDURE SP_MostarOrdenesPedido
AS
BEGIN
	SELECT id,fecha_emision,importe_total,forma_pago
	FROM OrdenPedido
END

CREATE PROCEDURE SP_ObtenerClientes
AS
BEGIN
    SELECT 
        c.id,
        c.nombre,
        c.tipo_documento,
        c.numero_documento,
        c.telefono,
        c.email,
        d.id AS departamento_id,
        d.nombre AS nombre_departamento,
        p.id AS provincia_id,
        p.nombre AS nombre_provincia,
        dis.id AS distrito_id,
        dis.nombre AS nombre_distrito
    FROM Clientes c
    INNER JOIN Distritos dis ON c.distrito_id = dis.id
    INNER JOIN Provincias p ON dis.provincia_id = p.id
    INNER JOIN Departamentos d ON p.departamento_id = d.id;
END;
ALTER PROCEDURE SP_GuardarCliente
    @nombre NVARCHAR(100),
    @tipo_documento NVARCHAR(50),
    @numero_documento NVARCHAR(20),
    @distrito_id INT,
    @telefono NVARCHAR(15),
    @email NVARCHAR(100)
AS
BEGIN
    INSERT INTO Clientes (nombre, tipo_documento, numero_documento, distrito_id, telefono, email)
    VALUES (
        @nombre,
        @tipo_documento,
        @numero_documento,
        @distrito_id, -- El distrito incluye relación con provincia y departamento
        @telefono,
        @email
    );
END;
SELECT * FROM Clientes
SELECT * FROM OrdenPedido
SELECT * FROM CarritoCompras

SELECT 1 
FROM CarritoCompras 
WHERE id = 1 AND usuario_id = 4 AND estado = 'activo';

SELECT * FROM CarritoCompras
SELECT d.inventario_id, i.cantidad AS stock_actual, d.cantidad AS cantidad_requerida
FROM DetallesCarritoComprar d
JOIN Inventario i ON d.inventario_id = i.id
WHERE d.carrito_id = 1 AND i.cantidad < d.cantidad;
